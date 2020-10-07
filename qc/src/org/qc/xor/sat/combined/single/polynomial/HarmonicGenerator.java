package org.qc.xor.sat.combined.single.polynomial;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HarmonicGenerator {

	
	
	
	private static final int MAX_HARMONIC = 100;
	static Map<Integer,List<Term>> termMapX = new HashMap<>();
		
	
	
	static {
		
		termMapX.put(0, Arrays.asList(new Term(0,new BigDecimal(1.0))));
		termMapX.put(1, Arrays.asList(new Term(1,new BigDecimal(1.0))));
		
		for(int i=1;i<MAX_HARMONIC;i++) {
			initilaizeHarmonicMap(i);
		}
		
	}
	
	/**Generates harmonics of cos (px)
	 * 
	 * cos[(p+1)x] = 2cospx.cosx - cos[(p-1)x]
	 * 
	 * @param harmonic
	 * @return
	 */
		
	public static void initilaizeHarmonicMap(Integer harmonic){
		
		
		for(Integer i=1;i<=harmonic;i++) {
			
		  List<Term> two = Arrays.asList(new Term(0,new BigDecimal(2)));
		  List<Term> cospx = termMapX.get(i);
		  List<Term> cosx  =  termMapX.get(1);
		  
		  List<Term> first = Term.multiplyTerms(Term.multiplyTerms(two, cospx),cosx);
		  List<Term> second = invert(termMapX.get(i-1));
		  first.addAll(second);
		  
		  termMapX.put(i+1,first);
		}
				
	}

	private static List<Term> invert(List<Term> terms) {
		terms.forEach(term->term.setFactor(term.getFactor().multiply(new BigDecimal(-1.0))));
		return terms;
	}

	public static List<Term> getHarmonic(int i) {
		
		return null;
	}
	
	
}
