package org.supersymmetry.order.general.max.xor.sat.models;

import java.util.ArrayList;
import java.util.List;

import org.supersymmetry.simple.sum.Utility;

public class Term {
	
	private List<String> variables = new ArrayList<String>();
	private Double factor;
	
	
   public List<String> getVariables() {
		return variables;
	}

	public void setVariables(List<String> variables) {
		this.variables = variables;
	}

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}
	
	

   public static List<Term> multiplyTerms(List<Term> terms1, List<Term> terms2){
		
	   
	   if( (terms1==null || terms1.isEmpty())
			   && (terms2==null || terms2.isEmpty())){
		   return new ArrayList<Term>();
	   }
	   
	   if(terms1==null || terms1.isEmpty()){
	   return terms2;
	   }
	   
	   if(terms2==null || terms2.isEmpty()){
	   return terms1;
	   }
	   
		List<Term> result = new ArrayList<Term>();
		terms1.forEach(term1->{
			terms2.forEach(term2->{
				result.addAll(multiply(term1,term2));
			});
		});
		
	return result;
	}
	
	public static List<Term> multiply(Term term1, Term term2){
		
		
	return null;
	}
	
	
	public static List<Term> reduce(List<Term> terms, List<String> removedVariables){
		
		
	return null;
	}
	
	
	
    public List<Term> expandTerms(List<Term> terms) {
    	
    	List<Term> termspowerAll = new ArrayList<Term>();
    	
    	for(int i=0;i<MAX_RESOLUTION;i++){
    		List<Term> termspower = raiseTermToPower(terms,2*i+1);
    		termspower = scaleDivide(termspower,Utility.factorial(2*i+1));
    		termspower = scaleMultiply(termspower,Utility.power(Math.PI/2,2*i+1));
    		termspowerAll.addAll(termspower);
        }
		
        return termspowerAll;
	}
	
    public List<Term> raiseTermToPower(List<Term> terms,int power){
    	
    List<Term> result = new ArrayList<Term>();
    	for(int i=0;i<power;i++){
    	result= Term.multiplyTerms(terms,result);
    	}
     return result;
	}
	
	
	
	
}
