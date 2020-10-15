package simpleMathTest;

import java.util.Random;

import javax.swing.JOptionPane;

public class MathDialog {
	public static void main(String[] args) {
		int opt1 = 0;
		int opt2 = 0;
		int cutoff = 0;
		String[] options = { "Easy", "Medium", "Hard" };
		int opt = JOptionPane.showOptionDialog(null, "Choose a difficulty", "Choose a difficulty",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
		if (opt == 0) {
			JOptionPane.showMessageDialog(null, "You chose difficulty easy");
			opt1 = 50;
			opt2 = 25;
			cutoff = 10;
		}
		if (opt == 1) {
			JOptionPane.showMessageDialog(null, "You chose difficulty medium");
			opt1 = 100;
			opt2 = 60;
			cutoff = 10;
		}
		if (opt == 2) {
			JOptionPane.showMessageDialog(null, "You chose difficulty hard");
			opt1 = 250;
			opt2 = 150;
			cutoff = 75;
		}
		Random r = new Random();
		for (int i = 0; i < options.length; i++) {
			int r1 = r.nextInt(opt1 - cutoff + 1) + cutoff;
			int r2 = r.nextInt(opt2 - cutoff + 1) + cutoff;
			int answer = r1 + r2;
			String a = JOptionPane.showInputDialog(null, "What is " + r1 + " + " + r2 + "?");
			String answers = "" + answer + "";
			if (a.equalsIgnoreCase(answers)) {
				JOptionPane.showMessageDialog(null, "You're correct!");
			}
			else if (a.equalsIgnoreCase("quit")) {
				System.exit(0);
			} 
			else {
				JOptionPane.showMessageDialog(null, "The correct answer is " + answers);
			}
		}

	}
}
