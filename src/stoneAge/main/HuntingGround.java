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
		return diceValue;
	}
	public void removeAllFiguresOfOnePlayer(Player player){
		int amountOfFoodGaind = 0;
		
		for (int i = 0; i < this.getFigures().size(); i++) {
			if((player != null) && (this.getFigures().get(i).getPlayer().equals(player))){
				player.takeFigure(this.getFigures().get(i));
				amountOfFoodGaind += removeFigure(this.getFigures().get(i));	
			}
		}
		System.out.println(player.getName()+" has gained "+amountOfFoodGaind/FOOD_COEFFICIENT+" amount of food.");
		player.gainFood(amountOfFoodGaind/FOOD_COEFFICIENT);
	}
}
