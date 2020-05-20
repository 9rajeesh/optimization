package org.qc.superposition.waves;

public class Wave {
	
	private Double amplitude;
	private Double halfperiod;
	
	
	
	public Wave( Double amplitude,Double halfperiod){
		this.amplitude   =  amplitude;
		this.halfperiod  =  halfperiod;
		
	}
	
	
	
	
	public Integer evaluate(Double x){
		//Double value = Math.sin(x*2.0*Math.PI*(1.0 + (1.0/halfperiod)));
		//System.out.println("");
		//System.out.println("Sine Value is:"+value);
		Double value = getSquareWave(x);
		//System.out.println("Square Value is:"+value);
		
		if(value >=0.8){
		return 1;
		}
		else if(value < -0.8){
		return 0;
		}
	
		return 2;
	}
	
	
	public Double getSquareWave(Double x){
		
		Double sum = 0.0;
		for(Integer n=1;n<10;n=n+2){
		sum = sum + ((4/Math.PI)*(1.0/n)*Math.sin(n*Math.PI*x/((halfperiod+1)/halfperiod)));
		
		}
		//System.out.println("Square Value is:"+sum);
		return sum;
	}
	
}
