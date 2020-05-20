package org.supersymmetry.grid.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GridRow {
	
	private String variable;
	
	private List<SAT> clauses = new ArrayList<SAT>();
	
	public Integer evaluate(Map valueMap){
		
		for(SAT sat:clauses){
			if(sat.evaluate(valueMap).equals(0)){
			return 0;
			}
		}
		return 1;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public List<SAT> getClauses() {
		return clauses;
	}

	public void setClauses(List<SAT> clauses) {
		this.clauses = clauses;
	}
	
	
	
	
}
