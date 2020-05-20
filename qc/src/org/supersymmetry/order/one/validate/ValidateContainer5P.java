package org.supersymmetry.order.one.validate;

public class ValidateContainer5P {

	
	   public static void main(String[] args){
			
			Long start = (32768L);
			Long end =   (65536L);
			
			Integer count = 1;
			while(count<16){
				Validate5P.main(new String[]{start.toString(),end.toString(),count.toString()});
			
				if (Validate5P.sum0 > Validate5P.sum1) {
					end = end - ((end - start) / 2);
	     		}

				else if (Validate5P.sum0 <= Validate5P.sum1) {
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
}
