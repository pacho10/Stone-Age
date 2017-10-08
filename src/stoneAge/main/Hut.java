package stoneAge.main;

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
	public void addFifure(Figure figure) {
		for (int i = 0; i < 2; i++) {
			figure.getPlayer().takeFigure(figure);
		}
	}
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
		for (int i = 0; i < 2; i++) {
			figure.getPlayer().takeFigure(figure);			
		}
		return 0;
	}
}
