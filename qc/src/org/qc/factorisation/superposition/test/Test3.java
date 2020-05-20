package org.qc.factorisation.superposition.test;

public class Test3 {

	private static int getDigitAtPositionAfterPoint(Long p1, int i) {
		
		String a = p1.toString();
		Integer a1 = Integer.parseInt(String.valueOf(a.charAt(a.length()-i)));
		return a1;
	}
	
	public static void main(String[] args) {
		int a = getDigitAtPositionAfterPoint(12345645L,3);
		System.out.println("A is:"+a);
	}
}
