package Tests;

import java.math.BigDecimal;
import java.util.Scanner;

public class Tests {	
	public void run()	{
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int answer;
		System.out.println("What is 2 + 2?");
		answer = scan.nextInt();
		if(answer==4) {
			System.out.println("Correct!");
		}
		else	{
			System.out.println("Seriously, how did you get that wrong?");
		}
	}
	
}
