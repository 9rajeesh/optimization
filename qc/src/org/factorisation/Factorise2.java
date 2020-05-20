package org.factorisation;

public class Factorise2 {

	static Long a_1 = 197L;
	static Long b_1 = 205L;
	static Long c = a_1*b_1;
	
	static final Integer bitLength = 8;
	static final Long count = 256L;
	
	static Double zeroSum = 0.0;
	static Double oneSum = 0.0;
	
	static Double zeroSum_1 = 0.0;
	static Double oneSum_1 = 0.0;
	
	
	static Integer bit = 6;
	
 public  static void test_a(Long start,Long end,Long start1,Long end1) {
		
	 System.out.println("a_1 with 0 is:"+"  "+a_1+ "   "+Long.toBinaryString(a_1));
	 System.out.println("b_1 with 0 is:"+"  "+b_1+ "   "+Long.toBinaryString(b_1));
	 
	 
		if(start==null){
		start=0L;
		end=count;
		}
		
		String base = prefixZeroes(Long.toBinaryString(c),bitLength*2);
		
		Double sum_0 = 0.0;
		Double sumsq_0 = 0.0;
		Double sumcu_0 = 0.0;
		
		
		Double sum_1 = 0.0;
		Double sumsq_1 = 0.0;
		Double sumcu_1 = 0.0;
		
		for(Long a=start;a<end;a++) {
			for(Long b=start1;b<end1;b++) {
			String a1 = prefixZeroes(Long.toBinaryString(a),bitLength);
			String b1 = prefixZeroes(Long.toBinaryString(b),bitLength);
			String c1 = prefixZeroes(Long.toBinaryString(a*b),bitLength*2);
			
			if(a1.charAt(bit+1)=='1' && b1.charAt(bit+1)=='1' && a1.charAt(bit)=='0') {
				sum_0 = sum_0   +  Math.pow(distance(c1,base),1);
				sumsq_0 =sumsq_0+  Math.pow(distance(c1,base),20);
				sumcu_0 =sumcu_0+  Math.pow(distance(c1,base),30);
				
			}
		 }
		}
		
		Double r1 = sumsq_0/sum_0;
		Double r2 = sumcu_0/sumsq_0;
		System.out.println("Ratio 1 with 0 is:"+r1);
		System.out.println("Ratio 2 with 0 is:"+r2);
		Double dr2r1 = r2-r1;
		
		
		System.out.println("Ratio 2 with 0 is:"+dr2r1);
		
				
		
		
		
		for(Long a=start;a<end;a++) {
			for(Long b=start1;b<end1;b++) {
			String a1 = prefixZeroes(Long.toBinaryString(a),bitLength);
			String b1 = prefixZeroes(Long.toBinaryString(b),bitLength);
			String c1 = prefixZeroes(Long.toBinaryString(a*b),bitLength*2);
			
			if(a1.charAt(bit+1)=='1' && b1.charAt(bit+1)=='1' && a1.charAt(bit)=='1') {
				sum_1 = sum_1 +  Math.pow(distance(c1,base),1);
				sumsq_1 =sumsq_1+  Math.pow(distance(c1,base),20);
				sumcu_1 =sumcu_1+  Math.pow(distance(c1,base),30);
						     
			}
		 }
		}
		
		 r1 = sumsq_1/sum_1;
		 r2 = sumcu_1/sumsq_1;
		System.out.println("Ratio 1 with 1 is:"+r1);
		System.out.println("Ratio 2 with 1 is:"+r2);
		 dr2r1 = r2-r1;
		
		
		System.out.println("Ratio 2 with 0 is:"+dr2r1);
	}
	
	
	
public static void main(String[] args) {
	
	
	
	
	
	test_a(0L,256L,0L,256L);
	
	
}
	
	public static Integer distance(String a,String b) {
		Integer sum = 0;
		for(int i=0;i<a.length();i++) {
			
			if(a.charAt(i) == b.charAt(i)) {
				sum=sum+1;
			}
			
		}
		/*if(sum<=8){
		sum = 8-sum;
		}
		
		else if(sum>8){
	    sum = sum-8;
		}*/
		return sum;
	}
	
	
	public static String prefixZeroes(String value, Integer bitLength) {
		while (value.length() < bitLength) {
		value = "0" + value;
		}
		return value;
	}
	
	
}
