package stoneAge.main;

import java.util.ArrayList;
import java.util.List;

public abstract class GameBoardElement {

	private static final int MAX_FREE_PLACES = 50;
private List<Figure> figures;
	
	public GameBoardElement() {
		this.figures = new ArrayList<>();
	}
	
	public void addFifure(Figure figure) {
		if (this.figures.size() < getMaxFreePlaces()) {
			this.figures.add(figure);
			figure.getPlayer().placeFigure();
			
		} else {
			// do not have free space
		}
	}
	
	public int removeFigure(Figure figure) {
		this.figures.remove(figure);
		figure.getPlayer().takeFigure(figure);
		return 0;
	}
	
	public List<Figure> getFigures() {
		return figures;
	}

	public void setFigures(List<Figure> figures) {
		this.figures = figures;
	}

	public int getMaxFreePlaces() {
		return MAX_FREE_PLACES;
	}
}
