package stoneAge.main;

import stoneAge.player.Player;

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
//		for(Figure figure : this.getFigures()){
//			if((player != null) && (figure.getPlayer().equals(player))){
//				player.takeFigure(figure);
//				amountOfStoneGained += removeFigure(figure);
//				
//			}
//		}
		
		if (player != null) {
			for (int i = 0; i < this.getFigures().size(); i++) {
				if ((this.getFigures().get(i) != null) && (this.getFigures().get(i).getPlayer().equals(player))) {
					player.takeFigure(this.getFigures().get(i));
					amountOfStoneGained += removeFigure(this.getFigures().get(i));
					i--;
				}
			}
			System.out.println(player.getName()+" has gained "+amountOfStoneGained/STONE_COEFFICIENT+" amount of stones.");
			player.gainStone(amountOfStoneGained/STONE_COEFFICIENT);
		}
	}
	
}
