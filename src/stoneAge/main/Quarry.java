package stoneAge.main;

import java.util.List;

import stoneAge.player.Player;
import stoneAge.resources.Stone;

public class Quarry extends GameBoardElementWithResources {
	//private List<Stone> resorces;

	private static final int STONE_COEFFICIENT = 5;
	public Quarry() {
		super();
		//this.resorces = stones;
	}
	
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
		int diceValue = (int)((Math.random()*6)+1);
		return diceValue;
	}
	public void removeAllFiguresOfOnePlayer(Player player){
		int amountOfStoneGained = 0;
		for(Figure figure : this.getFigures()){
			if((player != null) && (figure.getPlayer().equals(player))){
				player.takeFigure(figure);
				amountOfStoneGained += removeFigure(figure);
				
			}
		}
		player.gainStone(amountOfStoneGained/STONE_COEFFICIENT);
	}
	
}
