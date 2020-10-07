package org.qc.xor.sat.optimization;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HarmonicGenerator {

	
	
	
	static Map<Integer,List<Term>> termMapX = new HashMap<>();
	static Map<Integer,List<Term>> termMapY = new HashMap<>();
	
	
	public void init() {
		
		termMapX.put(0, Arrays.asList(new Term(0,0,new BigDecimal(1.0))));
		termMapX.put(1, Arrays.asList(new Term(1,0,new BigDecimal(1.0))));
		
		termMapY.put(0, Arrays.asList(new Term(0,0,new BigDecimal(1.0))));
		termMapY.put(1, Arrays.asList(new Term(0,1,new BigDecimal(1.0))));
		
		calculateHigher(100);
	}
	
	
	
	
	public static List<Term> getHarmonic(Integer harmonic, String variable) {

		switch (variable) {

		case "x":
			return termMapX.get(harmonic);
		case "y":
			return termMapY.get(harmonic);
		default:
			return null;

		}
	}
	
	/**Generates harmonics of cos (px)
	 * 
	 * cos[(p+1)x] = 2cospx.cosx - cos[(p-1)x]
	 * 
	 * @param harmonic
	 * @return
	 */
		
	public static void calculateHigher(Integer harmonic){
		
		
		for(Integer i=1;i<=harmonic;i++) {
			
		  List<Term> two = Arrays.asList(new Term(0,0,new BigDecimal(2)));
		  List<Term> cospx = termMapX.get(i);
		  List<Term> cosx  =  termMapX.get(1);
		  
		  List<Term> first = Term.multiplyTerms(Term.multiplyTerms(two, cospx),cosx);
		  List<Term> second = invert(termMapX.get(i-1));
		  first.addAll(second);
		  
		  termMapX.put(i+1,first);
		}
		
		for(Integer i=1;i<=harmonic;i++) {
			
			  List<Term> two = Arrays.asList(new Term(0,0,new BigDecimal(2)));
			  List<Term> cospx = termMapY.get(i);
			  List<Term> cosx  =  termMapY.get(1);
			  
			  List<Term> first = Term.multiplyTerms(Term.multiplyTerms(two, cospx),cosx);
			  List<Term> second = invert(termMapY.get(i-1));
			  first.addAll(second);
			  
			  termMapY.put(i+1,first);
			}
				
	}

	private static List<Term> invert(List<Term> list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
