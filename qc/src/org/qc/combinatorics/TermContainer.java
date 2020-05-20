package org.qc.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class TermContainer {

	static List<Term> termsList1 = new ArrayList<Term>();
	static List<Term> termsList2 = new ArrayList<Term>();
	
	public static void main(String[] args) {
		
		Term abc = new Term(1L,1L,1L,1L,0L,0L,0L);
		Term def = new Term(1L,0L,0L,0L,1L,1L,1L);
		//Term ef = new Term(1L,0L,0L,0L,0L,1L,1L);
		
		termsList1.add(abc);
		termsList1.add(def);	
		//termsList1.add(ef);	
		
		termsList2.add(abc);
		termsList2.add(def);	
		//termsList2.add(ef);	
		
		termsList2 = multiply(termsList2,termsList1);
		termsList2 = merge(termsList2);
		
		termsList2 = multiply(termsList2,termsList1);
		termsList2 = merge(termsList2);
		
		termsList2 = multiply(termsList2,termsList1);
		termsList2 = merge(termsList2);
		/*
		termsList2 = multiply(termsList2,termsList1);
		termsList2 = merge(termsList2);
		/*
		termsList2 = multiply(termsList2,termsList1);
		termsList2 = merge(termsList2);
		*/
		
		System.out.println("Size is:"+termsList2.size());
		termsList2.forEach(term->System.out.println(term));
		
	}
	
	private static List<Term>  multiply(List<Term> termsList22,List<Term> termsList12) {
		 List<Term> termsList3 = new ArrayList<Term>();
		
		 termsList22.stream().forEach(term1->{
			termsList12.stream().forEach(term2->{
			termsList3.add(Term.multiply(term1, term2));
			});
		});
		
		return termsList3;
	}

	private static List<Term>  merge(List<Term> termsList22) {
		 List<Term> termsList3 = new ArrayList<Term>();
		
		 termsList22.stream().forEach(term1->{
			 termsList22.stream().forEach(term2->{
				  if(term1!=term2 && term1.getFactor()!=0 && term2.getFactor()!=0) {
					 if(term1.similarTo(term2)){
						 term1.setFactor(term1.getFactor()+term2.getFactor());
					     term2.setFactor(0L);
					 }
				 }
			 });
		 });
		 termsList22.stream().forEach(term->{
			 if(term.getFactor()!=0) {
			 termsList3.add(term);
			 }
		 });
		
		return termsList3;
	}
	
	
	
	
	
	
}
