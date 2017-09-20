package stoneAge.main;

import java.util.List;

import stoneAge.resources.ClaymoundResource;

public class Claymound extends GameBoardElement {
	private List<ClaymoundResource> resources;
	
	public Claymound(List<ClaymoundResource> clay) {
		super();
		this.resources = clay;
	}
}
