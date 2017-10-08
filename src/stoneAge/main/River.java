package stoneAge.main;

import java.util.List;

import stoneAge.player.Player;
import stoneAge.resources.Gold;

public class River extends GameBoardElement {
	private static final int GOLD_COEFFICIENT = 6;
	//private List<Gold> resorces;

	public River() {
		super();
		// this.resorces = gold;
	}
	
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
		int diceValue = (int)((Math.random()*6)+1);
		return diceValue;
	}
	public void removeAllFiguresOfOnePlayer(Player player){
		int amountOfGoldGained = 0;
		for(Figure figure : this.getFigures()){
			if(figure.getPlayer().equals(player)){
				amountOfGoldGained += removeFigure(figure);
				
			}
		}
		player.gainStone(amountOfGoldGained/GOLD_COEFFICIENT);
	}
}
