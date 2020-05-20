package org.qc.superposition.waves.solver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Term {

	
	
	
	private BigDecimal factor;
	private Integer cosine1_power;
	private Integer sine1_power;
	private BigDecimal term1;
	
	private Integer cosine2_power;
	private Integer sine2_power;
	private BigDecimal term2;
	
	
	private Integer j;
	
	
	
	
	public Integer getJ() {
		return j;
	}



	public void setJ(Integer j) {
		this.j = j;
	}



	public Term (BigDecimal factor, Integer cosine1_power, Integer sine1_power, Integer cosine2_power,
			Integer sine2_power, Integer j) {
		super();
		this.factor = factor;
		this.cosine1_power = cosine1_power;
		this.sine1_power = sine1_power;
		this.cosine2_power = cosine2_power;
		this.sine2_power = sine2_power;
		this.j = j;
	}
	
	
	
	public Term() {
		// TODO Auto-generated constructor stub
	}



	public static List<Term> multiply(List<Term> terms1,List<Term> terms2){
		
		List<Term> terms = new ArrayList<Term>();
		
		terms1.forEach(term1->{
			terms2.forEach(term2->{
				terms.add(multiplyTerms(term1,term2));
			});
			
		});
		
		List<Term> mergedTerms = mergeLikeTerms(terms);
		return mergedTerms;
			
	}

	
      private static Term multiplyTerms(Term term1, Term term2) {
		
    	  Term term = new Term();
    	 
    	  term.factor =        term1.factor.multiply(term2.factor);
    	  term.cosine1_power = zeorNull(term1.cosine1_power) + zeorNull(term2.cosine1_power);
    	  term.sine1_power   = zeorNull(term1.sine1_power)   + zeorNull(term2.sine1_power);
    	  term.cosine2_power = zeorNull(term1.cosine2_power) + zeorNull(term2.cosine2_power);
    	  term.sine2_power =   zeorNull(term1.sine2_power)   + zeorNull(term2.sine2_power);
    	  term.j = (zeorNull(term1.j) + zeorNull(term2.j)) % 2;
    	  
    	  
		return term;
	}



	private static Integer zeorNull(Integer j2) {
				
		if(j2==null){
		return 0;
		}
		return j2;
	}



	public static List<Term> mergeLikeTerms(List<Term> terms1){
		
		 List<Term> result = new ArrayList<Term>();
		 Map<String,List<Term>> groupedTerms = terms1
		                                       .stream()
		                                       .collect(Collectors.groupingBy(Term::getDegree));
		 
		 
		 groupedTerms.forEach((key,value)->{
			 
			 BigDecimal sum = value.stream()
					         .map(Term::getFactor)
					         .reduce(BigDecimal::add)
					         .get();
			 
			 value.get(0).setFactor(sum);
			 result.add(value.get(0));
		 });
		
		return result;
			
	}



	private  String getDegree() {
	
		return this.cosine1_power
				    + ","  
				    +  this.sine1_power
				    + ","
				    + this.cosine2_power
				    +","
				    +this.sine2_power
				    +","
				    +this.j;
	}



	public BigDecimal getFactor() {
		return factor;
	}



	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}



	@Override
	public String toString() {
		return "Term [factor=" + factor + ", cosine1_power=" + cosine1_power + ", sine1_power=" + sine1_power
				+ ", term1=" + term1 + ", cosine2_power=" + cosine2_power + ", sine2_power=" + sine2_power + ", term2="
				+ term2 + ", j=" + j + "]";
	}
	
	
	
	
	
	
}
