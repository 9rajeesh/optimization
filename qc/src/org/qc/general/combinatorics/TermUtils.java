package org.qc.general.combinatorics;

import java.util.List;

public class TermUtils {

	
	public static Double evaluateSum_XYAB(int index) {
		Double sum = 0.0;
		sum =sum+ TermHandler.evaluate(TermHandler.XYABMap.get(index));
		
		
		return sum;
	}
	
	public static Double evaluateSum_PAB(int index) {
		
		Double sum = 0.0;
		sum =sum+ TermHandler.evaluate(TermHandler.PABMap.get(index));
		
		
		return sum;
	}
	
	public static Double evaluateCombinedSum_XYAB(int index) {
		Double sum = 0.0;
		
		for(int i=0;i<=index;i++) {
		sum =sum+ TermHandler.evaluate(TermHandler.XYABMap.get(i));
		}
		
		return sum;
	}
	
	public static Double evaluateCombinedSum_PAB(int index) {
		Double sum = 0.0;
		
		for(int i=0;i<=index;i++) {
		sum =sum+ TermHandler.evaluate(TermHandler.PABMap.get(i));
		}
		
		return sum;
	}
	
	
	
}
