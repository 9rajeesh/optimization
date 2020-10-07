package org.qc.xor.sat.combined.single.polynomial;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XORSATMAX2 {

	
	 
	static Map<Integer,List<Term>> varMap = new HashMap<>();
	
	public static void generateVariables() {
	
		for(int i=1;i<20;i++) {
			varMap.put(i,SquareWaveGenerator.generateSquareWave(i));
		}
	
	
	}
	
	
	
	
	
	
	
}
