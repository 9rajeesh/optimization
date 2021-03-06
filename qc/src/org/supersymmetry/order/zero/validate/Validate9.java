package org.supersymmetry.order.zero.validate;

import java.util.ArrayList;
import java.util.List;

public class Validate9  {
	
	
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
		
		
		Long startIndex = 1024L*1024L*16;
		Long endIndex =   1024L*1024L*32;
		int count = 1;
		
		while(count<23){
		doCompute(startIndex,endIndex,count);
		
		if(sum0>sum1){
		endIndex = endIndex - ((endIndex - startIndex)/2);
		}
		
		else if(sum1>=sum0){
		startIndex = startIndex + ((endIndex - startIndex)/2);	
		}
		count++;
		}
	}
	
	public static void doCompute(Long startIndex,Long endIndex, int count) {
		
		count1=0L;
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
		
	
		
		//Long startIndex =8192L*64 ;
		//Long endIndex = 8192L*128  ;
		//int count =1;
		
		//Long a = (8192L*64);
		Long a = startIndex;
			
		//while(a< (8192L*128 )) {
		while(a< endIndex) {
		String s = Long.toBinaryString(a);
		State state = new FMState(s);
		
		Double a1 =  state.evaluate(2,4,6,8,10,11,13,14,16,17,19);
		Double b1 =  state.evaluate(1,2,3,4,6,10,18,19,20,23);
		Double c1 =  state.evaluate(1,2,3,5,8,11,9,19,12,13,14,15,19);
		Double d1 =  state.evaluate(4,5,6,9,10,11,13,14,18,20,21);
		Double e1 =  state.evaluate(1,2,3,9,12,15,17,13,16,17,19,20);
		Double f1 =  state.evaluate(5,6,7,8,10,11,12,17,9,13,18,19);
		Double g1 =  state.evaluate(1,2,8,10,11,12,16,17,18,19);
		Double h1 =  state.evaluate(1,4,5,9,10,11,12,15,16,17,20);
		Double i1 =  state.evaluate(1,3,5,6,7,8,9,10,12,13,15,18);
		Double j1 =  state.evaluate(1,2,8,7,9,11,12,15,18,19,21);
		
		Double k1 =  state.evaluate(1,2,8,9,12,9,8,17,18,19);
		Double l1 =  state.evaluate(5,9,4,1,2,9,15,16,7,8,9,10,20);
		Double m1 =  state.evaluate(2,3,6,8,10,13,15,16,17,18,20,21);
		Double n1 =  state.evaluate(1,5,8,9,10,11,13,15,4,12,17,18,19);
		
		Double o1 =  state.evaluate(5,1,3,8,9,10,11,12,16,18,21);
		Double p1 =  state.evaluate(5,2,3,1,12,13,15,19,20);
		Double q1 =  state.evaluate(13,6,8,11,3,14,15,19,21);
		
		Double r1 =  state.evaluate(5,1,3,8,9,10,11,12,14,18,19);
		Double s1 =  state.evaluate(5,2,3,1,12,13,15,16,17,19);
		Double t1 =  state.evaluate(1,6,8,11,13,14,15,18,19,20,22,23);
		
		Double u1 =  state.evaluate(1,4,5,8,12,13,14,21,22,23);
		Double v1 =  state.evaluate(1,4,5,6,8,12,13,19,20,22);
		Double w1 =  state.evaluate(1,2,3,5,9,10,11,12,14,15,19,20);
		Double x1 =  state.evaluate(4,5,6,7,12,13,14,15,18,19,20);
		
		Double sum = a1+b1+c1+d1+e1+f1+g1+h1+i1+j1+k1+l1+m1+n1+o1+p1+q1+r1+s1+t1+u1+v1+w1+x1;
		//System.out.println("At a="+a+ "   "+s+"------   "+sum);
		
		//List<Double> values = addTolist(a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,k1,l1,m1,n1,o1,p1,q1,r1,s1,t1);
		//Double sum_c = getValues(values);
		//sum_c =sum_c+sum;
		//double spikesum =  (a1+b1+c1+d1+e1+f1+g1+h1)  +(i1+j1+k1+l1*m1+n1+o1+p1) 
				         // + (q1+r1+s1+t1);
				
		                  
		if(s.charAt(count)=='0') {
		sum0 = sum0+Math.pow(sum, 2);
		//sumsq0 = sumsq0 + Math.pow(sum, 2);
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
		sum1 = sum1+Math.pow(sum, 2);
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
		
		if(sum>max){
		max =sum;
		}
		
		if(sum>22.499999999999996){
		count1++;
		}
		
		a++;
		///sum1 = sum1+sum;
		
		}
		
		//Double sum2=0.0;
		
		System.out.println("Sum0_0 is:"+sum0);
		System.out.println("Sum1_1 is:"+sum1);
		//System.out.println("Ratio-1 is:"+ sum0/sum1);
		
		///System.out.println("sumsq0 is:"+sumsq0);
		///System.out.println("sumsq1 is:"+sumsq1);
		///System.out.println("Ratio-2 is:"+ sumsq0/sumsq1);
		
		///System.out.println("sumcu0 is:"+sumcu0);
		//System.out.println("sumcu1 is:"+sumcu1);
		///System.out.println("Ratio-3 is:"+ sumcu0/sumcu1);
		
		///System.out.println("sum_4_0 is:"+sum_4_0);
		//System.out.println("sum_4_1 is:"+sum_4_1);
		//System.out.println("Ratio-4 is:"+ sum_4_0/sum_4_1);
		
		System.out.println("Prevsum02:"+ prevSum02);
		System.out.println("Prevsum12:"+ prevSum12);
		
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
