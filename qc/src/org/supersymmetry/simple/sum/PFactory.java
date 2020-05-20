package org.supersymmetry.simple.sum;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PFactory {

	
	
	public static Conditional createConditional(Variable...variables){
		
	  List<Variable> variableList = new ArrayList<Variable>();
	  Arrays.asList(variables)
	  .stream()
	  .forEach(variable->{
		variableList.add(variable);
	   });
	
	  Conditional conditional = new Conditional(variableList);
	 return conditional;
	}
	
	public static PInstance createPIntance(Conditional...condtionals){
		PInstance pInstance = new PInstance(Arrays.asList(condtionals));
		return pInstance;
	}
	
	@Test
	public   void create(){
		
		Variable v1 = new Variable("v1");
		Variable v2 = new Variable("v2");
		Variable v3 = new Variable("v3");
		Variable v4 = new Variable("v4");
		
		Variable v5 = new Variable("v5");
		Variable v6 = new Variable("v6");
		Variable v7 = new Variable("v7");
		Variable v8 = new Variable("v8");
		
		Variable v9 = new Variable("v9");
		Variable v10 = new Variable("v10");
		Variable v11 = new Variable("v11");
		Variable v12 = new Variable("v12");
		
		Variable v13 = new Variable("v13");
		Variable v14 = new Variable("v14");
		Variable v15 = new Variable("v15");
		Variable v16 = new Variable("v16");
		
		Variable v17 = new Variable("v17");
		Variable v18 = new Variable("v18");
		Variable v19 = new Variable("v19");
		
		
		
		Conditional a1 =  createConditional(v1,v2,v4,v6,v8, v10,v11,v13,v15,v19, v5);
		Conditional b1 =  createConditional(v1,v2,v3,v4,v6, v10,v12,v15,v18,v19, v8);
		Conditional c1 =  createConditional(v1,v2,v3,v5,v8, v11,v12,v14,v15,v16, v4);
		Conditional d1 =  createConditional(v4,v5,v6,v9,v10,v11,v12,v14,v18,v19, v13);
		
		Conditional e1 =  createConditional(v1,v2,v3,v5,v6, v7,v9,v10,v13,v14, v4);
		Conditional f1 =  createConditional(v4,v6,v7,v8,v9, v10,v11,v12,v14,v15, v13);
		Conditional g1 =  createConditional(v1,v2,v3,v4,v6, v8,v9,v10,v11,v14, v12);
		Conditional h1 =  createConditional(v1,v2,v4,v5,v9, v10,v11,v12,v15,v17, v19);
		
		Conditional i1 =  createConditional(v1,v3,v5,v6,v7,  v8,v9,v10,v11,v12, v13);
		Conditional j1 =  createConditional(v1,v2,v3,v8,v7,  v11,v10,v12,v14,v18, v9);
		Conditional k1 =  createConditional(v1,v2,v5,v9,v10, v11,v12,v13,v14,v15, v3);
		Conditional l1 =  createConditional(v5,v6,v7,v9,v10, v12,v13,v15,v18,v19, v11);
		
		Conditional m1 =  createConditional(v3,v6,v8,v10,v13, v15,v16,v17,v18,v19, v5);
		Conditional n1 =  createConditional(v1,v5,v8,v9,v10,  v11,v13,v15,v18,v19, v12);
		Conditional o1 =  createConditional(v1,v4,v5,v7,v8, v10,v11,v12,v15,v19, v9);
		Conditional p1 =  createConditional(v2,v4,v5,v9,v10, v11,v13,v14,v18,v19, v12);
		
		Conditional q1 =  createConditional(v4,v5,v7,v8,v9, v10,v13,v15,v18,v19, v11);
		Conditional r1 =  createConditional(v3,v6,v9,v10,v11, v12,v13,v14,v15,v16, v17);
		Conditional s1 =  createConditional(v1,v2,v3,v5,v9, v10,v11,v12,v13,v14, v4);
		Conditional t1 =  createConditional(v1,v2,v4,v5,v6, v9,v10,v11,v12,v14, v13);
		
		
		Conditional.setPrecision(80);
		Conditional.setMathContext(new MathContext(50,RoundingMode.DOWN));
		
		
		PInstance pInstance = createPIntance(a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,k1,l1,m1,n1,o1,p1,q1,r1,s1,t1);
		//PInstance pInstance = createPIntance(a1,b1,c1,d1,e1,f1,g1,h1);
		pInstance.setVariables(Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,
				                             v12,v13,v14,v15,v16,v17,v18,v19));
		
		pInstance.compute_Values();
		
		pInstance.getVariables().forEach(variable->{
			System.out.println("Variable Name:"+variable.getName()+ "Variable value:"+variable.getValue());
		});
		
		
		
		
	}
	
	public static void main(String[] args){
	//	create();
	}
}
