package Factorials;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class FactorialCalculator {
public void run()	{
	Scanner myObj = new Scanner(System.in);
	System.out.println("Write an integer");
	for (int i = 0; i < 2000; i++) {
	String a = myObj.nextLine();
	long factorial = Long.parseLong(a);
	long runner = factorial;
	long forRunner = factorial-1;
	for (long j = 0; j < forRunner-1; j++) {
		runner-=1;
		factorial*=runner;
	}
	System.out.println(factorial);
	}
}
}
