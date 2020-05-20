package org.qc.factorisation.superposition.test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	static Long a = 91L;
	static Long b = 87L;
	
	static double sum = 0.0;
	
	static Long a1 = 91L;
	static Long b1 = 86L;
	
	public static void run() {
		
	   sum = 0L;
      for(int x=1;x<100;x=x+1) {
    	  for(int y=1;y<100;y=y+1) {
    	  
    	long p1 =   (a)*x*(b)*y;
    	long p2 =   (a1)*x*(b1)*y;  
    	
    	///System.out.println("A is:"+p1 + "  "+p2);
    	int p4 = getDigitAtPositionAfterPoint(p1,1);
    	int p5 = getDigitAtPositionAfterPoint(p2,1);
    	///System.out.println("B is:"+p4 + "  "+p5); 
    	sum = sum + sum(p4,p5);
    	
    	//System.out.println("A1 is:"+p1+ "  "+p2);
    	
    	  }
      }
      System.out.print("At a1:"+a1 + " b1:"+b1 + " Sum1:"+sum); 
      sum = 0L;
      for(int x=1;x<100;x=x+1) {
    	  for(int y=1;y<100;y=y+1) {
    	  
    	long p1 =   (a)*x*(b)*y;
    	long p2 =   (a1)*x*(b1)*y;  
    	
    	///System.out.println("A is:"+p1 + "  "+p2);
    	int p4 = getDigitAtPositionAfterPoint(p1,2);
    	int p5 = getDigitAtPositionAfterPoint(p2,2);
    	///System.out.println("B is:"+p4 + "  "+p5); 
    	sum = sum + sum(p4,p5);
    	
    	//System.out.println("A1 is:"+p1+ "  "+p2);
    	
    	  }
      }
      System.out.print( " Sum2:"+sum); 
      sum = 0L;
      for(int x=1;x<100;x=x+1) {
    	  for(int y=1;y<100;y=y+1) {
    	  
    	long p1 =   (a)*x*(b)*y;
    	long p2 =   (a1)*x*(b1)*y;  
    	
    	///System.out.println("A is:"+p1 + "  "+p2);
    	int p4 = getDigitAtPositionAfterPoint(p1,3);
    	int p5 = getDigitAtPositionAfterPoint(p2,3);
    	///System.out.println("B is:"+p4 + "  "+p5); 
    	sum = sum + sum(p4,p5);
    	
    	//System.out.println("A1 is:"+p1+ "  "+p2);
    	
    	  }
      }
      System.out.print( " Sum3:"+sum); 
      System.out.println();
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


	private static int getDigitAtPositionAfterPoint(Long p1, int i) {
	
		String a = p1.toString();
		Integer a1 =null;
		try {
		 a1 = Integer.parseInt(String.valueOf(a.charAt(a.length()-i)));
		}
		catch(StringIndexOutOfBoundsException ne) {
			a1=0;
		}
		return a1;
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
