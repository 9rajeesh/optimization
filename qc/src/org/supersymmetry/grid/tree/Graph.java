package org.supersymmetry.grid.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph {

	
	static List<Node> nodes = new ArrayList<Node>();
	static List<Node> workingList = new ArrayList<Node>();
	static Integer maxNodes = 1000;
	public static Integer maxLinks = 3;
	
	
	
	
	
	public static void main(String[] args){
		Graph Graph = new Graph();
		Graph.generate();
		System.out.println("Graph is:");
		nodes.forEach(node->System.out.println(node));
		
		
		NodeGrouper nodegrouper = new NodeGrouper();
		nodegrouper.doGroup();
	}
	
	
	
	public void generate(){
		
		generateNodes();
		linkNodesRandomly();
		
		
	}
	
	
	private void linkNodesRandomly() {
	
		outer: for(Node node:nodes){
			
			while(node.getLinks().size() < maxLinks){
			
			Node randomNode =null;
			
			  while(randomNode==null || !node.canLink(randomNode)){
			  randomNode = getRandomNodeFromWorkingList();
			  
			    if(workingList.size()==1 && workingList.contains(node)){
			    break outer;
			    }
			  
			    }
			
			node.linkTo(randomNode);
			removeNodesFromWorkingList();
			}
		}
	}


	public void generateNodes(){
	
		for(int i=0;i<maxNodes;i++){
			Node node = new Node("v"+i);
			nodes.add(node);
	  }
		
		for(Node node:nodes){
		workingList.add(node);
		}
	}
	
	public  Node getRandomNodeFromWorkingList(){
		
		double random = Math.random();
		Double randomIndexDouble = (Double)(random*workingList.size());
		Integer randomInt = randomIndexDouble.intValue();
		
		
		return workingList.get(randomInt);
	}
	
    public void removeNodesFromWorkingList(){
	
    	List<Node> newList = new ArrayList<Node>();
	    	
           for(Node node:workingList){
    		    		
    		if(node.getLinks().size() < maxLinks){
    		newList.add(node);
    		}
    	 }
        workingList = newList;
	}
	
}
