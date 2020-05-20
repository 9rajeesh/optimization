package org.factorisation;

public class ScaledFactorisation {

	static Long a_1 = 231L;
	static Long b_1 = 239L;
	
	static Long a_offset = 0L;
	static Long b_offset = 0L;
	
	static Long c = a_1*b_1 + a_1*b_offset + b_1*a_offset + a_offset*b_offset;
	
	static final Integer bitLength = 9;
	static final Long count = 256L;
	
	static Double zeroSum = 0.0;
	static Double oneSum = 0.0;
	
	static Double zeroSum_1 = 0.0;
	static Double oneSum_1 = 0.0;
	
	
	static  Integer bit =1;
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
			
			Long e = (a+a_offset) * (b + b_offset);
			String c1 = prefixZeroes(Long.toBinaryString(e),bitLength*2);
			
			
			if(a1.charAt(bit)=='0') {
			sum = sum +  Math.pow(distance(c1,base),power );
			}
		 }
		}
		
		//System.out.println("Sum with 0 is:"+sum);
		zeroSum=zeroSum + sum;
		
				
		
		sum = 0.0;
		
		for(Long a=start;a<end;a++) {
			for(Long b=start1;b<end1;b++) {
			String a1 = prefixZeroes(Long.toBinaryString(a),bitLength);
			String b1 = prefixZeroes(Long.toBinaryString(b),bitLength);
			
			//System.out.println(a);
			//System.out.println(b);
			
			Long e = (a + a_offset) * (b + b_offset);
			String c1 = prefixZeroes(Long.toBinaryString(e),bitLength*2);
			
			if(a1.charAt(bit)=='1') {
				sum = sum +  Math.pow(distance(c1,base),power);
						     
			}
		 }
		}
		oneSum= oneSum +sum;
		//System.out.println("Sum with 1 is:"+sum);
	}
	

	
	
public static void main(String[] args) {
	
	int count = 0;
	String a ="";
	String b = "";
	
	Long start0 = 0L;
	Long end0 = 256L;
	
	Long start1 = 0L;
	Long end1 = 256L;
	
	
	
	while(count<=7) {
		
	zeroSum = 0.0;
	oneSum = 0.0;
	a_offset = 0L;
	b_offset = 0L;
	
	for(int i=0;i<20;i++){
	
	a_offset = a_offset + 1;
	b_offset = b_offset + 1;
	c = a_1*b_1 + a_1*b_offset + b_1*a_offset + a_offset*b_offset;
	
	
	
	test_a(start0,end0,start1,end1);
	
	System.out.println("Actual is:"+Long.toBinaryString(a_1));
	System.out.println("Actual is"+Long.toBinaryString(b_1));
	System.out.println("--------------------------");
	
	System.out.println("Sum with 0 is:"+zeroSum);
	System.out.println("Sum with 1 is:"+oneSum);
	
	}
	
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
	
	
	
	bit= bit+1;
	count = count + 1;
	}
	System.out.println("A is:"+a);
	System.out.println("Actual is:"+Long.toBinaryString(a_1));
	System.out.println("Actual is"+Long.toBinaryString(b_1));
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
	
	
	public static String prefixZeroes(String value, Integer bitLength) {
		while (value.length() < bitLength) {
		value = "0" + value;
		}
		return value;
	}
	
	
}
