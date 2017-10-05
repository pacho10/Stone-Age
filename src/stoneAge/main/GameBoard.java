package stoneAge.main;

import java.util.List;

import stoneAge.cards.Card;
import stoneAge.houses.House;

public class GameBoard {
	//private List<Card> cards;
	//private List<House> houses;
	private Forest forest;
	private Claymound claymound;
	private River river;
	private Quarry quarry;
	private ToolTile toolTile;
	private Hut hut;
	private Field field;
	private HuntingGround huntingGround;
	
	public GameBoard() {
		this.forest = new Forest();
		this.claymound = new Claymound();
		this.river = new River();
		this.quarry = new Quarry();
		this.toolTile = new ToolTile();
		this.hut = new Hut();
		this.field = new Field();
		this.huntingGround = new HuntingGround();
	}
}
