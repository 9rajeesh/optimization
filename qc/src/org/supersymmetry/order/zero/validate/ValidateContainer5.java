package org.supersymmetry.order.zero.validate;

public class ValidateContainer5 {

	
	public static void main(String[] args){
		
		Long start = (8192L*64);
		Long end =   (8192L*128);
		
		Integer count = 1;
		while(count<20){
		Validate8.main(new String[]{start.toString(),end.toString(),count.toString()});
		
		if(Validate8.sum0 >	Validate8.sum1){
			end = end - ((end - start)/2);
	
		}
	
		else if(Validate8.sum1 >=	Validate8.sum0){
			
			start = start + ((end - start)/2);
		}
		
		count++;
		
	}
	
	
	}
}
	
	

