package org.supersymmetry.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CNF3ClauseGenerator {
	
	static List<CNF3> cnf3clauses = new ArrayList<CNF3>();
	static List<CNF3> workingCluases = new ArrayList<CNF3>();
	static List<CNF3> subset = new ArrayList<CNF3>();
	static List<String> pad = new ArrayList<String>();
	static List<String> removedVariables = new ArrayList<String>();
	static Integer length = 40;
	
	
	
	
	static List<List<CNF3>> subsets = new ArrayList<List<CNF3>>();
	private static int clauseCount = 500;
	private static double variables = 100;
	
	public static void main(String[] args) throws Exception {
		
		
		
		generate();
		//cnf3clauses.forEach(clause->System.out.println(clause));
		
		generateRandomSubset();
		System.out.println("size of subset is:"+subset.size());
		subset.forEach(clause->System.out.println(clause));
		
		//XORClauseTableEvaluator.tree();
		
		/*for(int i=0;i<100;i++){
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
		
		*/
		
		
		
		
		
		
	}
	
	
	
	
	private static void init() {
	workingCluases = new ArrayList<CNF3>();
	subset = new ArrayList<CNF3>();
	pad = new ArrayList<String>();
	removedVariables = new ArrayList<String>();
	
	}




	private static void shuffle() {
		
	List<CNF3> shuffledList = new ArrayList<CNF3>();	
	
	while(cnf3clauses.size()>0){
	int size = cnf3clauses.size();
	int index = (int)(Math.random()*size);
	CNF3 clause = cnf3clauses.get(index);
	shuffledList.add(clause);
	cnf3clauses.remove(clause);
	}
	cnf3clauses = shuffledList;
	}




	public static void generateRandomSubset(){
		
		cnf3clauses.forEach(clause->{
		workingCluases.add(new CNF3(clause.getA1(),clause.getA2(),clause.getA3() ));
		});
		
		    CNF3 init = cnf3clauses.get(0);
		   
		    
		   while(true){
			
		    addToPad(init);
			normalizepad();
			workingCluases.remove(init);
			subset.add(init);
			
			
			CNF3 clause = getClauseWithPadvariable();
			
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
	
	public static void addToPad(CNF3 cnf3){
		
		if(!pad.contains(cnf3.getA1())){
		pad.add(cnf3.getA1());
		}
		
		if(!pad.contains(cnf3.getA2())){
		pad.add(cnf3.getA2());
		}
		
		if(!pad.contains(cnf3.getA3())){
		pad.add(cnf3.getA3());
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
	
	public  static CNF3 getClauseWithPadvariable(){
		
		for(CNF3 clause:workingCluases){
			
			if(pad.contains(clause.getA1())
				&& !removedVariables.contains(clause.getA1())
				&& !removedVariables.contains(clause.getA2())
				&& !removedVariables.contains(clause.getA3())){	
				
				return clause;
				}
			
			if(pad.contains(clause.getA2())
					&& !removedVariables.contains(clause.getA1())
					&& !removedVariables.contains(clause.getA2())
					&& !removedVariables.contains(clause.getA3())){	
					
					return clause;
					}
			
			if(pad.contains(clause.getA3())
					&& !removedVariables.contains(clause.getA1())
					&& !removedVariables.contains(clause.getA2())
					&& !removedVariables.contains(clause.getA3())){	
					
					return clause;
					}
			}
		return null;
			
			
	}
	
	
      public  static CNF3 getRandomClause(){
		
		for(CNF3 clause:workingCluases){
			
			if(!removedVariables.contains(clause.getA1())
			&& !removedVariables.contains(clause.getA2())
			&& !removedVariables.contains(clause.getA3())){	
			
			return clause;
			
			}
			}
		return null;
	}
	
	
	
	
      public static void generate() {

  		while (cnf3clauses.size() < clauseCount ) {
  			Integer v1 = (int) (Math.random() * variables );
  			Integer v2 = (int) (Math.random() * variables);
  			Integer v3 = (int) (Math.random() * variables);
  			
  			if(Math.random()>0.5){
  			v1 =1*v1;
  			}
  			
  			if(Math.random()>0.5){
  			v2 =1*v2;
  			}
  			
  			if(Math.random()>0.5){
  			v3 =1*v3;
  			}
  			
  			CNF3 cnf = new CNF3("v" + v1, "v" + v2, "v"+v3);

  			if (v1 == v2 || v2==v3 || v1==v3) {
  			continue;
  			}

  			if (cnf3clauses.contains(cnf)) {
  			System.out.println("skipping");
  			continue;
  			}
  			cnf3clauses.add(cnf);
  		}
  		//cnf3clauses.forEach(clause -> System.out.println(clause));
  	}
	

}
