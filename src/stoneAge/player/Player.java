package stoneAge.player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import stoneAge.main.Figure;

public class Player {
	private static final int STARTING_FOOD_VALUE = 12;
	private int clay;
	private int stone;
	private int gold;
	private int wood;
	private int food;
	private Queue<Figure> figures;
	private int multiplierForHouses;
	private int multiplierForTools;
	private int multiplierForAgroCulture;
	private int multiplierForNumberOfFigures;
	private int[] tools;
	private int agroCulture;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int numberOfHouses;
	private int points;

	public Player() {
		super();
		this.food = STARTING_FOOD_VALUE;
		this.clay = 0;
		this.stone = 0;
		this.gold = 0;
		this.wood = 0;
		this.multiplierForHouses = 0;
		this.multiplierForTools = 0;
		this.multiplierForAgroCulture = 0;
		this.multiplierForNumberOfFigures = 0;
		tools = new int[3];
		figures = new LinkedList<Figure>();
		for (int i = 0; i < 5; i++) {
			figures.add(new Figure(this));			
		}
	}

	public void addOneTool() {
		int minToolValue = tools[0];
		int minToolIndex = 0;

		for (int i = 0; i < tools.length; i++) {
			if (minToolValue > tools[0]) {
				minToolValue = tools[0];
				minToolIndex = i;
			}
		}
		tools[minToolIndex] += 1;
	}
	
	public void incrementAgroculture(){
		this.agroCulture++;
	}

	public void payGold(int amountOfGold) {
		if (amountOfGold > 0) {
			this.gold -= amountOfGold;
		}
	}

	public void gainGold(int amountOfGold) {
		if (amountOfGold > 0) {
			this.gold += amountOfGold;
		}
	}
	public void gainPoints(int amountOfPoints) {
		if (amountOfPoints > 0) {
			this.gold += amountOfPoints;
		}
	}
	public void gainFood(int amountOfFood) {
		if (amountOfFood > 0) {
			this.food += amountOfFood;
		}
	}

	public void payClay(int amountOfClay) {
		if (amountOfClay > 0) {
			this.clay -= amountOfClay;
		}
	}

	public void gainClay(int amountOfClay) {
		if (amountOfClay > 0) {
			this.clay += amountOfClay;
		}
	}

	public void payWood(int amountOfWood) {
		if (amountOfWood > 0) {
			this.wood -= amountOfWood;
		}
	}

	public void gainWood(int amountOfWood) {
		if (amountOfWood > 0) {
			this.wood += amountOfWood;
		}
	}

	public void payStone(int amountOfStone) {
		if (amountOfStone > 0) {
			this.stone -= amountOfStone;
		}
	}

	public void gainStone(int amountOfStone) {
		if (amountOfStone > 0) {
			this.gold += amountOfStone;
		}
	}

	public void feed() {
		int foodToGive = this.figures.size();
		if (foodToGive > this.agroCulture) {
			if (this.food < foodToGive) {
				foodToGive -= this.food;
				this.food = 0;
				if (foodToGive > 0) {
					if (this.wood < foodToGive) {
						foodToGive -= this.wood;
						this.wood = 0;
					} else {
						this.wood -= foodToGive;
						foodToGive = 0;
					}
				}
				if (foodToGive > 0) {
					if (this.clay < foodToGive) {
						foodToGive -= this.clay;
						this.clay = 0;
					} else {
						this.clay -= foodToGive;
						foodToGive = 0;
					}
				}
				if (foodToGive > 0) {
					if (this.stone < foodToGive) {
						foodToGive -= this.stone;
						this.stone = 0;
					} else {
						this.stone -= foodToGive;
						foodToGive = 0;
					}
				}
				if (foodToGive > 0) {
					if (this.gold < foodToGive) {
						foodToGive -= this.gold;
						this.gold = 0;
					} else {
						this.gold -= foodToGive;
						foodToGive = 0;
					}
				}
				if (foodToGive > 0) {
					this.points -= (foodToGive * 10);
				}
			} else {
				this.food -= foodToGive;
			}
		}
	}
	
	public Figure giveFigure(){
		return this.figures.peek();
	}

	public void incrementAgroCulture() {
			this.agroCulture++;
	}

	public void placeFigure() {
		if (!this.figures.isEmpty()) {
			this.figures.poll();
		}
	}

	public void takeFigure(Figure figure) {
		this.figures.add(figure);
	}
	
	public int getNumberOfFreeFigures(){
		return this.figures.size();
	}

	@Override
	public String toString() {
		return "Player [clay=" + clay + ", stone=" + stone + ", gold=" + gold + ", wood=" + wood + ", food=" + food
				+ ", figures=" + figures + ", multiplierForHouses=" + multiplierForHouses + ", multiplierForTools="
				+ multiplierForTools + ", multiplierForAgroCulture=" + multiplierForAgroCulture
				+ ", multiplierForNumberOfFigures=" + multiplierForNumberOfFigures + ", tools=" + Arrays.toString(tools)
				+ ", agroCulture=" + agroCulture + ", numberOfHouses=" + numberOfHouses + ", points=" + points + "]";
	}

}
