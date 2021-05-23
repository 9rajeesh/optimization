package org.qc.boson.sampler.superposition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumAllPath {

	
	
	public static List<Double> factors = new ArrayList<>();
	
	public static Double sumAllPaths() {
		
		return factors
				.stream()
				.collect(Collectors.summingDouble(a->a));
	}
	
	
	
	 static void traverse(Node origin,Node end,Double factor) {
			
		
		for(Link link:origin.getLinks()) {
			
			if(link.getB().getName().equals(end.getName())) {
			factors.add(factor*link.getFactor());
			}
						
			else if(link.getB().getLinks().isEmpty()) {
				
			}
			
			else {
			traverse(link.getB(),end,factor*link.getFactor());
			}
		
		}
		
		
	}
	
	
	
	
	
	
	
	
}
