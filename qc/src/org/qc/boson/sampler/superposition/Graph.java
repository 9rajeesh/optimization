package org.qc.boson.sampler.superposition;

import java.util.Arrays;
import java.util.List;

public class Graph {

	public static void main(String[] args) {
		
		createGraph();
	}
	
	
	
	
	public static void createGraph() {
		
		Node o = new Node("o");
		Node a1 = new Node("a1");
		Node b1 = new Node("b1");
		Node a2 = new Node("a2");
		Node b2 = new Node("b2");
		Node a3 = new Node("a3");
		Node b3 = new Node("b3");
		
		Node e = new Node("e");
		
		
		
		Link l1 = new Link(o,a1,0.5);
		Link l2 = new Link(o,b1,0.5);
		
		Link l3 = new Link(a1,a2,2/3.0);
		Link l4 = new Link(a1,b2,-1/3.0);
		
		Link l5 = new Link(b1,b2,2/3.0);
		Link l6 = new Link(b1,a2,-1/3.0);
		
		Link l7 = new Link(a2,a3,2/3.0);
		Link l8 = new Link(a2,b3,1/3.0);
		
		Link l9 = new Link(b2,b3,2/3.0);
		Link l10 = new Link(b2,a3,-1/3.0);
				
		Link l11 = new Link(a3,e,1.0);
		Link l12 = new Link(b3,e,1.0);
		
		List<Link> links = Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
		
		o.computeLink(links);
		a1.computeLink(links);
		b1.computeLink(links);
		a2.computeLink(links);
		b2.computeLink(links);
		a3.computeLink(links);
		b3.computeLink(links);
		e.computeLink(links);
				
		SumAllPath.traverse(o, e, 1.0);
		Double value = SumAllPath.sumAllPaths();
		System.out.println("Values are:"+value);
		
		
		
	}
	
	
	
	
}
