package org.qc.factorisation.superposition.test;

public class CombinedStateTest {

	
	static Long  base1 = 2L;
	static Long  base2 = 3L;
	
	public static void run1() {
		
		double x =1;
		double sum = 0;
		for(int i=0;i<10000;i++) {
		x=x+0.1;
		double value = squareWave(32,base1*base2*x)*squareWave(32,2.0*2.0*x);
		sum = sum + value;
		System.out.println("value is:"+value);
		}
		System.out.println("Sum is:"+sum);
	}
	
	public static void run() {
		
		double x =1;
		double sum = 0;
		for(int i=0;i<1000;i++) {
		x=x+1;
		double value = Math.sin(base1*base2*x)*Math.sin(3.0*2.0*x);
		sum = sum + value;
		System.out.println("value is:"+value);
		}
		System.out.println("Sum is:"+sum);
	}
	
	  public static Integer squareWave(double period, double time){
			
	    	Double a = time/period;
			
	    	Long aInt = a.longValue();
			
	    	double v = a- (aInt);
	    	
			if(v>0 && v<0.5){
			return 1;
			}
			
			else if(v>0.5){
			return -1;
			}
			
			return 1;
		}
	  
	public static void main(String[] args) {
		run1();
		
	}
	
	
}



















