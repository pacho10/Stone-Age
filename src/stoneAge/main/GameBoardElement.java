package stoneAge.main;

import java.util.ArrayList;
import java.util.List;

public abstract class GameBoardElement {

	private static final int MAX_FREE_PLACES = 50;
private List<Figure> figures;
	
	public GameBoardElement() {
		this.figures = new ArrayList<>();
	}
	
	public int getFreeSpaces(){
		return MAX_FREE_PLACES - this.figures.size();
	}
	
	public void addFigure(Figure figure) {
		if (this.figures.size() < getMaxFreePlaces()) {
			this.figures.add(figure);
			figure.getPlayer().placeFigure();
			
		} else {
			// do not have free space
		}
	}
	
	public int removeFigure(Figure figure) {
		this.figures.remove(figure);
		//figure.getPlayer().takeFigure(figure);
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
	
	public boolean hasFigureOnIt(){
		if(this.figures.size()>0){
			return true;
		}
		return false;
	}
}
