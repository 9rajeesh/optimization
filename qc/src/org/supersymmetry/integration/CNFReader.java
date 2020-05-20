package org.supersymmetry.integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CNFReader {
	
	public static void main(String[] args) throws IOException{
		List<CNF3> cnfs = generate();
		
		cnfs.forEach(cnf->System.out.println(cnf));
		
	}

	 public static List<CNF3> generate() throws IOException {
		 List<CNF3>  cnfs = new ArrayList<CNF3>();
	
		 List<String> clausestring = readCNFFile();
		 for(String eachCluaseString:clausestring){
			 
			 String[] a = eachCluaseString.split(" ");
			 CNF3 cnf3 = new CNF3("v"+ a[0], "v"+a[1], "v"+a[2]);
			 cnfs.add(cnf3);
			 
		 }
		 return cnfs;
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
