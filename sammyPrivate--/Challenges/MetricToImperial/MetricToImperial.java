package MetricToImperial;

import javax.swing.JOptionPane;

public class MetricToImperial {
public static void main(String[] args)	{
	String[] options = { "Meters to feet", "Kilometers to miles", "Kilograms to pounds", "Liters to gallons",
	"Celsius to Fahrenheit" };
int opt = JOptionPane.showOptionDialog(null, "What would you like to convert?", "Metric to imperial converter",
	JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
if (opt == 0) {
	convert(3.2808, "feet", "meters");
}

if (opt == 1) {
	convert(1.6093, "miles", "kilometers");
}
if (opt == 2) {
	convert(2.2046, "pounds", "kilograms");
}
if (opt == 3) {
	convert(0.26417, "gallons", "liters");
}
if (opt == 4) {
String stringMeasurement = JOptionPane.showInputDialog("What is the temperature you would like to convert? (Celsius)");
double measurement = Double.parseDouble(stringMeasurement);
double conversionMethod = 1.8;
double answer = (measurement*conversionMethod) + 32;
JOptionPane.showMessageDialog(null, "" + measurement + " degrees C is " + answer + " degrees F.");
}
}
private static double convert(double conversionMethod, String output, String input)	{
	String stringMeasurement = JOptionPane.showInputDialog("How large is your measurement? (" + input + ")");
	double measurement = Double.parseDouble(stringMeasurement);
	double answer = measurement*conversionMethod;
	answer=answer*100;
	answer = Math.round(answer);
	answer = answer/100;
	JOptionPane.showMessageDialog(null, "" + measurement + " " + input + " is " + answer + " " + output + ".");
	return(answer);
}
}
