package org.supersymmetry.grid.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Iterator {

	
	static List<Edge> edges = new ArrayList<Edge>();
	static Long sum0 = 0L;
	static Long sum1 = 0L;
	
	
	private Integer MaxLength = 20;
	

	public void check(Long start,Long end,Integer checkbit){
		
		sum0 = 0L;
		sum1 = 0L;
		
		Integer max = 0;
		
		for(Long index = start;index<end;index++){
			
			String s = lpad(Long.toBinaryString(index),MaxLength);
			
			Map<String,Integer> valueMap = createMap(s);
			
			Integer sum = 0;
			for(Edge edge:edges){
			sum = sum + edge.evaluate(valueMap)	;
			}
			
			if(sum > max){
			max = sum;
			}
			
			//System.out.println("At: "+s + " Value is:"+sum);
			
			if(s.charAt(checkbit)=='0'){
			sum0 = sum0 + new Double(Math.pow(sum+0.0,3)).longValue();	
			}
			
			if(s.charAt(checkbit)=='1'){
			sum1 = sum1 + new Double(Math.pow(sum+0.0,3)).longValue();
			}
			
			
		}
		System.out.println("Max is:"+max);
		System.out.println("sum0:"+sum0);
		System.out.println("sum1:"+sum1);
		
		
	}

	private Map<String,Integer> createMap(String s) {
	
		Map<String,Integer> valueMap = new HashMap<String,Integer>();
        char[] c =  s.toCharArray();	
		for(int i=0;i<c.length;i++){
			
			Integer a = 0;
			
			if(c[i]=='0'){
			a=0;
			}
			
			else if(c[i]=='1'){
			a=1;
			}
			
			valueMap.put("v"+i, a);
			
		}
		
		return valueMap;
	}

	private String lpad(String binaryString, Integer maxLength2) {


		while(binaryString.length()<maxLength2){
		binaryString = "0"+binaryString;
		}
		
		
		return binaryString;
	}
	
	public void createEdges(){
		
		for(Node node:Graph.nodes){
			
			for(int i=0;i<node.getLinks().size();i++){
		      Edge edge = new Edge(node.getName(),node.getLinks().get(i));
		      edges .add(edge);
		    }
		 }
	  }
	
	public static void main(String[] args){
		Graph Graph = new Graph();
		Graph.generate();
		
		
		System.out.println("Graph is:");
		
		
		
		Iterator Iterator = new Iterator();
		Iterator.createEdges();
		
		Long start = 0L;
		Long end = 1024L*1024L;
		Integer index = 0;
		
		while(index<20){
		Iterator.check(start, end, index);
		
		if(Math.abs(sum0) >Math.abs(sum1)){
			end = end - ((end-start)/2);
			
		}
		
		else{
			start =start + ((end-start)/2);
		}
		index =index+ 1;
		}
		
		
		
	}
	
}
