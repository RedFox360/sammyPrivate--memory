package UnitConverter;

import javax.swing.JOptionPane;

public class MetricToImperial {
public static void main(String[] args) {
	String[] options = { "Meters to feet", "Kilometers to miles", "Kilograms to pounds", "Liters to gallons",
	"Celsius to Fahrenheit" };
int opt = JOptionPane.showOptionDialog(null, "What would you like to convert?", "Metric to imperial converter",
	JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
if (opt == 0) {
String stringMeasurement = JOptionPane.showInputDialog("How long is your measurement? (meters)");
double measurement = Double.parseDouble(stringMeasurement);
double conversionMethod = 3.2808;
double answer = measurement*conversionMethod;
JOptionPane.showMessageDialog(null, "" + measurement + " meters is " + answer + " feet.");
}
if (opt == 1) {
String stringMeasurement = JOptionPane.showInputDialog("How long is your measurement? (kilometers)");
double measurement = Double.parseDouble(stringMeasurement);
double conversionMethod = 1.6093;
double answer = measurement*conversionMethod;
JOptionPane.showMessageDialog(null, "" + measurement + " kilometers is " + answer + " miles.");
}
if (opt == 2) {
String stringMeasurement = JOptionPane.showInputDialog("How big is your measurement? (kilograms)");
double measurement = Double.parseDouble(stringMeasurement);
double conversionMethod = 2.2046;
double answer = measurement*conversionMethod;
JOptionPane.showMessageDialog(null, "" + measurement + " kilograms is " + answer + " pounds.");
}
if (opt == 3) {
String stringMeasurement = JOptionPane.showInputDialog("How large is your measurement? (liters)");
double measurement = Double.parseDouble(stringMeasurement);
double conversionMethod = 0.26417;
double answer = measurement*conversionMethod;
JOptionPane.showMessageDialog(null, "" + measurement + " liters is " + answer + " gallons.");
}
if (opt == 4) {
String stringMeasurement = JOptionPane.showInputDialog("What is the temperature you would like to convert? (Celsius)");
double measurement = Double.parseDouble(stringMeasurement);
double conversionMethod = 1.8;
double answer = (measurement*conversionMethod) + 32;
JOptionPane.showMessageDialog(null, "" + measurement + " degrees C is " + answer + " degrees F.");
}
}
}
