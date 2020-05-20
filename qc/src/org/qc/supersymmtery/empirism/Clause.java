package org.qc.supersymmtery.empirism;

import java.util.ArrayList;
import java.util.List;

public class Clause {

	
	private List<Term> terms = new ArrayList<>();
	
	public Clause(String v1, String v2){
	Term term1 = new Term(v1);
	Term term2 = new Term(v2);
	this.terms.add(term1);
	this.terms.add(term2);
		
	}

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}
	
	
}
