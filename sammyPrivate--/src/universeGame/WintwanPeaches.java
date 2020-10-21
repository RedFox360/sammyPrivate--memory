package universeGame;

import javax.swing.JOptionPane;

public class WintwanPeaches {
public static void main(String[] args) {
	String[] options = {"Yes", "No"};
	int opt = JOptionPane.showOptionDialog(null, "Should the GEWR sanction the foxes on Wintwan Peaches?", null, JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
	if(opt == 0)	{
		JOptionPane.showMessageDialog(null, "I'll think about it.");
	}
	if(opt == 1)	{
		JOptionPane.showMessageDialog(null, "Nah, I'll do it. JUST KIDDING GOTCHA!");
	}
}
}
