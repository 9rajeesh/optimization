package org.supersymmetry.grid.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name = "";
	private List<String> links = new ArrayList<String>();
	
		
	public Node(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public boolean isLinkedTo(String nodeName){
		
		return links.contains(nodeName);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getLinks() {
		return links;
	}


	public void setLinks(List<String> links) {
		this.links = links;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Node [name=" + name + ", links=" + links + "]";
	}

	public boolean canLink(Node node){
		
		if(this.name.equals(node.getName())){
			return false;
		}
		
		if(this.links.size() >= Graph.maxNodes){
			return false;
		}
		
		if(node.links.size() >= Graph.maxNodes){
			return false;
		}
		
		if(this.links.contains(node.getName())){
		return false;
		}
		
		
		return true;
	}
	
    public void linkTo(Node node){
		this.links.add(node.getName());
		node.links.add(this.getName());
	}
	
	
	
}
