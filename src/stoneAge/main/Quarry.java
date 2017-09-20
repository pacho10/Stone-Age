package stoneAge.main;

import java.util.List;

import stoneAge.resources.QuarryResource;

public class Quarry extends GameBoardElementWithResources {
	private List<QuarryResource> resorces;

	public Quarry(List<QuarryResource> stones) {
		super();
		this.resorces = stones;
	}
}
