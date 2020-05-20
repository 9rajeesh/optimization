package org.supersymmetry.grid.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grid {

	 static List<GridRow> gridrows = new ArrayList<GridRow>();
	 static Map <String,Integer> valueMap = new HashMap<String,Integer>();
	
	public static void main(String[] args) throws IOException{
		
		//GridFactory.generate();
		SAT3Reader.create();
		Grid Grid = new Grid();
		Grid.iterate(0);
				
		
		System.out.println("Map is:"+valueMap);
		
		Integer sum = 0;
		for(SAT3 sat3:SAT3Reader.sat3list){
		sum = sum  + sat3.evaluate(valueMap);
		}
		
		System.out.println("Sum is:"+sum);
		
		
	}
	public void iterate(Integer index){
		
		System.out.println("Entering iterate with index:"+index);
		Integer lastIndex = getLastItem();
		Integer currentIndex = lastIndex; 
		setEverythingBelowIndexToOne(index);
		
		while (lastIndex >= index && currentIndex>=0) {
			Integer value = evaluate(currentIndex);

			if (changed(currentIndex,value)) {
              setChangedValue(value,currentIndex);	
			  
			   if(lastIndex > index && currentIndex > index &&  currentIndex < getLastItem()){
			   iterate(currentIndex+1);
			   }
			   			  
			}
						
			currentIndex = currentIndex - 1;
			
			if(currentIndex < index){
				return;
				}
			
		}
		
		System.out.println("Exiting iterate with index:"+index);
	}


	


	private void setChangedValue(Integer value, Integer currentIndex) {
		String variable = gridrows.get(currentIndex).getVariable();
		valueMap.put(variable,value);
	}





	private boolean changed(Integer currentIndex, Integer value) {
		String variable = gridrows.get(currentIndex).getVariable();
		
		if(valueMap.get(variable).equals(value)){
		System.out.println("Not changed");
		return false;	
		}
		System.out.println("changed");
		return true;
	}





	private Integer evaluate(Integer currentIndex) {
	      return gridrows.get(currentIndex).evaluate(valueMap);
	}





	private Integer getLastItem() {
	
		return gridrows.size()-1;
	}





	private void setEverythingBelowIndexToOne(Integer index) {
		
		int size = gridrows.size();
		for(int i=index;i<size ;i++){
			String variable = gridrows.get(i).getVariable();
		    valueMap.put(variable,1);
		  
		}
	}
	
	
	
}
