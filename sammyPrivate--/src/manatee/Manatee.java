package manatee;

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Manatee {
	public void run() throws Exception {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String manateeImageURL = "https://s.abcnews.com/images/US/gty_manatee_jc_140626_4x3_992.jpg";
		Component manateeImageComp = createImage(manateeImageURL);
		frame.add(manateeImageComp);
		frame.pack();
		frame.setTitle("Manatee");
	}

	private Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
}
