package org.qc.xor.sat.combined.single.polynomial;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Term {

	
	private Integer xpower;
	
	private BigDecimal factor;

	public Integer getXpower() {
		return xpower;
	}

	public void setXpower(Integer xpower) {
		this.xpower = xpower;
	}

	

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public Term(Integer xpower,  BigDecimal factor) {
		super();
		this.xpower = xpower;
		this.factor = factor;
	}
	
	
	public Term() {
		// TODO Auto-generated constructor stub
	}

	public static List<Term> multiplyTerms(List<Term> terms1, List<Term> terms2) {
		
		List<Term> results = new ArrayList<>();
		terms1.forEach(term1->{
			
			terms2.forEach(term2->{
				results.add(multiply(term1,term2));
			});
		});	
		return results;
		
	}

	private static Term multiply(Term term1, Term term2) {


		Term result = new Term();
		result.setFactor(term1.getFactor().multiply(term2.getFactor()));
		result.setXpower(term1.getXpower() + term2.getXpower());
		
		
		return result;
	}
	
	
}
