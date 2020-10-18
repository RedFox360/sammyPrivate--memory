package universeGame;

import javax.swing.JOptionPane;

public class ChagraesDozks {
	public static void main(String[] args) {
		boolean repeat = true;
		while(repeat)	{
		String[] options = {"Chagraes Dozks", "Voltron", "Drantoox", "Foxoux", "Bottleog", "Chixcocoff Prime", "Blugerboi"};
		int opt = JOptionPane.showOptionDialog(null, "Where will the drantees attack the Choockchooxens?", null, JOptionPane.INFORMATION_MESSAGE, 
				JOptionPane.INFORMATION_MESSAGE, null, options, 0);
		if(opt==0) {
			JOptionPane.showMessageDialog(null, "You're correct!");
			repeat=false;
		}
		if(opt==3)	{
			JOptionPane.showMessageDialog(null, "What are you? A weird person?");
		}
		if(opt==2) {
			JOptionPane.showMessageDialog(null, "Did you misunderstand the question?");
		}
		if(opt==1) {
			JOptionPane.showMessageDialog(null, "Do you know your geography?");
		}
		if(opt == 4 || opt == 5 || opt == 6)	{
			JOptionPane.showMessageDialog(null, "Good guess, but the drantee bantees say no.");
		}
		}
	}
}
