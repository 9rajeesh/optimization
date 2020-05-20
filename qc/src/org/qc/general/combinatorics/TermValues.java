package org.qc.general.combinatorics;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**xyab
 * 
 */
public class TermValues {
	
	static BigInteger pointer = new BigInteger("0");
	static Map<String,Integer> valueMap = new HashMap<String,Integer>();

	public static Map<String,Integer> getValueMap() {
		return valueMap;
	}

	public static void setValueMap(Map<String,Integer> valueMap) {
		TermValues.valueMap = valueMap;
	}
	
     public static void setXY(Integer x,Integer y) {
		
    	 String xString =  padZeroes(x.toBinaryString(x),TermHandler.getCount());
    	 String yString =  padZeroes(x.toBinaryString(y),TermHandler.getCount());
    	 
		for(int i=0,j=TermHandler.getCount()-1;i<TermHandler.getCount();i++,j--) {
			///valueMap.put("a"+i, 0);
			////valueMap.put("b"+i, 0);
			valueMap.put("x"+j, Integer.parseInt(String.valueOf(xString.charAt(i))));
			valueMap.put("y"+j, Integer.parseInt(String.valueOf(yString.charAt(i))));
		}
			
	}
	
	private  static String padZeroes(String binaryString, Integer count) {
		
		String s = binaryString;
		while(binaryString.length()<count) {
			binaryString = "0"+binaryString;
		}
		
		return binaryString;
	}

	public static void initialize() {
		
		for(int i=0;i<TermHandler.getCount();i++) {
			valueMap.put("a"+i, 1);
			valueMap.put("b"+i, 1);
			valueMap.put("x"+i, 1);
			valueMap.put("y"+i, 1);
		}
			
	}

	 public static void setAB(Integer a,Integer b) {
		
    	 String aString =  padZeroes(a.toBinaryString(a),TermHandler.getCount());
    	 String bString =  padZeroes(b.toBinaryString(b),TermHandler.getCount());
    	 
		for(int i=0,j=TermHandler.getCount()-1;i<TermHandler.getCount();i++,j--) {
			///valueMap.put("a"+i, 0);
			////valueMap.put("b"+i, 0);
			valueMap.put("a"+j, Integer.parseInt(String.valueOf(aString.charAt(i))));
			valueMap.put("b"+j, Integer.parseInt(String.valueOf(bString.charAt(i))));
		}
			
	}
    
	
}
