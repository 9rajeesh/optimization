package org.waves;

public class WaveGenerator {

	
	/*
	 * sigma (4/pi) * sin(nx)
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args){
		
		double x = 0.001;
		double sinx = Math.sin(x);
		double squarex = sum(x,5000);
		
		System.out.println(" sin x is:"+sinx);
		System.out.println(" square x is:"+squarex);
		
	}

	private static double sum(double x, int i) {
		
		Double sum = 0.0;
		for(double n=1; n <i; n=n+2){
			
		double sum1 = ((4/Math.PI)* Math.sin(n*x) * (1/n));
		sum = sum + sum1;
			
		}
		
		
		return sum;
	}
	
	
	
	
	
	
}
