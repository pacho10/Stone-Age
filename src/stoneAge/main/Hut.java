package stoneAge.main;

import stoneAge.player.Player;

public class Hut extends GameBoardElement {
	private static final int MAX_FREE_PLACES = 2;

	public Hut() {
		super();
	}

	@Override
	public int getMaxFreePlaces() {
		// TODO Auto-generated method stub
		return MAX_FREE_PLACES;
	}

	@Override
	public void addFigure(Figure figure) {
//		for (int i = 0; i < 2; i++) {
//			//figure.getPlayer().takeFigure(figure);
//			this.addFigure(figure);
//		}
		
		super.addFigure(figure);
	}
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
		for (int i = 0; i < 2; i++) {
			figure.getPlayer().takeFigure(figure);			
		}
		return 0;
	}
	
	public void removeAllFiguresOfOnePlayer(Player player) {
		boolean flag = false;
//		for (Figure figure : this.getFigures()) {
//			if ((player != null) && (figure.getPlayer().equals(player))) {
//				player.takeFigure(figure);
//				super.removeFigure(figure);
//				flag = true;
//			}
//		}
		
		for (int i = 0; i < this.getFigures().size(); i++) {
			if ((player != null) && (this.getFigures().get(i).getPlayer().equals(player))) {
				player.takeFigure(this.getFigures().get(i));
				super.removeFigure(this.getFigures().get(i));
				flag = true;
			}
		}
		
		if (flag) {
			player.takeFigure(new Figure(player));
		}
	}
}
