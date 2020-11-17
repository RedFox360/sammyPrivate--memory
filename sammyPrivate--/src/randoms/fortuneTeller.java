package randoms;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class fortuneTeller {
	public static void main(String[] args) {
		String[] spiritAnimal = { "Octopus", "Dog", "Cat", "Snake", "Robin", "Lizard", "Giraffe", "Elephant", "Lion",
				"Tiger", "Butterfly", "Moth", };
		// 12 options
		int r1;
		int r2;
		String[] coloroptions1 = { "Red", "Orange", "Lime", "Blue", "Magenta", };
		String[] coloroptions2 = { "Yellow", "Green", "Cyan", "Purple", "Pink" };

		int opt1 = JOptionPane.showOptionDialog(null, "Choose a color", "Find your spirit animal",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, coloroptions1, 0);
		if (opt1 == 0 || opt1 == 2) {
			r1 = 4;
		} else {
			r1 = 3;
		}
		String[] tasteoptions = { "Sweet", "Salty", "Sour", "Spicy", };
		String[] foodoptions = { "Chinese", "Indian", "Italian", "Japanese", };
		int opt2 = JOptionPane.showOptionDialog(null, "Choose another color", "Find your spirit animal",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, coloroptions2, 0);
		if (opt2 == 0 || opt1 == 3) {
			r2 = 7;
			int opt3 = JOptionPane.showOptionDialog(null, "Choose a type of food", "Find your spirit animal",
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, tasteoptions, 0);
			if (opt3 == 0 || opt3 == 1) {
				r1 = 2;
			}

		} else {
			int opt4 = JOptionPane.showOptionDialog(null, "Choose a type of food", "Find your spirit animal",
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, foodoptions, 0);

			r2 = 11;
			if (opt4 == 3) {
				r1 = 1;
			}
		}
		int random = new Random().nextInt(r2 - r1 + 1) + r1;
		String spiritAnimalAnswer = spiritAnimal[random];
		JOptionPane.showMessageDialog(null, "Your spirit animal is " + spiritAnimalAnswer + ".");
	}

}
