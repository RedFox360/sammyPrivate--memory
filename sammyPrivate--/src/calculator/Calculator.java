package calculator;

import javax.swing.JOptionPane;

public class Calculator {
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Welcome to the calculator!");
		String number1string = JOptionPane.showInputDialog("Type in a number");
		String number2string = JOptionPane.showInputDialog("Type in another number");
		double number1 = Double.parseDouble(number1string);
		double number2 = Double.parseDouble(number2string);
		double subtracted = number1-number2;
		double exponents = Math.pow(number1, number2);
		double added = number1+number2;
		double divided = number1/number2;
		double multiplied = number1*number2;
	
		
		String[] options = {"�", "�", "+", "-", "^"};
		int numberop = JOptionPane.showOptionDialog(null, "Choose an operation",
		"Choose an operation",
		JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if(numberop==0)	{
			message("The answer is " + multiplied  + "");
		}
		if(numberop==1)	{
			if(number2==0)	{
				message("The answer is undefined");
			}
			else	{
				message("The answer is " + divided + "");
			}
		}
		if(numberop==2) {
			message("The answer is " + added + "");
		}
		if(numberop==3)	{
			message("The answer is " + subtracted + "");
		}
		if(numberop==4)	{
			message("The answer is " + exponents + "");
		}
		
	}
	
	private static void message(String words)	{
		JOptionPane.showMessageDialog(null, words);
	}

}
