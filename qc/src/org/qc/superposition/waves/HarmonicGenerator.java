package org.qc.superposition.waves;

public class HarmonicGenerator {

		
	public Double computeHarmonic(Double x,Integer harmonicDegree) {
		
		Double cosx = x;
		Double sinx = Math.sqrt(1-x*x);
		
		ComplexNumber e1 = new ComplexNumber(cosx,sinx);
		ComplexNumber e2 = new ComplexNumber(cosx,-sinx);
		
		
		ComplexNumber result = ComplexNumber.add(power(e1,harmonicDegree),
				                                 power(e2,harmonicDegree));
		
		return result.getReal()/2.0;
	}

	private ComplexNumber power(ComplexNumber e1, Integer harmonicDegree) {
		
		ComplexNumber result = new ComplexNumber(e1.getReal(),e1.getImg());
		
		for(int i=1;i<harmonicDegree;i++) {
			result  = ComplexNumber.multiply(result, e1);
		}
		
		return result;
	}
}
