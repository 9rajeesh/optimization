package org.supersymmetry.order.zero.validate;

public class ValidateContainer {

	public static void main1(String[] args){
		
		Long start = (8192L*2);
		Long end =   (8192L*4);
		
		Integer count = 1;
		while(count<14){
		Validator.main(new String[]{start.toString(),end.toString(),count.toString()});
		
		if(Validator.sum2_0 >	Validator.sum2_1){
			end = end - ((end - start)/2);
	
		}
	
		else if(Validator.sum2_1 >=	Validator.sum2_0){
			
			start = start + ((end - start)/2);
		}
		
		
     	
		count++;
		}
		
	}
	
	
	public static void main2(String[] args){
		
		Long start = (8192L*64);
		Long end =   (8192L*128);
		
		Integer count = 1;
		while(count<20){
			Validate3.main(new String[]{start.toString(),
					                      end.toString(),
					                    count.toString()});
		
		if(Validate3.sum0 >	Validate3.sum1){
			end = end - ((end - start)/2);
				
		}
	
		else if(Validate3.sum1 >=	Validate3.sum0){
			start = start + ((end - start)/2);
		}
        
		
		count++;
		}
		
	}
	
  public static void main2_2(String[] args){
		
		Long start = (8192L*64);
		Long end =   (8192L*128);
		
		Integer count = 1;
		
		while(count<20){
		
		Validate3.main(new String[]{start.toString(),
					                end.toString(),
					                count.toString()});
			
		
		if(checkTrend(Validate3.sum0,Validate3.sum1,
				      Validate3.sumsq0,Validate3.sumsq1)){
			
		start = start + ((end - start)/2);
		}
		
		else{
		end = end - ((end - start)/2);
		}
   	
		count++;
		}
		
	}
  
  public static void main(String[] args){
		
		Long start = (8192L*64*16);
		Long end =   (8192L*128*16);
		
		Integer count = 1;
		
		while(count<20){
		
		Validate4.main(new String[]{start.toString(),
					                end.toString(),
					                count.toString()});
			
		
		if(checkTrend(Validate4.sum0,Validate4.sum1,
				      Validate4.sumsq0,Validate4.sumsq1,
				      Validate4.sumcu0,Validate4.sumcu1,
				      0.0,0.0)){
			
		start = start + ((end - start)/2);
		}
		
		else{
		end = end - ((end - start)/2);
		}
 	
		count++;
		}
		
	}
	
	public static boolean checkTrend(Double sum0, Double sum1,
			Double sum20, Double sum21,
			Double sum30, Double sum31,
			Double sum40, Double sum41) {

		double ratio_0 = sum0 / sum1;
		double ratio_1 = sum20 / sum21;
		double ratio_2 = sum30 / sum31;
		double ratio_3 = sum40 / sum41;

		double d20 = ratio_1 - ratio_0;
		double d21 = ratio_2 - ratio_1;
		double d31 = ratio_3 - ratio_2;

		double e10 = d21 - d20;
		double e21 = d31 - d21;
		System.out.println("e21:" + e21);
		System.out.println("e10:" + e10);

		/*
		 * if(e21<e10){ return true; } else if(e21>e10){ return false; }
		 */

		if (d21 < d20) {
			return true;
		} else {
			return false;
		}

	}
	
	
public static boolean checkTrend(Double sum0,Double sum1,Double sum20,Double sum21){
		
		double ratio_0 = sum0/sum1;
		double ratio_1 = sum20/sum21;
		
		if(ratio_1 <= ratio_0){
		//Decreasing	converging 1 win
		return true;
		}
		else if(ratio_1 > ratio_0){
	    //Diverging 0 win
		return false;	
		}
		return false;
		
	}
	
	
	
	
	
}
