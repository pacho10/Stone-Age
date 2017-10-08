package stoneAge.main;

import java.util.List;

import stoneAge.player.Player;
import stoneAge.resources.Wood;

public class Forest extends GameBoardElementWithResources {
	private static final int WOOD_COEFICIENT = 3;
	//private List<TreeResource> resorces;
	
	public Forest() {
		super();
		//this.resorces = trees;
	}
	
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
		int diceValue = (int)((Math.random()*6)+1);
		return diceValue;
	}
	
	public void removeAllFiguresOfOnePlayer(Player player){
		int amountOfWoodGained = 0;
		for(Figure figure : this.getFigures()){
			if((player != null) && (figure.getPlayer().equals(player))){
				amountOfWoodGained += removeFigure(figure);
				
			}
		}
		player.gainWood(amountOfWoodGained/WOOD_COEFICIENT);
	}
}