package org.qc.xor.sat.combined.single.polynomial;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SquareWaveGenerator {

	
	
	private static final int FOURIER_TERMS = 10;

	/**
	 * 
	 * 
	 * @param harmonic
	 * @return
	 */
	
	
	
	public static List<Term> generateSquareWave(Integer varIndex){
		
		List<Term> result = new ArrayList<>();
		
		for(int i=1;i<FOURIER_TERMS;i++) {
		
		List<Term> termsx = HarmonicGenerator.getHarmonic(varIndex*i);
		termsx = applyScale(termsx,new BigDecimal(1.0));
		result.addAll(termsx);
		
		}
		return result;
	}

	private static List<Term> applyScale(List<Term> terms,BigDecimal scale) {
		
		terms.forEach(term->{
			
			term.setFactor(term.getFactor().multiply(scale));
		});
		return null;
	}
	
	
}
