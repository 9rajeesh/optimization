package org.supersymmetry.integration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Term {

	protected Integer power = 0;
	protected BigInteger factor = BigInteger.ONE;
	protected Map<String,Integer> values = new TreeMap<String,Integer>();
	
	public Term(Term term){
		this.factor=term.factor;
		term.values.forEach((k,v)->{
		this.values.put(k, v);
		});
	}
		
	public Term(Integer sign,String variable){
		this.factor=new BigInteger(sign.toString());
		values.put(variable,1);
	}
	
	public Term() {

	}
	
	public Term(Integer value){
	 
	 this.factor = new BigInteger(String.valueOf(value));
	 values.put(value.toString(),1);
	 
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
	 mergedResults    = removezeroTerms(mergedResults);
	return mergedResults;
	}
	
	
	
    protected  Term multiply(Term term1,Term term2) {
		
    Term result = new Term();
    validateTermsForMultiply(term1,term2);
       
    result.factor = term1.factor.multiply(term2.factor);

    
    //copy from term1 to result
    term1.values.forEach((k,v)->{
    result.values.put(k,v);
    });
    
    
    term2.values.forEach((key,value)-> {
    //If no key present its a new variable
    	//e.g (abc * d)
    	if(term1.values.get(key) == null){
    	result.values.put(key, value);
    	}
    	
    	//if key is present add them ab*a
    	else{
    	result.values.put(key, term2.values.get(key) + term1.values.get(key));	
    	}
    });
    
    result.power = term1.power+term2.power;
	return result;
	}
    
    protected  void validateTermsForMultiply(Term term1, Term term2) {
    	
    if(term1.factor==null || term2.factor==null){
    throw new IllegalArgumentException("Factor is null");
    }
    
    if(term1.power!=0 && term2.power!=0){
    throw new IllegalStateException("Non zero power");
    }
    
    }

	protected  List<Term> mergeLikeTerms(List<Term> terms){
	
	List<Term> mergedTerms =  new ArrayList<Term>();
                              
	                          terms
			                 .stream()
			                 .collect(Collectors.groupingBy(Term::valueStringOptimized))
			                 .forEach((key,value)->{
			                 //for each item in map sum all the factors of like terms
			                 Term newTerm = new Term(value.get(0));
			                 BigInteger sum = value.stream().map(term->term.getFactor()).reduce(BigInteger::add).get();
			                 newTerm.setFactor(sum);
			                 newTerm.setPower(value.get(0).power);
			                 mergedTerms.add(newTerm);  
			            	  
			                 });
		
	return mergedTerms;
    }
	
	
	
	public String valueStringOptimized(){
		
		StringBuffer valueString = new StringBuffer();
		this.values.forEach((k,v)->{
		valueString.append(k+"->"+"1"+",");	
		});
		valueString.append("P:"+this.power);
			
		return valueString.toString();
		}
    
    
    
   
    
       public String toString(){
		
		StringBuffer valueString = new StringBuffer();
		this.values.forEach((k,v)->{
		valueString.append(k+"->"+"1"+",");	
		});
		valueString.append("P:"+this.power);
			
		return valueString.toString();
		}
	

	public BigInteger getFactor() {
		return factor;
	}

	public void setFactor(BigInteger factor) {
		this.factor = factor;
	}

	public static List<Term> removezeroTerms(List<Term> termList) {
		
		termList.removeIf(term->term.values.containsKey("0"));
		
		return termList;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public void removeVariable(String v1) {
		if(this.values.containsKey(v1)){
			power = power+1;
			this.values.remove(v1);
		}
		
	}

	
    
    
	
}
