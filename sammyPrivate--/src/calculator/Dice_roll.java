package calculator;

import java.util.Random;

public class Dice_roll {

	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
		int r = random(1, 6);
		System.out.println(r);
	}
	}
	private static int random(int r1, int r2) {
		Random r = new Random();
		int rsan = r.nextInt(r2 - r1) + r1;
		return(rsan);
	}
}

