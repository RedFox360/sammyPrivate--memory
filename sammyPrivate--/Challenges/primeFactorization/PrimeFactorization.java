package primeFactorization;

import java.util.Scanner;

public class PrimeFactorization {
	public void run() {
		int number = 0;
		System.out.println("Type in a number");
		for (int j = 0; j < 4100; j++) {
			Scanner myObj = new Scanner(System.in);
			number = myObj.nextInt();
			for (int i = 2; i < number; i++) {
				while (number % i == 0) {
			
					System.out.print(i + "*");
					number /= i;
				}
			}
			if (number > 2) {
				System.out.print(number);
			}
		}
		

	}
}
