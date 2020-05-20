package org.qc.superposition.waves.solver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SquareWave {

	
	
	
	
	private BigDecimal period;
	
	
	 public SquareWave(BigDecimal period){
		 this.period = period;
		 
	 }
	 
	 
	 public List<Term> raiseToPower(List<Term> terms,Integer count){
		 List<Term> result = new ArrayList<Term> ();
		   while(count>0){
			 result = Term.multiply(result, terms);
			 count = count - 1;
		   }
		 return result;
		}
	 
	 public List<Term> getSquareWave(BigDecimal x){
		
		 List<Term> terms = new ArrayList<Term>();
		 
		 Term cosine1 = new Term(new BigDecimal("1.0"),1,0, null, null,0);
	     Term sine1 = new Term(new BigDecimal("1.0"),0,1, null, null,1);
	     List<Term> baseTerms = new ArrayList<Term>(); 
	     baseTerms.add(cosine1);
	     baseTerms.add(sine1);
	       
		 for(int i=1;i<10;i=i+2){
		  
		   List<Term> raisedPower  =  raiseToPower(baseTerms,i);
		   
		   BigDecimal scale = BigDecimal.valueOf((4/Math.PI)*(1.0/i));	
		   
		   List<Term> scaledRaisedPower  = scale(raisedPower,scale);
		   
		   terms.addAll(scaledRaisedPower);
		   
		 }
		 
		 terms =  terms
				 .stream()
				 .filter(term -> Integer.valueOf(1).equals(term.getJ()))
				 .collect(Collectors.toList());
		 
		 return terms;
	 }


	private List<Term> scale(List<Term> terms, BigDecimal scale) {
		
		terms.forEach(term->{
			term.setFactor(term.getFactor().multiply(scale));
		});
		return terms;
	}
	 
	 
	 
	
}
