package numberOp;

public class NumberOpRunner {
	public static void main(String[] args) {
		System.out.println(choose(5,2));
	}
	 static int choose(int pool, int selection) {
			return (factorial(pool))/(factorial(selection)*(factorial(pool-selection)));		
	}
	 static int factorial(int factorial) {
		for (int i = 0; i < 2000; i++) {
			int runner = factorial;
			int forRunner = factorial - 1;
			for (int j = 0; j < forRunner - 1; j++) {
				runner -= 1;
				factorial *= runner;
			}
			
		}return factorial;
	}
}
