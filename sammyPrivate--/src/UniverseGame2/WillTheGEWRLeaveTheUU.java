package UniverseGame2;

import java.net.URI;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WillTheGEWRLeaveTheUU {

	public static void main(String[] args) {
		boolean repeat = true;
		while (repeat) {
			String[] options = { "Yes", "No" };
			int opt = JOptionPane.showOptionDialog(null, "Will the GEWR leave the UU?", null,
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
			if (opt == 0) {
				JOptionPane.showMessageDialog(null,
						"The drantees won't do that! (They are scared that the ECF won't give them any money *giggles*)");
			}
			if (opt == 1) {
				JOptionPane.showMessageDialog(null, "Correct, drantee bantee!");
				repeat = false;
			}
		}
	}
}
