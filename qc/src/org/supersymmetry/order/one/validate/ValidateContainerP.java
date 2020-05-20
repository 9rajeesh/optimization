package org.supersymmetry.order.one.validate;

import org.supersymmetry.order.zero.validate.Validate3;

public class ValidateContainerP {

	public static void main10(String[] args){
		
		Long start = (8192L*2);
		Long end =   (8192L*4);
		
		Integer count = 1;
		while(count<14){
		ValidatorP.main(new String[]{start.toString(),end.toString(),count.toString()});
		
			if (ValidatorP.sum2_0 > ValidatorP.sum2_1) {
				end = end - ((end - start) / 2);
     		}

			else if (ValidatorP.sum2_1 > ValidatorP.sum2_0) {
			start = start + ((end - start) / 2);
			}

			else if (ValidatorP.sum2_1.equals(ValidatorP.sum2_0)) {

				if (ValidatorP.sum3_0 > ValidatorP.sum3_1) {
				end = end - ((end - start) / 2);
				}

				else if (ValidatorP.sum3_1 >= ValidatorP.sum3_0) {
				start = start + ((end - start) / 2);
				}
			}
	  	
		count++;
		}
		
	}
	
    public static void main(String[] args){
		
		Long start = (128L);
		Long end =   (256L);
		
		Integer count = 1;
		while(count<8){
			Validate4P.main(new String[]{start.toString(),end.toString(),count.toString()});
		
			if (Validate4P.sum0 > Validate4P.sum1) {
				end = end - ((end - start) / 2);
     		}

			else if (Validate4P.sum0 <=  Validate4P.sum1) {
			start = start + ((end - start) / 2);
			}
			
            /*
			else if (Validate3P.prevSum02.equals(Validate3P.prevSum12)) {

				if (Validate3P.sumcu0 > Validate3P.sumcu1) {
				end = end - ((end - start) / 2);
				}

				else if (Validate3P.sumcu1 >= Validate3P.sumcu0) {
				start = start + ((end - start) / 2);
				}
				*/
			
			count++;
			}
	  	
	
		}
		
	
	
	/*
	public static void main1(String[] args){
		
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
	*/
	
public static void main25(String[] args){
		
		Long start = (8192L*64);
		Long end =   (8192L*128);
		
		Integer count = 1;
		
		while(count<20){
		
		Validate3P.main(new String[]{start.toString(),
					                end.toString(),
					                count.toString()});
			
		
		if(checkTrend(Validate3P.sum0,Validate3P.sum1,
				      Validate3P.sumcu0,Validate3P.sumcu1)){
			
		start = start + ((end - start)/2);
		}
		
		else{
		end = end - ((end - start)/2);
		}
   	
		count++;
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
