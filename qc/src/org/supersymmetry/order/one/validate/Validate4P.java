package org.supersymmetry.order.one.validate;

import java.util.ArrayList;
import java.util.List;

import org.supersymmetry.order.zero.validate.State;

public class Validate4P  {
	
	
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
	
	static double max = 0.0;
	
	
	static Double prevSum02 = 0.0;
	static Double prevSum12 = 0.0;

	static Double sumc_0 = 0.0;
	static Double sumc_1 = 0.0;
	
	static Long count1 = 0L;
	
	public static void main(String[] args) {
		
		zeroList = new ArrayList<Double>();
		oneList = new ArrayList<Double>();
		
		sum0 = 0.0;
		sum1 = 0.0;
		
		sumsq0 = 0.0;
		sumsq1 = 0.0;
		
		sumcu0 = 0.0;
		sumcu1 = 0.0;
		
		
		max = 0.0;
		
		int maxc = 0;
		
		prevSum02 = 0.0;
		prevSum12 = 0.0;
		
		prevSum0= 0.0;
		prevSum1 = 0.0;
		
		Long startIndex = null ;
		Long endIndex = null;
		int count = 1;
		
		if(args!=null && args.length>0 &&  args[0]!=null){
		startIndex = Long.parseLong(args[0]) ;
		endIndex = Long.parseLong(args[1]) ;
		count = Integer.parseInt(args[2]);
		}
		
		else{
		startIndex =128L ;
	    endIndex = 256L  ;
		count =4;
		}
		
		//Long a = (8192L*64);
		Long a = startIndex;
			
		//while(a< (8192L*128 )) {
		while(a< endIndex) {
		String s = Long.toBinaryString(a);
		State state = new State(s);
		
		Double a1 =  state.evaluate(1,2,4,5);
		Double b1 =  state.evaluate(1,2,3,7);
		Double c1 =  state.evaluate(1,3,5,7);
		Double d1 =  state.evaluate(2,5,6,7);
		Double e1 =  state.evaluate(3,4,5,7);
		Double f1 =  state.evaluate(1,2,3,5);
		Double g1 =  state.evaluate(4,5,6,7);
		Double h1 =  state.evaluate(3,5,6,7);
	
		
		Double sum = a1+b1+c1+d1+e1+f1+g1+h1;
		System.out.println("At a="+a+ "   "+s+"------   "+sum);
		
		//List<Double> values = addTolist(a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,k1,l1,m1,n1,o1,p1,q1,r1,s1,t1);
		//Double sum_c = getValues(values);
		//sum_c =sum_c+sum;
		
		if(s.charAt(count)=='0') {
		sum0 = sum0+sum;
		//sumsq0 = sumsq0 + Math.pow(sum, 2);
		//sumcu0 = sumcu0 + Math.pow(sum,3);
		//prevSum02 = prevSum02 + sum * prevSum0;
		//prevSum0 = sum;
		//sum00 = sum00+doSum1(sum,prevSum0);
		//cumvSum0 = cumvSum0 + Math.pow((sum - prevSum0),2); //+ Math.pow(sum-prev2Sum0, 2);
		//prev2Sum0 = new Double(prevSum0);
		//prevSum0 = new Double(sum);
		//sumc_0= sumc_0+ Math.pow(sum_c,4);
		zeroList.add(sum);
		
		
		}
		
		
		if(s.charAt(count)=='1') {
		sum1 = sum1+sum;
		//sumsq1 = sumsq1 + Math.pow(sum, 2);
		//sumcu1 = sumcu1 + Math.pow(sum,3);
		//prevSum12 = prevSum12 +  Math.pow((sum*sum - prevSum1*prevSum1),2);
		//prevSum1 = sum;
		//sum11 = sum11+doSum1(sum,prevSum1);
		//prevSum12 = prevSum12 + sum * prevSum1;
		//cumSum1 = cumSum1 + Math.pow((sum - prevSum1),2);//+ Math.pow(sum-prev2Sum1, 2);
		//prev2Sum1 = new Double(prevSum1);
		//prevSum1 = new Double(sum);
		oneList.add(sum);
		
		//sumc_1= sumc_1+  Math.pow(sum_c,4);
		
		}
		
		if(sum>max){
		max =sum;
		}
		
		if(sum>6){
		maxc++;	
		}
		a++;
		///sum1 = sum1+sum;
		
		}
		
		//Double sum2=0.0;
		
		print(zeroList);
		print(oneList);
		System.out.println("");
		
		sum0 = getProductOfNumbersAndDistance(zeroList);
		sum1 = getProductOfNumbersAndDistance(oneList);
		
		
		System.out.println("Sum0_0 is:"+sum0);
		System.out.println("Sum1_1 is:"+sum1);
		
		
		
		
		System.out.println("Max is:"+max);
		System.out.println("Maxc is:"+maxc);
		System.out.println("count1 is:"+count1);
		
		
		//System.out.println("SumC0 is:"+sumc_0);
		///System.out.println("SumC1 is:"+sumc_1);
		
		
		
	}
	
	private static void print(List<Double> zeroList2) {
		
		System.out.println();
		zeroList2.forEach(number->System.out.print(number+","));
	}

	public static Double getProductOfNumbersAndDistance(List<Double> list) {

		Double sum = 0.0;

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {

				if (i == j) {
					continue;
				}

				Double a = list.get(i);
				Double b = list.get(j);
				sum = sum + a * b * Math.pow(Math.abs(i - j),1);
				//sum = sum + a * b;
			}
		}
		return sum;
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
