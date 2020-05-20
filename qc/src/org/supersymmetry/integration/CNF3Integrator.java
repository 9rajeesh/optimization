package org.supersymmetry.integration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

public class CNF3Integrator extends Integrator{

	protected Map<String,String> variables = new TreeMap<String,String>();
	static  Map<String, BigInteger> diffMap = new HashMap<String, BigInteger>();
	static  Map<Long, BigInteger> valueMap = new HashMap<Long, BigInteger>();
		
	@Override
	public BigInteger integrateOverVariables(List<Clause> clauses, String targetVariable, Integer value) {
		// TODO Auto-generated method stub
		return null;
			
	}
	
	public static void main(String[] args){
		CNF3Integrator xORIntegrator = new CNF3Integrator();
		//xORIntegrator.compute();
		
	}
	

  
      /*
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
  		CNF3Integrator xORIntegrator = new CNF3Integrator();
  		
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
  		*
  		/
  		 * 
  		 * 
  		 */
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
      
      public void evaluateOverSquareClauses(String variable) {
    		
	         System.out.println("Trying for variable:"+variable);
	    	 BigInteger collectiveSum0 = new BigInteger("0");
	    	 BigInteger collectiveSum1 = new BigInteger("0");
	    	  
	    	 if(this.variables.isEmpty()){
	    	 this.variables= createVariableMapFromCaluses(CNF3TableEvaluator.clauses);
	    	 }
	    	   
	    	 
	  		for(CNF3 cnf1:getContainingClauses(CNF3TableEvaluator.clauses,variable)){
	  			
	  			for(CNF3 cnf2:CNF3TableEvaluator.clauses){
	  		  
	  				
	  				
	  		List<CNF3> cnf3clauses = new ArrayList<CNF3>();
	  		cnf3clauses.add(cnf1);
	  		cnf3clauses.add(cnf2);
	  		
	    	 
	  		TermFactory termFactory = new TermFactory();
	  		CNF3Integrator cNF3Integrator = new CNF3Integrator();
	  		
	  		cNF3Integrator.variables = variables;
	  		termFactory.variables = variables;
	  		this.variables=variables;
	  				
	  		variables.put(variable, "0");
	  		BigInteger sum0 = computeSum(termFactory,cNF3Integrator,cnf3clauses);
	  		collectiveSum0 = collectiveSum0.add(sum0);
	  		
	  		
	  		variables.put(variable, "1");
	  		BigInteger sum1 = computeSum(termFactory,cNF3Integrator,cnf3clauses);
	  		collectiveSum1 = collectiveSum1.add(sum1);
	  		
	  		}
	    }
	  		
	  		System.out.println("sum0:"+collectiveSum0);
	  		System.out.println("sum1:"+collectiveSum1);
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
      
      private List<CNF3> getContainingClauses(List<CNF3> clauses, String variable) {
		
    	  List<CNF3> result = new ArrayList();
    	  clauses.forEach(clause->{
    		 
    		  if(clause.getA1().replaceAll("-", "").contains(variable)){
    		  result.add(clause);
    		  }
    		  
    		  else if(clause.getA2().replaceAll("-", "").contains(variable)){
        	  result.add(clause);
        	  }
    		  
    		  else if(clause.getA3().replaceAll("-", "").contains(variable)){
              result.add(clause);
             }
    		  
    		  
    	  });
    	  
		return result;
	}

	public void evaluateOverDoubleClauses(String variable) {
  		
	         System.out.println("Trying for variable:"+variable);
	    	 BigInteger collectiveSum0 = new BigInteger("0");
	    	 BigInteger collectiveSum1 = new BigInteger("0");
	    	  
	    	 if(this.variables.isEmpty()){
	    	 this.variables= createVariableMapFromCaluses(CNF3TableEvaluator.clauses);
	    	 }
	    	   
	    	 
	  		for(CNF3 cnf1:CNF3TableEvaluator.clauses){
	  			
	  			for(CNF3 cnf2:CNF3TableEvaluator.clauses){
	  		  
	  		List<CNF3> cnf3clauses = new ArrayList<CNF3>();
	  		cnf3clauses.add(cnf1);
	  		cnf3clauses.add(cnf2);
 	    	 
	  		TermFactory termFactory = new TermFactory();
	  		CNF3Integrator cNF3Integrator = new CNF3Integrator();
	  		
	  		cNF3Integrator.variables = variables;
	  		termFactory.variables = variables;
	  		this.variables=variables;
	  				
	  		variables.put(variable, "0");
	  		BigInteger sum0 = computeSum(termFactory,cNF3Integrator,cnf3clauses);
	  		collectiveSum0 = collectiveSum0.add(sum0);
	  		
	  		
	  		variables.put(variable, "1");
	  		BigInteger sum1 = computeSum(termFactory,cNF3Integrator,cnf3clauses);
	  		collectiveSum1 = collectiveSum1.add(sum1);
	  		
	  		}
	    }
	  		
	  		System.out.println("sum0:"+collectiveSum0);
	  		System.out.println("sum1:"+collectiveSum1);
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
      
      public void evaluateOverMultiClauses(String... variables1) {
  		
	         System.out.println("Trying for variable:"+variables1);
	    	 
	         BigInteger collectiveSum00 = new BigInteger("0");
	    	 BigInteger collectiveSum01 = new BigInteger("0");
	    	 BigInteger collectiveSum10 = new BigInteger("0");
	    	 BigInteger collectiveSum11 = new BigInteger("0");
	    	  
	    	 if(this.variables.isEmpty()){
	    	 this.variables= createVariableMapFromCaluses(CNF3TableEvaluator.clauses);
	    	 }
	        	  	
	    	this.valueMap = new HashMap<Long,BigInteger>();
	    	
	  		for(CNF3 cnf3clause :CNF3TableEvaluator.clauses){
	  		  
	  		List<CNF3> cnf3clauses = new ArrayList<CNF3>();
	  		cnf3clauses.add(cnf3clause);
 	    	 
	  		TermFactory termFactory = new TermFactory();
	  		CNF3Integrator cNF3Integrator = new CNF3Integrator();
	  		
	  		cNF3Integrator.variables = variables;
	  		termFactory.variables = variables;
	  		this.variables=variables;
	  		  		
	  		generateIterationMap(termFactory,cNF3Integrator,cnf3clauses,variables1);
	  		
	  		}
	  		 		
	  		findLargestAndAssign(variables1);
	  		
	  		}
      
      
      public  void generateIterationMap(TermFactory termFactory, CNF3Integrator cNF3Integrator, 
    		                            List<CNF3> cnf3clauses, String... variables1){
    	  
    	  int size = variables1.length;
    	  Double p = Math.pow(2, size);
    	  
    	  
    	  for(Long i=0L;i<p.longValue();i++){
    	  
    	  String s = getIndexString(i,size);
    	  assignValuesinMap(s,variables1);
    	  
    	   termFactory = new TermFactory();
	  	   cNF3Integrator = new CNF3Integrator();
	  		
	  		cNF3Integrator.variables = variables;
	  		termFactory.variables = variables;
	  		this.variables=variables;
    	  
    	 // cNF3Integrator.variables = variables;
	  	 // termFactory.variables = variables;
	  	 // this.variables=variables;
	  	  
	  	  BigInteger sum = computeSum(termFactory,cNF3Integrator,cnf3clauses);
	  	 
	  	  BigInteger collectivesum = valueMap.get(i);
	  	  
	  	  if(collectivesum == null){
	  	  collectivesum = new BigInteger("0");
	  	  }
	  	  collectivesum = collectivesum.add(sum);
	  	  valueMap.put(i,collectivesum);
    	  }
    	  
      }
      
      
      

	private  void assignValuesinMap(String s,String... variables1) {
				
		for(int i=0;i<s.length();i++){
		char v = s.charAt(i);
			
		if(v=='1'){
		variables.put(variables1[i],"1");
		}
		else{
		variables.put(variables1[i],"0");	
		}
		}	
	}

	private static String getIndexString(Long p,Integer size) {
		return lpad(Long.toBinaryString(p),size);
	}
	

	private static String lpad(String binaryString, Integer size) {
		while(binaryString.length()<size){
		binaryString = "0" + binaryString;	
		}
		return binaryString;
	}

	private void findLargestAndAssign(String... variables1) {
		
		 int size = variables1.length;
   	     Double p = Math.pow(2, size);
   	    
   	     Long maxIndex = 0L;
   	     BigInteger max = new BigInteger("0");
   	     
   	    for(Entry entry:this.valueMap.entrySet()){
   	    	
   	    	Long index = (Long)entry.getKey();
   	    	BigInteger v = (BigInteger)entry.getValue();
   	    	
   	    	if(v.compareTo(max)>0){
   	    		max=v;
   	    		maxIndex= index;
   	    	}
   	    }
   	  
   	  String s = getIndexString(maxIndex.longValue(),size);
   	  assignValuesinMap(s,variables1);
	}

	public void evaluateOverSingleClauses(String variable) {
    		
    	         System.out.println("Trying for variable:"+variable);
    	    	 BigInteger collectiveSum0 = new BigInteger("0");
    	    	 BigInteger collectiveSum1 = new BigInteger("0");
    	    	  
    	    	 if(this.variables.isEmpty()){
    	    	 this.variables= createVariableMapFromCaluses(CNF3TableEvaluator.clauses);
    	    	 }
    	        	  	
    	    	 
    	  		for(CNF3 cnf3clause :getContainingClauses(CNF3TableEvaluator.clauses,variable)){
    	  		  
    	  		List<CNF3> cnf3clauses = new ArrayList<CNF3>();
    	  		cnf3clauses.add(cnf3clause);
        	    	 
    	  		TermFactory termFactory = new TermFactory();
    	  		CNF3Integrator cNF3Integrator = new CNF3Integrator();
    	  		
    	  		cNF3Integrator.variables = variables;
    	  		termFactory.variables = variables;
    	  		this.variables=variables;
    	  				
    	  		variables.put(variable, "0");
    	  		BigInteger sum0 = computeSum(termFactory,cNF3Integrator,cnf3clauses);
    	  		collectiveSum0 = collectiveSum0.add(sum0);
    	  		
    	  		
    	  		variables.put(variable, "1");
    	  		BigInteger sum1 = computeSum(termFactory,cNF3Integrator,cnf3clauses);
    	  		collectiveSum1 = collectiveSum1.add(sum1);
    	  				
    	  		}
    	  		
    	  		System.out.println("sum0:"+collectiveSum0);
    	  		System.out.println("sum1:"+collectiveSum1);
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
	
	public void evaluateOverSingleClausesAllPossibleValues(String variable) {
		
     System.out.println("Trying for variable:"+variable);
   	 BigInteger collectiveSum0 = new BigInteger("0");
   	 BigInteger collectiveSum1 = new BigInteger("0");
   	  
   	 if(this.variables.isEmpty()){
   	 this.variables= createVariableMapFromCaluses(CNF3TableEvaluator.clauses);
   	 }
   	  	
   	   String value = this.variables.get(variable);
 		
   	   for(CNF3 cnf3clause :getContainingClauses(CNF3TableEvaluator.clauses,variable)){
 		  
 		List<CNF3> cnf3clauses = new ArrayList<CNF3>();
 		cnf3clauses.add(cnf3clause);
 		
	    	 
 		TermFactory termFactory = new TermFactory();
 		CNF3Integrator cNF3Integrator = new CNF3Integrator();
 		
 		cNF3Integrator.variables = variables;
 		termFactory.variables = variables;
 		this.variables=variables;
 		
 		variables.put(variable, "0");
 		BigInteger sum0 = computeSum(termFactory,cNF3Integrator,cnf3clauses);
 		collectiveSum0 = collectiveSum0.add(sum0);
 		
 		
 		variables.put(variable, "1");
 		BigInteger sum1 = computeSum(termFactory,cNF3Integrator,cnf3clauses);
 		collectiveSum1 = collectiveSum1.add(sum1);
 				
 		}
   	   //restore original value to Map
 		variables.put(variable,value);
 		
 		System.out.println("sum0:"+collectiveSum0);
 		System.out.println("sum1:"+collectiveSum1);
 		 
 		diffMap .put(variable,collectiveSum0.subtract(collectiveSum1));
 		
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

	public BigInteger computeSum(TermFactory termFactory,CNF3Integrator CNF3Integrator, List<CNF3> cnf3 ){
		
		termFactory.getTerms().clear();
		
        List<CNF3> restClauses = new ArrayList<CNF3>();
		
        cnf3.forEach(cnf->{
		restClauses.add(cnf);
		});
		
		
 		for(CNF3 cnf:cnf3){
 		termFactory.addCaluseCNF(cnf);
 		restClauses.remove(cnf);
		
   		///List<Term> reducedTerms = reduceTerms(termFactory.getTerms(),
 					                              // "","",
  						                            //   restClauses);
 		//termFactory.setTerms(reducedTerms);
		
			 
				 
		}
	
			
		List<Term> termList = termFactory.getTerms();
		BigInteger value = CNF3Integrator.integrateOverVariables(termList);
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
	
    public  Map<String,String> createVariableMapFromCaluses( List<CNF3> clauses){
		
    	Map<String,String> variables = new TreeMap<String,String>();
    	
    	for(CNF3 cnf3:clauses){
    	variables.put(cnf3.getA1().replaceAll("-", ""),cnf3.getA1().replaceAll("-", ""));
    	variables.put(cnf3.getA2().replaceAll("-", ""),cnf3.getA2().replaceAll("-", ""));
    	variables.put(cnf3.getA3().replaceAll("-", ""),cnf3.getA3().replaceAll("-", ""));
    	}
       return variables;
	}
	
	
	public static void main2(String[] args){
	
		
		TermFactory termFactory = new TermFactory();
		CNF3Integrator xORIntegrator = new CNF3Integrator();
		
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
		
		CNF3Integrator xORIntegrator = new CNF3Integrator();
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
			
		 
		 Optional<BigInteger> value = terms
		  .stream()
		  .map(term->this.integrateTerm(term))
		  .reduce(BigInteger::add);
		 
	    	if(value.isPresent()){
	        return value.get();
	    	}
		 return new BigInteger("0");
	 }
	    
	 public  BigInteger integrateTerm(Term term){
		
	  BigInteger result = term.getFactor();
	  
	  if(term.factor==BigInteger.ZERO){
	  return BigInteger.ZERO;
	  }
	  
	  else if(term.values.containsValue("0")){
	  return BigInteger.ZERO;
	  }
	  
	  else if(term.values.containsKey("0")){
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
	 
	 
	 
  private List<Term> reduceTerms(List<Term> terms, String v1, String v2, List<CNF3> restClauses) {

	
  	
	for(String variable:getUnsetVariables()){

  		if(!doesVariableOccursInRestClauses(variable,restClauses)){
			terms.forEach(term->{
				term.removeVariable(variable);

			});	
		}
	}

   		return terms;
   		
	}

	private boolean doesVariableOccursInRestClauses(String v1, List<CNF3> restClauses) {
		
		boolean occur = false;
		for(CNF3 cnf:restClauses){
			String a = cnf.getA1().replaceAll("-", "");
			String b = cnf.getA2().replaceAll("-", "");
			String c = cnf.getA3().replaceAll("-", "");
			
			if(v1.equalsIgnoreCase(a) || v1.equalsIgnoreCase(b) || v1.equalsIgnoreCase(c)){
			return true;
			}
			
		}
		
		return occur;
	}
	
	
}
