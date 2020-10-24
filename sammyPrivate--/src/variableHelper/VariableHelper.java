package variableHelper;

public class VariableHelper {
	public static <Words> void main(String[] args) {
		int integer = 10;
		// Ints only store integers
		// Ints can store numbers from -2147483648 to 2147483647
		System.out.println("int example: " + integer);

		float floatx = (float) 0.1234567891011121314151617;
		// Floats can only store up to 7 decimal places
		System.out.println("float example: " + floatx);

		double doublex = 0.1234567891011121314151617;
		// Doubles can store up to 17 decimal palces;
		System.out.println("double example: " + doublex);

		String words = "String example";
		// Strings store words
		System.out.println(words);

		String[] array = { "Hello", "World", "Array" };
		// String arrays store multiple Strings
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);

		char c;
		// Chars store a single letter
		String toc = "Hello";
		c = toc.charAt(0);
		// This will print the first digit of "Hello"
		System.out.println("char example: " + c);

		boolean isTrue;
		boolean isFalse;
		// Booleans store either true or false;
		isTrue = true;
		isFalse = false;
		System.out.println("True boolean: " + isTrue);
		System.out.println("False boolean: " + isFalse);

		// TYPES OF INTS:
		{
			byte x = 123;
			// A byte is a type of int that can store numbers from -128 to 127
			System.out.println("byte example: " + x);
		}
		{
			short x = 32;
			// A short is a type of int that can store numbers from -32768 to 32767
			System.out.println("short example: " + x);
		}
		{
			long x = 64;
			// A long is a type of int that can store numbers from -9223372036854775808 to
			// -9223372036854775807
			System.out.println("long example: " + x);
		}
		// CUSTOM VARIABLES:
		// you can easily create a custom String variable in java:
		// First, add a cast to the main method: public static <[nameOfYourVariable]> void main(String[] args)	{
		// Next: declare your variable: [nameOfYourVariable] x = [nameOfYourVariable] "Hello";
		// Your variable now acts like a normal string. You can even print it!
		// System.out.println(x);
		
		//EXAMPLE (Check main method to see cast):
		Words x = (Words) "Words example";
		System.out.println(x);
		
	}
}
