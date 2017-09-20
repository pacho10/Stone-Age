package stoneAge.main;

public class Field extends GameBoardElement {
private static final int MAX_FREE_PLACES = 1;
//food
	
	public Field() {
		super();
	}
	
	@Override
	public int getFreePlaces() {
		// TODO Auto-generated method stub
		return MAX_FREE_PLACES;
	}
}
