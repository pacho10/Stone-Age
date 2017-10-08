package stoneAge.main;

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
			figure.getPlayer().takeFigure(figure);
	}
	@Override
	public int removeFigure(Figure figure) {
		super.removeFigure(figure);
			figure.getPlayer().takeFigure(figure);	
			figure.getPlayer().addOneTool();
		return 0;
	}
}
