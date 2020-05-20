package org.supersymmetry.order.zero.model;

public class Literal implements Comparable<Literal>{

	private String literal;

	public Literal(String string) {
		this.literal=string;
	}

	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((literal == null) ? 0 : literal.hashCode());
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
		Literal other = (Literal) obj;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		return true;
	}

	@Override
	public int compareTo(Literal l) {
		if(this.literal!=null && l!=null) {
			
			Integer s1 = Integer.parseInt(this.literal.substring(1));
			Integer s2 = Integer.parseInt(l.getLiteral().substring(1));
			return s1.compareTo(s2);
		}
		
		return 0;
	}

	
	
	
	
	
}
