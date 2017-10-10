package stoneAge.main;

import stoneAge.player.Player;

public class AgroculturePlace  extends GameBoardElement {

	private static final int MAX_FREE_PLACES = 1;
	
	public AgroculturePlace() {
		// TODO Auto-generated constructor stub
	
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
			figure.getPlayer().incrementAgroculture();
		return 0;
	}
	
	public void removeAllFiguresOfOnePlayer(Player player) {
//		for (Figure figure : this.getFigures()) {
//			if ((player != null) && (figure.getPlayer().equals(player))) {
//				player.takeFigure(figure);
//				player.incrementAgroculture();
//				super.removeFigure(figure);
//			}
//		}
		
		if (player != null) {
			for (int i = 0; i < this.getFigures().size(); i++) {
				if((this.getFigures().get(i) != null) && (this.getFigures().get(i).getPlayer().equals(player))){
					player.takeFigure(this.getFigures().get(i));
					player.incrementAgroculture();
					super.removeFigure(this.getFigures().get(i));
					System.out.println("Agroculture of "+player.getName()+" has increased.");
					i--;
				}
			}
		}
	}
}
