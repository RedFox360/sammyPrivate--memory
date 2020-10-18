package universeGame;

import javax.swing.JOptionPane;

public class WhyDidTheChookChooxensAttackFirst {

	public static void main(String[] args) {
		boolean repeat = true;
		while (repeat) {
			String[] options = { "They were sad", "They were mad", "They thought the GEWR would attack first." };
			int opt = JOptionPane.showOptionDialog(null, "Why did the Choockchooxens attack first?", null,
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
			if (opt == 0) {
				JOptionPane.showMessageDialog(null, "Your ignorance makes me so sad. Try again.");
			}
			if (opt==1) {
				JOptionPane.showMessageDialog(null, "If you keep getting this wrong, I'll be mad.");
			}
			if(opt==2) {
				repeat=false;
				JOptionPane.showMessageDialog(null, "We'll make a diplomat out of you yet.");
			}
		}
	}
}
