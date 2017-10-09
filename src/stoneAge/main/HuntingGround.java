package stoneAge.main;

import stoneAge.player.Player;

public class HuntingGround extends GameBoardElement {
	
	private static final int FOOD_COEFFICIENT = 2;
	public HuntingGround() {
		super();
	}
	
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
		int diceValue = (int)((Math.random()*6)+1);
		figure.getPlayer().gainFood(diceValue);//fix
		return diceValue;
	}
	public void removeAllFiguresOfOnePlayer(Player player){
		int amountOfFoodGaind = 0;
		for(Figure figure : this.getFigures()){
			if(figure.getPlayer().equals(player)){
				amountOfFoodGaind += removeFigure(figure);	
			}
		}
		player.gainFood(amountOfFoodGaind/FOOD_COEFFICIENT);
	}
}
