package org.supersymmetry.integration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class XORIntegrator extends Integrator{

	protected Map<String,String> variables = new TreeMap<String,String>();
		
	@Override
	public BigInteger integrateOverVariables(List<Clause> clauses, String targetVariable, Integer value) {
		// TODO Auto-generated method stub
		return null;
			
	}
	
	public static void main(String[] args){
		XORIntegrator xORIntegrator = new XORIntegrator();
		xORIntegrator.compute();
		
	}
	
	public void compute(){
		
		List<XORClause> xorclauses = getClauses();
		Map<String,String> variables = createVariableMapFromCaluses(xorclauses);
		
		TermFactory termFactory = new TermFactory();
		XORIntegrator xORIntegrator = new XORIntegrator();
		
		xORIntegrator.variables = variables;
		termFactory.variables = variables;
		this.variables=variables;
		
		long time1 = System.currentTimeMillis();
		
		while(getUnsetVariables().size()>0){
		String variable = getUnsetVariables().get(0);
		
		variables.put(variable, "0");
		BigInteger sum0 = computeSum(termFactory,xORIntegrator,xorclauses);
		
		variables.put(variable, "1");
		BigInteger sum1 = computeSum(termFactory,xORIntegrator,xorclauses);
		
		System.out.println("Trying for variable:"+variable);
		System.out.println("sum0:"+sum0);
		System.out.println("sum1:"+sum1);
		
		  if(sum0.compareTo(sum1)>0){
		  variables.put(variable, "0");	
		  }
		  
		  else if(sum0.compareTo(sum1)==0){
		  variables.put(variable, "1");	
		  }
		  
		  else{
		  variables.put(variable, "1");	
		  }
		
		}
		System.out.println("Max occurs at:"+variables);
		variables.forEach((k,v)-> System.out.println(k+" "+v));
		
		long time2 = System.currentTimeMillis();
		
		printFullTable(xorclauses);
		long time3 = System.currentTimeMillis();
		
		System.out.println("Time for integration"+(time2-time1));
		System.out.println("Time for expansion"+(time3-time2));
		
		
	}
	
      public void compute5(String variable) {
		
		List<XORClause> xorclauses = XORClauseGenerator.xorcluses;
		
		if(this.variables.isEmpty()){
		this.variables=	createVariableMapFromCaluses(xorclauses);
		}
		
		
		TermFactory termFactory = new TermFactory();
		XORIntegrator xORIntegrator = new XORIntegrator();
		
		xORIntegrator.variables = variables;
		termFactory.variables = variables;
		this.variables=variables;
				
		variables.put(variable, "0");
		BigInteger sum0 = computeSum(termFactory,xORIntegrator,xorclauses);
		
		variables.put(variable, "1");
		BigInteger sum1 = computeSum(termFactory,xORIntegrator,xorclauses);
		
		System.out.println("Trying for variable:"+variable);
		System.out.println("sum0:"+sum0);
		System.out.println("sum1:"+sum1);
		
		  if(sum0.compareTo(sum1)>0){
		  variables.put(variable, "0");	
		  }
			  
		 else if(sum0.compareTo(sum1)==0){
		 variables.put(variable, "1");	
	     }
			  
		else{
	    variables.put(variable, "1");	
	    }
		
	}
      
      public void evaluateOverMultipleClauses(String variable) {
  		
    System.out.println("Trying for variable:"+variable);
    	 BigInteger collectiveSum0 = new BigInteger("1");
    	 BigInteger collectiveSum1 = new BigInteger("1");
    	  
    	 if(this.variables.isEmpty()){
    	 this.variables= createVariableMapFromCaluses(XORClauseGenerator.xorcluses);
    	 }
    	 
  		for(List<XORClause> xorclauses :XORClauseGenerator.subsets){
  		
  		//xorclauses = doublelist(xorclauses);
  			
  		TermFactory termFactory = new TermFactory();
  		XORIntegrator xORIntegrator = new XORIntegrator();
  		
  		xORIntegrator.variables = variables;
  		termFactory.variables = variables;
  		this.variables=variables;
  				
  		variables.put(variable, "0");
  		BigInteger sum0 = computeSum(termFactory,xORIntegrator,xorclauses);
  		collectiveSum0 = collectiveSum0.multiply(sum0);
  		
  		
  		variables.put(variable, "1");
  		BigInteger sum1 = computeSum(termFactory,xORIntegrator,xorclauses);
  		collectiveSum1 = collectiveSum1.multiply(sum1);
  		
  		
  		//System.out.println("sum0:"+sum0);
  		//System.out.println("sum1:"+sum1);
  		
  		}
  		  if(collectiveSum0.compareTo(collectiveSum1)>0){
  		  variables.put(variable, "0");	
  		  }
  			  
  		 else if(collectiveSum0.compareTo(collectiveSum1)==0){
  		 variables.put(variable, "1");	
  	     }
  			  
  		else{
  	    variables.put(variable, "1");	
  	      }
  		}
  		
      private List<XORClause> doublelist(List<XORClause> xorclauses) {
		
    	  List<XORClause> cluases = new ArrayList<XORClause>(); 
    	  xorclauses.forEach(clause->{
    		  cluases.add(clause);
    		  cluases.add(clause);
    		  cluases.add(clause);
    		  cluases.add(clause);
    		  
    	  });
    	  
		return cluases;
	}

	public void evaluateOverSingleClauses(String variable) {
    		
    	   System.out.println("Trying for variable:"+variable);
    	    	 BigInteger collectiveSum0 = new BigInteger("1");
    	    	 BigInteger collectiveSum1 = new BigInteger("1");
    	    	  
    	    	 if(this.variables.isEmpty()){
    	    	 this.variables= createVariableMapFromCaluses(XORClauseGenerator.xorcluses);
    	    	 }
    	    	 
    	    	
    	    	 
    	  		for(XORClause clauses :XORClauseGenerator.xorcluses){
    	  		  
    	  		List<XORClause> xorclauses = new ArrayList<XORClause>();
        	    xorclauses.add(clauses);
        	    	 
    	  		TermFactory termFactory = new TermFactory();
    	  		XORIntegrator xORIntegrator = new XORIntegrator();
    	  		
    	  		xORIntegrator.variables = variables;
    	  		termFactory.variables = variables;
    	  		this.variables=variables;
    	  				
    	  		variables.put(variable, "0");
    	  		BigInteger sum0 = computeSum(termFactory,xORIntegrator,xorclauses);
    	  		collectiveSum0 = collectiveSum0.add(sum0);
    	  		
    	  		
    	  		variables.put(variable, "1");
    	  		BigInteger sum1 = computeSum(termFactory,xORIntegrator,xorclauses);
    	  		collectiveSum1 = collectiveSum1.add(sum1);
    	  		
    	  		
    	  		//System.out.println("sum0:"+sum0);
    	  		//System.out.println("sum1:"+sum1);
    	  		
    	  		}
    	  		  if(collectiveSum0.compareTo(collectiveSum1)>0){
    	  		  variables.put(variable, "0");	
    	  		  }
    	  			  
    	  		 else if(collectiveSum0.compareTo(collectiveSum1)==0){
    	  		 variables.put(variable, "1");	
    	  	     }
    	  			  
    	  		else{
    	  	    variables.put(variable, "1");	
    	  	      }
    	  		}
	
	public void evaluateOverSingleClausesSquare(String variable) {
		
	   System.out.println("Trying for variable:"+variable);
	    	 BigInteger collectiveSum0 = new BigInteger("1");
	    	 BigInteger collectiveSum1 = new BigInteger("1");
	    	  
	    	 if(this.variables.isEmpty()){
	    	 this.variables= createVariableMapFromCaluses(XORClauseGenerator.xorcluses);
	    	 }
	    	 
	   for(XORClause clause1 :XORClauseGenerator.xorcluses){	
	    	 
	  		for(XORClause clause2 :XORClauseGenerator.xorcluses){
	  		  
	  		List<XORClause> xorclauses = new ArrayList<XORClause>();
    	    xorclauses.add(clause1);
    	    xorclauses.add(clause2);
    	    	 
	  		TermFactory termFactory = new TermFactory();
	  		XORIntegrator xORIntegrator = new XORIntegrator();
	  		
	  		xORIntegrator.variables = variables;
	  		termFactory.variables = variables;
	  		this.variables=variables;
	  				
	  		variables.put(variable, "0");
	  		BigInteger sum0 = computeSum(termFactory,xORIntegrator,xorclauses);
	  		collectiveSum0 = collectiveSum0.add(sum0);
	  		
	  		
	  		variables.put(variable, "1");
	  		BigInteger sum1 = computeSum(termFactory,xORIntegrator,xorclauses);
	  		collectiveSum1 = collectiveSum1.add(sum1);
	  		
	  		
	  		//System.out.println("sum0:"+sum0);
	  		//System.out.println("sum1:"+sum1);
	  		
	  		}
	   }
	  		  if(collectiveSum0.compareTo(collectiveSum1)>0){
	  		  variables.put(variable, "0");	
	  		  }
	  			  
	  		 else if(collectiveSum0.compareTo(collectiveSum1)==0){
	  		 variables.put(variable, "1");	
	  	     }
	  			  
	  		else{
	  	    variables.put(variable, "1");	
	  	      }
	  		}
	
     public void compute2(){
		
		List<XORClause> xorclauses = getClauses();
		Map<String,String> variables = createVariableMapFromCaluses(xorclauses);
		
		TermFactory termFactory = new TermFactory();
		XORIntegrator xORIntegrator = new XORIntegrator();
		
		xORIntegrator.variables = variables;
		termFactory.variables = variables;
		this.variables=variables;
		
		long time1 = System.currentTimeMillis();
		
	    while(getUnsetVariables().size()>0) {
		
		String variable = getUnsetVariables().get(0);
		
		List<BigInteger> zeroList = new ArrayList<BigInteger>();
		List<BigInteger> oneList = new  ArrayList<BigInteger>();
		
		
			for (int i = 0; i < 10; i++) {

				Map<Integer, List<XORClause>> xorclausesMap = XORGrouper.getClauseSetRandomized();
				  xorclausesMap.forEach((key, clauses) -> {

					variables.put(variable, "0");
					BigInteger sum0 = computeSum(termFactory, xORIntegrator, clauses);
					zeroList.add(sum0);

					variables.put(variable, "1");
					BigInteger sum1 = computeSum(termFactory, xORIntegrator, clauses);
					oneList.add(sum1);
				});
			}
		
		if(checkSizeZeroGreaterThanOne(oneList,zeroList)){
		variables.put(variable, "0");		
		}
		
		else{
		variables.put(variable, "1");	
		}
			
		}
	    
		System.out.println("Max occurs at:"+variables);
		variables.forEach((k,v)-> System.out.println(k+" "+v));
		
		long time2 = System.currentTimeMillis();
		
		printFullTable(xorclauses);
		long time3 = System.currentTimeMillis();
		
		System.out.println("Time for integration"+(time2-time1));
		System.out.println("Time for expansion"+(time3-time2));
		
		
	}
	
	private boolean checkSizeZeroGreaterThanOne(List<BigInteger> oneList, List<BigInteger> zeroList) {
	
		BigInteger zeroSum = zeroList.stream().map(value->value).reduce(BigInteger::multiply).get();
		BigInteger oneSum =  oneList.stream().map(value->value).reduce(BigInteger::multiply).get();
		
		if(zeroSum.compareTo(oneSum)>0){
		return true;
		}
		
		
		return false;
	}

	public void printFullTable(List<XORClause> xorclauses){
		
		Integer size = variables.size();
		Double listsize = Math.pow(2, size);
		Long longsize = listsize.longValue();
		
		BigInteger max = new BigInteger("0");
		Map<String,String> maxMap = new TreeMap<String,String>();
		for(Long b=0L; b<longsize; b++){
			String v = appendZeores(longsize.toBinaryString(b),size);
			variables=populateVariables(variables,v);
			BigInteger value = computeClauseValue(xorclauses,variables);
			//System.out.println("At variables:"+variables + " Value is:"+value);
			
			if(value.compareTo(max)>0){
				max=value;
				copytoMaxMap(maxMap,variables);
			}
		}
		System.out.println("Maximum occurs at "+maxMap + " with values:" +max );
	}
	
	
	private void copytoMaxMap(Map<String, String> maxMap, Map<String, String> variables2) {
		
		variables2.forEach((key,value)->{
			maxMap.put(key, value);
		});
	}

	private BigInteger computeClauseValue(List<XORClause> xorclauses, Map<String, String> variables2) {
		
		return xorclauses
		      .stream()
		      .map(clause->clause.getValue(variables2))
		      .reduce(BigInteger::multiply).get();
				
	 }

	
	
	
	
	
	
	
	private Map<String, String> populateVariables(Map<String, String> variables2, String v) {
		
	
	   int count = 0;
	   int size =  variables2.entrySet().size();
	    
	    for(Entry entry:variables2.entrySet()){
	    	
	    String key = (String)entry.getKey();
	    String value = (String)entry.getValue();
	    
	    entry.setValue(String.valueOf(v.charAt(count)));
	    count++;
	    }
		
		return variables2;
	}

	private String appendZeores(String binaryString, Integer size) {
		
		while(binaryString.length()<size){
		binaryString = "0"+binaryString;
		}
		
		return binaryString;
	}

	public BigInteger computeSum(TermFactory termFactory,XORIntegrator xORIntegrator, List<XORClause> xorclauses ){
		
		termFactory.getTerms().clear();
		
        List<XORClause> restClauses = new ArrayList<XORClause>();
		
		xorclauses.forEach(clause->{
		restClauses.add(clause);
		});
		
		
 		for(XORClause xorclause:xorclauses){
 		termFactory.addCaluse(xorclause.getV1(),xorclause.getV2());
 		restClauses.remove(xorclause);
		
   		List<Term> reducedTerms = reduceTerms(termFactory.getTerms(),
 					                               xorclause.getV1(),xorclause.getV2(),
  						                               restClauses);
 		termFactory.setTerms(reducedTerms);
		
			 
				 
		}
	
			
		List<Term> termList = termFactory.getTerms();
		BigInteger value = xORIntegrator.integrateOverVariables(termList);
		return value;
			
	}
	
	
	public List<XORClause> getClauses(){
		
		List<XORClause> xorclauses = new ArrayList<XORClause>();
		xorclauses.add(new XORClause("v0","v1"));
		xorclauses.add(new XORClause("v0","v2"));
		xorclauses.add(new XORClause("v0","v3"));
		xorclauses.add(new XORClause("v2","v3"));
		xorclauses.add(new XORClause("v1","v3"));
		/*xorclauses.add(new XORClause("a","d"));
		xorclauses.add(new XORClause("a","e"));
		xorclauses.add(new XORClause("a","f"));
		
		xorclauses.add(new XORClause("b","c"));
		xorclauses.add(new XORClause("b","d"));
		
		xorclauses.add(new XORClause("c","e"));
		
		xorclauses.add(new XORClause("d","e"));
		
		xorclauses.add(new XORClause("e","f"));
		*/
		
		
		
		
		return xorclauses;
	}
	
    public  Map<String,String> createVariableMapFromCaluses( List<XORClause> clauses){
		
    	Map<String,String> variables = new TreeMap<String,String>();
    	
    	for(XORClause corclause:clauses){
    	variables.put(corclause.getV1(),corclause.getV1());
    	variables.put(corclause.getV2(),corclause.getV2());
    	}
       return variables;
	}
	
	
	public static void main2(String[] args){
	
		
		TermFactory termFactory = new TermFactory();
		XORIntegrator xORIntegrator = new XORIntegrator();
		
		termFactory.getVariables().put("a", "0");
		termFactory.getVariables().put("b", "0");
		termFactory.getVariables().put("c", "1");
		termFactory.getVariables().put("d", "0");
		
		xORIntegrator.variables = termFactory.getVariables();
		
		
		termFactory.addCaluse("a","b").addCaluse("b", "c").addCaluse("c", "a")
		.addCaluse("a", "d").addCaluse("c", "d");
		List<Term> termList = termFactory.getTerms();
	
		
		BigInteger value0 = xORIntegrator.integrateOverVariables(termList);
		System.out.println("Value 0 is:"+value0);
		
		//////////////////////////////////////////////////////////
		
		
		termFactory.getTerms().clear();
		
		termFactory.getVariables().put("a", "0");
		termFactory.getVariables().put("b", "0");
		termFactory.getVariables().put("c", "1");
		termFactory.getVariables().put("d", "1");
		xORIntegrator.variables = termFactory.getVariables();
		
		
		termFactory.addCaluse("a","b").addCaluse("b", "c").addCaluse("c", "a")
		.addCaluse("a", "d").addCaluse("c", "d");
		termList = termFactory.getTerms();
		
		xORIntegrator.integrateOverVariables(termList);
		BigInteger value1 = xORIntegrator.integrateOverVariables(termList);
		System.out.println("Value 1 is:"+value1);
	}
	
	
	public static void main1(String[] args){
		
		XORIntegrator xORIntegrator = new XORIntegrator();
		TermFactory termFactory = new TermFactory();
		Term term = new Term();
		
		xORIntegrator.getVariables().put("a","0");
		xORIntegrator.getVariables().put("b","0");
		xORIntegrator.getVariables().put("c","c");
		
		
		List<Term> terms1 = termFactory.createTermFromCaluse("a", "b");
		List<Term> terms2 = termFactory.createTermFromCaluse("b", "c");
		//List<Term> terms3 = termFactory.createTermFromCaluse("a", "c");
		List<Term> terms4 = term.multiply(terms1, terms2);
		//List<Term> terms5 = term.multiply(terms4, terms3);
		
		
		
		//List<Term> oneList = new ArrayList<Term>();
		//oneList.add(new Term(1,"c"));
		terms4.forEach(term1->System.out.println(term1));
		
		BigInteger value = xORIntegrator.integrateOverVariables(terms4);
		
		System.out.println("Value0 is:"+value);
		
		xORIntegrator.getVariables().put("a","0");
		xORIntegrator.getVariables().put("b","1");
		xORIntegrator.getVariables().put("c","c");
		
		value = xORIntegrator.integrateOverVariables(terms4);
		System.out.println("Value1 is:"+value);
	
	}
	
	
	/**
	public static void main(String[] args){
		
		XORIntegrator xORIntegrator = new XORIntegrator();
		TermFactory termFactory = new TermFactory();
		Term term = new Term();
		
		xORIntegrator.variables.put("a","0");
		xORIntegrator.variables.put("b","0");
		xORIntegrator.variables.put("c","c");
		
		List<Term> terms1 = termFactory.createTermFromCaluse("a", "b");
		List<Term> terms2 = termFactory.createTermFromCaluse("b", "c");
		//List<Term> terms3 = termFactory.createTermFromCaluse("a", "c");
		List<Term> terms4 = term.multiply(terms1, terms2);
		//List<Term> terms5 = term.multiply(terms4, terms3);
		
		
		
		//List<Term> oneList = new ArrayList<Term>();
		//oneList.add(new Term(1,"c"));
		terms4.forEach(term1->System.out.println(term1));
		
		BigInteger value = xORIntegrator.integrateOverVariables(terms4);
		
		System.out.println("Value0 is:"+value);
		
		xORIntegrator.variables.put("a","0");
		xORIntegrator.variables.put("b","1");
		xORIntegrator.variables.put("c","c");
		
		value = xORIntegrator.integrateOverVariables(terms4);
		System.out.println("Value1 is:"+value);
	
	}
	***/
		

	
	
	 public  BigInteger integrateOverVariables(List<Term> terms){
			
	    	return terms
	    		  .stream()
	    		  .map(term->this.integrateTerm(term))
	    		  .reduce(BigInteger::add).get();
	 }
	    
	 public  BigInteger integrateTerm(Term term){
		
	  BigInteger result = term.getFactor();
	  
	  if(term.factor==BigInteger.ZERO){
	  return BigInteger.ZERO;
	  }
	  
	  else if(term.values.containsValue("0")){
	  return BigInteger.ZERO;
	  }
	  
	  //if any values contain a variable assigned to zero
	  for(String variable:getZeroVariables()){
		  if(term.values.containsKey(variable)){  
		  return BigInteger.ZERO;
		  }
	   }
	  
		 
	 for(String variable:getUnsetVariables()) {
	   if(!term.values.containsKey(variable)){  
	   result = result.multiply(new BigInteger("2"));
	   }
	  }
	 
	 int p = term.power;
	 while(p>0){
	  result = result.divide(new BigInteger("2")); 
	  p = p-1;
	 }
			
	 return result;
	 }

	
	 
	 private List<String> getUnsetVariables() {
		List<String> unsetVariableList = new ArrayList<String>();
		variables.forEach((key,value)->{
		if(!value.equals("0") && !value.equals("1")){
		unsetVariableList.add(key);
		}
		});
		return unsetVariableList;
	}
	 
	 private List<String> getZeroVariables() {
		List<String> unsetVariableList = new ArrayList<String>();
		variables.forEach((key,value)->{
		if(value.equals("0") ){
		unsetVariableList.add(key);
		}
		});
		return unsetVariableList;
	}

	public Map<String, String> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}
	 
	 
	 
  private List<Term> reduceTerms(List<Term> terms, String v1, String v2, List<XORClause> restClauses) {

	
  	
	for(String variable:getUnsetVariables()){

  		if(!doesVariableOccursInRestClauses(variable,restClauses)){
			terms.forEach(term->{
				term.removeVariable(variable);

			});	
		}
	}

   		return terms;
   		
	}

	private boolean doesVariableOccursInRestClauses(String v1, List<XORClause> restClauses) {
		
		boolean occur = false;
		for(XORClause clause:restClauses){
			String a = clause.getV1();
			String b = clause.getV2();
			
			if(v1.equalsIgnoreCase(a) || v1.equalsIgnoreCase(b)){
			return true;
			}
			
		}
		
		return occur;
	}
	
	
}
