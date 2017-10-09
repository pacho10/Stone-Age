package stoneAge.main;

import java.util.LinkedList;

import stoneAge.houses.House;
import stoneAge.player.Player;

public class HousePile extends GameBoardElement {
	private static final int NUMBER_OF_HOUSES_IN_PILE = 7;
	private static final int MAX_FREE_PLACES = 1;
	private LinkedList<House> pile;

	public HousePile() {
		super();
		this.pile = new LinkedList<House>();
		for (int i = 0; i < NUMBER_OF_HOUSES_IN_PILE; i++) {
			this.pile.add(House.generateRandomHouse());
		}
	}

	public House getFirstHouse() {
		return this.pile.peek();
	}

	public int getSize() {
		return this.pile.size();
	}

	public void removeAllFiguresOfOnePlayer(Player player) {
		if (this.hasFigureOnIt() && (player != null) && (this.getFigures().get(0).equals(player))) {
			player.takeFigure(this.getFigures().get(0));
			super.removeFigure(this.getFigures().get(0));
			player.gainPoints(this.pile.peek().getPoints());

		}
	}
}
