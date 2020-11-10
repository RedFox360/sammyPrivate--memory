package jTextInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JTextInput implements ActionListener {
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton exit = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("i");
	String answerInAllMethods;
	JTextField textfield1 = new JTextField("", 20);
	boolean continueB = true;
	String givenAnswer;
	static int score = 0;
	int counter = 0;
	static Random r;
	int r1;
	int r2;
	String answerToS;
	int answerToMath;
	public void run() {
		exit.addActionListener(this);
		r = new Random();
		r1 = r.nextInt(200-50+1)+50;
		r2 = r.nextInt(200-5+1)+50;
		answerToMath = r1+r2;
		answerInAllMethods = "" + answerToMath;
		for(int i = 0; i < 10; i++)	{
		continueB=true;
		question("What is " + r1 + " + " + r2 + "?", answerToS);
		}
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
	JLabel label1 = new JLabel("Your final score is " + score);
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button3) {
			givenAnswer = textfield1.getText();
			if (givenAnswer.equalsIgnoreCase(answerToS)) {
				continueB = false;
				score+=1;
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
