package org.factorisation;

public class Test {

	
	
	public static void main(String[] args){
		double a = 0.32154648;
		double delta = 0.001;
		for(int i=0;i<1000;i++){
		a = a+delta;
		double a1 = 0.88*a;
		
		System.out.println("A is:"+a);
		System.out.println("B is:"+a1);
		
		System.out.println("Diff is:"+(a-a1));
			
		}
	}
}
