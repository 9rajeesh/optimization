package org.supersymmetry.integration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TermFactory {

	
	public Map<String,String> variables = new HashMap<String,String>();
	protected TermFactory termFactory;
	protected List<Term> terms = new ArrayList<Term>();
	
	
	public Term createTermFromClause(){
		
		
	return null;
	}
	
	public TermFactory addCaluse(String a,String b){
		termFactory= this;
		Term term = new Term();
		if(!terms.isEmpty()){
		terms = term.multiply(terms, createTermFromCaluse(a,b));
		}
		else{
		terms = createTermFromCaluse(a,b);	
		}
		
	return termFactory;
	}
	
	
	public TermFactory addCaluseCNF(CNF3 cnf3){
		termFactory= this;
		Term term = new Term();
		if(!terms.isEmpty()){
		terms = term.multiply(terms, createTermFromCNF3Clause(cnf3));
		}
		else{
		terms = createTermFromCNF3Clause(cnf3);	
		}
		
	return termFactory;
	}
	
	public List<Term> createTermFromCaluse(String a,String b){
	
		List<Term> result = new ArrayList<Term>();
		List<Term> tlist1 = new ArrayList<Term>();
		List<Term> tlist2 = new ArrayList<Term>();
		Term term = new Term();
		
		Term terma =  getTerm(1,a);
		Term termb =  getTerm(-1,b);
		
		tlist1.add(terma);
		tlist1.add(termb);
		
		Term terma1 =  getTerm(1,a);
		Term termb1 =  getTerm(-1,b);
		
		tlist2.add(terma1);
		tlist2.add(termb1);
		result = term.multiply(tlist1, tlist2);
		result.add(new Term(1));
		
		return result;
	}
	

	public List<Term> createTermFromCNF3Clause(CNF3 cnf3){
	
			
		List<Term> tlistfirst = new ArrayList<Term>();
		List<Term> tlistsec = new ArrayList<Term>();
		
		Term term = new Term();
		
		List<Term> terma =  getTermCNF3(1,cnf3.getA1());
		List<Term> termb =  getTermCNF3(1,cnf3.getA2());
		List<Term> termc =  getTermCNF3(1,cnf3.getA3());
		
		List<Term> abp = new ArrayList<Term>();
		List<Term> acp = new ArrayList<Term>();
				
		tlistfirst.addAll(terma);
		tlistfirst.addAll(termb);
		tlistfirst.addAll(inverse(term.multiply(terma, termb)));
				
		
		tlistsec.addAll(tlistfirst);
		tlistsec.addAll(termc);
		tlistsec.addAll(inverse(term.multiply(tlistfirst, termc)));
			
		return tlistsec;
	}

	private Collection<? extends Term> inverse(List<Term> terms) {
	
		terms.forEach(term->{
			term.setFactor(term.getFactor().multiply(new BigInteger("-1")));
		});
		
		return terms;
	}

	private List<Term> getTermCNF3(int factor, String variable) {
		
		
		if(variable.contains("-")){
		return getTermCNF3Inverse(factor,variable);
		}
		
		List<Term> result = new ArrayList<Term>();
		Term one = new Term(1);
		
		String var1 = variables.get(variable);
		if(var1==null){
		throw new IllegalStateException("Unampped variable:"+variable);
		}
		Term t =  new Term(factor,var1);
		result.add(t);
				
		return result;
	}

	private List<Term> getTermCNF3Inverse(int factor, String variable) {
		
		    variable = variable.replaceAll("-", "");
					
			List<Term> result = new ArrayList<Term>();
			Term one = new Term(1);
			
			String var1 = variables.get(variable);
			if(var1==null){
			throw new IllegalStateException("Unampped variable:"+variable);
			}
			Term t =  new Term(factor*-1,var1);
			result.add(one);
			result.add(t);
					
			return result;
		
		
		
		
	}

	public Map<String, String> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}
	
	protected Term getTerm(Integer factor,String variable){
		
		String var1 = variables.get(variable);
		if(var1==null){
		throw new IllegalStateException("Unampped variable:"+variable);
		}
		return new Term(factor,var1);
	}

	public TermFactory getTermFactory() {
		return termFactory;
	}

	public void setTermFactory(TermFactory termFactory) {
		this.termFactory = termFactory;
	}

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}
	
	
	
	
	
	
}
