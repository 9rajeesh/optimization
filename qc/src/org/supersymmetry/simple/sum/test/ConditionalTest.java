package org.supersymmetry.simple.sum.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.supersymmetry.simple.sum.Conditional;
import org.supersymmetry.simple.sum.Utility;
import org.supersymmetry.simple.sum.Variable;

public class ConditionalTest {

	private static final Double _2PIBY3 = Math.PI * 2 / 3.0;

	@Test
	public void doTest1() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(2, 3, 0);
		System.out.println("Value is:" + value);
		assert (value .equals(new BigDecimal(24)));
	}

	@Test
	public void doTest12() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(2, 3, 0);
		System.out.println("Value is:" + value);
	assert (value .equals(new BigDecimal(24)));
	}

	@Test
	public void doTest2() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(3, 3, 0);
		System.out.println("Value is:" + value);
		
		assert (value .equals(new BigDecimal(54)));
	}

	@Test
	public void doTest3() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(4, 3, 0);
		System.out.println("Value is:" + value);

		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				for (int k = 0; k <= 1; k++) {
					sum = sum + Math.pow((i + j + k), 4);
				}
			}
		}
		System.out.println("Sum is:" + sum);
		assert (value.equals(new BigDecimal(sum)));

	}

	@Test
	public void doTest4() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(5, 4, 0);
		System.out.println("Value is:" + value);

		
		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				for (int k = 0; k <= 1; k++) {
					for (int l = 0; l <= 1; l++) {
						sum = sum + Math.pow((i + j + k + l), 5);
					}
				}
			}
		}
		System.out.println("Sum is:" + sum);
		assert (value.equals(new BigDecimal(sum)));

	}
	

	@Test
	public void doTestConditional_with_Set1() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(2, 3, 1);
		System.out.println("Value_0 is:" + value);

		
		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {

				sum = sum + Math.pow((1 + i + j), 2);
			}
		}

		System.out.println("Sum_0 is:" + sum);
		assert (value.equals(new BigDecimal(sum)));

	}

	@Test
	public void doTestConditional_with_Set2() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(2, 3, 1);
		System.out.println("Value_0 is:" + value);

		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {

				sum = sum + Math.pow((1 + i + j), 2);
			}
		}

		System.out.println("Sum_0 is:" + sum);
		assert (value.equals(new BigDecimal(sum)));

	}

	@Test
	public void doTestConditional_with_Set3() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(5, 3, 1);
		System.out.println("Value_0 is:" + value);

		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				sum = sum + Math.pow((1 + i + j), 5);

			}
		}

		System.out.println("Sum_0 is:" + sum);
		assert (value.equals(new BigDecimal(sum)));
	}

	@Test
	public void doTestConditional_with_Set4() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(5, 6, 3);
		System.out.println("Value_0 is:" + value);

		Double sum = 0.0;
		for (int k = 0; k <= 1; k++) {
			for (int i = 0; i <= 1; i++) {
				for (int j = 0; j <= 1; j++) {
					sum = sum + Math.pow((1 + 1 + 1 + i + j + k), 5);

				}
			}
		}

		System.out.println("Sum_0 is:" + sum);
		assert (value.equals(new BigDecimal(sum)));

	}
	
	@Test
	public void doTestConditional_with_Set4_0() {

		Conditional conditional = new Conditional(new ArrayList());
		BigDecimal value = conditional.raiseConditionalToPower(5, 3, 0);
		System.out.println("Value_0 is:" + value);

		Double sum = 0.0;
		for (int k = 0; k <= 1; k++) {
			for (int i = 0; i <= 1; i++) {
				for (int j = 0; j <= 1; j++) {
					sum = sum + Math.pow((0 + 0 + 0 + i + j + k), 5);

				}
			}
		}

		System.out.println("Sum_0 is:" + sum);
		assert (value.equals(new BigDecimal(sum)));

	}

	
	@Test
	public void doTestConditional_withSine1() {

		Variable va = new Variable("a");
		Variable vb = new Variable("b");
		Variable vc = new Variable("c");
		va.setValue(1);

		List<Variable> varibales = Arrays.asList(va, vb, vc);
		Conditional conditional = new Conditional(varibales);
		conditional.setPrecision(26);

		BigDecimal value = conditional.computeValue();
		System.out.println("Value compute1 is:" + value);

		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				sum = sum + computeSine((_2PIBY3) * (1 + i + j));
			}
		}

		System.out.println("Sum compute1 is:" + sum);
		assert diffIsZero(sum,value,0.000001);

	}
	

	
	@Test
	public void doTestConditional_withSine2() {

		Variable va = new Variable("a");
		Variable vb = new Variable("b");
		Variable vc = new Variable("c");

		List<Variable> varibales = Arrays.asList(va, vb, vc);
		Conditional condtional = new Conditional(varibales);
		condtional.setPrecision(26);

		BigDecimal value = condtional.computeValue();
		System.out.println("Value compute is:" + value);

		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				for (int k = 0; k <= 1; k++) {
					sum = sum + computeSine((_2PIBY3) * (i + j + k));
				}
			}
		}

		System.out.println("Sum compute is:" + sum);
		assert diffIsZero(sum,value,0.000001);


	}

	@Test
	public void doTestConditional_withSine3() {

		Variable va = new Variable("a");
		Variable vb = new Variable("b");
		Variable vc = new Variable("c");
		Variable vd = new Variable("d");
		va.setValue(1);
		vb.setValue(1);

		List<Variable> varibales = Arrays.asList(va, vb, vc, vd);
		Conditional condtional = new Conditional(varibales);
		condtional.setPrecision(26);

		BigDecimal value = condtional.computeValue();
		System.out.println("Value compute is:" + value);

		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {

				sum = sum + computeSine((_2PIBY3) * (1 + 1 + i + j));

			}
		}

		System.out.println("Sum compute is:" + sum);
		assert diffIsZero(sum,value,0.000001);


	}

	@Test
	public void doTestConditional_withSine4() {

		Variable va = new Variable("a");
		Variable vb = new Variable("b");
		Variable vc = new Variable("c");
		Variable vd = new Variable("d");
		va.setValue(1);

		List<Variable> varibales = Arrays.asList(va, vb, vc, vd);
		Conditional condtional = new Conditional(varibales);
		condtional.setPrecision(26);

		BigDecimal value = condtional.computeValue();
		System.out.println("Value compute is:" + value);

		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				for (int k = 0; k <= 1; k++) {
					sum = sum + computeSine((_2PIBY3) * (1 + k + i + j));

				}
			}
		}

		System.out.println("Sum compute is:" + sum);
		assert diffIsZero(sum,value,0.000001);


	}

	@Test
	public void doTestConditional_withSine5() {

		Variable va = new Variable("a");
		Variable vb = new Variable("b");
		Variable vc = new Variable("c");
		Variable vd = new Variable("d");
		Variable ve = new Variable("e");
		va.setValue(1);
		vb.setValue(1);

		List<Variable> varibales = Arrays.asList(va, vb, vc, vd, ve);
		Conditional condtional = new Conditional(varibales);
		condtional.setPrecision(26);

		BigDecimal value = condtional.computeValue();
		System.out.println("Value compute is:" + value);

		Double sum = 0.0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				for (int k = 0; k <= 1; k++) {
					sum = sum + computeSine((_2PIBY3) * (1 + 1 + i + j + k));

				}
			}
		}

		System.out.println("Sum compute is:" + sum);
		assert diffIsZero(sum,value,0.000001);


	}
   
	
	private boolean diffIsZero(Double sum, BigDecimal value,double d) {
		
		BigDecimal value2 = new BigDecimal(sum);
		BigDecimal diff = (value2.subtract(value)).multiply(value2.subtract(value));
		int diff_int= diff.compareTo(new BigDecimal(d));
		
		if(diff_int < 0){
		return true;
		}
		
		return false ;
	}
	public Double computeSine(Double v) {
		Double sum = 0.0;
		sum = v - (Math.pow(v, 3) / Utility.factorial_double(3))
				+ (Math.pow(v, 5) / Utility.factorial_double(5))
				- (Math.pow(v, 7) / Utility.factorial_double(7))
				+ (Math.pow(v, 9) / Utility.factorial_double(9))
				- (Math.pow(v, 11) / Utility.factorial_double(11))
				+ (Math.pow(v, 13) / Utility.factorial_double(13))
				- (Math.pow(v, 15) / Utility.factorial_double(15))
				+ (Math.pow(v, 17) / Utility.factorial_double(17))
				- (Math.pow(v, 19) / Utility.factorial_double(19))
				+ (Math.pow(v, 21) / Utility.factorial_double(21))
				- (Math.pow(v, 23) / Utility.factorial_double(23))
				+ (Math.pow(v, 25) / Utility.factorial_double(25));

		return sum;
	}

}
