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
	private AgroculturePlace agroCulturePlace;
	
	public GameBoard() {
		this.forest = new Forest();
		this.claymound = new Claymound();
		this.river = new River();
		this.quarry = new Quarry();
		this.toolTile = new ToolTile();
		this.hut = new Hut();
		this.field = new Field();
		this.huntingGround = new HuntingGround();
		this.agroCulturePlace = new AgroculturePlace();
	}

	public AgroculturePlace getAgroCulturePlace() {
		return agroCulturePlace;
	}

	public Forest getForest() {
		return forest;
	}

	public void setForest(Forest forest) {
		this.forest = forest;
	}

	public Claymound getClaymound() {
		return claymound;
	}

	public void setClaymound(Claymound claymound) {
		this.claymound = claymound;
	}

	public River getRiver() {
		return river;
	}

	public void setRiver(River river) {
		this.river = river;
	}

	public Quarry getQuarry() {
		return quarry;
	}

	public void setQuarry(Quarry quarry) {
		this.quarry = quarry;
	}

	public ToolTile getToolTile() {
		return toolTile;
	}

	public void setToolTile(ToolTile toolTile) {
		this.toolTile = toolTile;
	}

	public Hut getHut() {
		return hut;
	}

	public void setHut(Hut hut) {
		this.hut = hut;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public HuntingGround getHuntingGround() {
		return huntingGround;
	}

	public void setHuntingGround(HuntingGround huntingGround) {
		this.huntingGround = huntingGround;
	}
}
