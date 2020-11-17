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

	
	System.out.println("Choose an operation: * | / | + | - | ^");
	String op = scan.nextLine();
	if(op.equals("*")) {
		System.out.println("The answer is " + multiplied);
	}
	if(op.equals("/")) {
		if(number2 == 0) {
			System.out.println("ERROR: Dividing by 0");
		}
		else {
			System.out.println("The answer is " + divided);
		}
	}
	if(op.equals("+")) {
		System.out.println("The answer is " + added);
	}
	if(op.equals("-")) {
		System.out.println("The answer is " + subtracted);
	}
	if(op.equals("^")) {
		System.out.println("The answer is " + exponents);
	}
}
}
