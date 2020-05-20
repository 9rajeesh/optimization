package org.qc.general.combinatorics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Term {

	private Long factor;
	private Integer power2;
	private List<String> variables = new ArrayList<String>();
	
	public Term(Long factor,Integer power2,String variable) {
		this.factor=factor;
		this.power2=power2;
		this.variables.add(variable);
	}
	public Term(Long factor,Integer power2) {
		this.factor=factor;
		this.power2=power2;
		//this.variables.add(variable);
	}
		
	public Term() {
	
	}
	public Double evaluate() {
		Double p = 1.0;
		p = p*factor;
		Map valueMap = TermValues.getValueMap();
		for(int i=0;i<variables.size();i++) {
			p = p*TermValues.getValueMap().get(variables.get(i));
		}
		return p*Math.pow(2.0,this.power2);
	}

	public Integer getPower2() {
		return power2;
	}
	public void setPower2(Integer power2) {
		this.power2 = power2;
	}

	public List<String> getVariables() {
		return variables;
	}

	public void setVariables(List<String> variables) {
		this.variables = variables;
	}
	
	
	public Long getFactor() {
		return factor;
	}

	public void setFactor(Long factor) {
		this.factor = factor;
	}

	public String toString() {
		
		String s1 = "";
		s1 = factor+"*"+"2^"+power2+" "+ variables.stream().collect(Collectors.joining(" "));
		return s1;
	}

	public Term multiply(Term term1,Term term2) {
		Term term = new Term();
		term.setFactor(term1.getFactor()*term2.getFactor());
		term.setPower2(term1.getPower2()+term2.getPower2());
		term.getVariables().addAll(term1.getVariables());
		term.getVariables().addAll(term2.getVariables());
		return term;
	}
	
	
	
}
