package org.supersymmetry.order.zero.validate;

public class FactorisationValidate {
	
	static int a = 0;
	static int b = 0;
	
	static int a1 = 29;
	static int b1 = 24;
	
	///
	static int maxbits = 5;
	static int N=32;
	static int checkbit = 4;
	/////
	
	static int product = a1*b1;
	
	static long zerocount = 0;
	static long onecount = 0;
	
	public static void main(String[] args) {
		
		//test();
		//System.out.println("One count:"+onecount);
		//System.out.println("Zero count:"+zerocount);
		
		Double sum = getPeriodSum2(60.0,29.0);
		System.out.println("Sum:"+sum);
	}
	
	
	 public static Double getPeriodSum1(Double period,Double value) {
			
			Double sum = 0.0;
						
			
			for(Double x=0.0;x<=60.0;x=x+1) {
			sum = sum + Math.sin(2.0*Math.PI*x/period)* Math.sin(2.0*Math.PI*x/value);
			}
			
			
			
			return sum;
		}
	 
	 public static Double getPeriodSum2(Double period,Double value) {
			
			Double sum = 0.0;
			
			for(Double phase=0.0; phase<=2*Math.PI; phase=phase+(2*Math.PI*5/200000)) {
			
			for(Double x=0.0;x<=120;x=x+1) {
			sum = sum + Math.sin( (2.0*Math.PI*x/period))* Math.sin( ((2.0*Math.PI*x)/value) + phase);
			}
			
			}
			
			return sum;
		}
	
   public static Double getPeriodSum(Double period,Double value) {
		
		Double sum = 0.0;
		
		for(Double phase=0.0; phase<2*Math.PI; phase=phase+(2*Math.PI*0.0001)) {
		
		for(Double x=0.0;x<120;x=x+1) {
		sum = sum + Math.sin(2.0*Math.PI*x/period)* Math.sin( ((2.0*Math.PI*x)/value) + phase);
		}
		
		}
		
		return sum;
	}
	
	
	public static  void test() {
		
		for(a=0;a<N;a++) {
			
			for(b=0;b<N;b++) {
			
				int product1 = a*b;
				int score = computeScore(product1);
				
				if(checkBit(a)==1) {
				onecount = onecount+score;
				}
				else {
				zerocount = zerocount +score;	
				}
							
			}
		}
	}


	private static int checkBit(int a2) {
		
		String string = lpad(Integer.toBinaryString(a2),maxbits);
		
		if(string.charAt(checkbit)=='0') {
		return 0;
		}
		
		if(string.charAt(checkbit)=='1') {
		return 1;
		}
		
		return 0;
	}


	private static int computeScore(int product1) {
	    int score = 0;
		String productString = lpad(Integer.toBinaryString(product),maxbits*2);
		String product1String = lpad(Integer.toBinaryString(product1),maxbits*2);
		
		for(int i=0;i<productString.length();i++) {
			if(productString.charAt(i) == '1') {
			score++;
			}
		}
		return score;
	 }
	
	public static String lpad(String value, Integer bitLength) {
		while (value.length() < bitLength) {
		value = "0" + value;
		}
		return value;
	}
	

}
