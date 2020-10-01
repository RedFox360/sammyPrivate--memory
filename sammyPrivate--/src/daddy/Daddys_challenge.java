package daddy;

import javax.swing.JOptionPane;

import java.util.Random;
@SuppressWarnings("unused")
public class Daddys_challenge {

	public static void main(String[] args) {
		//Have a user write something using input("");, and then print it to the console.
		//In Java, every line of code must have a semicolon (;) after it. for example: print(); and message();
		
		//print("Carrots");
		//Remove the comments on line 12 to see how the print method works.
		
		//String string = input("Type something here");
		//print(string + string);
		//Remove the comments on lines 16 and 17 to see how the input method works.
		
		//message("Hello");
		//Remove the comments on line 20 to see how the message method works.
		
		//int r = random(12, 23);
		//printi(r);
		//Remove the comments on lines 23 and 24 to generate a random number between 12 and 23.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	//DO NOT CHANGE ANYTHING BELOW THIS COMMENT
	
	
	private static void print(String words)	{
		System.out.println(words);
	}

	private static void printi(int words) {
		System.out.println("" + words + "");
	}
	private static void printf(String words)	{
		System.out.print(words);
	}
	private static void printchar(char letter)	{
		System.out.println(letter);
	}
	private static void message(String words)	{
		JOptionPane.showMessageDialog(null, words);
	}
	private static String input(String words) {
		String example = JOptionPane.showInputDialog(words);
		return(example);
	}
	private static int random(String random1, String random2) {
		Random r = new Random();
		int r1 = Integer.parseInt(random1);
		int r2 = Integer.parseInt(random2);
		int rsan = r.nextInt(r2 - r1) + r1;
		return(rsan);
	}
	private static int toInt(String words)	{
		int example = Integer.parseInt(words);
		return(example);
	}
	private static double toDouble(String words)	{
		double example = Double.parseDouble(words);
		return(example);
	}
	private static char charAt(String words, int x)	{
		char example = words.charAt(x-1);
		return(example);
	}
	private static void exit()	{
		System.exit(0);
	}
}
 