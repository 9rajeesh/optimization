package org.supersymmetry.order.zero.validate;

public class FMState extends State {

	public FMState(String a) {
		super(a);
		
	}
	
	public double sigma(Integer sum) {
		
		return sum%1.5;
		
	}
	
	public static void main(String[] args){
		System.out.println("A is:"+3%1.5);
		
	}
	
	/*
	public double sigma(Integer sum) {
		///System.out.println("Sum1:"+sum);
	
	if(sum.equals(0)){
	return 0;
	}
	else if(sum.equals(1)){
	return 1;
	}
	
	else if(sum.equals(2)){
	return 0.00000001;
	}
	else if(sum.equals(3)){
	return 1.00000001;
	}
		
	
	else if(sum.equals(4)){
	return 0.00000002;
	}
	else if(sum.equals(5)){
	return 1.00000002;
	}
		
	else if(sum.equals(6)){
	return 0.00000003;
	}
	
	else if(sum.equals(7)){
	return 1.00000003;
	}
	
	else if(sum.equals(8)){
	return 0.00000004;
	}
	
		else if (sum.equals(9)) {
			return 1.00000004;
		} else if (sum.equals(10)) {
			return 0.00000005;
		}

		else if (sum.equals(11)) {
			return 1.00000005;
		}

		else if (sum.equals(12)) {
			return 0.00000006;
		}

		else if (sum.equals(13)) {
			return 1.00000006;
		}
	
	
		else if (sum.equals(14)) {
			return 0.00000007;
		} else if (sum.equals(15)) {
			return 1.00000007;
		}

		else if (sum.equals(16)) {
			return 0.00000008;
		}

		else if (sum.equals(17)) {
			return 1.00000008;
		}

		else if (sum.equals(18)) {
			return 0.00000009;
		}
	
		else if (sum.equals(19)) {
			return 1.00000009;
		}

		else if (sum.equals(20)) {
			return 0.0000001;
		}
	
	return 0;
	}
*/
	
	
	
}
