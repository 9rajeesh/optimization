package org.supersymmetry.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class XORClauseGenerator {
	
	static List<XORClause> xorcluses = new ArrayList<XORClause>();
	static List<XORClause> workingCluases = new ArrayList<XORClause>();
	static List<XORClause> subset = new ArrayList<XORClause>();
	static List<String> pad = new ArrayList<String>();
	static List<String> removedVariables = new ArrayList<String>();
	static Integer length = 8;
	
	
	
	
	static List<List<XORClause>> subsets = new ArrayList<List<XORClause>>();
	private static int clauseCount = 500;
	private static double variables = 200;
	
	public static void main(String[] args) throws Exception {
		
		
		
		generate();
		xorcluses.forEach(clause->System.out.println(clause));
		//XORClauseTableEvaluator.tree();
		
		for(int i=0;i<100;i++){
		init();
		shuffle();
		generateRandomSubset();
		subsets.add(subset);
		//System.out.println("Subsets");
		//subset.forEach(clause->System.out.println(clause));
		System.out.println("Subset size:"+subset.size());
		//XORClauseValidator.verify();
		//System.out.println("Max width:"+XORClauseValidator.maxsize);
		
		//XORClauseTableEvaluator.tree();
		//System.out.println("Iterating");
		//XORClauseTableEvaluator.iterate();
		}
		//XORClauseTableEvaluator.iterate();
		XORClauseTableEvaluator.calculateSingle();
		XORClauseTableEvaluator.calculateSingleSquare();
		XORClauseTableEvaluator.calculate();
		
		
		
		
		
		
		
		
	}
	
	
	
	
	private static void init() {
	workingCluases = new ArrayList<XORClause>();
	subset = new ArrayList<XORClause>();
	pad = new ArrayList<String>();
	removedVariables = new ArrayList<String>();
	
	}




	private static void shuffle() {
		
	List<XORClause> shuffledList = new ArrayList<XORClause>();	
	
	while(xorcluses.size()>0){
	int size = xorcluses.size();
	int index = (int)(Math.random()*size);
	XORClause clause = xorcluses.get(index);
	shuffledList.add(clause);
	xorcluses.remove(clause);
	}
	xorcluses = shuffledList;
	}




	public static void generateRandomSubset(){
		
		xorcluses.forEach(clause->{
		workingCluases.add(new XORClause(clause.getV1(), clause.getV2()));
		});
		
		    XORClause init = xorcluses.get(0);
		   
		    
		   while(true){
			
		    addToPad(init);
			normalizepad();
			workingCluases.remove(init);
			subset.add(init);
			
			
			XORClause clause = getClauseWithPadvariable();
			
			if(clause == null){
			
				if( (pad.size() +2) <=length){
				clause = getRandomClause();
				     if(clause==null){
					  break;
				      }
				}
				else{
				break;
				}
			}
			
			init = clause;
			
		    }
			
		
		
		
	}
	
	public static void addToPad(XORClause xorClause){
		
		if(!pad.contains(xorClause.getV1())){
		pad.add(xorClause.getV1());
		}
		
		if(!pad.contains(xorClause.getV2())){
		pad.add(xorClause.getV2());
		}
		
	}
	
    public static void normalizepad(){
		
		if(pad.size()==0){
		return;
		}
		
		while(pad.size() > length){
		String variable = pad.get(0);
		pad.remove(variable);
		removedVariables.add(variable);
		}
			
	 }
	
	public  static XORClause getClauseWithPadvariable(){
		
		for(XORClause clause:workingCluases){
			
			if(pad.contains(clause.getV1())  && !removedVariables.contains(clause.getV1())){
				
				if(!removedVariables.contains(clause.getV2())){
				return clause;
				}
			}
			
			if(pad.contains(clause.getV2()) && !removedVariables.contains(clause.getV2())){
				    if(!removedVariables.contains(clause.getV1())){
					return clause;
					}
			}
		}
		
		return null;
	}
	
	
      public  static XORClause getRandomClause(){
		
		for(XORClause clause:workingCluases){
			
			if(!removedVariables.contains(clause.getV1())){
				
				if(!removedVariables.contains(clause.getV2())){
				return clause;
				}
			}
			
			if(!removedVariables.contains(clause.getV2())){
				    if(!removedVariables.contains(clause.getV1())){
					return clause;
					}
			}
		}
		
		return null;
	}
	
	
	
	
	public static void generate() {

		while (xorcluses.size() < clauseCount) {
			Integer v1 = (int) (Math.random() * variables);
			Integer v2 = (int) (Math.random() * variables);
			XORClause xorClause = new XORClause("v" + v1, "v" + v2);

			if (v1 == v2) {
			continue;
			}

			if (xorcluses.contains(xorClause)) {
			System.out.println("skipping");
			continue;
			}
			xorcluses.add(xorClause);
		}
		//xorcluses.forEach(clause -> System.out.println(clause));
	}
	

}
