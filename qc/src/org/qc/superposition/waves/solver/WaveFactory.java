package org.qc.superposition.waves.solver;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaveFactory {

	
	private Integer numberofVariables;
	private BigDecimal period1;
	private BigDecimal period2;
	
	private Map<String,List<Term>> variableMap = new HashMap<String,List<Term>>();
	
	
	public WaveFactory(Integer numberofVariables,BigDecimal period1,BigDecimal period2){
		this.numberofVariables = numberofVariables;
		this.period1 = period1;
		this.period2 = period2;
	}
	
	
	
	public void get(){
		
		Term term1 = new Term(new BigDecimal(1.0),1,0, null, null,0);
		Term term2 = new Term(new BigDecimal(1.0),0,1, null, null,1);
	}
	
	public void generateVariableMap(){
		
		
		
		
		
		
		
	}
	
	
}
