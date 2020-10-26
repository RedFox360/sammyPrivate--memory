package daddy;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
@SuppressWarnings("unused")
public class Daddys_challenge {

	public static void main(String[] args) {
		//Have a user write something using input("");, and then print it to the console.
		//In Java, every line of code must have a semicolon (;) after it. for example: print(); and message();
		
		//print("Carrots");
		//Remove the comments on line 12 to see how the print method works.
		
		//String string = input("Type something here");
		//print(string);
		//Remove the comments on lines 16 and 17 to see how the input method works.
		
		//message("Hello");
		//Remove the comments on line 20 to see how the message method works.
		
		//int r = random(12, 23);
		//printi(r);
		//Remove the comments on lines 23 and 24 to generate a random number between 12 and 23.

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	//DO NOT CHANGE ANYTHING BELOW THIS COMMENT
	
	
	private static void longSleep(int seconds) throws InterruptedException	{
		TimeUnit.SECONDS.sleep(seconds);
	}
	private static void sleep(int milliseconds) throws InterruptedException	{
		TimeUnit.MILLISECONDS.sleep(milliseconds);
	}
	private static String input(String words) {
		Scanner myObj = new Scanner(System.in);
		System.out.println(words);
		String s = myObj.nextLine();
		return (s);
	}

	private static void printArray(String[] array, int x) {
		System.out.println(array[x - 1]);

	}
	
	private Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
	private static JFrame JText(String words) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		label.setText(words);
		frame.add(panel);
		frame.add(label);
		frame.setSize(100, 100);
		frame.pack();
		return (frame);
	}

	private static void printonloop(String words, int numberoftimes) {
		for (int i = 0; i < numberoftimes; i++) {
			System.out.println(words);
		}
	}

	private static boolean question(String questionS, String answer) {
		String a = JOptionPane.showInputDialog("" + questionS + "");
		boolean b1;
		if (a.equalsIgnoreCase(answer)) {
			JOptionPane.showMessageDialog(null, "You're correct!");
			b1 = true;
		} else {
			message("Sorry, but the correct answer is " + answer + ".");
			b1 = false;
		}
		return (b1);
	}

	private static boolean question2(String questionS, String option1, String option2, String correctanswerS,
			int correctanswer) {
		boolean iscorrect;
		String[] options = { "A) " + option1 + "", "B) " + option2 + "" };
		int optiont = JOptionPane.showOptionDialog(null, questionS, "Choose an answer", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if (optiont == correctanswer+1) {
			JOptionPane.showMessageDialog(null, "You're correct!");
			iscorrect = true;
		} else {
			JOptionPane.showMessageDialog(null, "The correct answer is " + correctanswerS);
			iscorrect = false;
		}

		return (iscorrect);
	}

	private static boolean question3(String questionS, String option1, String option2, String option3,
			String correctanswerS, int correctanswer) {
		boolean iscorrect;
		String[] options = { "A) " + option1 + "", "B) " + option2 + "", "C) " + option3 + "" };
		int optiont = JOptionPane.showOptionDialog(null, questionS, "Choose an answer", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if (optiont == correctanswer+1) {
			JOptionPane.showMessageDialog(null, "You're correct!");
			iscorrect = true;
		} else {
			JOptionPane.showMessageDialog(null, "The correct answer is " + correctanswerS);
			iscorrect = false;
		}

		return (iscorrect);
	}

	private static boolean question4(String questionS, String option1, String option2, String option3, String option4,
			String correctanswerS, int correctanswer) {
		boolean iscorrect;
		String[] options = { "A) " + option1 + "", "B) " + option2 + "", "C) " + option3 + "", "D) " + option4 + "" };
		int optiont = JOptionPane.showOptionDialog(null, questionS, "Choose an answer", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if (optiont == correctanswer+1) {
			JOptionPane.showMessageDialog(null, "You're correct!");
			iscorrect = true;
		} else {
			JOptionPane.showMessageDialog(null, "The correct answer is " + correctanswerS);
			iscorrect = false;
		}
		return (iscorrect);
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

	private static void printn(String words) {
		System.out.print(words);
	}

	private static void printchar(char letter) {
		System.out.println(letter);
	}

	private static void message(String words) {
		JOptionPane.showMessageDialog(null, words);
	}

	private static String paneinput(String words) {
		String example = JOptionPane.showInputDialog(words);
		return (example);
	}

	private static int random(int r1, int r2) {
		Random r = new Random();
		int rsan = r.nextInt(r2 - r1 + 1) + r1;
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

	private static String intToString(int x) {
		String string = "" + x + "";
		return (string);
	}

	private static void helloWorld() {
		System.out.println("Hello World");
	}

	private static int intPrint(int integer) {
		System.out.println(integer);
		return (integer);
	}

	private static String stringPrint(String words) {
		System.out.println(words);
		return (words);
	}

	private static String string() {
		String x = new String();
		return (x);
	}
}