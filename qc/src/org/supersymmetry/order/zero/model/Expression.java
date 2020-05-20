package org.supersymmetry.order.zero.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Expression {

	public Expression() {
		
	}
	
	public Expression(List<Term> terms1) {
    this.terms=terms1;
	}

	private List<Term> terms = new ArrayList<Term>();

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}
	
	
	public static Expression mergeLikeTerms(Expression expression) {
		
		Expression e = new Expression();
		Map<String, List<Term>> terms =  expression.getTerms()
				.stream()
				.collect(Collectors.groupingBy(Term::toString));
		
		List<Term> termList = new ArrayList();
		terms.forEach((k,v)->{
			Term term = v.get(0);
			Double factor =  v.stream().collect(Collectors.summingDouble(Term::getFactor));
			term.setFactor(factor);
			termList.add(term);
		});
		e.setTerms(termList);
		
		return e;
	}
	
	public Expression multiply(Expression expression1,Expression expression2) {
		Expression result = new Expression();
		
		expression1.getTerms().stream().forEach(term1->{
		  	expression2.getTerms().stream().forEach(term2->{
		  		result.getTerms().add(multiply(term1,term2));
			});
			
		});
	return result;
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer("");
		this.getTerms().forEach(term->{
			s.append(term.getFactor()+"*"+term+ "+");
		});
		String b = s.toString();
		if(b.endsWith("+")) {
		b=b.substring(0,b.length()-1);
		}
		return b;
	}

	private Term multiply(Term term1, Term term2) {
		
		Term term = new Term(term2);
		term1.getMap().forEach((k1,v1) ->{
			Integer power = term2.getMap().get(k1);
			
			if (power != null) {
				term.getMap().put(k1, v1 + power);
				term.setFactor(term1.getFactor()*term2.getFactor());
			} 
			else {
				term.getMap().put(k1, v1);
				term.setFactor(term1.getFactor()*term2.getFactor());
			}
		});
		
		
		return term;
	}

	public Expression add(Expression e) {
		
		Expression newE = new Expression();
		newE.getTerms().addAll(this.getTerms());
		newE.getTerms().addAll(e.getTerms());
		newE  = mergeLikeTerms(newE);
		return newE;
	}

	public void setScale(Double scale) {
	
		this.getTerms().forEach(term->{
			term.setFactor(term.getFactor()*scale);	
		});;
	
		
	}

	public Double evaluate(String string, int i) {
	
		Double value = this.getTerms().stream().collect(Collectors.summingDouble(Term::getFactor));
		
		return value;
	}
	
	
	
} 
