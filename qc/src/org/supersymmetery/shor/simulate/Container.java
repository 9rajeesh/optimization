package org.supersymmetery.shor.simulate;

public class Container {

	static Integer product = 6;
	static Integer a= 3;
	static Integer b = 2;
    
	static Integer a1= 2;
	static Integer b1 = 2;
	
	public static void main(String[] args){
		simulate1();
		
	}
	
	private static void simulate1() {
		// TODO Auto-generated method stub
		// TODO 
	}

	public static void simulate(){
		
     double x=0.0;
	 
     for(int k=-30;k<30;k++){  
     
     Double sum=0.0;
     x=0.0;
	 for(int i=1;i<1000;i++){
			Double p = Math.sin(2*Math.PI*6*x);
			Double p1 =Math.sin(2*Math.PI*6*x - k*0.1);
			sum =sum+p*p1;
			x=x+0.001;
		  }
	 
	 System.out.println("Sum at "+k+"is:"+sum);
	 	}
	}
	}
	
	

