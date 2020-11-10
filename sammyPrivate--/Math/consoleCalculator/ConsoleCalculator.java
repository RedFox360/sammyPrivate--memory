package consoleCalculator;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ConsoleCalculator {
public void run()	{
	Scanner scan = new Scanner(System.in);
	System.out.println("Welcome to the calculator!");
	System.out.println("Type in a number");
	String number1string = scan.nextLine();
	System.out.println("Type in another number");
	String number2string = scan.nextLine();
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
		System.out.println("The answer is " + multiplied  + "");
	}
	if(numberop==1)	{
		if(number2==0)	{
			System.out.println("The answer is undefined");
		}
		else	{
			System.out.println("The answer is " + divided + "");
		}
	}
	if(numberop==2) {
		System.out.println("The answer is " + added + "");
	}
	if(numberop==3)	{
		System.out.println("The answer is " + subtracted + "");
	}
	if(numberop==4)	{
		System.out.println("The answer is " + exponents + "");
	}
	
}
}
