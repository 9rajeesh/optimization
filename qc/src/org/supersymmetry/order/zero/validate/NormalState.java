package org.supersymmetry.order.zero.validate;

public class NormalState extends State{

	public NormalState(String a) {
		super(a);
	
	}

	
	public double sigma(Integer sum) {
		///System.out.println("Sum1:"+sum);
		Double sum1 = (double) (sum%2);
		if(sum1.equals(0)){
			return -1.0;
		}
		
		if(sum1.equals(1)){
			return 1.0;
		}
		return sum1;
		
		//return sum1;
		//System.out.println("Sum11:"+sum1);
		//return sum1;
	}
}
