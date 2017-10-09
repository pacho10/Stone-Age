package stoneAge.main;

import java.util.Scanner;

import stoneAge.player.Player;

public class Demo {
	private static final int NUMBER_OF_PLACES = 8;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		GameBoard gameBoard = new GameBoard();
		Player p1 = new Player();
		Player p2 = new Player();
		System.out.println("Enter the name of the first player");
		p1.setName(sc.next());
		System.out.println("Enter the name of the second player");
		p2.setName(sc.next());
		

		
		int turn = 0;
		Player playerOnTurn = null;
		while (gameBoard.getPileOne().getSize() > 0 || gameBoard.getPileTwo().getSize() > 0
				|| gameBoard.getPileThree().getSize() > 0) {
			int putPhaseTurn = 0;

			while ((p1.getNumberOfFreeFigures() > 0) || (p2.getNumberOfFreeFigures() > 0)) {
				playerOnTurn = (turn % 2 == 0) ? p1 : p2;
				System.out.println(playerOnTurn.getName() +"'s turn:");
				System.out.println(
						"Choose the area you wish to put workers:\n0: Forest(wood)\n1: Claymound\n2: Quarry(stones)\n3: River(gold)\n4:HuntingGround(food)\n5: Hut(more workers)\n6: ToolTile(tools)\n7: AgroCulturePlace(increases your agroculture)\n8: Buy house");

				int place = sc.nextInt();
				if (place >= 0 && place <= NUMBER_OF_PLACES) {
					int workers = 0;
					switch (place) {
					case 0:
						// wood

						System.out.println("How many workers do you want to place here ?");
						workers = sc.nextInt();
						if (checkIfValidWorkers(workers, gameBoard.getForest(), playerOnTurn)) {
							for (int i = 0; i < workers; i++) {
								gameBoard.getForest().addFigure(playerOnTurn.giveFigure());
							}
						}
						break;
					case 1:
						System.out.println("How many workers do you want to place here ?");
						workers = sc.nextInt();
						if (checkIfValidWorkers(workers, gameBoard.getClaymound(), playerOnTurn)) {

							for (int i = 0; i < workers; i++) {
								gameBoard.getClaymound().addFigure(playerOnTurn.giveFigure());
							}

						}
						// clay
						break;
					case 2:
						System.out.println("How many workers do you want to place here ?");
						workers = sc.nextInt();
						if (checkIfValidWorkers(workers, gameBoard.getQuarry(), playerOnTurn)) {

							for (int i = 0; i < workers; i++) {
								gameBoard.getQuarry().addFigure(playerOnTurn.giveFigure());
							}
						}
						// stones
						break;
					case 3:
						System.out.println("How many workers do you want to place here ?");
						workers = sc.nextInt();
						if (checkIfValidWorkers(workers, gameBoard.getRiver(), playerOnTurn)) {

							for (int i = 0; i < workers; i++) {
								gameBoard.getRiver().addFigure(playerOnTurn.giveFigure());
							}
						}
						// gold
						break;
					case 4:
						System.out.println("How many workers do you want to place here ?");
						workers = sc.nextInt();
						if (checkIfValidWorkers(workers, gameBoard.getHuntingGround(), playerOnTurn)) {
							for (int i = 0; i < workers; i++) {
								gameBoard.getHuntingGround().addFigure(playerOnTurn.giveFigure());
							}
						}
						// food
						break;
					case 5:
						if (gameBoard.getHut().getFreeSpaces() > 0) {
							gameBoard.getHut().addFigure(playerOnTurn.giveFigure());
						}
						// hut
						break;
					case 6:
						if (gameBoard.getToolTile().getFreeSpaces() > 0) {
							gameBoard.getToolTile().addFigure(playerOnTurn.giveFigure());
						}
						// tools
						break;
					case 7:
						if ((gameBoard.getHut().getFreeSpaces() > 0) && (playerOnTurn.getNumberOfFreeFigures() >= 2)) {
							gameBoard.getHut().addFigure(playerOnTurn.giveFigure());
							gameBoard.getHut().addFigure(playerOnTurn.giveFigure());
						}
						break;
					// agroculture
					case 8:
						System.out.println("Your options are:");
						System.out.println("1: " + gameBoard.getPileOne().getFirstHouse());
						System.out.println("2: " + gameBoard.getPileTwo().getFirstHouse());
						System.out.println("3: " + gameBoard.getPileThree().getFirstHouse());
						boolean over = true;
						while (over) {
							if(gameBoard.getPileOne().hasFigureOnIt()&&gameBoard.getPileTwo().hasFigureOnIt()&&gameBoard.getPileThree().hasFigureOnIt());
							int house = sc.nextInt();
							switch (house) {
							case 1:
								if (gameBoard.getPileOne().hasFigureOnIt()) {
									System.out.println("Sorry, this one is taken.");
									over = true;
								} else {
									if (playerOnTurn.getNumberOfFreeFigures() >= 1) {
										gameBoard.getPileOne().addFigure(playerOnTurn.giveFigure());
									}
									over = false;
								}break;
							case 2:
								if (gameBoard.getPileTwo().hasFigureOnIt()) {
									System.out.println("Sorry, this one is taken.");
									over = true;
								} else {
									if (playerOnTurn.getNumberOfFreeFigures() >= 1) {
										gameBoard.getPileTwo().addFigure(playerOnTurn.giveFigure());
									}
									over = false;
								}break;
							case 3:
								if (gameBoard.getPileThree().hasFigureOnIt()) {
									System.out.println("Sorry, this one is taken.");
									over = true;
								} else {
									if (playerOnTurn.getNumberOfFreeFigures() >= 1) {
										gameBoard.getPileThree().addFigure(playerOnTurn.giveFigure());
									}
									over = false;
								}
								break;
							default:
								System.out.println("You will have to choose from 1 to 3.");
							}
						}break;
					default:
						System.out.println("Not a valid choise.");
						break;
					}
				}
				putPhaseTurn++;
				turn++;
			}

			System.out.println("GAIN RESOURCES");
			System.out.println("###########################################################");
			System.out.println();

			playerOnTurn = (turn % 2 == 0) ? p1 : p2;
			while (gameBoard.getClaymound().hasFigureOnIt() || gameBoard.getRiver().hasFigureOnIt()
					|| gameBoard.getHuntingGround().hasFigureOnIt() || gameBoard.getForest().hasFigureOnIt()
					|| gameBoard.getHut().hasFigureOnIt() || gameBoard.getQuarry().hasFigureOnIt()
					|| gameBoard.getToolTile().hasFigureOnIt() || gameBoard.getAgroCulturePlace().hasFigureOnIt()) {

				// int allFiguresInOneZone = 0;
				// for (Figure figure : gameBoard.getClaymound().getFigures()) {
				// if (figure.getPlayer().equals(playerOnTurn)) {
				// allFiguresInOneZone++;
				// }
				// }

				// int resource =
				// gameBoard.getClaymound().removeAllFiguresOfOnePlayer(playerOnTurn);

				gameBoard.getClaymound().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getRiver().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getHuntingGround().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getForest().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getHut().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getQuarry().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getToolTile().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getAgroCulturePlace().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getPileOne().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getPileTwo().removeAllFiguresOfOnePlayer(playerOnTurn);
				gameBoard.getPileThree().removeAllFiguresOfOnePlayer(playerOnTurn);
			}

			p1.feed();
			p2.feed();
			p1.toString();
			p2.toString();
		}
		sc.close();
	}

	public static boolean checkIfValidWorkers(int workers, GameBoardElement e, Player p) {
		if (workers <= p.getNumberOfFreeFigures() && e.getFreeSpaces() >= workers) {
			return true;
		}
		return false;
	}
}
