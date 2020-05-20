package org.supersymmetry.integration;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XORClauseSolver {

	Map<String, BigInteger> results = new HashMap<String, BigInteger>();
	
	public void doSolve(List<Clause> clauses){
		
		Grouper grouper = new XORGrouper();
		List<String> variables = getAllUnsetVariables(clauses);
		
		for (String variable : variables) {
			  results = new HashMap<String, BigInteger>();
			  grouper.group(clauses).forEach((key, groupedCluases) -> {
			  solveEachGroupForVariable(key, groupedCluases, variable);
			  });

		Integer value = weighResults(results);
		setVariableinAllClauses(clauses, variable, value);
		}
		
	}

	private void setVariableinAllClauses(List<Clause> clauses, String variable, Integer value) {
	clauses.forEach(clause->clause.setVariable(variable,value));
	}

	private Integer weighResults(Map<String, BigInteger> results) {
		
		
		
		
		return null;
	}

	private List<String> getAllUnsetVariables (List<Clause> clauses) {
		// TODO Auto-generated method stub
		return null;
	}

	private void solveEachGroupForVariable(String key, List<Clause> groupedCluases,String variable) {
		
		Integrator integrator = new XORIntegrator();
			
		BigInteger value0 = (BigInteger) integrator.integrateOverVariables(groupedCluases, variable, 0);
		BigInteger value1 =  (BigInteger)integrator.integrateOverVariables(groupedCluases, variable, 1);
		
		results.put(key+",0", value0);
		results.put(key+",1", value1);
		
		
	}
	
	
	
}
