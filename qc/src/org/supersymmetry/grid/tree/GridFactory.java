package org.supersymmetry.grid.tree;

import java.util.List;

public class GridFactory {

	
	public static void generate(){
		
		
		GridRow GridRow1 = new GridRow();
		GridRow1.getClauses().add(new SAT3("a","b","-c"));
		GridRow1.getClauses().add(new SAT3("-a","-b","c"));
		
		GridRow1.setVariable("a");
		
		
		GridRow GridRow2 = new GridRow();
		GridRow2.getClauses().add(new SAT3("a","b","-c"));
		GridRow2.getClauses().add(new SAT3("-a","-b","c"));
		GridRow2.setVariable("b");
		
		GridRow GridRow3 = new GridRow();
		GridRow3.getClauses().add(new SAT3("a","b","-c"));
		GridRow3.getClauses().add(new SAT3("-a","-b","c"));
		GridRow3.setVariable("c");
		
		Grid.gridrows.add(GridRow1);
		Grid.gridrows.add(GridRow1);
		Grid.gridrows.add(GridRow1);
		
		Grid.valueMap.put("a", 1);
		Grid.valueMap.put("b", 1);
		Grid.valueMap.put("c", 1);
		
			
	}
}
