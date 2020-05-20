package org.supersymmetry.simple.sum.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.supersymmetry.simple.sum.Conditional;
import org.supersymmetry.simple.sum.Variable;

import junit.framework.Assert;

 public class PInstanceTest {

	@Test
	public void doTest(){
		
		Variable va = new Variable("a");
		Variable vb = new Variable("b");
		Variable vc = new Variable("c");
		Variable vd = new Variable("d");
		Variable ve = new Variable("e");
		Variable vf = new Variable("f");
		Variable vg = new Variable("g");
		Variable vh = new Variable("h");
		Variable vi = new Variable("i");
		Variable vj = new Variable("j");
		Variable vk = new Variable("k");
		
		Variable vl = new Variable("l");
		
		List<Variable> varibales = Arrays.asList(va, vb, vc);
		
		va.setValue(0);
			
		Conditional conditional = new Conditional(varibales);
		conditional.setPivotVariable(va);
		conditional.setTotalVariables(4);
		conditional.setPrecision(100);

		BigDecimal value0 = conditional.computeTotalValue();
		
		va.setValue(1);
		
		

		BigDecimal value1 = conditional.computeTotalValue();
		
		System.out.println("Value 0 is:"+value0);
		System.out.println("Value 1 is:"+value1);
		
		
		
	}
	
	
	
}
	
	

