package org.qc.boson.sampler.superposition;

public class Link {

	private Double factor;
	private Node a;
	private Node b;
	
	public Link(Node a,Node b,Double factor ) {
		
		this.factor =factor;
		this.a = a;
		this.b = b;
		
		
	}

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

	public Node getA() {
		return a;
	}

	public void setA(Node a) {
		this.a = a;
	}

	public Node getB() {
		return b;
	}

	public void setB(Node b) {
		this.b = b;
	}
	
	
	
	
	
	
	
	
}
