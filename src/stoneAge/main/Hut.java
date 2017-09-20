package stoneAge.main;

public class Hut extends GameBoardElement {
private static final int MAX_FREE_PLACES = 2;
	
	public Hut() {
		super();
	}
	
	@Override
	public int getFreePlaces() {
		// TODO Auto-generated method stub
		return MAX_FREE_PLACES;
	}
}
