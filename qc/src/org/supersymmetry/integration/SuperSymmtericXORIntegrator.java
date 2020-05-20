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

public class SuperSymmtericXORIntegrator extends XORIntegrator{

	private Map<String,String> variables = new TreeMap<String,String>();
	
	private String currentVariable = null;
		
	@Override
	public BigInteger integrateOverVariables(List<Clause> clauses, String targetVariable, Integer value) {
		// TODO Auto-generated method stub
		return null;
			
	}
	
	public static void main(String[] args){
		SuperSymmtericXORIntegrator xORIntegrator = new SuperSymmtericXORIntegrator();
		xORIntegrator.compute();
		
	}
	
	public void compute(){
		
		List<XORClause> xorclauses = getClauses();
		Map<String,String> variables = createVariableMapFromCaluses(xorclauses);
		
		SuperSymmetricTermFactory termFactory = new SuperSymmetricTermFactory();
		SuperSymmtericXORIntegrator xORIntegrator = new SuperSymmtericXORIntegrator();
		
		xORIntegrator.variables = variables;
		termFactory.variables = variables;
		this.variables=variables;
		
		long time1 = System.currentTimeMillis();
		
		while(getUnsetVariables().size()>0){
		String variable = getUnsetVariables().get(0);
		
		currentVariable=variable;
		
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
		 
		// List<Term> reducedTerms = reduceTerms(termFactory.getTerms(),
		//		                               xorclause.getV1(),xorclause.getV2(),
		//		                               restClauses);
		// termFactory.setTerms(reducedTerms);
		
		}
			
		List<Term> termList = termFactory.getTerms();
		BigInteger value = xORIntegrator.integrateOverVariables(termList);
		return value;
			
	}
	
	
	private List<Term> reduceTerms(List<Term> terms, String v1, String v2, List<XORClause> restClauses) {
		
		if(!doesVariableOccursInRestClauses(v1,restClauses) && !currentVariable.equals(v1)){
			terms.forEach(term->{
				
				SuperSymmetricTerm sterm = (SuperSymmetricTerm)term;
				sterm.removeVariable(v1);
				
			});	
		}
		
        if(!doesVariableOccursInRestClauses(v2,restClauses) && !currentVariable.equals(v2)){
        	terms.forEach(term->{
        		SuperSymmetricTerm sterm = (SuperSymmetricTerm)term;
				sterm.removeVariable(v2);
			});
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

	public List<XORClause> getClauses(){
		
		List<XORClause> xorclauses = new ArrayList<XORClause>();
		xorclauses.add(new XORClause("a","b"));
		xorclauses.add(new XORClause("a","c"));
		xorclauses.add(new XORClause("a","d"));
		xorclauses.add(new XORClause("a","e"));
		xorclauses.add(new XORClause("a","f"));
		xorclauses.add(new XORClause("a","g"));
		xorclauses.add(new XORClause("a","h"));
		
		xorclauses.add(new XORClause("b","c"));
		xorclauses.add(new XORClause("b","e"));
		xorclauses.add(new XORClause("b","f"));
		xorclauses.add(new XORClause("b","h"));
		
		xorclauses.add(new XORClause("c","d"));
		xorclauses.add(new XORClause("c","e"));
		xorclauses.add(new XORClause("c","g"));
		xorclauses.add(new XORClause("c","h"));
		
		xorclauses.add(new XORClause("d","f"));
		xorclauses.add(new XORClause("d","h"));
		
		xorclauses.add(new XORClause("e","f"));
		xorclauses.add(new XORClause("e","g"));
		
		xorclauses.add(new XORClause("f","g"));
		xorclauses.add(new XORClause("f","h"));
		
		
		return xorclauses;
	}
	
    public  Map<String,String> createVariableMapFromCaluses( List<XORClause> clauses){
		
    	Map<String,String> variables = new HashMap<String,String>();
    	
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
	    
	 public  BigInteger integrateTerm(SuperSymmetricTerm term){
		
	  BigInteger result = term.getFactor();
	  SuperSymmetricTerm sTerm= (SuperSymmetricTerm) term;
	  
	 
	  
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
	  
		 
	 for(String variable:getUnsetVariables()){
	   if(!term.values.containsKey(variable)){  
	   result = result.multiply(new BigInteger("2"));
	   }
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
	 
	 
	 
	 
	
	
}
