package org.supersymmetry.integration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSymmetricTerm  extends Term {
	
	protected Integer power = 0;
	
	public SuperSymmetricTerm(Term term){
		this.factor=term.factor;
		this.values=term.values;
	}
	
	public SuperSymmetricTerm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected  SuperSymmetricTerm multiply(Term term1,Term term2) {
		
		super.validateTermsForMultiply(term1, term2);
		
		SuperSymmetricTerm superSymmetricTerm1 = (SuperSymmetricTerm)term1;
		SuperSymmetricTerm superSymmetricTerm2 = (SuperSymmetricTerm)term2;
		
		validateTermsForMultiply(superSymmetricTerm1,superSymmetricTerm2);
		
		Term termResult = super.multiply(term1, term2);
		SuperSymmetricTerm result = new SuperSymmetricTerm(termResult);
		result.power = (superSymmetricTerm1.power!=0 ? superSymmetricTerm1.power : superSymmetricTerm2.power);
		 
		return result;
	}
	
	protected  void validateTermsForMultiply(Term term1, Term term2) {
		
		SuperSymmetricTerm superSymmetricTerm1 = (SuperSymmetricTerm)term1;
		SuperSymmetricTerm superSymmetricTerm2 = (SuperSymmetricTerm)term2;
		    	
		if(superSymmetricTerm1.power!=0 && superSymmetricTerm2.power!=0){
		throw new IllegalStateException("Both terms have non zero power:"+term1 + " "+term2);
		}
				
	}
	
	public  List<Term> multiply(List<Term> terms1,List<Term> terms2){
		
		if(terms1.isEmpty() && terms2.isEmpty()){
		return new ArrayList<Term>();
		}
		
		else if(terms1.isEmpty() && !terms2.isEmpty()){
		terms1.addAll(terms2);
		terms2.clear();
		}
			
		List<Term> result = new ArrayList<Term>();	
		terms1.forEach(term1->{
			terms2.forEach(term2->{
				result.add(multiply(term1,term2));
			});	
		});	
		
		List<Term> mergedResults = mergeLikeTerms(result);	
		mergedResults = removezeroTerms(mergedResults);
		return mergedResults;
		}
		
	  
	
	
	protected  List<Term> mergeLikeTerms(List<Term> terms){
		
		List<Term> mergedTerms =  new ArrayList<Term>();
		List<SuperSymmetricTerm> superTerms =  new ArrayList<SuperSymmetricTerm>();
		
		terms.forEach(term->{
			SuperSymmetricTerm sterm = (SuperSymmetricTerm)term;
			superTerms.add(sterm);
		});
	                              
		                         superTerms
				                 .stream()
				                 .collect(Collectors.groupingBy(SuperSymmetricTerm::valueStringOptimized))
				                 .forEach((key,value)->{
				                 //for each item in map sum all the factors of like terms
				                 SuperSymmetricTerm newTerm = new SuperSymmetricTerm(value.get(0));
				                 BigInteger sum = value.stream().map(term->term.getFactor()).reduce(BigInteger::add).get();
				                 newTerm.setFactor(sum);
				                 mergedTerms.add(newTerm);  
				            	  
				                 });
			
		return mergedTerms;
	    }
		
		public String valueString(){
		
		StringBuffer valueString = new StringBuffer();
		this.values.forEach((k,v)->{
		valueString.append(k+"->"+v+",");	
		});
			
		return valueString.toString();
		}
		
		public String valueStringOptimized(){
			
			StringBuffer valueString = new StringBuffer();
			this.values.forEach((k,v)->{
			valueString.append(k+"->"+"1"+","+this.power+"~");	
			});
				
			return valueString.toString();
			}
	  
	   public  BigInteger evaluate(Term term){
			
	    	return null;
	     }

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}
	    
	public SuperSymmetricTerm removeVariable(String variable){
		if(this.values.containsKey(variable)){
			this.power=this.power+1;
			this.values.remove(variable);
		}
	    return null;
	    }

}
