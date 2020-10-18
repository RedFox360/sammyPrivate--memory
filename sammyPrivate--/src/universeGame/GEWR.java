package universeGame;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class GEWR {
	public static void main(String[] args) throws InterruptedException {
		boolean repeat = true;
		
		while(repeat) {
		String[] options = {"ECF", "Yiider Republic", "Vlooping Zebras", "Chookchooxen Confederation"};
		int opt = JOptionPane.showOptionDialog(null, "Who will the GEWR attack?", null, JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.INFORMATION_MESSAGE, null, options, 0);
		if(opt==0) {
			JOptionPane.showMessageDialog(null, "Try again");
		}
		if(opt==1)	{
			JOptionPane.showMessageDialog(null, "Try again");
		}
		if(opt==2)	{
			JOptionPane.showMessageDialog(null, "Come again tomorrow.");
		}
		if(opt==3)	{
			repeat=false;
			JOptionPane.showMessageDialog(null, "DING DING DING! Correct!");
		}
	
		}

	}
}
