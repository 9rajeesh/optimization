package org.supersymmetry.integration;

public class CNF3 {

	private String a1;
	private String a2;
	private String a3;
	
	public CNF3(String a, String b, String c){
		
		this.a1=a;
		this.a2=b;
		this.a3=c;
	}
	
	
	public Integer evaluate(){
			
		Integer a = getValue(a1);
		Integer b = getValue(a2);
		Integer c = getValue(a3);
		
		if(a.equals(new Integer(1)) || b.equals(new Integer(1)) 
				|| c.equals(new Integer(1))){
			return 1;
		}
		
		else{
			return 0;
		}
		
		
	}


	private Integer getValue(String a) {
		
		if(a.contains("-")){
		a = a.replaceAll("-", "");
		Integer value = CNF3TableEvaluator.variableMap.get(a);
		value = flip(value);
		return value;
		}
		Integer value = CNF3TableEvaluator.variableMap.get(a);
		return value;
	}


	private Integer flip(Integer value) {
		if(value.equals(new Integer(0))){
			return 1;
		}
		
		else if(value.equals(new Integer(1))){
			return 0;
		}
		
		
		return null;
	}


	public String getA1() {
		return a1;
	}


	public void setA1(String a1) {
		this.a1 = a1;
	}


	public String getA2() {
		return a2;
	}


	public void setA2(String a2) {
		this.a2 = a2;
	}


	public String getA3() {
		return a3;
	}


	public void setA3(String a3) {
		this.a3 = a3;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a1 == null) ? 0 : a1.hashCode());
		result = prime * result + ((a2 == null) ? 0 : a2.hashCode());
		result = prime * result + ((a3 == null) ? 0 : a3.hashCode());
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
		CNF3 other = (CNF3) obj;
		if (a1 == null) {
			if (other.a1 != null)
				return false;
		} else if (!a1.equals(other.a1))
			return false;
		if (a2 == null) {
			if (other.a2 != null)
				return false;
		} else if (!a2.equals(other.a2))
			return false;
		if (a3 == null) {
			if (other.a3 != null)
				return false;
		} else if (!a3.equals(other.a3))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CNF3 [a1=" + a1 + ", a2=" + a2 + ", a3=" + a3 + "]";
	}
	
	
}
