package org.qc.factorisation.superposition.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	static Long a = 91L;
	static Long b = 87L;
	
	static double sum = 0.0;
	
	static Long a1 = 91L;
	static Long b1 = 86L;
	
	public static void run() {
		
	   sum = 0L;
      for(double x=1.0;x<100;x=x+1) {
    	  for(double y=1.0;y<100;y=y+1) {
    	  
    	double p1 =   (a)*x*(b)*y;
    	double p2 =   (a1)*x*(b1)*y;  
    	
    	//System.out.println("A is:"+p1 + "  "+p2);
    	int p4 = getDigitAtPositionAfterPoint(p1,1);
    	int p5 = getDigitAtPositionAfterPoint(p2,1);
    	//System.out.println("B is:"+p4 + "  "+p5); 
    	
    	sum = sum + sum(p4,p5);
    	
    	//System.out.println("A1 is:"+p1+ "  "+p2);
    	
    	  }
      }
      System.out.println("Sum is:"+sum + " At a1:"+a1 + " b1:"+b1); 
	}
	
	
	private static double sum1(int p4, int p5) {
		
		double p = (Math.PI*2)/10;
		double value = Math.sin(p*p4)*Math.sin(p*p5);
		
		
		
		return value;
	}


	private static int sum(int p4, int p5) {
		int a=10000;
		int b = 10000;
		if(p4>=0 && p4<=4) {
			a=1;
		}
		else if(p4>=5) {
			a=-1;
		}
		
		if(p5>=0 && p5<=4) {
			b=1;
		}
		else if(p5>=5) {
			b=-1;
		}
		
		return a*b;
	}


	private static int getDigitAtPositionAfterPoint(Double p1, int i) {
	
		String a = p1.toString();
		String b = "";
		for(int k=a.length()-1;k>=0;k--) {
		b= b+String.valueOf(a.charAt(k));
		}
		b=b.substring(b.indexOf(".")+1);
		String c = String.valueOf(b.charAt(i-1));
		return Integer.parseInt(c);
	}


	public static void main(String[] args) {
		
		for(long a=0;a<100;a++) {
			for(long b=0;b<100;b++) {
				
				a1=a;
				b1=b;
		    run();
			}
	    }
	}
	
	
	
	
	
}
