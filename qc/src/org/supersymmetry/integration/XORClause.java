package org.supersymmetry.integration;

import java.math.BigInteger;
import java.util.Map;

public class XORClause extends Clause {

	
	private String v1;
	private String v2;
	
	public XORClause(String v1,String v2){
		
		this.v1=v1;
		this.v2=v2;
		
	}
	
	public void setVariable(String variable, Integer value){
		
		if(v1.equals(variable)){
		v1 = value.toString();
		}
		
		if(v2.equals(variable)){
		v2 = value.toString();
		}
	}

	public String getV1() {
		return v1;
	}

	public void setV1(String v1) {
		this.v1 = v1;
	}

	public String getV2() {
		return v2;
	}

	public void setV2(String v2) {
		this.v2 = v2;
	}
	
	
	public String toString(){
		
		return this.v1+"-"+this.v2;
	}
	
	
	
	
	
	
	public BigInteger getValue( Map<String, String> variables){
		
		String a = variables.get(v1);
		String b = variables.get(v2);
		
		if(a==null || b==null){
		throw new IllegalStateException("Unassigned variable");
		}
		if(a.equalsIgnoreCase(b)){
			return new BigInteger("1");
		}
		else{
			return new BigInteger("2");
		}
		
	}
	
	public String doString(){
		return "[" + this.v1 + " xor " + this.v2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
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
		
		XORClause other = (XORClause) obj;
		
		if(this.v1.equals(other.v1) && this.v2.equals(other.v2)){
		return true;
		}
		
		else if(this.v1.equals(other.v2) && this.v2.equals(other.v1)){
		return true;
		}
		
		
		return false;
	}
	
	public BigInteger evaluate() {
		
		
		Integer a = XORClauseTableEvaluator.variableMap.get(this.v1);
		Integer b = XORClauseTableEvaluator.variableMap.get(this.v2);
		
		if(a==null || b==null){
		throw new RuntimeException("Unassigned value:");
		}
		
		if(a.equals(b)){
		return new BigInteger("0");
		}
		else{
		return new BigInteger("1");	
		}
			
	}

	
	
}
