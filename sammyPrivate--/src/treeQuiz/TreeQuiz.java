package treeQuiz;

import java.util.Scanner;

public class TreeQuiz {
	Scanner scan = new Scanner(System.in);
	String answer;
	boolean repeat = true;
	public void run() {
		while (repeat) {
		System.out.println("What is the tallest type of tree?");
		answer = scan.nextLine();
		
			if (answer.equalsIgnoreCase("Redwood")) {
				repeat = false;
				System.out.println("You're correct!");
				
			} else {
				System.out.println("Try again!");
			}
		}
	}

}
