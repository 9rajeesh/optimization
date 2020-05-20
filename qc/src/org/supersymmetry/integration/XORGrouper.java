package org.supersymmetry.integration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class XORGrouper extends Grouper{

	static Integer rotate = 0;
	private Set<String> variables = new TreeSet<String>();
	private List<XORClause> clauses = new ArrayList<XORClause>();
	Map<String,List<XORClause>> vMap = new TreeMap<String,List<XORClause>>();
	Map<String,Map<String,XORClause>> fullMap = new TreeMap<String,Map<String,XORClause>>();
    XORClauseComparator xORClauseComparator;
	
	public static void main(String[] args){
		
		XORGrouper XORGrouper = new XORGrouper();
		XORGrouper.clauses.add(new XORClause("a","b"));
		XORGrouper.clauses.add(new XORClause("a","c"));
		XORGrouper.clauses.add(new XORClause("a","d"));
		XORGrouper.clauses.add(new XORClause("a","e"));
		XORGrouper.clauses.add(new XORClause("a","f"));
		
		
		XORGrouper.clauses.add(new XORClause("b","c"));
		XORGrouper.clauses.add(new XORClause("b","d"));
		XORGrouper.clauses.add(new XORClause("b","f"));
		
		
		XORGrouper.clauses.add(new XORClause("c","d"));
		XORGrouper.clauses.add(new XORClause("c","f"));
		
		
		XORGrouper.clauses.add(new XORClause("d","e"));
		XORGrouper.clauses.add(new XORClause("d","f"));
		
		
		XORGrouper.clauses.add(new XORClause("e","f"));
		
		
		for(int i=0;i<3;i++){		
		Set<String> variables = XORClauseComparator.sortVariablesRandom(XORGrouper.getAllVariablesAsSet());
		
		rotate = 0;
		for(;rotate<6;rotate=rotate+1){
			XORGrouper.xORClauseComparator = new XORClauseComparator(variables,rotate);
			XORGrouper.prepareMap();
			String map = XORGrouper.printFullMap();
			System.out.println("Map is:\n"+map);
			
			List<XORClause> groupedClauses = XORGrouper.extractValuesFromMap(2);
			groupedClauses.forEach(clause->System.out.println(clause));
			
			}
		}
	}
	
      public static Map<Integer,List<XORClause>> getClauseSetRandomized() {
		
    	Map<Integer,List<XORClause>> xorMap = new HashMap<Integer,List<XORClause>>();
    	  
    	  
		XORGrouper XORGrouper = new XORGrouper();
		XORGrouper.clauses.add(new XORClause("a","b"));
		XORGrouper.clauses.add(new XORClause("a","c"));
		XORGrouper.clauses.add(new XORClause("a","d"));
		XORGrouper.clauses.add(new XORClause("a","e"));
		XORGrouper.clauses.add(new XORClause("a","f"));
		
		
		XORGrouper.clauses.add(new XORClause("b","c"));
		XORGrouper.clauses.add(new XORClause("b","d"));
		XORGrouper.clauses.add(new XORClause("b","f"));
		
		
		XORGrouper.clauses.add(new XORClause("c","d"));
		XORGrouper.clauses.add(new XORClause("c","f"));
		
		
		XORGrouper.clauses.add(new XORClause("d","e"));
		XORGrouper.clauses.add(new XORClause("d","f"));
		
		
		XORGrouper.clauses.add(new XORClause("e","f"));
		
		
	
		Set<String> variables = XORClauseComparator.sortVariablesRandom(XORGrouper.getAllVariablesAsSet());
		
		rotate = 0;
		for(;rotate<6;rotate=rotate+1){
			XORGrouper.xORClauseComparator = new XORClauseComparator(variables,rotate);
			XORGrouper.prepareMap();
			String map = XORGrouper.printFullMap();
			System.out.println("Map is:\n"+map);
			
			List<XORClause> groupedClauses = XORGrouper.extractValuesFromMap(2);
			groupedClauses.forEach(clause->System.out.println(clause));
			xorMap.put(rotate, groupedClauses);
			}
		
		return xorMap;
		}
	
	
	
	@Override
	public Map<String, List<Clause>> group(List<Clause> clauses) {
			
		
		return null;
	}
	
    
    


   


	private List<XORClause> getShiftedList(List<XORClause> values, Integer bits) {
		
    	List<XORClause> shifted = new ArrayList<XORClause>();
    	 
    	for(int i=bits;i<values.size();i++){
    	shifted.add(values.get(i));
    	}
    	
    	for(int i=bits-1;i>=0;i--){
        shifted.add(values.get(i));
        }
    	
    	
		return shifted;
	}

	private List<XORClause> extractValuesFromMap(Integer maxWidth){
    	 List<XORClause> clauses = new  ArrayList<XORClause>();
    	
    	 Integer row = 1;
    	 for (Entry<String, Map<String, XORClause>> entry : fullMap.entrySet()) {
    		
           clauses.addAll(getFirstNElements(entry.getKey(),row,maxWidth));
           row = row +1;
    	 }
    	
    	return clauses;
     }

	private List<XORClause> getFirstNElements(String key, Integer row, Integer maxWidth) {
		
		List<XORClause> clauses = new ArrayList<XORClause>();
		Map<String, XORClause> nestedMap = fullMap.get(key);

	    Integer column = 0;
		
	    for (Entry<String, XORClause> entry : nestedMap.entrySet()) {
			column = column + 1;

			if (row >= column) {
				continue;
			}

			if (maxWidth == 0) {
				break;
			}

			XORClause clause = entry.getValue();

			if (clause != null) {
				clauses.add(clause);
				maxWidth = maxWidth - 1;
			}

			
		}
		return clauses;
		}

	
	

	private void getAllVariables() {
		clauses.forEach(clause->{
			this.variables.add(clause.getV1());
			this.variables.add(clause.getV2());
		});
		
	}
	
	private Set<String> getAllVariablesAsSet() {
		Set<String> variables = new LinkedHashSet<String>();
			
		clauses.forEach(clause->{
			variables.add(clause.getV1());
			variables.add(clause.getV2());
		});
		return variables;
		
	}
	
	
	
	private void prepareMap() {
		getAllVariables();
		initializeFullMap();
		this.clauses = sortClauses(this.clauses);
		
		Map<String,List<XORClause>> cMap =  clauses
				                           .stream()
				                           .collect(Collectors.groupingBy(XORClause::getV1));
		
						
		cMap.forEach((key,values)->{
			values.forEach(clause->{
			fullMap.get(key).put(clause.getV2(),clause);
			});
			
			
		});
	}

	public String printFullMap(){
		StringBuffer mapString = new StringBuffer();
		
		fullMap.forEach((key,nestedMap)->{
			nestedMap.forEach((key1,clause)->{
			mapString.append("       "+clause);
			});
			mapString.append("\n");
		});
		return mapString.toString();
	};
	
	
	private void initializeFullMap() {

		for (String variable1 : variables) {
  
	  
	    
        
		Map<String, XORClause> nestedMap = new TreeMap<String, XORClause>(xORClauseComparator);
			  for (String variable2 : variables) {
			  nestedMap.put(variable2, null);
		      }
		fullMap.put(variable1, nestedMap);
		}
	}

	private List<XORClause> sortClauses(List<XORClause> clauses){
		List<XORClause> sortedClauses = new ArrayList<XORClause>();
		
		clauses.forEach(clause->{
			if(clause.getV1().compareTo(clause.getV2())>0){
				
				String v1 = clause.getV1();
				String v2 = clause.getV2();
				
				clause.setV1(v2);
				clause.setV2(v1);
			}
			sortedClauses.add(clause);
		});
		
		return sortedClauses;
		
	}
	

}
