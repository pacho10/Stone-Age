package stoneAge.main;
import stoneAge.player.Player;

public class Figure {
	public Player getPlayer() {
		return player;
	}

	private Player player;

	public Figure(Player player) {
		this.player = player;
	}

}
