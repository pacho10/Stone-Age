package stoneAge.main;

public abstract class GameBoardElementWithResources extends GameBoardElement {
	private static final int MAX_FREE_PLACES = 7;
	
	public GameBoardElementWithResources() {
		super();
	}
	
	@Override
	public int getFreePlaces() {
		// TODO Auto-generated method stub
		return MAX_FREE_PLACES;
	}
}
