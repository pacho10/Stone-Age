package stoneAge.main;

import java.util.List;

import stoneAge.player.Player;
import stoneAge.resources.Clay;

public class Claymound extends GameBoardElement {
	private static final int CLAY_COEFFICIENT = 4;
	//private List<ClaymoundResource> resources;
	
	public Claymound() {
		super();
		//this.resources = clay;
	}
	
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
		int diceValue = (int)((Math.random()*6)+1);
		return diceValue;
	}
	public void removeAllFiguresOfOnePlayer(Player player){
		int amountOfClayGained = 0;
		for(Figure figure : this.getFigures()){
			if(figure.getPlayer().equals(player)){
				amountOfClayGained += removeFigure(figure);
				
			}
		}
		player.gainClay(amountOfClayGained/CLAY_COEFFICIENT);
	}
}
