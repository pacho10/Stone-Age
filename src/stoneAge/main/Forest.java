package stoneAge.main;

import stoneAge.player.Player;

public class Forest extends GameBoardElementWithResources {
	private static final int WOOD_COEFICIENT = 3;
	// private List<TreeResource> resorces;

	public Forest() {
		super();
		// this.resorces = trees;
	}

	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
		int diceValue = (int) ((Math.random() * 6) + 1);
		return diceValue;
	}

	public void removeAllFiguresOfOnePlayer(Player player) {
		int amountOfWoodGained = 0;

		if (player != null) {
			for (int i = 0; i < this.getFigures().size(); i++) {
				if ((this.getFigures().get(i) != null) && (this.getFigures().get(i).getPlayer().equals(player))) {
					player.takeFigure(this.getFigures().get(i));
					amountOfWoodGained += removeFigure(this.getFigures().get(i));
					i--;
				}
			}
			System.out.println(player.getName()+" has gained "+amountOfWoodGained / WOOD_COEFICIENT+" amount of wood.");
			player.gainWood(amountOfWoodGained / WOOD_COEFICIENT);
		}
	}
}