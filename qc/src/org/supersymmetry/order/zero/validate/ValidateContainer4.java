package org.supersymmetry.order.zero.validate;

public class ValidateContainer4 {

public static void main21(String[] args){
		
		
		Long start = (8192L*64);
		Long end =   (8192L*128);
		
		Integer count = 1;
		
		while(count<20){
		
		Validate3.main(new String[]{start.toString(),
					                end.toString(),
					                count.toString()});
			
		
		if(Validate3.sum0 < Validate3.sum1){
			
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
		
		while(count<24){
		
		Validate4.main(new String[]{start.toString(),
					                end.toString(),
					                count.toString()});
			
		
		if(Validate4.sumsq0 < Validate4.sumsq1){
			
		start = start + ((end - start)/2);
		}
		
		else{
		end = end - ((end - start)/2);
		}
 	
		count++;
		}
		
		
		
		
		
		
	}
	
	
	public static void main25(String[] args){
		
		
		Long start = (8192L*64*16);
		Long end =   (8192L*128*16);
		
		Integer count = 1;
		
		while(count<24){
		
		Validate4.main(new String[]{start.toString(),
					                end.toString(),
					                count.toString()});
			
		
		if(checkTrend(Validate4.sum0,Validate4.sum1,
				      Validate4.sumsq0,Validate4.sumsq1)){
			
		start = start + ((end - start)/2);
		}
		
		else{
		end = end - ((end - start)/2);
		}
 	
		count++;
		}
		
		
		
		
		
		
	}
	
	
	public static boolean checkTrend(Double sum0, Double sum1,
			                         Double sum20, Double sum21
			) {

		double ratio_0 = 1;
		double ratio_1 = sum0 / sum1;
		double ratio_2 = sum20 / sum21;
		

		double d20 = ratio_1 - ratio_0;
		double d21 = ratio_2 - ratio_1;
		

	
		

		/*
		 * if(e21<e10){ return true; } else if(e21>e10){ return false; }
		 */

		if (d21 < d20) {
			return true;
		} else {
			return false;
		}

	}
	
	
	
	
	
	
	
	
	
}
