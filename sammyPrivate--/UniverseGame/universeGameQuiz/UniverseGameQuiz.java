package universeGameQuiz;

import javax.swing.JOptionPane;

public class UniverseGameQuiz {
	static int score = 0;

	public void run() {

		questionx("What is the capital of the ECF? (format: city, planet)", "Sylvonia City, Sylvonia");

		{
			String[] options1 = { "Dragon and Panda", "Dragon and Snake", "Dragon, Panda, and Lizard",
					"Dragon, Panda, and Snake", "Panda, Iguana, and Lizard", "Snake, Lizard, and Dragon" };
			int counter = 0;
			boolean repeat = true;
			while (repeat) {
				int opt1 = JOptionPane.showOptionDialog(null, "Which animals were combined to create the drantee?",
						"Universe game quiz", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null,
						options1, 0);
				if (opt1 == 3) {
					JOptionPane.showMessageDialog(null, "You're correct!");
					repeat = false;
				} else {
					JOptionPane.showMessageDialog(null, "Try again!");
				}
			}
		}
		questionx("Who was the first prime minister of the Fox Kingdom?", "Isaac Finnegan Frederick");
		questionx("What is the drantees' specialty?", "Military");
		questionx("Who was the first drantee chancellor of the DR1", "Draton Yinyee Ozolok");
		{
			String[] options1 = { "Earth", "Foxoux", "Sylvonia", "Drantoox", "Enchantia", "Revelonia" };
			int counter = 0;
			boolean repeat = true;
			while (repeat) {
				int opt1 = JOptionPane.showOptionDialog(null, "Where did the foxes originate?", "Universe game quiz",
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options1, 0);
				if (opt1 == 0) {
					JOptionPane.showMessageDialog(null, "You're correct!");
					repeat = false;
				} else {
					JOptionPane.showMessageDialog(null, "Try again!");
				}
			}
		}
		
		questionx("What's the most advanced Drantese warship?", "DDF Lasagna");

	}

	private static boolean questionx(String question, String correctAnswer) {
		boolean isCorrect = false;
		boolean repeat1 = true;
		int counter1 = 0;
		while (repeat1) {
			String opt1 = JOptionPane.showInputDialog(question);
			if (opt1.equalsIgnoreCase(correctAnswer)) {
				JOptionPane.showMessageDialog(null, "You're correct!");
				isCorrect = true;
				repeat1 = false;
				score += 1;
			} else if (opt1.equalsIgnoreCase("skip")) {
				repeat1 = false;
			} else if (opt1.equalsIgnoreCase("quit")) {
				System.exit(0);
			} else {
				counter1 += 1;
				if (counter1 < 5) {
					JOptionPane.showMessageDialog(null, "Incorrect! Try again.");
				} else if (counter1 <= 5) {
					JOptionPane.showMessageDialog(null, "Incorrect! The correct answer is " + correctAnswer + ".");
					repeat1 = false;
				}
			}

		}
		return (isCorrect);
	}
	
}