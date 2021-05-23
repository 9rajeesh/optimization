package org.qc.boson.sampler.superposition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Node {

	String name;
	List<Link> links = new ArrayList<>();
	
	public Node(String name) {
		this.name=name;
	}
	
	public Node(String name,Double amplitude) {
		this.name=name;
	}
	
	public void computeLink(List<Link> links) {
		
		this.links.addAll(
		links.stream()
		.filter(link -> link.getA().getName().equals(this.name))
		.collect(Collectors.toList()));
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	
	
}
