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
		int  count =0;
		for(Long i=0L;i<1000000;i++) {
		
		x = randomize(x);
		y = randomize(y);
		
		
		List<Integer> harmoncisOfx = computeHarmonics(x);
		List<Integer> harmoncisOfy = computeHarmonics(y);
		
		String bitString  = combine(harmoncisOfx,harmoncisOfy);
		
		
		if(!bitString.contains("2")) {
		//System.out.println("Bit String is:"+bitString);
		bitSet.add(bitString);
		
		}
		if(count ==1000) {
		System.out.println("Bit size is:"+bitSet.size());
		count =0;
		}
		
		count++;
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
		
		if(integer.equals(2) || integer2.equals(2)) {
			return 2;
		}
		
		if(integer.equals(integer2)) {
		return 0;
		}
		
		else {
		return 1;
		}
		
		
	}

	private static List<Integer> computeHarmonics(Double x) {
       List<Integer> harmonics = new ArrayList<>();
       
//       harmonics.add(getMSB(x));
//       harmonics.add(getMSB(2*x*x - 1));
//       harmonics.add(getMSB(4*x*x*x - 3*x));  
//       harmonics.add(getMSB(8*x*x*x*x - 8*x*x + 1)); 
       
       HarmonicGenerator harmonicGenerator = new HarmonicGenerator();
       harmonics.add(getMSB(x));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 2)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 3)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 4)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 5)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 6)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 7)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 8)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 9)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 10)));
       
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 11)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 12)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 13)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 14)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 15)));
       
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 16)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 17)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 18)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 19)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 20)));
       
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 21)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 22)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 23)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 24)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 25)));
       
       
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 26)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 27)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 28)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 29)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 30)));
       
       
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 31)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 32)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 33)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 34)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 35)));
       
       
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 36)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 37)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 38)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 39)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 40)));
       
       
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 41)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 42)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 43)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 44)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 45)));
       
       
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 46)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 47)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 48)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 49)));
       harmonics.add(getMSB(harmonicGenerator.computeHarmonic(x, 50)));

		return harmonics;
	}

	private static Integer getMSB(Double x2) {

		if(x2 > 0.01) {
		return 1;
		}
		
		else if(x2 < -0.01) {
		return 0;
		}
		
		return 2;
	}

	private static Double randomize(Double x2) {

		Double x = 1 - (Math.random() * 2);

		return x;
	}
	
}
