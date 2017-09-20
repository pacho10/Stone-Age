package stoneAge.main;

import java.util.List;

import stoneAge.resources.GoldResource;

public class River extends PlayerBoardElement {
private List<GoldResource> resorces;
	
	public River(List<GoldResource> gold) {
		super();
		this.resorces = gold;
	}
}
