package org.qc.superposition.waves;

import org.junit.Test;

public class HarmonicGeneratorTest {

	
	
	
	@Test
	public void dotest1() {
		
		HarmonicGenerator harmonicGenerator = new HarmonicGenerator();
		Double value = harmonicGenerator.computeHarmonic(Math.cos(Math.PI/6), 3);
		System.out.println("Value is:"+value);
		
		
		
		assert(Math.abs(value - Math.cos(3*Math.PI/6))<0.000001);
	}
	
	@Test
	public void dotest2() {
		
		HarmonicGenerator harmonicGenerator = new HarmonicGenerator();
		Double value = harmonicGenerator.computeHarmonic(Math.cos(Math.PI/6), 4);
		System.out.println("Value is:"+value);
		
		
		
		assert(Math.abs(value - Math.cos(4*Math.PI/6))<0.000001);
	}
	
	@Test
	public void dotest3() {
		
		HarmonicGenerator harmonicGenerator = new HarmonicGenerator();
		Double value = harmonicGenerator.computeHarmonic(Math.cos(Math.PI/3), 3);
		System.out.println("Value is:"+value);
		
		
		
		assert(Math.abs(value - Math.cos(3*Math.PI/3))<0.000001);
	}
	
	
	@Test
	public void dotest4() {
		
		HarmonicGenerator harmonicGenerator = new HarmonicGenerator();
		Double value = harmonicGenerator.computeHarmonic(Math.cos(Math.PI/8), 3);
		System.out.println("Value is:"+value);
		
		
		
		assert(Math.abs(value - Math.cos(3*Math.PI/8))<0.000001);
	}
	
	
	@Test
	public void dotest5() {
		
		HarmonicGenerator harmonicGenerator = new HarmonicGenerator();
		Double value = harmonicGenerator.computeHarmonic(Math.cos(Math.PI/5), 10);
		System.out.println("Value is:"+value);
		
		
		
		assert(Math.abs(value - Math.cos(10*Math.PI/5))<0.000001);
	}
}
