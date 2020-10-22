package _01_UnitConverterWithButtons;

import java.net.URI;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImperialToMetricButtons implements ActionListener {
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();

	public void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setTitle("Imperial to metric converter");
		button1.setText("Feet to meters");
		button2.setText("Miles to kilometers");
		button3.setText("Pounds to kilograms");
		button4.setText("Gallons to liters");
		button5.setText("Fahrenheit to Celsius");
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.add(panel);
		frame.pack();
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			playSound("buttonClick.wav");
			convert(3.2808, "feet", "meters");
		}
		if (e.getSource() == button2) {
			playSound("buttonClick.wav");
			convert(1.6093, "miles", "kilometers");
		}
		if (e.getSource() == button3) {
			playSound("buttonClick.wav");
			convert(2.2046, "pounds", "kilograms");
		}
		if (e.getSource() == button4) {
			playSound("buttonClick.wav");
			convert(0.26417, "gallons", "liters");
		}
		if (e.getSource() == button5) {
			playSound("buttonClick.wav");
			String stringMeasurement = JOptionPane
					.showInputDialog("What is the temperature you would like to convert? (Fahrenheit)");
			double measurement = Double.parseDouble(stringMeasurement);
			double conversionMethod = 1.8;
			double answer = (measurement - 32) / conversionMethod;
			JOptionPane.showMessageDialog(null, "" + measurement + " degrees F is " + answer + " degrees C.");
		}
	}

	private void playSound(String soundFile) {
		try {
			AudioClip sound = JApplet.newAudioClip(getClass().getResource(soundFile));
			sound.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static double convert(double conversionMethod, String input, String output) {
		String stringMeasurement = JOptionPane.showInputDialog("How large is your measurement? (" + input + ")");
		double measurement = Double.parseDouble(stringMeasurement);
		double answer = measurement / conversionMethod;
		answer = answer * 100;
		answer = Math.round(answer);
		answer = answer / 100;
		JOptionPane.showMessageDialog(null, "" + measurement + " " + input + " is " + answer + " " + output + ".");
		return (answer);
	}
}
