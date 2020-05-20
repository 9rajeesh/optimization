package org.qc.superposition.waves;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Container4 {

	static Double period1 = 1000000.0;
	static Double period2 = 1000001.0;
	static Long count = 0L;
	static Integer size = 22;
	static List<Wave> waves1= new ArrayList<Wave>();
	static List<Wave> waves2= new ArrayList<Wave>();
	
	public static void main(String[] args){
		
		
		for(int i=1;i<=size;i++){
		waves1.add(new Wave(1.0,period1/i));
		}
		
		for(int i=1;i<=size;i++){
		waves2.add(new Wave(1.0,period2/i));
		}
		
				
		Set<String> set = new HashSet<String>();
		
		while(count <1000000){
			String s = "";
			String s1 = "";
			String s2 = "";
			
		   Double x  = Math.random()*1000000000000.0 + 0.5;
			 
			for(int i=0;i<size;i++){
			s =s + xor(waves1.get(i).evaluate(x),waves2.get(i).evaluate(x));	
			}
			
			if(!s.contains("2")){
			set.add(s);
			}
			
			if(count %1000 ==0){
			System.out.println("At count:"+count + " Size is:"+set.size());
			}
			
			count++;
			
		}
		//set.forEach(s->System.out.println(s));
		System.out.println("Size is:"+set.size());
		
	}

	private static String xor(Integer evaluate, Integer evaluate2) {
	
		if(evaluate.equals(evaluate2)){
			return "0";
		}
		else{
			return "1";
		}
		
		
	}
}
