package org.supersymmetry.grid.tree;

import java.util.Map;

public class Edge {

	private String a;
	private String b;
	
	
	
	
	public Edge(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
        Edge e = (Edge)obj;
		
		if(this.a.equals(e.a) && this.b.equals(e.b)){
			return true;
		}
	
		if(this.a.equals(e.b) && this.b.equals(e.a)){
			return true;
		}
		
		return false;
	}



	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}



	public Integer evaluate(Map<String, Integer> valueMap) {
	
		
		Integer v1 = valueMap.get(this.a);
		Integer v2 = valueMap.get(this.b);
		
		if(v1.equals(0) && v2.equals(1)){
		return 1;
		}
		
		else if(v1.equals(1) && v2.equals(0)){
		return 1;
		}
		
		
		return 0;
	}
	
	
	
	
	
}
