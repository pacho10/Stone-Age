package stoneAge.main;

import stoneAge.player.Player;

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
//		for(Figure figure : this.getFigures()){
//			if((player != null) && (figure.getPlayer().equals(player))){
//				player.takeFigure(figure);
//				amountOfClayGained += removeFigure(figure);
//				
//			}
//		}
		
		if (player != null) {
			for (int i = 0; i < this.getFigures().size(); i++) {
				if ((this.getFigures().get(i) != null) && (this.getFigures().get(i).getPlayer().equals(player))) {
					player.takeFigure(this.getFigures().get(i));
					amountOfClayGained += removeFigure(this.getFigures().get(i));
					i--;
				}
			}
			System.out.println(player.getName()+" has gained "+amountOfClayGained/CLAY_COEFFICIENT+" amount of clay.");
			player.gainClay(amountOfClayGained/CLAY_COEFFICIENT);
		}
	}
}
