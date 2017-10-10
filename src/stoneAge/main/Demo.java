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
		while (gameBoard.getPileOne().getSize() > 0 && gameBoard.getPileTwo().getSize() > 0
				&& gameBoard.getPileThree().getSize() > 0) {
			int putPhaseTurn = 0;

			while ((p1.getNumberOfWorkers() > 0) || (p2.getNumberOfWorkers() > 0)) {
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
							System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
						}
						break;
					case 1:
						System.out.println("How many workers do you want to place here ?");
						workers = sc.nextInt();
						if (checkIfValidWorkers(workers, gameBoard.getClaymound(), playerOnTurn)) {

							for (int i = 0; i < workers; i++) {
								gameBoard.getClaymound().addFigure(playerOnTurn.giveFigure());
							}
							System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");

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
							System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
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
							System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
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
							System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
						}
						// food
						break;
					case 5:
						if (gameBoard.getHut().getFreeSpaces() > 0) {
							gameBoard.getHut().addFigure(playerOnTurn.giveFigure());
							gameBoard.getHut().addFigure(playerOnTurn.giveFigure());
							System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
						}
						// hut
						break;
					case 6:
						if (gameBoard.getToolTile().getFreeSpaces() > 0) {
							gameBoard.getToolTile().addFigure(playerOnTurn.giveFigure());
							System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
						}
						// tools
						break;
					case 7:
						if ((gameBoard.getAgroCulturePlace().getFreeSpaces() > 0) && (playerOnTurn.getNumberOfWorkers() >= 1)) {
							gameBoard.getAgroCulturePlace().addFigure(playerOnTurn.giveFigure());
							System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
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
									if (playerOnTurn.getNumberOfWorkers() >= 1) {
										gameBoard.getPileOne().addFigure(playerOnTurn.giveFigure());
										System.out.println("You now have "+playerOnTurn+" workers.");
									}
									over = false;
								}break;
							case 2:
								if (gameBoard.getPileTwo().hasFigureOnIt()) {
									System.out.println("Sorry, this one is taken.");
									over = true;
								} else {
									if (playerOnTurn.getNumberOfWorkers() >= 1) {
										gameBoard.getPileTwo().addFigure(playerOnTurn.giveFigure());
										System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
									}
									over = false;
								}break;
							case 3:
								if (gameBoard.getPileThree().hasFigureOnIt()) {
									System.out.println("Sorry, this one is taken.");
									over = true;
								} else {
									if (playerOnTurn.getNumberOfWorkers() >= 1) {
										gameBoard.getPileThree().addFigure(playerOnTurn.giveFigure());
										System.out.println("You now have "+playerOnTurn.getNumberOfWorkers()+" workers.");
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
				
				turn++;
				playerOnTurn = (turn % 2 == 0) ? p1 : p2;
				System.out.println("in second while");
			}
			
			System.out.println("End of turn.");

			p1.feed();
			p2.feed();
			
			
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
		}
		sc.close();
		String winner = (p1.getPoints()-p2.getPoints()>0) ? p1.getName():p2.getName();
		History.createHistory(p1.getName(), p2.getName(), winner);
		
	}

	public static boolean checkIfValidWorkers(int workers, GameBoardElement e, Player p) {
		if (workers <= p.getNumberOfWorkers() && e.getFreeSpaces() >= workers) {
			return true;
		}
		return false;
	}
}
