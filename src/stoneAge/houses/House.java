package stoneAge.houses;

public class House {
	private int woodToPay;
	private int clayToPay;
	private int stonesToPay;
	private int goldToPay;
	private int points;
	public House(int woodToPay, int clayToPay, int stonesToPay, int goldToPay, int points) {
		super();
		this.woodToPay = woodToPay;
		this.clayToPay = clayToPay;
		this.stonesToPay = stonesToPay;
		this.goldToPay = goldToPay;
		this.points = points;
	}
	
	public static House generateRandomHouse(){
		int woodToPay=0,  clayToPay=0,  stonesToPay=0,  goldToPay=0,  points=0;
		for (int i = 0; i < 3; i++) {
			int rand = (int)((Math.random()*4));
			switch (rand) {
			case 1:
				woodToPay++;
				break;
			case 2:
				clayToPay++;
				break;
			case 3:
				stonesToPay++;
			break;
			case 4:
				goldToPay++;
				break;
			}
		}
		points=((woodToPay*3)+(clayToPay*4)+(stonesToPay*5)+(goldToPay*6));
		return new House(woodToPay, clayToPay, stonesToPay, goldToPay, points) ;
		
		
	}

	public int getWoodToPay() {
		return woodToPay;
	}

	public int getClayToPay() {
		return clayToPay;
	}

	public int getStonesToPay() {
		return stonesToPay;
	}

	public int getGoldToPay() {
		return goldToPay;
	}

	public int getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "House [woodToPay=" + woodToPay + ", clayToPay=" + clayToPay + ", stonesToPay=" + stonesToPay
				+ ", goldToPay=" + goldToPay + ", points=" + points + "]";
	}
	
}
