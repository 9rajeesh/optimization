package org.supersymmetry.integration.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.supersymmetry.integration.Term;

public class TermTest {

	
	@Test
	public void doTest(){
	Term t = new Term();
		
	List<Term> tlist1 = new ArrayList();
	List<Term> tlist2 = new ArrayList();
	
	Term t1 = new Term(1,"a");
	Term t2 = new Term(-1,"b");	
	
	Term t3 = new Term(1,"a");
	Term t4 = new Term(-1,"b");	
	
	tlist1.add(t1);
	tlist1.add(t2);
	
	tlist2.add(t3);
	tlist2.add(t4);
	
	List<Term> result = t.multiply(tlist1,tlist2);
	result.forEach(term->System.out.println(term));
		
		
	}
	
	
	
}
