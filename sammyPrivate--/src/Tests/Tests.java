package Tests;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tests {	
	public void run()	{
		
	}
	public static void main(String[] args) {
		JCheckBox x = new JCheckBox("hello");
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		p.add(x);
		f.add(p);
		f.setVisible(true);
		f.pack();
	}
	
}
