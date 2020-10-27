package jTextInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String answerInAllMethods;
	JTextField textfield1 = new JTextField("", 20);
	String givenAnswer;

	public void run() {
		question("test name", "test");
	}

	void question(String question, String answer) {
		label.setText(question);
		answerInAllMethods = answer;
		panel.add(textfield1);
		panel.add(label);
		panel.add(button3);
		panel.add(button1);
		panel.add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		textfield1.addActionListener(this);
		frame.add(panel);
		frame.setSize(500, 80);
		button1.setText("Skip");
		button2.setText("Quit");
		button3.setText("Submit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button3) {
			givenAnswer = textfield1.getText();
				if (givenAnswer.equals(answerInAllMethods)) {
					label.setText("You're correct!");
					frame.pack();
				} else	{
					label.setText("Try again!");
					frame.pack();
				}
			
		}
		if (e.getSource() == button1) {
			givenAnswer=answerInAllMethods;
		}
		if (e.getSource() == button2) {
			System.exit(0);
		}

	}
}
