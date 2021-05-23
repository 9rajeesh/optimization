package org.qc.xor.sat.optimization;

import java.util.HashSet;
import java.util.Set;

public class Test {

	static double var =  0.0000215895463;
	static double var1 = 0.000031256456546;		

	public static void main(String[] args) {

		Set<String> p = new HashSet<>();



		for (double x = 1; x <  65536*32; x = x + 1) {
			
			
			Double y =  (Math.random() * 65536*12800.0);
			
			
			String t = "";

			for (Integer i = 0; i < 60; i++) {
				
				
				//
				double x1 = Math.cos(i*var*y)*Math.sin(i*var1*y);
           
           //System.out.println(x1);
				
				
				if (x1 < 0) {
					t = t + "0";
				}


				else if (x1 >= 0) {
					t = t + "1";
				}	

				else {
					t = t + "a";
				}
			}

			if (!t.contains("a")) {
				p.add(t);
			}
			System.out.println(t);
		}
		System.out.println("Size is:" + p.size());

	}

}
