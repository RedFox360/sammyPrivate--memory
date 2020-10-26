package _02_Random_Questions;

import javax.swing.JOptionPane;

public class PrimeMinister {

	public static void main(String[] args) {
		boolean repeat = true;
		while(repeat)	{
		String x = JOptionPane.showInputDialog("Where does the prime minister of the ECF live?");
		if(x.equalsIgnoreCase("14 Wellice Street, Sylvonia City"))	{
			repeat=false;
			JOptionPane.showMessageDialog(null, "You're correct!");
		}
		else if(x.equalsIgnoreCase("quit"))	{
			System.exit(0);
		}
		else if(x.equalsIgnoreCase("correct answer"))	{
			JOptionPane.showMessageDialog(null, "The correct answer is 14 Wellice Street, Sylvonia City");
			repeat=false;
		}
		else	{
			JOptionPane.showMessageDialog(null, "Try again.");
		}
		}

	}

}
