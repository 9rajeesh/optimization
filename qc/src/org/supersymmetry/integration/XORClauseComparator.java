package org.supersymmetry.integration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class XORClauseComparator implements Comparator<String> {

	
	private Map<String,Integer> variables = new HashMap<String,Integer>();
	
	
	public XORClauseComparator( Map<String,Integer> variables,Integer bits){
		
		this.variables = variables;
		rotate(bits);
	}
	
      public XORClauseComparator( Set<String> variables,Integer bits){
		 Integer count = 1;
    	  for(String variable:variables){
    	  this.variables.put(variable, count);
    	  count = count + 1;
    	  }
    	  	  
		rotate(bits);
	 }
	
	
	
	public void rotate(Integer bits){
		Integer size = variables.size();
		variables.forEach((key,value)->{
			
			variables.put(key, getRotatedValue(value,bits,size));	
		});
		
		
	}
	
	
	private Integer getRotatedValue(Integer value,Integer bits, Integer size) {
		
		value = value - bits;
		
		if(value<=0){
		value = size +(value);
		}
		
		
		return value;
	}


	@Override
	public int compare(String o1, String o2) {
	
		return variables.get(o1).compareTo( variables.get(o2));
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		
		Set<String> variables = new TreeSet<String> ();
		variables.add("a");
		variables.add("b");
		variables.add("c");
		variables.add("d");
		variables.add("e");
		
		Set<String> variables1 = sortVariablesRandom(variables);
		
		
		
		variables1.forEach(variable->System.out.println(variable));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static Set<String> sortVariablesRandom(Set<String> variables){
		Set<String> random = new LinkedHashSet<String>();
		List<String> l1 = new ArrayList<String>();
		
		
		variables.forEach(item->l1.add(item));
		Integer count = l1.size();
		
		while(random.size()<count){
			int index = (int)(Math.random()*l1.size());
			random.add(l1.get(index));	
			l1.remove(index);
		}
		
		return random;
	}
	
	
	
	
}
