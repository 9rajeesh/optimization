package org.supersymmetry.simple.sum.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.supersymmetry.simple.sum.Conditional;
import org.supersymmetry.simple.sum.SST;

public class SSTTest {

	@Test
	public void dotest(){
		
		SST a = new SST(1.0,3,1);
		SST b = new SST(1.0,3,1);
			
		List<SST> ssts = SST.multiplyWithUnitSST(a, b);
		BigDecimal value = SST.evaluate(ssts);
		 System.out.println("Value is:"+value);
		assert(value.equals(new BigDecimal(24)));
		
	}
	
	
	@Test
	public void dotest1(){
		
		SST a = new SST(1.0,3,2);
		SST b = new SST(1.0,3,1);
			
		List<SST> ssts = SST.multiplyWithUnitSST(a, b);
		BigDecimal value = SST.evaluate(ssts);
		 System.out.println("Value is:"+value);
		assert(value.equals(new BigDecimal(15)));
		
	}
	
	
	@Test
	public void dotest2(){
		
		SST a = new SST(1.0,4,2);
		SST b = new SST(1.0,4,1);
			
		List<SST> ssts = SST.multiplyWithUnitSST(a, b);
		BigDecimal value = SST.evaluate(ssts);
		 System.out.println("Value is:"+value);
		
		assert(value.equals(new BigDecimal(72)));
	}
	
	@Test
	public void dotest3(){
		
		SST a = new SST(1.0,4,3);
		SST b = new SST(1.0,4,1);
			
		List<SST> ssts = SST.multiplyWithUnitSST(a, b);
		BigDecimal value = SST.evaluate(ssts);
		 System.out.println("Value is:"+value);
	
		assert(value.equals(new BigDecimal(28)));
	}
	
	@Test
	public void dotest4(){
		
		SST a = new SST(1.0,3,3);
		SST b = new SST(1.0,3,1);
			
		List<SST> ssts = SST.multiplyWithUnitSST(a, b);
		BigDecimal value = SST.evaluate(ssts);
		System.out.println("Value is:"+value);
		
		assert(value.equals(new BigDecimal(3)));
	}
	
	
	
}
