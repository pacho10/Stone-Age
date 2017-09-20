package stoneAge.main;

import java.util.List;

import stoneAge.resources.TreeResource;

public class Forest extends PlayerBoardElementWithResources {
	private List<TreeResource> resorces;
	
	public Forest(List<TreeResource> trees) {
		super();
		this.resorces = trees;
	}
}