package org.qc.factorisation.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.qc.factorisation.model.BiTerm;
import org.qc.factorisation.model.Term;

public class Factory {

	public static Integer maxbits = 8;
	/**
	 * This creates the full expressions for x
	 * 
	 * 
	 * 
	 */
	public static List<BiTerm> createFullX(Integer index){
		List<BiTerm> biTermList = new ArrayList<BiTerm>();	
		for(int i=0;i<=index;i++) {
		biTermList.addAll(createScaledX(i));
		}
		return biTermList;
	}
	/**
	 * This creates the full expressions for y
	 * 
	 * 
	 * 
	 */
	public static List<BiTerm> createFullY(Integer index){
		List<BiTerm> biTermList = new ArrayList<BiTerm>();	
		for(int i=0;i<=index;i++) {
		biTermList.addAll(createScaledY(i));
		}
		return biTermList;
	}
	
	/***
	 * Creates expression at a specific index
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public  static List<BiTerm> createScaledX(Integer index){
		
	List<BiTerm> biTermList = new ArrayList<BiTerm>();
	
	if(index<maxbits) {
	 for(int i=0;i<=index;i++) {
		
			Term term1 = new Term("a"+(i));
			Term term2 = new Term("x"+(index-i));
			BiTerm biterm = new BiTerm(term1,term2,power(2,index-1));
			biTermList.add(biterm);
		}
	}

	 else if(index>=maxbits) {
		 for(int i=(index-maxbits+1);i<maxbits;i++) {
					Term term1 = new Term("a"+(i));
					Term term2 = new Term("x"+(index-i));
					BiTerm biterm = new BiTerm(term1,term2,power(2,index-1));
					biTermList.add(biterm);
				}	 
	   }
		
		return biTermList;
	}
	
    private static BigDecimal power(int i, int j) {
	
		return null;
	}
       
    /***
	 * Creates expression at a specific index
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
    public static  List<BiTerm> createScaledY(Integer index){
		
    	List<BiTerm> biTermList = new ArrayList<BiTerm>();
    	
    	if(index<maxbits) {
    	 for(int i=0;i<=index;i++) {
    		
    			Term term1 = new Term("a"+(i));
    			Term term2 = new Term("y"+(index-i));
    			BiTerm biterm = new BiTerm(term1,term2,power(2,index-1));
    			biTermList.add(biterm);
    		}
    	}

    	 else if(index>=maxbits) {
    		 for(int i=(index-maxbits+1);i<maxbits;i++) {
    					Term term1 = new Term("a"+(i));
    					Term term2 = new Term("y"+(index-i));
    					BiTerm biterm = new BiTerm(term1,term2,power(2,index-1));
    					biTermList.add(biterm);
    				}	 
    	   }
    		
    		return biTermList;
    	}
	
	
	public static void main(String[] args) {
		
		for(int i=0;i<2*maxbits;i++){
		createFullX(i);
		createFullY(i);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
