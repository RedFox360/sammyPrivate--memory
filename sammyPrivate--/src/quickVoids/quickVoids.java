package quickVoids;

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class quickVoids {


	public static void main(String[] args) throws InterruptedException {
		double x = 3.526030620502040200530;
		double rounded = round(x, 4);
		System.out.println(rounded);
	}

	 static boolean primeOrNot(int prime) {
		boolean primeOrNot;
		for (int i = 2; i < prime; i++) {
			if (prime % i == 0) {
				primeOrNot = false;
			}
		}
		primeOrNot = true;
		return (primeOrNot);
	}
	 static double round(double number, double decimalPlace)	{
		double toBeMultiplied = Math.pow(10, decimalPlace);
		number*=toBeMultiplied;
		number = Math.round(number);
		number/=toBeMultiplied;
		return(number);
	}
	 static void longSleep(int seconds) throws InterruptedException	{
		TimeUnit.SECONDS.sleep(seconds);
	}
	 static void sleep(int milliseconds) throws InterruptedException	{
		TimeUnit.MILLISECONDS.sleep(milliseconds);
	}
	 static String input(String words) {
		Scanner myObj = new Scanner(System.in);
		System.out.println(words);
		String s = myObj.nextLine();
		return (s);
	}

	 static void printArray(String[] array, int x) {
		System.out.println(array[x - 1]);

	}
	
	 Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
	 static JFrame JText(String words) {
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

	 static void printonloop(String words, int numberoftimes) {
		for (int i = 0; i < numberoftimes; i++) {
			System.out.println(words);
		}
	}

	 static boolean question(String title, String answer) {
		String a = JOptionPane.showInputDialog("" + title + "");
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

	 static boolean question2(String title, String option1, String option2, String stringCorrectAnswer,
			int correctanswer) {
		boolean iscorrect;
		String[] options = { "A) " + option1 + "", "B) " + option2 + "" };
		int optiont = JOptionPane.showOptionDialog(null, title, "Choose an answer", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if (optiont == correctanswer) {
			JOptionPane.showMessageDialog(null, "You're correct!");
			iscorrect = true;
		} else {
			JOptionPane.showMessageDialog(null, "The correct answer is " + stringCorrectAnswer);
			iscorrect = false;
		}

		return (iscorrect);
	}

	 static boolean question3(String title, String option1, String option2, String option3,
			String stringCorrectAnswer, int correctanswer) {
		boolean iscorrect;
		String[] options = { "A) " + option1 + "", "B) " + option2 + "", "C) " + option3 + "" };
		int optiont = JOptionPane.showOptionDialog(null, title, "Choose an answer", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if (optiont == correctanswer) {
			JOptionPane.showMessageDialog(null, "You're correct!");
			iscorrect = true;
		} else {
			JOptionPane.showMessageDialog(null, "The correct answer is " + stringCorrectAnswer);
			iscorrect = false;
		}

		return (iscorrect);
	}

	 static boolean question4(String title, String option1, String option2, String option3, String option4,
			String stringCorrectAnswer, int correctanswer) {
		boolean iscorrect;
		String[] options = { "A) " + option1 + "", "B) " + option2 + "", "C) " + option3 + "", "D) " + option4 + "" };
		int optiont = JOptionPane.showOptionDialog(null, title, "Choose an answer", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if (optiont == correctanswer) {
			JOptionPane.showMessageDialog(null, "You're correct!");
			iscorrect = true;
		} else {
			JOptionPane.showMessageDialog(null, "The correct answer is " + stringCorrectAnswer);
			iscorrect = false;
		}
		return (iscorrect);
	}

	 static boolean isequalto(String words, String check) {
		boolean equals;
		if (words.equalsIgnoreCase(check)) {
			equals = true;
		} else {
			equals = false;
		}
		return (equals);
	}

	 static boolean isequalto2(String words, String check1, String check2) {
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

	 static void print(String words) {
		System.out.println(words);

	}

	 static void printi(int integer) {
		System.out.println("" + integer + "");
	}

	 static void printd(double number) {
		System.out.println(number);
	}

	 static void printn(String words) {
		System.out.print(words);
	}

	 static void printchar(char letter) {
		System.out.println(letter);
	}

	 static void message(String words) {
		JOptionPane.showMessageDialog(null, words);
	}

	 static String paneinput(String words) {
		String example = JOptionPane.showInputDialog(words);
		return (example);
	}

	 static int random(int r1, int r2) {
		Random r = new Random();
		int rsan = r.nextInt(r2 - r1 + 1) + r1;
		return (rsan);
	}

	 static int toInt(String words) {
		int example = Integer.parseInt(words);
		return (example);
	}

	 static double toDouble(String words) {
		double example = Double.parseDouble(words);
		return (example);
	}

	 static char charAt(String words, int x) {
		char example = words.charAt(x - 1);
		return (example);
	}

	 static void exit() {
		System.exit(0);
	}

	 static double addp(double x, double y) {
		double answer = x + y;
		System.out.println(answer);
		return (answer);
	}

	 static double multiplyp(double x, double y) {
		double answer = x * y;
		System.out.println(answer);
		return (answer);
	}

	 static double subtractp(double x, double y) {
		double answer = x - y;
		System.out.println(answer);
		return (answer);
	}

	 static double dividep(double x, double y) {
		double answer = x / y;
		System.out.println(answer);
		return (answer);
	}

	 static double exponentsp(double x, double y) {
		double answer = Math.pow(x, y);
		System.out.println(answer);
		return (answer);
	}

	 static String intToString(int x) {
		String string = "" + x + "";
		return (string);
	}

	 static void helloWorld() {
		System.out.println("Hello World");
	}

	 static int intPrint(int integer) {
		System.out.println(integer);
		return (integer);
	}

	 static String stringPrint(String words) {
		System.out.println(words);
		return (words);
	}

	 static String string() {
		String x = new String();
		return (x);
	}
	
	

}
