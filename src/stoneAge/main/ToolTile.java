package stoneAge.main;

import stoneAge.player.Player;

public class ToolTile extends GameBoardElement {
	private static final int MAX_FREE_PLACES = 1;
	//coollection of tools
	
	public ToolTile() {
		super();
	}

	@Override
	public int getMaxFreePlaces() {
		// TODO Auto-generated method stub
		return MAX_FREE_PLACES;
	}
	
	
	@Override
	public void addFigure(Figure figure) {
			//figure.getPlayer().takeFigure(figure);
		super.addFigure(figure);
	}
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
			figure.getPlayer().takeFigure(figure);	
			figure.getPlayer().addOneTool();
		return 0;
	}
	
	public void removeAllFiguresOfOnePlayer(Player player) {
//		for (Figure figure : this.getFigures()) {
//			if ((player != null) && (figure.getPlayer().equals(player))) {
//				player.takeFigure(figure);
//				player.addOneTool();
//			}
//		}
		
		for (int i = 0; i < this.getFigures().size(); i++) {
			if ((player != null) && (this.getFigures().get(i).getPlayer().equals(player))) {
				player.takeFigure(this.getFigures().get(i));
				player.addOneTool();
				System.out.println(player + "gained one tool.");
			}
		}
	}
}
