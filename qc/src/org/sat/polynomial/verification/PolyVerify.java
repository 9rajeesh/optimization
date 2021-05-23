package org.sat.polynomial.verification;

import java.util.HashSet;
import java.util.Set;

public class PolyVerify {

	static Set<String> pSet = new HashSet<>();
	
	public static void main(String[] args) {

		double x = 2.245645;
	
		
		
		for (Integer p = 0; p < 1024*1024; p++) {

			String s = "";
			
			Double power = 1.0;
			
			for (Integer a = 0; a <40; a++) {
				
				double y = Math.sin(power*(x+a)*(x+a)+ (x+a)+2 );
				Integer value = calc(y);
				
				s = s + value;
				power = power + 2;
				
			}
			pSet.add(s);
			System.out.println("Values are:"+s);
			x = x + 0.01;
		}
		
		System.out.println("Size is:"+pSet.size());

	}

	private static Integer calc(double x) {
		
		if(x<0) {
			return 0;
		}
		else {
			return 1;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
