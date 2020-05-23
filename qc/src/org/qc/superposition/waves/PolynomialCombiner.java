package org.qc.superposition.waves;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PolynomialCombiner {

	static Double x = 0.0;
	static Double y = 0.0;
	static Integer length = 4;
	
	public static void main(String[] args) {
		
		
		Set<String> bitSet = new HashSet<>();
		
		for(int i=0;i<200;i++) {
		x = randomize(x);
		y = randomize(y);
		
		
		List<Integer> harmoncisOfx = computeHarmonics(x);
		List<Integer> harmoncisOfy = computeHarmonics(y);
		
		String bitString  = combine(harmoncisOfx,harmoncisOfy);
		System.out.println("Bit String is:"+bitString);
		bitSet.add(bitString);
		}
		
		
		System.out.println("Bit String Set size is:"+bitSet.size());
	}

	private static String combine(List<Integer> harmoncisOfx, List<Integer> harmoncisOfy) {

		String bitString = "";
		for (int i = 0; i < harmoncisOfx.size(); i++) {
			Integer value = xor(harmoncisOfx.get(i), harmoncisOfy.get(i));
			bitString = bitString + String.valueOf(value);
		}

		return bitString;
	}

	private static Integer xor(Integer integer, Integer integer2) {
		
		if(integer.equals(integer2)) {
		return 0;
		}
		
		else {
		return 1;
		}
		
		
	}

	private static List<Integer> computeHarmonics(Double x) {
       List<Integer> harmonics = new ArrayList<>();
       
       harmonics.add(getMSB(x));
       harmonics.add(getMSB(2*x*x - 1));
       harmonics.add(getMSB(4*x*x*x - 3*x));  
       harmonics.add(getMSB(8*x*x*x*x - 8*x*x + 1)); 

		return harmonics;
	}

	private static Integer getMSB(Double x2) {

		if(x2>0) {
		return 1;
		}
		
		return 0;
	}

	private static Double randomize(Double x2) {

		Double x = 1 - (Math.random() * 2);

		return x;
	}
	
}
