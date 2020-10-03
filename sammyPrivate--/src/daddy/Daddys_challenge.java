package daddy;

import javax.swing.JOptionPane;

import java.util.Random;
@SuppressWarnings("unused")
public class Daddys_challenge {

	public static void main(String[] args) {
		//Have a user write something using input("");, and then print it to the console.
		//In Java, every line of code must have a semicolon (;) after it. for example: print(); and message();
		
		//print("Carrots");
		//Remove the comments on line 12 to see how the print method works.
		
		//String string = input("Type something here");
		//print(string + string);
		//Remove the comments on lines 16 and 17 to see how the input method works.
		
		//message("Hello");
		//Remove the comments on line 20 to see how the message method works.
		
		//int r = random(12, 23);
		//printi(r);
		//Remove the comments on lines 23 and 24 to generate a random number between 12 and 23.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	//DO NOT CHANGE ANYTHING BELOW THIS COMMENT
	
	
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
	private static boolean question3(String questionS, String option1, String option2, String option3, String answer, String answerletter)	{
		String a = input("" + questionS+ "" + '\n' + "A) " + option1 + "" + '\n' + "B) " + option2 + " " + '\n'
				+ "C) " + option3 + " " + '\n' + "");
		boolean b1 = isequalto2(a, answer, answerletter);
		if (b1) {
			message("You're correct!");
		} else {
			message("The correct answer is " + answer);
		}
		return(b1);
	}
	private static boolean question4(String questionS, String option1, String option2, String option3, String option4, String answer, String answerletter)	{
		String a = input("" + questionS+ "" + '\n' + "A) " + option1 + "" + '\n' + "B) " + option2 + " " + '\n'
				+ "C) " + option3 + " " + '\n' + "D) " + option4 + "");
		boolean b1 = isequalto2(a, answer, answerletter);
		if (b1) {
			message("You're correct!");
		} else {
			message("The correct answer is " + answer);
		}
		return(b1);
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
 