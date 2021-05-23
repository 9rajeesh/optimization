package org.qc.boson.sampler.superposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Term {

	private List<String> variables = new ArrayList<String>();
	
	private Double factor;
	
	
	
	public Term(String...vars) {
		
	variables = Arrays.asList(vars);
	//computeFactor();	
	}
	
	
	public void computeFactor(Integer length) {
		
		
		
		Double factor = (1.0/length);
		Integer diffpower = length - variables.size();
		
		//Review formula
		factor = factor * (1/Math.pow(2, (variables.size() - 1 )));
		
	}
	
	public String toString() {
		
		String s = "";
		for(String v:variables) {
			s =s +v;
		}
		
		return s;
	}
	
	
	
	
	
	
	
	
	
}
