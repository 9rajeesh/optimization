package org.qc.factorisation.model;

import java.math.BigDecimal;

public class BiTerm {

	private Term term1;
	private Term term2;
	private BigDecimal factor;
	
	public BiTerm(Term term1,Term term2,BigDecimal factor) {
		this.term1=term1;
		this.term2=term2;
		this.factor=factor;
	}

	public Term getTerm1() {
		return term1;
	}

	public void setTerm1(Term term1) {
		this.term1 = term1;
	}

	public Term getTerm2() {
		return term2;
	}

	public void setTerm2(Term term2) {
		this.term2 = term2;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}
	
	
	
	
}
