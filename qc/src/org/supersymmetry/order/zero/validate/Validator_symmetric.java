package org.supersymmetry.order.zero.validate;

import java.util.ArrayList;
import java.util.List;

public class Validator_symmetric {
	
	
	static List<Double> zeroList = new ArrayList<Double>();
	static List<Double> oneList = new ArrayList<Double>();
	
	static Double prev2Sum0 = 0.0;
	static Double prev2Sum1 = 0.0;
	
	static Double prevSum0 = 0.0;
	static Double prevSum1 = 0.0;
	
	static Double cumvSum0 = 0.0;
	static Double cumSum1 = 0.0;
	
	
	static Double sum_0 = 0.0;
	static Double sum_1 = 0.0;
	
	static Double sum2_0 = 0.0;
	static Double sum2_1 = 0.0;
	
	static Double sum3_0 = 0.0;
	static Double sum3_1 = 0.0;
	
	static Double sumbst_0 = 0.0;
	static Double sumbst_1 = 0.0;
	
	static Double sumbsine_0 = 0.0;
	static Double sumbsine_1 = 0.0;
	
	static Double odd0 = 0.0;
	static Double even0 = 0.0;
	
	static Double odd1 = 0.0;
	static Double even1 = 0.0;
	
	static double max = 0.0;
	
	public static void main558(String[] args) {
		
		sum_0 = 0.0;
		sum_1 = 0.0;
		
		sum2_0 = 0.0;
		sum2_1 = 0.0;
		max = 0.0;
		
		//Long startIndex = Long.parseLong(args[0]) ;
		//Long endIndex = Long.parseLong(args[1]) ;
		//int count = Integer.parseInt(args[2]);
		int count = 14;
		
		Long startIndex = 1024L*32+ 1024*4+1024+256+128+32+16+4;
		Long endIndex = 1024L*64 - 1024*16 -1024*8 - 1024*2-512-64-8;
		//Integer a = (8192*2+4096+2048+1024+512+256+32+8+4);
		//Long a = (8192L*2 + 4096);
		Long a = startIndex;
		
		Double sum1 = 0.0;
		Double sum00 = 0.0;
		Double sum11 = 0.0;
		
		Double sum0_0 = 0.0;
		Double sum1_1 = 0.0;
		
		
		//while(a< (8192*4 -8192-128-64-16-2) ) {
		while(a< (endIndex) ) {
		String s = Long.toBinaryString(a);
		State state = new State(s);
		
		Double a1 =  state.evaluate(0,1,3, 4,5,6,  8,9,10);
		Double b1 =  state.evaluate(12,1,5,  7,8,9,  10,13,4);
		Double c1 =  state.evaluate(14,3,8,  11,12,15, 4,9,6);
		Double d1 =  state.evaluate(4,5,6,   8,10,11, 13,14,9);
		Double e1 =  state.evaluate(0,1,7,   3,9,12, 15,14,11);
		
		/*Double f1 =  state.evaluate(0,5,6,7,8,10,11,12);
		Double g1 =  state.evaluate(0,1,2,8,10,11,12);
		Double h1 =  state.evaluate(0,1,4,5,9,10,11,12);
		Double i1 =  state.evaluate(0,1,3,5,6,7,8,9);
		Double j1 =  state.evaluate(0,1,2,8,7,9,11,12);
		
		Double k1 =  state.evaluate(0,1,2,8,9,12,9,8);
		Double l1 =  state.evaluate(5,9,4,1,2,9);
		Double m1 =  state.evaluate(3,6,8,10,13);
		Double n1 =  state.evaluate(0,1,5);
		*/
		Double sum = a1+b1+c1+d1+e1;
		///List<Double> values = addTolist(a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,k1,l1,m1,n1);
		///Double sum_c = getValues(values);
		Double diff = 14.0 - sum;
		
		Double sumd = sum - diff;
		
		System.out.println("At a="+a+ "   "+s+"------   "+sum);
		
		if(sum>max) {
			max=sum;
		}
		if(s.charAt(count)=='0') {
		//sum00 = sum00+doSum1(sum,prevSum0);
		//sum0_0 = sum0_0 + doSum(sum);
		///sumc_0= sumc_0+ sum_c*sum_c*sum_c;
		//cumvSum0 = cumvSum0 + Math.pow((sum - prevSum0),2); //+ Math.pow(sum-prev2Sum0, 2);
		//prev2Sum0 = new Double(prevSum0);
		// = new Double(sum);
		prevSum0=sum;
		sum_0 = sum_0+ sum;
		sum2_0 = sum2_0+ sum*sum;
		sum3_0 = sum3_0+ sum*sum*sum;
		sumbst_0 = sumbst_0 + bell(sum);
		//System.out.println("Bell is:"+bell(sum));
		sumbsine_0 = sumbsine_0 + bell2(sum);
		
		zeroList.add(sum);
		oddEven0(sum+sum);
				
		}
				
		if(s.charAt(count)=='1') {
		sum11 = sum11+doSum1(sum,prevSum1);
		//cumSum1 = cumSum1 + Math.pow((sum - prevSum1),2);//+ Math.pow(sum-prev2Sum1, 2);
		//prev2Sum1 = new Double(prevSum1);
		//prevSum1 = new Double(sum);
		sum1_1 = sum1_1 + doSum(sum);
		prevSum1=sum;
		oneList.add(sum);
		sum_1 = sum_1+ sum;
		sum2_1 = sum2_1+ sum*sum;
		sum3_1 = sum3_1+ sum*sum*sum;
		sumbst_1 = sumbst_1 + bell(sum);
		sumbsine_1 = sumbsine_1 + bell2(sum);
		//sumc_1= sumc_1+ sum_c*sum_c*sum_c;
		oddEven1(sum+sum);
		//System.out.println("Bell is:"+bell(sum));
		}
		
		a++;
		sum1 = sum1+sum;
		
		}
		System.out.println("Sum is:"+sum1);
		Double sum2=0.0;
		
		System.out.println("sum_0 is:"+sum_0);
		System.out.println("sum_1 is:"+sum_1);
		
		System.out.println("sum2_0 is:"+sum2_0);
		System.out.println("sum2_1 is:"+sum2_1);
		
		System.out.println("sum3_0 is:"+sum3_0);
		System.out.println("sum3_1 is:"+sum3_1);
		
		System.out.println("sumbst_0 is:"+sumbst_0);
		System.out.println("sumbst_1 is:"+sumbst_1);
		
		System.out.println("sumbsine_0 is:"+sumbsine_0);
		System.out.println("sumbsine_1 is:"+sumbsine_1);
		
		System.out.println("Max is:"+max);
		
		
		
		//System.out.println("CumSum00 is:"+cumvSum0);
		//System.out.println("CumSum11 is:"+cumSum1);
		
       Double Asum0 = 0.0;
     // zeroList.set(0, zeroList.get(0)+1.0);
     /// oneList.set(0, oneList.get(0)+1.0);
       
       //zeroList.add(2.0);
       //oneList.add(2.0);
		/*
		for(int i=0;i<zeroList.size();i++) {
			
			Double a5 = (Double)zeroList.get(i);
			
			 for(int j=0;j<zeroList.size();j++) {
				
				 Double b5 = (Double)zeroList.get(j);
				 Asum0 = Asum0 + Math.pow(a5*a5-b5*b5, 4);
			 }
		  }
		
		
		System.out.println("Asum0 is:"+Asum0);
		
		 Double Asum1 = 0.0;
			
		 for(int i=0;i<oneList.size();i++) {
				
				Double a5 = (Double)oneList.get(i);
				
				 for(int j=0;j<oneList.size();j++) {
					
					 Double b5 = (Double)oneList.get(j);
										 
					  Asum1 = Asum1 +Math.pow(a5*a5-b5*b5, 4);
				 }
			  }
			
			System.out.println("Asum1 is:"+Asum1);
		*/
	}
	
	private static void oddEven1(Double sum) {
		
		Long sum1 = sum.longValue();
		if(sum1%2==0) {
			
			even1 = even1 + 1;
		}
		else {
			odd1 = odd1+1;
		}
		
	}

	private static void oddEven0(Double sum) {
		Long sum1 = sum.longValue();
		if(sum1%2==0) {
			
			even0 = even0 + 1;
		}
		else {
			odd0 = odd0+1;
		}
		
	}

	private static Double getValues(List<Double> values) {
		
		Double sum = 0.0;
		for(int i =0;i<values.size();i++) {
			Double a = values.get(i);
			
			for(int j=0;j<values.size();j++) {
				Double b = values.get(j);
				
				if(i==j) {
				continue;
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

	public static Double doSum1(double sum,double prevSum) {
		return Math.pow(sum-prevSum,2);
	//return 1+ Math.pow(10.1*sum,2);
			
	}
	
	public static Double doSum(double sum) {
		
		
		return  Math.pow(sum,2);
	}
	
public static Double bell(Double sum1) {
		
	//Double sum = Math.sin(Math.PI*sum1/14);
	//return sum*sum;
	
	if(sum1<=7) {
		return 7-sum1;
	}
	
	else if(sum1>7) {
	return sum1-7;
	}
	
	return 0.0;
	}


public static Double bell2(Double sum1) {
	
	Double sum = Math.sin(Math.PI*sum1/14);
	return sum;
	
	}
	
	public static Double getPeriodSum(Double period,Double value) {
		
		Double sum = 0.0;
		for(Double x=0.0;x<10;x=x+0.1) {
		sum = sum + Math.sin(2*Math.PI*x/period)*Math.sin(2*Math.PI*x/value);
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		
		Long startIndex = 512L;
		Long endIndex = 1024L;
		Integer count = 1;
		Validate9.main(new String[]{startIndex.toString(),endIndex.toString(),count.toString()});
	}
	
}
