package universeGameQuizJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UniverseGameQuizJ implements ActionListener {
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String answerInAllMethods;
	JTextField textfield1 = new JTextField("", 20);
	boolean continueB = true;
	String givenAnswer;
	static int score = 0;
	int counter = 0;

	public void run() {
		question("What is the capital of the ECF? (format: city, planet)", "Sylvonia City, Sylvonia");
		continueB = true;
		question("Who was the first prime minister of the Fox Kingdom?", "Isaac Finnegan Frederick");

		continueB = true;
		question("What is the drantees' specialty?", "Military");

		continueB = true;
		question("Who is the first Drantee Chancellor (DR1)", "Draton Yinyee Ozolok");

		panel.remove(button1);
		button2.setText("Exit");
		panel.remove(button3);
		panel.remove(textfield1);
		label.setText(
				"Answers: Question 1 - Sylvonia City, Sylvonia; Question 2: Isaac Finnegan Frederick; Question 3: Military; Question 4: Draton Yinyee Ozolok. Your final score is " + score);
		frame.pack();

	}

	void question(String question, String answer) {
		counter = 0;
		frame.setSize(575, 100);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		textfield1.addActionListener(this);
		panel.add(textfield1);
		panel.add(label);
		panel.add(button3);
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		while (continueB) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			button1.setText("Skip");
			button2.setText("Quit");
			button3.setText("Submit");

			label.setText(question);
			answerInAllMethods = answer;

			frame.setVisible(true);
		}
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button3) {
			givenAnswer = textfield1.getText();
			if (givenAnswer.equalsIgnoreCase(answerInAllMethods)) {

				frame.setSize(575, 100);

				frame.pack();
				score+=1;
				continueB = false;
			} else if (counter < 5) {

				frame.setSize(575, 100);
				frame.pack();
				counter += 1;
			} else {
				label.setText("The correct answer is " + answerInAllMethods);
				frame.setSize(575, 100);

				frame.pack();

				continueB = false;
			}

		}
		if (e.getSource() == button1) {
			frame.pack();
			givenAnswer = answerInAllMethods;
			continueB = false;
		}
		if (e.getSource() == button2) {
			System.exit(0);
		}

	}

}
