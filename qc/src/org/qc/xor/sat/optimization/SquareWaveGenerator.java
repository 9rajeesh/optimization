package org.qc.xor.sat.optimization;

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
	
	
	
	public List<Term> generateSquareWave(Integer varIndex){
		
		List<Term> result = new ArrayList<>();
		
		for(int i=1;i<FOURIER_TERMS;i++) {
		
		List<Term> termsx = HarmonicGenerator.getHarmonic(varIndex*i,"x");
		List<Term> termsy = HarmonicGenerator.getHarmonic(varIndex*i,"y");
		
		termsx = applyScale(termsx);
		termsy = applyScale(termsy);
		
		result.addAll(termsx);
		result.addAll(termsy);
		}
		
		
		return result;
	}

	private List<Term> applyScale(List<Term> terms) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
