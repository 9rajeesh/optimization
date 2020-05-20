package org.factorisation;

public class Factorise {

	static Long a_1 = 201L;
	static Long b_1 = 239L;
	static Long c = a_1*b_1;
	
	static final Integer bitLength = 8;
	static final Long count = 256L;
	
	static Double zeroSum = 0.0;
	static Double oneSum = 0.0;
	
	static Double zeroSum_1 = 0.0;
	static Double oneSum_1 = 0.0;
	
	
	static  Integer bit = 0;
	private static double power = 3;
	
 public  static void test_a(Long start,Long end,Long start1,Long end1) {
		
		if(start==null){
		start=0L;
		end=count;
		}
		
		String base = prefixZeroes(Long.toBinaryString(c),bitLength*2);
		
		Double sum = 0.0;
		
		for(Long a=start;a<end;a++) {
			for(Long b=start1;b<end1;b++) {
			String a1 = prefixZeroes(Long.toBinaryString(a),bitLength);
			String b1 = prefixZeroes(Long.toBinaryString(b),bitLength);
			String c1 = prefixZeroes(Long.toBinaryString(a*b),bitLength*2);
			
			
			if(a1.charAt(bit)=='0') {
			sum = sum +  Math.pow(distance(c1,base),power );
			}
		 }
		}
		
		System.out.println("Sum with 0 is:"+sum);
		zeroSum=sum;
		
				
		
		sum = 0.0;
		
		for(Long a=start;a<end;a++) {
			for(Long b=start1;b<end1;b++) {
			String a1 = prefixZeroes(Long.toBinaryString(a),bitLength);
			String b1 = prefixZeroes(Long.toBinaryString(b),bitLength);
			String c1 = prefixZeroes(Long.toBinaryString(a*b),bitLength*2);
			
			if(a1.charAt(bit)=='1') {
				sum = sum +  Math.pow(distance(c1,base),power);
						     
			}
		 }
		}
		oneSum=sum;
		System.out.println("Sum with 1 is:"+sum);
	}
	
 public  static void test_b(Long start,Long end,Long start1,Long end1) {
		
		if(start==null){
		start=0L;
		end=count;
		}
		
		String base = prefixZeroes(Long.toBinaryString(c),bitLength*2);
		
		Double sum = 0.0;
		
		for(Long a=start;a<end;a++) {
			for(Long b=start1;b<end1;b++) {
			String a1 = prefixZeroes(Long.toBinaryString(a),bitLength);
			String b1 = prefixZeroes(Long.toBinaryString(b),bitLength);
			String c1 = prefixZeroes(Long.toBinaryString(a*b),bitLength*2);
			
			
			if(b1.charAt(bit)=='0') {
				sum = sum +  Math.pow(distance(c1,base),power);
			}
		 }
		}
		System.out.println("Sum with 0 is:"+sum);
		zeroSum=sum;
		
				
		
		sum = 0.0;
		
		for(Long a=start;a<end;a++) {
			for(Long b=start1;b<end1;b++) {
			String a1 = prefixZeroes(Long.toBinaryString(a),bitLength);
			String b1 = prefixZeroes(Long.toBinaryString(b),bitLength);
			String c1 = prefixZeroes(Long.toBinaryString(a*b),bitLength*2);
			
			if(b1.charAt(bit)=='1') {
				sum = sum +  Math.pow(distance(c1,base),power);
						     
			}
		 }
		}
		oneSum=sum;
		System.out.println("Sum with 1 is:"+sum);
	}
	
	
public static void main(String[] args) {
	
	Long start0 = 0L;
	Long end0 = 256L;
	
	Long start1 = 0L;
	Long end1 = 256L;
	String a ="";
	String b = "";
	int count = 0;
	
	while(count<8) {
	
	test_a(start0,end0,start1,end1);
	
	if(zeroSum>=oneSum){
	end0 = end0 - ((end0-start0)/2);
	a = a+"0";
	System.out.println("Selected-----------A-----------0");
	}
	
	else{
	start0 = start0 + ((end0-start0)/2);
	a = a+"1";
	System.out.println("Selected----------A-------------1");
	}
	
    test_b(start0,end0,start1,end1);
	
	if(zeroSum>=oneSum){
	end1 = end1 - ((end1-start1)/2);
	b=b+"0";
	System.out.println("Selected-----0");
	}
	
	else{
	start1 = start1 + ((end1-start1)/2);
	System.out.println("Selected-----1");
	b=b+"1";
	}
	
	
	bit= bit+1;
	count++;
   }
	
	Integer p1 = Integer.parseInt(a, 2);
	Integer q1 = Integer.parseInt(b, 2);
	
	System.out.println("A1 is:"+a);
	System.out.println("B1 is:"+b);
	
	System.out.println("Actual is:"+Long.toBinaryString(a_1));
	System.out.println("Actual is"+Long.toBinaryString(b_1));
	System.out.println("P1 is:"+p1);
	System.out.println("Q1 is:"+q1);
	
	System.out.println("P1 is:"+p1);
	System.out.println("Q1 is:"+q1);
	
	String base = prefixZeroes(Long.toBinaryString(a_1*b_1),bitLength*2);
	String value = prefixZeroes(Long.toBinaryString(p1*q1),bitLength*2);
	Integer distance = distance(base,value);
	
	
	System.out.println("Distance is:"+distance);
	
}
	
	public static Integer distance(String a,String b) {
		Integer sum = 0;
		
		for(int i=a.length()/2;i<a.length();i++) {
			
			if(a.charAt(i)!=b.charAt(i)) {
				return 0;
			}
		}
		
		
		for(int i=0;i<a.length();i++) {
			
			if(a.charAt(i)==b.charAt(i)) {
				sum=sum+1;
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
