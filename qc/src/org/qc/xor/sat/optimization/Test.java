package org.qc.xor.sat.optimization;

import java.util.HashSet;
import java.util.Set;

public class Test {

	
	
	
	static double var = 0.112645453354145;
	
	public static void main(String[] args) {
		
		Set<String> p = new HashSet<>();
		
		for(double x=10000000000000000.0;x<10000000000000000.0+1000000.0;x=x+1.5) {
			String t= "";
			
			for(Integer i=0;i<40;i++) {
		  				
			 double x1 = Math.cos((var+i)*x);
		      
			 if(x1<0) {
		      t= t+"0";
		     }
			 
		     else if(x1>0) {
		     t=t+"1"; 
		     }
		          
		
			}
			 p.add(t);
			 //System.out.println(t);
		}
		 System.out.println("Size is:"+p.size());
		
		
	}
	
	
	
	
}
