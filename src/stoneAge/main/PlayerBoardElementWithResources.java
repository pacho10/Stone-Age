package stoneAge.main;

public abstract class PlayerBoardElementWithResources extends PlayerBoardElement {
	private static final int MAX_FREE_PLACES = 7;
	
	public PlayerBoardElementWithResources() {
		super();
	}
	
	@Override
	public int getMaxFreePlaces() {
		// TODO Auto-generated method stub
		return MAX_FREE_PLACES;
	}
}
