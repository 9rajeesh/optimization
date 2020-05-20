package org.supersymmetry.grid.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NodeGrouper {

    
	static Set<Edge> edgeSet = new HashSet<Edge>();
    static Set<Edge> edgeSetadded = new HashSet<Edge>();
	static Integer maxVariableCount = 0;
	static Set<String> activeVariables1 = new HashSet<String>();
	
	public void doGroup(){
		
		createEdges();
		
		while(edgeSet.size()>0){
			
			setActiveVariables();
			
			Edge e = get2Match();
			
			if(e==null){
			e=get1Match();
			}
			
			if(e==null){
			e=getAny();
			}
			
			edgeSetadded.add(e);
			edgeSet.remove(e);
			
			if(activeVariables1.size() > maxVariableCount){
				maxVariableCount = activeVariables1.size();
			}
		}
		
		System.out.println("Maximum variables active:"+maxVariableCount);
		
		
	}
	
	
	
	public void createEdges(){
	
		for(Node node:Graph.nodes){
			
			for(int i=0;i<node.getLinks().size();i++){
		      Edge edge = new Edge(node.getName(),node.getLinks().get(i));
		      edgeSet.add(edge);
		    }
		 }
	  }
	
	public void setActiveVariables(){
		Set<String> activeVariables = new HashSet<String>();
		Set<String> variables = getAllVariablesinSet(edgeSetadded);
		Set<String> remainingVariables = getAllVariablesinSet(edgeSet);
		
		for(String variable:variables){
			
			if(remainingVariables.contains(variable)){
				activeVariables.add(variable);
			}
		}
		activeVariables1 = activeVariables;
	}
	
	private Set<String> getAllVariablesinSet(Set<Edge> edgeSetadded2) {
		
		Set<String> variables = new HashSet<String>();
		
		for(Edge edge:edgeSetadded2){
			variables.add(edge.getA());
			variables.add(edge.getB());
		}
		return variables;
	}

	public Edge get2Match(){
		
		List<Edge> elist = new ArrayList<Edge>();
		for(Edge edge:edgeSet){
			if(activeVariables1.contains(edge.getA()) && 
				activeVariables1.contains(edge.getB())){
				System.out.println("2 edge");
					elist.add(edge);
				}
			}
		
		return getBestEdge(elist);
		
		
		}
		
			
	
	
   private Edge getBestEdge(List<Edge> elist) {
		
	   if(elist.isEmpty()){
	   return null;
	   }
	
	   Integer max = 0;
	   Edge maxEdge = elist.get(0);
	   for(Edge edge:elist){
		
		  Integer a = computeMatch(edge);
		  System.out.println("Edge match:"+a);
		  if(a > max){
			 max = a;  
			 maxEdge = edge;
		   }
		}
	   return maxEdge;
	}



     private Integer computeMatch(Edge edge) {
	
    	
    	String a = edge.getA();
    	String b = edge.getB();
    	
    	return getLinkedNodes(a) + getLinkedNodes(b);
      }



	private Integer getLinkedNodes(String a) {
		Integer sum = 0;
		for(Node node:Graph.nodes){
			
			if(a.equals(node.getName())){
				
				for(String link:node.getLinks()){
					
					if(activeVariables1.contains(link)){
						sum = sum +1;
					}
				}
			}
		}
	return sum;
	}



	public Edge get1Match(){
		
		for(Edge edge:edgeSet){
			if(activeVariables1.contains(edge.getA()) || 
				activeVariables1.contains(edge.getB())){
				System.out.println("1 edge");
					return edge;
				}
			}
		return null;
		}
    
    public Edge getAny(){
		
		for(Edge edge:edgeSet){
			System.out.println("0 edge");
			return edge;
		}
		return null;
	}
	
	
	
	
	
	
	
}
