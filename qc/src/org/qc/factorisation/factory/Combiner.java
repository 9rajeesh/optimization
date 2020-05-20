package org.qc.factorisation.factory;

import java.math.BigDecimal;
import java.util.List;

import org.qc.factorisation.model.BiTerm;

public class Combiner {

static int maxbits = 8;
public static void main(String[] args) {
		
		Factory.maxbits=maxbits;
		for(int i=0;i<2*maxbits;i++){
		generateSines(Factory.createFullX(i),i);
		generateSines(Factory.createFullY(i),i);
		}
		
	}
    private static void generateSines(List<BiTerm> createFullX, int i) {
	 
    	BigDecimal factor = null;
    	List<BiTerm> terms = scale(createFullX,factor);
    	
    	for(int power=1;power<10;power=power+2) {
    		
    		terms = scale(power(createFullX,power),factorialInverse(power));
    	}
    	
	
    }
	private static List<BiTerm> scale(Object power, BigDecimal factorialInverse) {
		// TODO Auto-generated method stub
		return null;
	}
	private static BigDecimal factorialInverse(int power) {
		// TODO Auto-generated method stub
		return null;
	}
	private static Object power(List<BiTerm> createFullX, int power) {
		// TODO Auto-generated method stub
		return null;
	}

}
