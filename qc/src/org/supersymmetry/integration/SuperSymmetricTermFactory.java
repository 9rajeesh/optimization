package org.supersymmetry.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperSymmetricTermFactory extends TermFactory {

	
	

	
	
	public Term createTermFromClause(){
		
		
	return null;
	}
	
	public TermFactory addCaluse(String a,String b){
		termFactory= this;
		SuperSymmetricTerm term = new SuperSymmetricTerm();
		
		if(!terms.isEmpty()){
		terms = term.multiply(terms, createTermFromCaluse(a,b));
		}
		
		else{
		terms = createTermFromCaluse(a,b);	
		}
		
	return termFactory;
	}
	
	
	public List<Term> createTermFromCaluse(String a,String b){
		
		List<Term> result = new ArrayList<Term>();
		List<Term> tlist1 = new ArrayList<Term>();
		List<Term> tlist2 = new ArrayList<Term>();
		SuperSymmetricTerm term = new SuperSymmetricTerm();
		
		Term terma =  getTerm(1,a);
		Term termb =  getTerm(-1,b);
		
		tlist1.add(terma);
		tlist1.add(termb);
		
		Term terma1 =  getTerm(1,a);
		Term termb1 =  getTerm(-1,b);
		
		tlist2.add(terma1);
		tlist2.add(termb1);
		result = term.multiply(tlist1, tlist2);
		result.add(new SuperSymmetricTerm(new Term(1)));
		
		return result;
	}


	
	

	protected Term getTerm(Integer factor,String variable){
		
		String var1 = variables.get(variable);
		if(var1==null){
		throw new IllegalStateException("Unampped variable:"+variable);
		}
		Term term = new Term(factor,var1);
		SuperSymmetricTerm sterm = new SuperSymmetricTerm(term);
		return sterm;
	}

	
	
	
	
	
	
}
