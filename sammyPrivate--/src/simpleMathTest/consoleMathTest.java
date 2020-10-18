package simpleMathTest;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class consoleMathTest {
	public static void main(String[] args) throws InterruptedException {
		int score = 0;
		
			Random r = new Random();
			int opt1 = 100;
			int opt2 = 50;
			int cutoff = 20;
			
			
			@SuppressWarnings("resource")
			Scanner myScanner = new Scanner(System.in);
			boolean repeat = true;
			while(repeat)	{
			System.out.println("Choose your difficulty: Easy, Medium, or Hard");
			String difficulty = myScanner.nextLine();
			if (difficulty.equalsIgnoreCase("Easy")) {
				repeat =false;
				opt1 = 50;
				opt2 = 25;
				cutoff = 5;
				System.out.println("You chose Easy");
			}
			else if (difficulty.equalsIgnoreCase("Hard")) {
				repeat = false;
				opt1 = 250;
				opt2 = 200;
				cutoff = 50;
				System.out.println("You chose Hard");
			} else if(difficulty.equalsIgnoreCase("Medium")) {
				repeat = false;
				System.out.println("You chose Medium");
			}
			else	{
				System.out.println("Type in a valid argument");
			}
			}
			for (int i = 0; i < 2000000000; i++) {
			int r1 = r.nextInt(opt1 - cutoff + 1) + cutoff;
			int r2 = r.nextInt(opt2 - cutoff + 1) + cutoff;
			int answer = r1 + r2;
			TimeUnit.SECONDS.sleep(1);
			System.out.println("What is " + r1 + " + " + r2 + "?");
			String s = myScanner.nextLine();
			if (s.equalsIgnoreCase("" + answer + "")) {
				System.out.println("You're correct!");
				score++;
			}
			else if (s.equalsIgnoreCase("quit")) {
				System.out.println("Operation succesful");
				System.exit(0);
			} else {
				System.out.println("The correct answer is " + answer);
				score--;
			}
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Your current score is " + score);
			TimeUnit.SECONDS.sleep(1);
		}
			
	}
}
