package calculator;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Calculator {
	public void run() throws Exception {
		
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
	
		
		String[] options = {"×", "÷", "+", "-", "^"};
		int numberop = JOptionPane.showOptionDialog(null, "Choose an operation",
		"Calculator",
		JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, null);
		if(numberop==0)	{
			JOptionPane.showMessageDialog(null, "The answer is " + multiplied  + "");
		}
		if(numberop==1)	{
			if(number2==0)	{
				JOptionPane.showMessageDialog(null, "The answer is undefined");
			}
			else	{
				JOptionPane.showMessageDialog(null, "The answer is " + divided + "");
			}
		}
		if(numberop==2) {
			JOptionPane.showMessageDialog(null, "The answer is " + added + "");
		}
		if(numberop==3)	{
			JOptionPane.showMessageDialog(null, "The answer is " + subtracted + "");
		}
		if(numberop==4)	{
			JOptionPane.showMessageDialog(null, "The answer is " + exponents + "");
		}
		
		
	}


}
