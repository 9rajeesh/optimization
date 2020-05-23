package org.qc.superposition.waves;

public class ComplexNumber {

		
	private Double real;
	private Double img;
	
	public ComplexNumber(Double real,Double img) {
	
		this.real = real;
		this.img=img;
		
	}
	
	
	public static ComplexNumber add (ComplexNumber c1,ComplexNumber c2) {
		
		return new ComplexNumber(c1.real+c2.real,c1.img+c2.img);
		
	}
	
      public static ComplexNumber multiply (ComplexNumber c1,ComplexNumber c2) {
		
		return new ComplexNumber(c1.real*c2.real - c1.img*c2.img,
				                 c1.img*c2.real + c1.real*c2.img);
		
	}


	public Double getReal() {
		return real;
	}


	public void setReal(Double real) {
		this.real = real;
	}


	public Double getImg() {
		return img;
	}


	public void setImg(Double img) {
		this.img = img;
	}
	
	
	
	
	
	
	
	
}
