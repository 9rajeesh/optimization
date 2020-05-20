package org.supersymmetry.order.zero.validate;

import java.util.ArrayList;
import java.util.List;

public class Validate5  {
	
	
	static List<Double> zeroList = new ArrayList<Double>();
	static List<Double> oneList = new ArrayList<Double>();
	
	static Double prev2Sum0 = 0.0;
	static Double prev2Sum1 = 0.0;
	
	static Double prevSum0 = 0.0;
	static Double prevSum1 = 0.0;
	
	static Double cumvSum0 = 0.0;
	static Double cumSum1 = 0.0;
	
	static Double sum0 = 0.0;
	static Double sum1 = 0.0;
	
	static Double sumsq0 = 0.0;
	static Double sumsq1 = 0.0;
	
	static Double sumcu0 = 0.0;
	static Double sumcu1 = 0.0;
	
	static Double sum_4_0= 0.0;
	static Double sum_4_1 = 0.0;
	
	static double max = 0.0;
	
	
	static Double prevSum02 = 0.0;
	static Double prevSum12 = 0.0;

	static Double sumc_0 = 0.0;
	static Double sumc_1 = 0.0;
	
	static Long count1 = 0L;
	
	public static void main(String[] args) {
		count1 = 0L;
		
		sum0 = 0.0;
		sum1 = 0.0;
		
		sumsq0 = 0.0;
		sumsq1 = 0.0;
		
		sumcu0 = 0.0;
		sumcu1 = 0.0;
		
		sum_4_0 = 0.0;
		sum_4_1 = 0.0;
		
		max = 0.0;
		
		prevSum02 = 0.0;
		prevSum12 = 0.0;
		
		prevSum0= 0.0;
		prevSum1 = 0.0;
		
		Long startIndex = Long.parseLong(args[0]) ;
		Long endIndex = Long.parseLong(args[1]) ;
		int count = Integer.parseInt(args[2]);
		
		//Long startIndex =8192L*64 ;
		//Long endIndex = 8192L*128  ;
		//int count =1;
		
		//Long a = (8192L*64);
		Long a = startIndex;
			
		//while(a< (8192L*128 )) {
		while(a< endIndex) {
		String s = Long.toBinaryString(a);
		State state = new State(s);
		
		Double a1 =  state.evaluate(0,1);
		Double b1 =  state.evaluate(1,2);
		Double c1 =  state.evaluate(0,2);
		Double d1 =  state.evaluate(0,3);
		Double e1 =  state.evaluate(1,12);
		Double f1 =  state.evaluate(5,6);
		Double g1 =  state.evaluate(7,8);
		Double h1 =  state.evaluate(0,9);
		Double i1 =  state.evaluate(11,5);
		Double j1 =  state.evaluate(1,5);
		Double k1 =  state.evaluate(2,6);
		Double l1 =  state.evaluate(3,8);
		
		Double m1 =  state.evaluate(10,11);
		Double n1 =  state.evaluate(11,1);
		Double o1 =  state.evaluate(12,0);
		Double p1 =  state.evaluate(12,1);
		Double q1 =  state.evaluate(10,5);
		Double r1 =  state.evaluate(3,5);
		Double s1 =  state.evaluate(10,4);
		Double t1 =  state.evaluate(10,9);
		Double u1 =  state.evaluate(1,5);
		Double v1 =  state.evaluate(4,7);
		
		Double w1 =  state.evaluate(4,8);
		Double x1 =  state.evaluate(0,1);
		Double y1 =  state.evaluate(3,6);
		Double z1 =  state.evaluate(5,8);
		
		Double a11 =  state.evaluate(4,8);
		Double b11 =  state.evaluate(0,11);
		Double c11 =  state.evaluate(3,6);
		Double d11 =  state.evaluate(5,8);
		
		Double e11 =  state.evaluate(10,8);
		Double f11 =  state.evaluate(10,3);
		Double g11 =  state.evaluate(3,9);
		Double h11 =  state.evaluate(6,8);
		
		
		Double sum = a1+b1+c1+d1+e1+f1+g1+h1+i1+j1+
				k1+l1+m1+n1+o1+p1+q1+r1+s1+t1+u1+v1+w1+x1+y1+z1
				+a11+b11+c11+d11 + e11+f11+g11+h11;
		//System.out.println("At a="+a+ "   "+s+"------   "+sum);
		
		//List<Double> values = addTolist(a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,k1,l1,m1,n1,o1,p1,q1,r1,s1,t1);
		//Double sum_c = getValues(values);
		//sum_c =sum_c+sum;
	
				
		                  
		if(s.charAt(count)=='0') {
		sum0 = sum0+sum;
		sumsq0 = sumsq0 + Math.pow(sum, 2);
		///sumcu0 = sumcu0 +  Math.pow(sum, 3);
		//sum_4_0 = sum_4_0+ Math.pow(sum, 4);
		//prevSum02 = prevSum02 + Math.pow((sum*sum - prevSum0*prevSum0),2);
		//prevSum0 = sum;
		//sum00 = sum00+doSum1(sum,prevSum0);
		//cumvSum0 = cumvSum0 + Math.pow((sum - prevSum0),2); //+ Math.pow(sum-prev2Sum0, 2);
		//prev2Sum0 = new Double(prevSum0);
		 //prevSum0 = new Double(sum);
		//sumc_0= sumc_0+ Math.pow(sum_c,4);
		//zeroList.add(sum);
		
		}
		
		if(s.charAt(count)=='1') {
		 sum1 = sum1+sum;
		 sumsq1 = sumsq1 + Math.pow(sum, 2);
		//sumsq1 = sumsq1 + Math.pow(sum, 2);
		//sumcu1 = sumcu1 +  Math.pow(sum, 3);
		//sum_4_1 = sum_4_1+ Math.pow(sum, 4);
		//prevSum12 = prevSum12 +  Math.pow((sum*sum - prevSum1*prevSum1),2);
		//prevSum1 = sum;
		//sum11 = sum11+doSum1(sum,prevSum1);
		//cumSum1 = cumSum1 + Math.pow((sum - prevSum1),2);//+ Math.pow(sum-prev2Sum1, 2);
		//prev2Sum1 = new Double(prevSum1);
		//prevSum1 = new Double(sum);
		//oneList.add(sum);
		//sumc_1= sumc_1+  Math.pow(sum_c,4);
		
		}
		
		if(sum>max ){
		max =sum;
		}
		
		if(sum>=26){
		count1++;
		}
		
		a++;
		///sum1 = sum1+sum;
		
		}
		
		//Double sum2=0.0;
		
		System.out.println("Sum0_0 is:"+sum0);
		System.out.println("Sum1_1 is:"+sum1);
		//System.out.println("Ratio-1 is:"+ sum0/sum1);
		
		System.out.println("sumsq0 is:"+sumsq0);
		System.out.println("sumsq1 is:"+sumsq1);
		///System.out.println("Ratio-2 is:"+ sumsq0/sumsq1);
		
		///System.out.println("sumcu0 is:"+sumcu0);
		//System.out.println("sumcu1 is:"+sumcu1);
		///System.out.println("Ratio-3 is:"+ sumcu0/sumcu1);
		
		///System.out.println("sum_4_0 is:"+sum_4_0);
		//System.out.println("sum_4_1 is:"+sum_4_1);
		//System.out.println("Ratio-4 is:"+ sum_4_0/sum_4_1);
		
		//System.out.println("Prevsum02:"+ prevSum02);
		//System.out.println("Prevsum12:"+ prevSum12);
		
		System.out.println("Max is:"+max);
		System.out.println("count1 is:"+count1);
		
		
		//System.out.println("SumC0 is:"+sumc_0);
		///System.out.println("SumC1 is:"+sumc_1);
		
		
		
	}
	
	
	public static Double doSum1(double sum,double prevSum) {
		return Math.pow(sum, 6);
	//return 1+ Math.pow(10.1*sum,2);
			
	}
	
	public static Double doSum(double sum) {
		return  Math.pow(sum,2);
	}
	
private static Double getValues(List<Double> values) {
		
		Double sum = 0.0;
		for(int i =0;i<values.size();i++) {
			Double a = values.get(i);
			
			for(int j=0;j<values.size();j++) {
				Double b = values.get(j);
				
				if(i==j) {
				//continue;
				}
				
				sum = sum + a*b;	
			}
		}
		
		return sum;
	}

	private static List<Double> addTolist(Double...values) {
	
		List<Double> values1  = new ArrayList<Double>();
		for(int i =0;i<values.length;i++) {
			values1.add(values[i]);
		}
		
		return values1;
	}

}
