package simpleMathTest;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class consoleMathTest {
	public static void main(String[] args) throws InterruptedException {
		int score = 0;
		for (int i = 0; i < 100; i++) {
			Random r = new Random();
			int opt1 = 100;
			int opt2 = 50;
			int cutoff = 20;
			int r1 = r.nextInt(opt1 - cutoff + 1) + 20;
			int r2 = r.nextInt(opt2 - cutoff + 1) + 20;
			int answer = r1 + r2;
			@SuppressWarnings("resource")
			Scanner myScanner = new Scanner(System.in);
			System.out.println("Choose your difficulty: Easy, Medium, or Hard");
			String difficulty = myScanner.nextLine();
			if (difficulty.equalsIgnoreCase("Easy")) {
				opt1 = 50;
				opt2 = 25;
				cutoff = 5;
				System.out.println("You chose Easy");
			}
			if (difficulty.equalsIgnoreCase("Hard")) {
				opt1 = 250;
				opt2 = 200;
				cutoff = 50;
				System.out.println("You chose Hard");
			} else {
				System.out.println("You chose Medium");
			}
			TimeUnit.SECONDS.sleep(1);
			System.out.println("What is " + r1 + " + " + r2 + "?");
			String s = myScanner.nextLine();
			if (s.equalsIgnoreCase("" + answer + "")) {
				System.out.println("You're correct!");
				score += 1;
			}
			if (s.equalsIgnoreCase("quit")) {
				System.exit(0);
			} else {
				System.out.println("The correct answer is " + answer);
			}
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Your current score is " + score);
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
