package org.supersymmetry.order.zero.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Term {

	private Map<Literal,Integer> map = new TreeMap<Literal,Integer>();

	private Double factor = 1.0;
	
	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

	public Term(Term term2) {
		
		term2.getMap().forEach((k,v)->{
		Literal l = new Literal(k.getLiteral());
		Integer power = new Integer(v);
		map.put(l, power);
		});
	}

	public Term() {
	
	}

	public Map<Literal, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Literal, Integer> map) {
		this.map = map;
	}

	
	public String toString() {
		StringBuffer s = new StringBuffer("(");
		this.getMap().forEach((k,v)->{
			s.append(k.getLiteral()+"^"+v+"*");
		});
		String b =s.toString();
		
		if(b.endsWith("*")) {
		b=b.substring(0,b.length()-1);
		}
		b=b+")\n";
		return b;
	}
	
	
	
	
}
