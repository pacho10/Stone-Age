package stoneAge.main;

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
			figure.getPlayer().takeFigure(figure);
	}
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
			figure.getPlayer().takeFigure(figure);	
			figure.getPlayer().incrementAgroculture();
		return 0;
	}
}
