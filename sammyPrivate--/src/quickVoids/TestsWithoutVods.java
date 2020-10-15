package quickVoids;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class TestsWithoutVods {

	public static void main(String[] args) throws InterruptedException {
		int score = 0;
		for (int i = 0; i < 100; i++) {
		Random r = new Random();
		int r1 = r.nextInt(100-20+1)+20;
		int r2 = r.nextInt(50-20+1)+20;
		int answer = r1+r2;
		Scanner myScanner = new Scanner(System.in);
		System.out.println("What is " + r1 + " + " + r2 + "?");
		String s = myScanner.nextLine();
		if(s.equalsIgnoreCase("" + answer + ""))	{
			System.out.println("You're correct!");
			score+=1;
		}
		if(s.equalsIgnoreCase("quit")) {
			System.exit(0);
		}
		else	{
			System.out.println("The correct answer is " + answer);
		}
		}
	}
}
 