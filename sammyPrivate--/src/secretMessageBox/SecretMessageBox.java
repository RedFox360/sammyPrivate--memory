package secretMessageBox;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;
public class SecretMessageBox {
	int auth = new Random().nextInt(999999-100000+1)+100000;
	String password;
	String secretMessage;
	String passwordGuess;
	String authGuess;
	int authGuessAsInt;
	
	
boolean run()	{
	boolean isCorrect = false;
	JOptionPane.showMessageDialog(null, "Person 1: Write a password for a secret message to protect person 2 from viewing the message. ");
	password = JOptionPane.showInputDialog(null, "Enter the password");
	secretMessage = JOptionPane.showInputDialog(null,"What's the secret message?");
	JOptionPane.showMessageDialog(null, "Your randomly-generated authentication code is " + auth);
	JOptionPane.showMessageDialog(null, "Person 2: Guess the password to find the secret message. You will also need to provide a 6-digit authentication code.");
	passwordGuess = JOptionPane.showInputDialog("Guess the password");
	if(passwordGuess.equals(password))	{
		authGuess = JOptionPane.showInputDialog("Now guess the authentication code. (it's a 6-digit number)");
		authGuessAsInt = Integer.parseInt(authGuess);
		if(authGuessAsInt==auth)	{
			JOptionPane.showMessageDialog(null, "The secret message is \"" + secretMessage + "\"");
			isCorrect=true;
		}
		else	{
			JOptionPane.showMessageDialog(null, "INTRUDER!!!");
		}
				}
	else	{
		JOptionPane.showMessageDialog(null, "INTRUDER!!!");
	}
	return(isCorrect);

}
}
