package numberOps;

public class NumberOp {
	 public long choose(long pool, long selection) {
		 	
			return (factorial(pool))/(factorial(selection)*(factorial(pool-selection)));		
	}
	 public long factorial(long factorial) {
			long runner = factorial;
			long forRunner = factorial - 1;
			for (long j = 0; j < forRunner - 1; j++) {
				runner -= 1;
				factorial *= runner;
			}
			
		return factorial;
	}
	 public String primeFactorization(long number) {
		String toReturn = "";
		for (long j = 0; j < 4100; j++) {
			for (long i = 2; i < number; i++) {
				while (number % i == 0) {
			
					toReturn += i + "*";
					number /= i;
				}
			}
			if (number > 2) {
				toReturn += number;
			}
		}
		return toReturn;
	}
	 public static void main(String[] args) {
			NumberOp n = new NumberOp();
			System.out.println(n.factorial(4));
		}
}
