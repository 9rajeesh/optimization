package org.supersymmetry.integration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XORClauseValidator {

	static int maxsize = 0;
	static List<XORClause> restsubset = new ArrayList<XORClause>();
	static Set<String> pad = new HashSet<String>();
	
	public static void verify() throws Exception{
		
		for(XORClause clause:XORClauseGenerator.subset){
		restsubset.add(clause);
		}
		
		for(XORClause clause:XORClauseGenerator.subset){
			
			if(!XORClauseGenerator.xorcluses.contains(clause)){
				throw new Exception ("Invalid clause");
			}
			
			
			pad.add(clause.getV1());
			pad.add(clause.getV2());
			restsubset.remove(clause);
			
			if(!isPresentinRestClauses(clause.getV1())){
			pad.remove(clause.getV1());	
			}
			
			if(!isPresentinRestClauses(clause.getV2())){
			pad.remove(clause.getV2());	
			}
			
			if(pad.size() > maxsize){
				maxsize = pad.size();
			}
			
		}
		
		
	}

	private static boolean isPresentinRestClauses(String v1) {

		for (XORClause clause : restsubset) {
			if (clause.getV1().equals(v1)) {
			return true;
			}

			if (clause.getV2().equals(v1)) {
			return true;
			}
		}
		return false;
	}
	
}
