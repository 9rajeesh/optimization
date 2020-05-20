package org.qc.supersymmtery.empirism;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClauseFactory {

	
	public static void main(String[] args){
		
		
		Clause a = new Clause("a","b");
		Clause b = new Clause("a","c");
		Clause c = new Clause("a","d");
		Clause d = new Clause("b","c");
		//Clause e = new Clause("i","j");
		//Clause f = new Clause("k","l");
		
		List<Clause> clauseList = new ArrayList<>();
		clauseList.add(a);
		clauseList.add(b);
		clauseList.add(c);
		clauseList.add(d);
		//clauseList.add(e);
		//clauseList.add(f);
				
		doProcess(clauseList);
		System.out.println("---------------------------------");
		
		
		
	}
	
	
	public static void doProcess(List<Clause> clauseList){
		
		List<Term> result = new ArrayList<>();
		for(Clause clause:clauseList){
			result = Term.multiply(result,clause.getTerms());
			result=  Term.mergeTerms(result);
		}
		
		Map<Integer,List<Term>> termMap = result
				                         .stream()
				                         .collect(Collectors.groupingBy(term->term.getVariables().size()));
		

		List<Term> result2 = new ArrayList<>();
		
		termMap.forEach((k,v)->{
			Long sum = v.stream().collect(Collectors.summingLong(Term::getFactor));
			v.get(0).setFactor(sum);
			result2.add(v.get(0));
			
		});
		
		result2.forEach(term->System.out.println(term));	
		
	}
	
	
	
	
}
