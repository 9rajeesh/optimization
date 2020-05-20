package org.supersymmetry.order.one.validate;

import java.util.ArrayList;
import java.util.List;

public class PState {

	
	public List<Integer> states = new ArrayList<Integer>();
	private static final Double MOD = 2.0;
	
	public PState(String a) {
		states = new ArrayList<Integer>();
		for (char c : a.toCharArray()) {
			states.add(Integer.parseInt(String.valueOf(c)));
		}

	}
	
	public Double evaluate(Integer...indexes) {
		Integer sum = 0;
		Integer pivot = states.get(indexes[0]);
		for(int i=1;i<indexes.length;i++) {
		sum = sum + states.get(indexes[i]);
		}
		Double value = sigma(sum);
		
		
		
		
		return value;
	}

	private double sigma(Integer sum) {
		///System.out.println("Sum1:"+sum);
		double sum1 = sum%2;
		
		
		
		
		return sum1;
		//System.out.println("Sum11:"+sum1);
		//return sum1;
	}
	public static void main(String[] args){
		
		double a = 8%2.01;
		System.out.println("a:"+a);
		
	}
	
	
}
