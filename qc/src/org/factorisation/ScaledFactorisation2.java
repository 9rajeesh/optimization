package org.factorisation;

public class ScaledFactorisation2 {

	static Long a_1 = 153L;
	static Long b_1 = 239L;
	
	
	static String first = "";
	static String second = "";
	
	static Long a_offset = 0L;
	static Long b_offset = 0L;
	
	static Long c = a_1*b_1 + a_1*b_offset + b_1*a_offset + a_offset*b_offset;
	
	static final Integer bitLength = 9;
	static final Long count = 256L;
	
	static Double zeroSum = 0.0;
	static Double oneSum = 0.0;
	
	static Double zeroSum_1 = 0.0;
	static Double oneSum_1 = 0.0;
	
	static Long start0 = 0L;
	static Long end0 = 256L;
	
	static Long start1 = 0L;
	static Long end1 = 256L;
	
	
	static  Integer bit =1;
	private static double power = 3;
	
	static String a ="";
	static String b = "";
	

	
	
public static void main(String[] args) {
	
	int count = 0;
	
	
	Double sum00 = 0.0;
	Double sum01 = 0.0;
	Double sum10 = 0.0;
	Double sum11 = 0.0;
	
	while(count<=7) {
		
	sum00 = 0.0;
    sum01=  0.0;
	sum10 = 0.0;
	sum11 = 0.0;
		
	zeroSum = 0.0;
	oneSum = 0.0;
	a_offset = 0L;
	b_offset = 0L;
	
	for(int i=0;i<25;i++){
	a_offset = new Double(Math.random()*256).longValue();
	b_offset = new Double(Math.random()*256).longValue();
	
	c = a_1*b_1 + a_1*b_offset + b_1*a_offset + a_offset*b_offset;
		
    sum00 = sum00 + testBoth(first+"0",second+"0");
	sum01 = sum01 + testBoth(first+"0",second+"1");
	sum10 = sum10 + testBoth(first+"1",second+"0");
	sum11 = sum11 + testBoth(first+"1",second+"1");
	
	/*  Double sum100 = testBoth(first+"0",second+"0");
	  Double sum101 = testBoth(first+"0",second+"1");
	  Double sum110 = testBoth(first+"1",second+"0");
	  Double sum111 = testBoth(first+"1",second+"1");
	 
	Double large = findLargest(sum100,sum101,sum110,sum111);
	
	if(large.equals(sum100)){
	sum00 = sum00 + 1;
	}
	if(large.equals(sum101)){
	sum01 = sum01 + 1;	
	}
	if(large.equals(sum110)){
	sum10 = sum10 + 1;	
	}
	if(large.equals(sum111)){
	sum11 = sum11 + 1;	
	}
	 */
	
	}
	
	System.out.println("Sum00 is:"+sum00);
	System.out.println("Sum01 is:"+sum01);
	System.out.println("Sum10 is:"+sum10);
	System.out.println("Sum11 is:"+sum11);
	
	checkAll(sum00,sum01,sum10,sum11);
		
	
	bit= bit+1;
	count = count + 1;
	}
	System.out.println("A is:"+first);
	System.out.println("B is:"+second);
	System.out.println("Actual is:"+Long.toBinaryString(a_1));
	System.out.println("Actual is:"+Long.toBinaryString(b_1));
}
	






	private static void checkAll(Double sum00, Double sum01, Double sum10, Double sum11) {
	
		Double large = findLargest(sum00,sum01,sum10,sum11);
		
		if(sum00.equals(large)){
			first = first+"0";
			second = second+"0";
			System.out.println("A:0");
			System.out.println("B:0");
		}
		else if(sum01.equals(large)){
			first = first+"0";
			second = second+"1";
			System.out.println("A:0");
			System.out.println("B:1");
		}
		
		else if(sum10.equals(large)){
			first = first+"1";
			second = second+"0";
			System.out.println("A:1");
			System.out.println("B:0");
		}
		
		else{
			first = first+"1";
			second = second+"1";
			System.out.println("A:1");
			System.out.println("B:1");
		}
	
    }

	private static Double findLargest(Double sum00, Double sum01, Double sum10, Double sum11) {

		
		Double large = 0.0;
		
		if(sum00>large){
		large =sum00;	
		}
		
		if(sum01>large){
		large =sum01;	
		}
		
		if(sum10>large){
		large =sum10;	
		}
		
		
		if(sum11>large){
		large =sum11;	
		}
		

		return large;
	}







	private static Double testBoth(String string, String string2) {
	
		   Double sum = 0.0;
		
		   Long start = Long.parseLong(suffixZeroes(string,bitLength-1),2);
		   Long end = Long.parseLong(suffixOnes(string,bitLength-1),2);
				   
		   Long start1 = Long.parseLong(suffixZeroes(string2,bitLength-1),2);
		   Long end1 = Long.parseLong(suffixOnes(string2,bitLength-1),2);
		   
		  // System.out.println("testing with:"+ suffixZeroes(string,bitLength-1));
		  // System.out.println("testing with:"+ suffixZeroes(string2,bitLength-1));
		   
			
		   String base = prefixZeroes(Long.toBinaryString(c),bitLength*2);
			
			for(Long a=start;a<end;a++) {
				for(Long b=start1;b<end1;b++) {
				String a1 = prefixZeroes(Long.toBinaryString(a),bitLength);
				String b1 = prefixZeroes(Long.toBinaryString(b),bitLength);
				
				Long e = (a+a_offset) * (b + b_offset);
				String c1 = prefixZeroes(Long.toBinaryString(e),bitLength*2);
				sum = sum +  Math.pow(scaleddistance(c1,base),power );
			}
		}
			
	return sum;
}


	private static String suffixZeroes(String string, int i) {
		while (string.length() < i) {
			string =  string + "0";
			}
			return string;
	}
	
	private static String suffixOnes(String string, int i) {
		while (string.length() < i) {
			string =  string + "1";
			}
			return string;
	}


	public static Integer distance(String a,String b) {
		Integer sum = 0;
		
		//System.out.println(a);
		//System.out.println(b);
		
		for(int i=0;i<a.length();i++) {
			
			if(a.charAt(i)==b.charAt(i)) {
				sum=sum+1;
			}
			
		}
		//sum = bitLength*2-sum;
		
		
		return sum;
	}
	
	public static Double scaleddistance(String a,String b) {
		Double  sum = 0.0;
		
		//System.out.println(a);
		//System.out.println(b);
		
		for(int i=0;i<a.length();i++) {
			
			if(a.charAt(i)==b.charAt(i)) {
				sum=sum + (Math.pow(2,a.length()-i));
			}
			
		}
		//sum = bitLength*2-sum;
		
		
		return sum;
	}
	
	
	
	public static String prefixZeroes(String value, Integer bitLength) {
		while (value.length() < bitLength) {
		value = "0" + value;
		}
		return value;
	}
	
	
}
