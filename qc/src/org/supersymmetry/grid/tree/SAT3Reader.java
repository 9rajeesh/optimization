package org.supersymmetry.grid.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.supersymmetry.integration.CNF3;


  

public class SAT3Reader {
	
	static List<SAT3> sat3list = new ArrayList<SAT3>();
	
	
	public static void create() throws IOException{
		
		List<SAT3> sat3list = generate();
		SAT3Reader.sat3list = sat3list;
		group(sat3list);
	}
	

	public static void group (List<SAT3> sat3list){
		
		Set<String> varaiblelist = new HashSet<String> ();
		
		sat3list.forEach(sat3->{
			varaiblelist.add(sat3.getV1().replaceAll("-", ""));
			varaiblelist.add(sat3.getV2().replaceAll("-", ""));
			varaiblelist.add(sat3.getV3().replaceAll("-", ""));
			
		});
		
		List<GridRow> gridRows = new ArrayList<GridRow>();
		
		varaiblelist.forEach(variable->{
			
			GridRow GridRow = new GridRow();
			GridRow.setVariable(variable);
			    
			    sat3list.forEach(sat3->{
				  
			    	if(sat3.containsVariable(variable)){
					GridRow.getClauses().add(new SAT3(sat3));
				   }
				});
			    
			    gridRows.add(GridRow);
			});
		
		Grid.gridrows=gridRows;
		varaiblelist.forEach(variable->{
			Grid.valueMap.put(variable, 1);
		});
		
		
	}
	
	
	
	public static List<SAT3> generate() throws IOException {
		 List<SAT3>  sat3list = new ArrayList<SAT3>();
	
		 List<String> clausestring = readCNFFile();
		 for(String eachCluaseString:clausestring){
			 
			 String[] a = eachCluaseString.split(" ");
			 SAT3 sat3 = new SAT3("v"+ a[0], "v"+a[1], "v"+a[2]);
			 sat3list.add(sat3);
			 
		 }
		 return sat3list;
	 }
	
	public static List<String> readCNFFile() throws IOException {

		 List<String>  cnfs = new ArrayList<String> ();
	        try {

	            File f = new File("src/cnf.txt");
	            BufferedReader b = new BufferedReader(new FileReader(f));

	            String readLine = "";
	            System.out.println("Reading file using Buffered Reader");

	            while ((readLine = b.readLine()) != null) {
	            	cnfs.add((readLine).trim());
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return cnfs;

	    }
	
}
