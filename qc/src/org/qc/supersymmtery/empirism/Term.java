package org.qc.supersymmtery.empirism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Term {

	private Set<String> variables = new TreeSet<>();
	private Long factor = 1L;
	
	public Term(){
		
	}
	
		
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((variables == null) ? 0 : variables.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (variables == null) {
			if (other.variables != null)
				return false;
		} else if (!variables.equals(other.variables))
			return false;
		return true;
	}



	public Term(String variable){
	this.getVariables().add(variable);	
	}
	
	public Set<String> getVariables() {
		return variables;
	}

	public void setVariables(Set<String> variables) {
		this.variables = variables;
	}

	public Long getFactor() {
		return factor;
	}


	public void setFactor(Long factor) {
		this.factor = factor;
	}

	
	
	

	@Override
	public String toString() {
	return this.factor+ "*"+variables;
	}


	public static List<Term> multiply(List<Term> terms1, List<Term> terms2){
		
		if(terms1.isEmpty()){
		return terms2;
		}
		
		else if(terms2.isEmpty()){
		return terms1;
		}
		
		
		List<Term> result = new ArrayList<>();
		terms1.forEach(term1->{
			terms2.forEach(term2->
				result.add(multiply(term1,term2)));
		});
	  return result;
	}



	private static Term multiply(Term term1, Term term2) {
		
		Term result = new Term();
		result.variables.addAll(term1.variables);
		result.variables.addAll(term2.variables);
		result.factor= term1.factor*term2.factor;
		return result;
	}
	
	public static List<Term> mergeTerms(List<Term> terms) {

		List<Term> result = new ArrayList<>();

		Map<Term, List<Term>> termMap = terms.stream().collect(Collectors.groupingBy(term -> term));

		termMap.forEach((k, v) -> {
		Long sum = v.stream().collect(Collectors.summingLong(Term::getFactor));
		k.factor=sum;
		result.add(k);
		});

		return result;
	}
	
	
}
