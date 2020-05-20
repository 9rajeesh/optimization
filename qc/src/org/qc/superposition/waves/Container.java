package org.qc.superposition.waves;

import java.util.HashSet;
import java.util.Set;

public class Container {

	static Double period1 = 1000.0;
	static Double period2 = 1001.0;
	static Long count = 0L;
	
	public static void main(String[] args){
		
		Wave wave10 = new Wave(1.0,period1);
		Wave wave11 = new Wave(1.0,period1/2);
		Wave wave12 = new Wave(1.0,period1/3);
		Wave wave13 = new Wave(1.0,period1/4);
		Wave wave14 = new Wave(1.0,period1/5);
		Wave wave15 = new Wave(1.0,period1/6);
		Wave wave16 = new Wave(1.0,period1/7);
		Wave wave17 = new Wave(1.0,period1/8);
		Wave wave18 = new Wave(1.0,period1/9);
		Wave wave19 = new Wave(1.0,period1/10);
		Wave wave191 = new Wave(1.0,period1/11);
		Wave wave192 = new Wave(1.0,period1/12);
		Wave wave193 = new Wave(1.0,period1/13);
		//Wave wave194 = new Wave(1.0,period1/14);
		//Wave wave195 = new Wave(1.0,period1/15);
		
				
		Wave wave20 = new Wave(1.0,period2);
		Wave wave21 = new Wave(1.0,period2/2);
		Wave wave22 = new Wave(1.0,period2/3);
		Wave wave23 = new Wave(1.0,period2/4);
		Wave wave24 = new Wave(1.0,period2/5);
		Wave wave25 = new Wave(1.0,period2/6);
		Wave wave26 = new Wave(1.0,period2/7);
		Wave wave27 = new Wave(1.0,period2/8);
		Wave wave28 = new Wave(1.0,period2/9);
		Wave wave29 = new Wave(1.0,period2/10);
		Wave wave291 = new Wave(1.0,period2/11);
		Wave wave292 = new Wave(1.0,period2/12);
		Wave wave293 = new Wave(1.0,period2/13);
		//Wave wave294 = new Wave(1.0,period2/14);
		//Wave wave295 = new Wave(1.0,period2/15);
		
		
		Set<String> set = new HashSet<String>();
		
		for(double x=0.5; x < 1000000.0; x = x + 1){
			String s = "";
			String s1 = "";
			String s2 = "";
			s =s + xor(wave10.evaluate(x),wave20.evaluate(x));
			s =s + xor(wave11.evaluate(x),wave21.evaluate(x));
			s =s + xor(wave12.evaluate(x),wave22.evaluate(x));
			s =s + xor(wave13.evaluate(x),wave23.evaluate(x));
			s =s + xor(wave14.evaluate(x),wave24.evaluate(x));
			s =s + xor(wave15.evaluate(x),wave25.evaluate(x));
			s =s + xor(wave16.evaluate(x),wave26.evaluate(x));
			s =s + xor(wave17.evaluate(x),wave27.evaluate(x));
			s =s + xor(wave18.evaluate(x),wave28.evaluate(x));
			s =s + xor(wave19.evaluate(x),wave29.evaluate(x));
			s =s + xor(wave191.evaluate(x),wave291.evaluate(x));
			s =s + xor(wave192.evaluate(x),wave292.evaluate(x));
			s =s + xor(wave193.evaluate(x),wave293.evaluate(x));
			//s =s + xor(wave194.evaluate(x),wave294.evaluate(x));
			//s =s + xor(wave195.evaluate(x),wave295.evaluate(x));
			//System.out.println("A:"+s);			
			
			/*s1 =s1 + wave10.evaluate(x);
			s1 =s1 + wave11.evaluate(x);
			s1 =s1 + wave12.evaluate(x);
			s1 =s1 + wave13.evaluate(x);
			s1 =s1 + wave14.evaluate(x);
			
			s1 =s1 + wave15.evaluate(x);
			s1 =s1 + wave16.evaluate(x);
			s1 =s1 + wave17.evaluate(x);
			s1 =s1 + wave18.evaluate(x);
			s1 =s1 + wave19.evaluate(x);
			
			s1 =s1 + wave191.evaluate(x);
			s1 =s1 + wave192.evaluate(x);
			s1 =s1 + wave193.evaluate(x);
			
			
			s2 =s2 + wave20.evaluate(x);
			s2 =s2 + wave21.evaluate(x);
			s2 =s2 + wave22.evaluate(x);
			s2 =s2 + wave23.evaluate(x);
			s2 =s2 + wave24.evaluate(x);
			
			s2 =s2 + wave25.evaluate(x);
			s2 =s2 + wave26.evaluate(x);
			s2 =s2 + wave27.evaluate(x);
			s2 =s2 + wave28.evaluate(x);
			s2 =s2 + wave29.evaluate(x);
			
			s2 =s2 + wave291.evaluate(x);
			s2 =s2 + wave292.evaluate(x);
			s2 =s2 + wave293.evaluate(x);
			
			System.out.println("A:"+s1);		
			System.out.println("B:"+s2);
			*/
			if(!s.contains("2")){
			set.add(s);
			}
			
			if(count %1000 ==0){
			System.out.println("At count:"+count + " Size is:"+set.size());			
			}
			count++;
		}
		set.forEach(s->System.out.println(s));
		System.out.println("Size is:"+set.size());
		
	}

	private static String xor(Integer evaluate, Integer evaluate2) {
	
		if(evaluate.equals(evaluate2)){
			return "0";
		}
		else{
			return "1";
		}
		
		
	}
}
