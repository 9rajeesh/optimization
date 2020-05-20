package org.supersymmetry.simple.sum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PInstance {

	
	
	private List<Conditional> condtionals = new ArrayList<Conditional>();

	private Map<Variable,Integer> variableMap = new HashMap<Variable,Integer>();
	
	private List<Variable> variables = new ArrayList<Variable>();
	
	
	public PInstance(List<Conditional> asList) {
		this.condtionals=asList;
		this.variables=variables;
	}

	public List<Conditional> getCondtionals() {
		return condtionals;
	}

	public void setCondtionals(List<Conditional> condtionals) {
		this.condtionals = condtionals;
	}
	
	
	
	public List<Variable> getVariables() {
		return variables;
	}

	public void setVariables(List<Variable> variables) {
		this.variables = variables;
		condtionals.forEach(conditional->{
		 conditional.setAllVariables(variables);
		});
		
		
	}

	public void refresh_VariableMap_With_Values_From_Each_Variable_Inside_Conditional(){
		condtionals.stream().forEach(conditional->{
			conditional.getVariables().stream().forEach(variable->{
				variableMap.put(variable, variable.getValue());
			});
		});
	}
	
	public void compute_Values(){
		//refresh_VariableMap_With_Values_From_Each_Variable_Inside_Conditional();
		
		variables.forEach((variable)->{
			compute_Sum_Of_Conditionals_With_Pivot_Around_Variable(variable);
			
		});
	}
		
    public void compute_Sum_Of_Conditionals_With_Pivot_Around_Variable(Variable variable){
    	
    	System.out.println("Checking at variable:"+variable.getName());
    	BigDecimal zero_sum =  new BigDecimal(0.0);
    	BigDecimal one_sum  =  new BigDecimal(0.0);
    	
    	condtionals.forEach(condtional->{
    		
    		condtional.setTotalVariables(19);
    		condtional.setPivotVariable(variable);
    	});
    	
    	
    	variable.setValue(0);
    	zero_sum = condtionals
    			  .stream()
    			  .map(Conditional::computeTotalValue)
    			  .reduce(BigDecimal::add).get();
    	
    	System.out.println("Zero sum:"+zero_sum);
    	
    	variable.setValue(1);
    	
    	one_sum =  condtionals
  			      .stream()
  			      .map(Conditional::computeTotalValue)
  			      .reduce(BigDecimal::add).get();
    	
    	System.out.println("One sum:"+one_sum);
        	    	
    	if(isGreater(zero_sum,one_sum)){
    	variable.setValue(0);	
    	}
    	else{
    	variable.setValue(1);		
    	}
    	
	}

	private boolean isGreater(BigDecimal zero_sum, BigDecimal one_sum) {
		
		if(zero_sum.compareTo(one_sum) > 0){
		return true;
		}
		
		return false;
	}
    
     public void setRandomValues() {
		
		for(Variable v:this.variables){
		  if(Math.random()<0.5){
			v.setValue(0);
			}
			
		  else {
			v.setValue(1);
			}
		}
	}
    
	
}
