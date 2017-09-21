package stoneAge.player;

import java.util.LinkedList;
import java.util.Queue;

import stoneAge.main.Figure;

public class Player {
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
	public Player() {
		super();
		this.food = 12;
		this.clay = clay;
		this.stone = stone;
		this.gold = gold;
		this.wood = wood;
		this.multiplierForHouses = multiplierForHouses;
		this.multiplierForTools = multiplierForTools;
		this.multiplierForAgroCulture = multiplierForAgroCulture;
		this.multiplierForNumberOfFigures = multiplierForNumberOfFigures;
		tools = new int[3];
		figures = new LinkedList<Figure>();
	}
	
	public void addOneTool(){
		int minToolValue = tools[0];
		int minToolIndex = 0;
		
		for (int i = 0; i < tools.length; i++) {
			if(minToolValue > tools[0]){
				minToolValue = tools[0];
				minToolIndex = i;
			}
		}
		tools[minToolIndex] += 1;
	}

}
