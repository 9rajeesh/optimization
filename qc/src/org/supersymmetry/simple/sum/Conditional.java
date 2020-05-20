package org.supersymmetry.simple.sum;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Conditional {

	private static final Double _2PIBY3 = Math.PI*2/3.0;
	private static  Integer precision = 26;
	static MathContext mathContext = new MathContext(precision, RoundingMode.HALF_UP);
	private static final Double _2root3 = 2.0*Math.sqrt(3);
	private static  Integer count =1;
	private Integer totalVariables = 0;
	
	private String name="";
	
	private Variable pivotVariable;
	
	private List<Variable> variables = new ArrayList<Variable>();
	private List<Variable> allVariables = new ArrayList<Variable>();
	
	
	private static Map<String,List<SST>> condtionPowerCache= new HashMap<String,List<SST>>();
	

	public List<Variable> getVariables() {
		return variables;
	}

	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}

	public Conditional(List<Variable> variables) {
		super();
		this.variables = variables;
		this.name =count.toString();
		count++;
	}
	
	

    public static Integer getPrecision() {
		return precision;
	}

	public static void setPrecision(Integer precision) {
		Conditional.precision = precision;
	}
	
	
	
	
	public Integer getTotalVariables() {
		return totalVariables;
	}

	public void setTotalVariables(Integer totalVariables) {
		this.totalVariables = totalVariables;
	}
	public Variable getPivotVariable() {
		return pivotVariable;
	}

	public void setPivotVariable(Variable pivotVariable) {
		this.pivotVariable = pivotVariable;
	}
	
	
	
	
	public List<Variable> getAllVariables() {
		return allVariables;
	}

	public void setAllVariables(List<Variable> allVariables) {
		this.allVariables = allVariables;
	}
	
	
	

	public static MathContext getMathContext() {
		return mathContext;
	}

	public static void setMathContext(MathContext mathContext) {
		Conditional.mathContext = mathContext;
	}

	public  BigDecimal computeTotalValue(){
		
		return computeValue()
			  .multiply(Utility.pow(2,getScale()));
	
	}

	

	public  BigDecimal computeValue(){
		
		//reset Cache
		condtionPowerCache= new HashMap<String,List<SST>>();
		
		BigDecimal value = new BigDecimal(0.0);
    	Integer factor = 1;
    	 for(Integer power=1; power<precision; power=power+2){
    		 /**
    		  * x - x^3/3! + x^5/5! - x^7/7! + x^9/9!
    		  * 
    		  */
    		//System.out.println("Calculating for:"+power);		
    		BigDecimal coeff =   new BigDecimal(factor) //alternate +,-
    				         .multiply(Utility.pow(_2PIBY3, power)) //constant
    				         .multiply(raiseConditionalToPower(power))
    				         .divide(Utility.factorial(power),Conditional.mathContext);
    	    		
    		 coeff = coeff
    				.multiply(new BigDecimal(_2root3))
    				.divide(new BigDecimal(3.0));
    		 
    		 value =value.add(coeff);
    		 factor= factor*-1;
    	 }
          return value.add(Utility.pow(2, getNumberOfNonZeroNonOneVaiables()));
          			
       }
	
    
    public BigDecimal raiseConditionalToPower(Integer power){
    	
    	Integer total_variables = getNumberOfNonZeroVaiables(this.variables);
    	Integer count_set =   getNumberOfSetVaiables(this.variables);
    	
    	return raiseConditionalToPower(power,total_variables,count_set);
    }

	
    public BigDecimal raiseConditionalToPower(Integer power,Integer count_unset,Integer count_set){
    	
    	if(isCondtionPowerCached(power,count_unset,count_set)){
    	return raiseConditionalToPower_cached(power,count_unset,count_set);
    	}
    	
    	SST sst1 = new SST(1.0,count_unset,1,count_set);
    	//SST sst2 = new SST(0+0.0,0,0);
    	
    	
    	//prepare initial one - (a+sst)
        List<SST> result = new ArrayList<SST>();
        result.add(sst1);
        //result.add(sst2);
        
        List<SST> unitsst = new ArrayList<SST>();
        unitsst.add(sst1);
        //unitsst.add(sst2);
        
        for(int i=1; i<power; i++){
        result = SST.multiply(result, unitsst);
        result = SST.merge(result);
        }
        condtionPowerCache.put((power)+"u"+count_unset+"v"+count_set, result);
    	return SST.evaluate(result);
    }
    
    
    

	private BigDecimal raiseConditionalToPower_cached(Integer power, Integer count_unset, Integer count_set) {
		
		
		List<SST> result = condtionPowerCache.get((power-2)+"u"+count_unset+"v"+count_set);
		
		SST sst1 = new SST(1.0,count_unset,1,count_set);
		List<SST> unitsst = new ArrayList<SST>();
	    unitsst.add(sst1);
	    
	    result = SST.multiply(result, unitsst);
        result = SST.merge(result);
        
        result = SST.multiply(result, unitsst);
        result = SST.merge(result);
        
        condtionPowerCache.put((power)+"u"+count_unset+"v"+count_set, result);
		return  SST.evaluate(result);
	}

	private boolean isCondtionPowerCached(Integer power, Integer count_unset, Integer count_set) {
		
		if(condtionPowerCache.containsKey((power-2)+"u"+count_unset+"v"+count_set)){
		return true;	
		}
		return false;
	}

	private Integer getNumberOfNonZeroVaiables(List<Variable> variables) {
	    Long unsetVariables_count =  (Long)variables
	    		                      .stream()
	    		                      .filter(variable-> ! new Integer (0).equals(variable.getValue()))
	    		                      .count();
	    		                      
	                       
	    		                      
		return unsetVariables_count.intValue();
	}
	
	private Integer getNumberOfSetVaiables(List<Variable> variables) {
	    Long unsetVariables_count =    (Long)variables
	    		                       .stream()
	    		                       .filter(variable-> variable.getValue()!=null 
	    		                                         && !variable.getValue().equals(0) )
	    		                       .count();
	                       
	    		                      
		return unsetVariables_count.intValue();
	}
	
	private Integer getNumberOfNonZeroNonOneVaiables() {
	    Long unsetVariables_count =  (Long)variables
	    		                      .stream()
	    		                      .filter(variable-> 
	    		                       (!new Integer (0).equals(variable.getValue()))
	    		                       && (!new Integer (1).equals(variable.getValue()))
	    		                       )
	    		                      .count();
	    		                      
	                       
	    		                      
		return unsetVariables_count.intValue();
	}
   
	private int getScale() {
		
		List<Integer> count = new ArrayList<Integer>();
	    this.allVariables.forEach(variable->{
		   if(variable.getValue()==null  //unset
				   && !variable.equals(this.pivotVariable) //non pivit
				   && !this.variables.contains(variable)){  //outside the variable list
			   count.add(1);
		   }
	   });
	  
	return count.size();
   }
	
	
	public Integer dosum(){
		
		Integer sum = 0;
		for(Variable variable:this.variables){
		sum = sum + variable.getValue();	
		}
		
		sum = sum%3;
		 
		if(sum==0){
		return 1;
		}
		else if(sum==1){
		return 2;
		}
		
		else if(sum==2){
		return 0;
		}
		
		return sum;
	}
	
	
	
	
	
}
