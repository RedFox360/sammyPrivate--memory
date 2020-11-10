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
	JButton exit = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel(".initialize");
	String answerInAllMethods;
	JTextField textfield1 = new JTextField("", 20);
	boolean continueB = true;
	String givenAnswer;
	static int score = 0;
	int counter = 0;
	String type = "y";

	public void run() {
		exit.addActionListener(this);
		question("What is the capital of the ECF? (format: city, planet)", "Sylvonia City, Sylvonia");
		continueB = true;
		question("Who was the first prime minister of the Fox Kingdom?", "Isaac Finnegan Frederick");
		type = "military";
		continueB = true;
		question("What is the drantees' specialty?", "Military");
		type = "y";
		type = "Ozo";
		continueB = true;
		question("Who is the first Drantee Chancellor (DR1)", "Draton Yinyee Ozolok");
		continueB=true;
		question("What is the capital of the GEWR?", "Snatos");
		panel.remove(button1);
		panel.remove(button2);
		panel.remove(button3);
		panel.add(exit);
		exit.setText("Exit");
		panel.remove(textfield1);
		label.setText(
				"Answers: Question 1 - Sylvonia City, Sylvonia; Question 2: Isaac Finnegan Frederick; Question 3: Military; Question 4: Draton Yinyee Ozolok."
				+ "Question 5: Snatosz");

		frame.setSize(800, 100);
		frame.pack();

	}

	void question(String question, String answer) {
		counter = 0;
		if (type.equals("military")) {
			frame.setSize(450, 100);
		} else if (type.equals("Ozo")) {
			frame.setSize(500, 100);
		} else {
			frame.setSize(575, 100);
		}
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
	JLabel label1 = new JLabel("Your final score is " + score);
	JLabel youreCorrect = new JLabel("You're correct!");
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button3) {
			givenAnswer = textfield1.getText();
			if (givenAnswer.equalsIgnoreCase(answerInAllMethods)) {
				continueB = false;
			} else if (counter < 5) {
				counter += 1;
			} else {
				continueB = false;
			}
			

		}
		if (e.getSource() == button1) {
			frame.pack();
			givenAnswer = answerInAllMethods;
			continueB = false;
		}
		
		if (e.getSource() == button2) {
			panel.remove(label);
			panel.add(label1);
			frame.setSize(400, 100);
			panel.remove(button1);
			panel.remove(button2);
			panel.remove(button3);
			panel.remove(textfield1);
			panel.add(exit);
			exit.setText("Exit");
			frame.pack();
		}
		if(e.getSource()==exit)	{
			System.exit(0);
		}

	}

}
