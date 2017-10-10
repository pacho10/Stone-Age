package stoneAge.main;

import stoneAge.player.Player;

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
//		for(Figure figure : this.getFigures()){
//			if((player != null) && (figure.getPlayer().equals(player))){
//				player.takeFigure(figure);
//				amountOfGoldGained += removeFigure(figure);
//				
//			}
//		}
		
		if (player != null) {
			for (int i = 0; i < this.getFigures().size(); i++) {
				if ((this.getFigures().get(i) != null) && (this.getFigures().get(i).getPlayer().equals(player))) {
					player.takeFigure(this.getFigures().get(i));
					amountOfGoldGained += removeFigure(this.getFigures().get(i));
					i--;
				}
			}
			System.out.println(player.getName()+" has gained "+amountOfGoldGained/GOLD_COEFFICIENT+" amount of gold.");
			player.gainGold(amountOfGoldGained/GOLD_COEFFICIENT);
		}
	}
}
