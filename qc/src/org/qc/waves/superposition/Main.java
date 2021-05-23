package org.qc.waves.superposition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	private static final double MAX = 100000.0;
	static Set<String> values = new HashSet<>();
	static List<Double> halfperiods = new ArrayList<>();
	static List<Double> points = new ArrayList<>();
	
	static void createPoints(){
		
		halfperiods.forEach(period->{
			
			for(Long i=0L;period*i<MAX;i++) {
			points.add(period*i);
			
			}
		});
		
	}
	
    static void calculate(){
		
    	
    	
    	points.forEach(point->{
    		StringBuffer s = new StringBuffer("");
    		halfperiods.forEach(period->{
    			s.append(computeAtPoint(point,period));
    		});
    		//System.out.println("At point "+point+" Value is:"+s);
    		values.add(s.toString());
			
		});
		
	}

	private static String computeAtPoint(Double point, Double period) {
		
		
		if(point.equals(new Double("0.0"))) {
			point = point + 0.1;
		}
		
		Double value = ((point-0.05)/period);
		
		Double floor = Math.floor(value);
		
		Integer index = floor.toString().indexOf(".");
		
		char c  = floor.toString().charAt(index-1);
		
		Integer a = new Integer(String.valueOf(c));
		
		if(a%2 == 0) {
		return "0";
		}
		
		if(a%2 == 1) {
		return "1";
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		
		halfperiods.add(2/3.0);
		halfperiods.add(2/5.0);
		halfperiods.add(2/7.0);
		halfperiods.add(2/9.0);
		halfperiods.add(2/11.0);
		halfperiods.add(2/13.0);
		halfperiods.add(2/15.0);
		halfperiods.add(2/17.0);
		createPoints();
		calculate();
		System.out.println(values.size());
	}
	
	
	
	
	
}
