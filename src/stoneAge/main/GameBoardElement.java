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
		if (this.figures.size() < getFreePlaces()) {
			this.figures.add(figure);
		} else {
			// do not have free space
		}
	}
	
	public void removeFigure(Figure figure) {
		this.figures.remove(figure);
	}
	
	public int getFreePlaces() {
		return MAX_FREE_PLACES;
	}
}
