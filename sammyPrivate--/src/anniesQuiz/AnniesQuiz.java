package anniesQuiz;

import java.util.Random;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class AnniesQuiz {

	public void run() {

		int score = 0;
		
		boolean b1 = question3("The capital of California is...", "San Francisco", "Los Angeles", "Sacramento", "Sacramento", 2); if(b1)	{score+=1;}
		boolean b2 = question("Which year did America gain its independence?", "1776"); if(b2)	{score+=1;}
		int r1 = random(10, 100);
		int r2 = random(10, 40);
		int answer = r1+r2;
		String answerS = "" + answer + "";
		boolean b3 = question("What is " + r1 + " + " + r2 + "?", answerS); if(b3)	{score+=1;}
		boolean b4 = question4("Which type of triangle has all sides equal?", "Isosceles", "Equilateral", "Scalene", "Right", "Equilateral", 1); if(b4)	{score+=1;}
		message("You got " + score + " out of 4 questions correct.");
	
		
	
		
		
		
		
		
		
		
		
		
		
	}
	private static boolean question(String questionS, String answer)	{
		String a = input("" + questionS+ "");
		boolean b1 = isequalto(a, answer);
		if (b1) {
			message("You're correct!");
		} else {
			message("The correct answer is " + answer);
		}
		return(b1);
	}
	private static boolean question3(String questionS, String option1, String option2, String option3, String correctanswerS, int correctanswer)	{
		boolean iscorrect;
		String[] options = {"A) " + option1 +"", "B) " + option2 + "", "C) " + option3 + ""};
		int optiont = JOptionPane.showOptionDialog(null, questionS,
		"Choose an answer",
		JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if(optiont==correctanswer) {
			message("You're correct!");
			iscorrect=true;
			}
		else	{
			message("The correct answer is " + correctanswerS );
			iscorrect=false;
		}
		
		return(iscorrect);
	}
	private static boolean question4(String questionS, String option1, String option2, String option3, String option4, String correctanswerS, int correctanswer)	{
		boolean iscorrect;
		String[] options = {"A) " + option1 +"", "B) " + option2 + "", "C) " + option3 + "", "D) " + option4 + ""};
		int optiont = JOptionPane.showOptionDialog(null, questionS,
		"Choose an answer",
		JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if(optiont==correctanswer) {
			message("You're correct!");
			iscorrect=true;
			}
		else	{
			message("The correct answer is " + correctanswerS );
			iscorrect=false;
		}
		return(iscorrect);
	}

	private static boolean isequalto(String words, String check) {
		boolean equals;
		if (words.equalsIgnoreCase(check)) {
			equals = true;
		} else {
			equals = false;
		}
		return (equals);
	}

	private static boolean isequalto2(String words, String check1, String check2) {
		boolean equals;
		if (words.equalsIgnoreCase(check1)) {
			equals = true;
		} else if (words.equalsIgnoreCase(check2)) {
			equals = true;
		} else {
			equals = false;
		}
		return (equals);
	}

	private static void print(String words) {
		System.out.println(words);
	}

	private static void printi(int integer) {
		System.out.println("" + integer + "");
	}

	private static void printd(double number) {
		System.out.println(number);
	}

	private static void printf(String words) {
		System.out.print(words);
	}

	private static void printchar(char letter) {
		System.out.println(letter);
	}

	private static void message(String words) {
		JOptionPane.showMessageDialog(null, words);
	}

	private static String input(String words) {
		String example = JOptionPane.showInputDialog(words);
		return (example);
	}

	private static int random(int r1, int r2) {
		Random r = new Random();
		int rsan = r.nextInt(r2 - r1) + r1;
		return (rsan);
	}

	private static int toInt(String words) {
		int example = Integer.parseInt(words);
		return (example);
	}

	private static double toDouble(String words) {
		double example = Double.parseDouble(words);
		return (example);
	}

	private static char charAt(String words, int x) {
		char example = words.charAt(x - 1);
		return (example);
	}

	private static void exit() {
		System.exit(0);
	}

	private static double addp(double x, double y) {
		double answer = x + y;
		System.out.println(answer);
		return (answer);
	}

	private static double multiplyp(double x, double y) {
		double answer = x * y;
		System.out.println(answer);
		return (answer);
	}

	private static double subtractp(double x, double y) {
		double answer = x - y;
		System.out.println(answer);
		return (answer);
	}

	private static double dividep(double x, double y) {
		double answer = x / y;
		System.out.println(answer);
		return (answer);
	}

	private static double exponentsp(double x, double y) {
		double answer = Math.pow(x, y);
		System.out.println(answer);
		return (answer);
	}
}
