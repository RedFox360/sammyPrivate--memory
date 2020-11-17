package calcJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CalcFrame implements ActionListener {
	public static JFrame f = new JFrame();
	private JPanel p = new JPanel();
	private JButton plus = new JButton();
	private JButton minus = new JButton();
	private JButton x = new JButton();
	private JButton slash = new JButton();
	private JButton e = new JButton();
	static JLabel l = new JLabel();
	private JButton clear = new JButton();
	private JButton b7 = new JButton();
	private JButton b8 = new JButton();
	private JButton b9 = new JButton();
	private JButton b4 = new JButton();
	private JButton b5 = new JButton();
	private JButton b6 = new JButton();
	private JButton b1 = new JButton();
	private JButton b2 = new JButton();
	private JButton b3 = new JButton();
	private JButton b0 = new JButton();
	private JButton dec = new JButton();
	private JButton neg = new JButton();
	private JButton fact = new JButton();
	private static String op = "";
	static BigDecimal number1 = new BigDecimal(0);
	static BigDecimal number2 = new BigDecimal(0);
	private static double dnumber1;
	private static double dnumber2;
	private static double decTimes = 0;
	private static boolean opPressed = false;
	private static boolean decPressed = false;
	private static String labelText;
	private BigDecimal answer = new BigDecimal(0);

	public void run() {
		f.setTitle("Calculator");
		f.setVisible(true);
		// text setting
		plus.setText("+");
		minus.setText("-");
		x.setText("×");
		slash.setText("÷");
		e.setText("=");
		b7.setText("7");
		b8.setText("8");
		b9.setText("9");
		clear.setText("clear");
		b4.setText("4");
		b5.setText("5");
		b6.setText("6");
		b1.setText("1");
		b2.setText("2");
		b3.setText("3");
		b0.setText("0");
		dec.setText(".");
		neg.setText("n");
		fact.setText("^");
		// ops
		Dimension buttonSize = new Dimension(55, 55);
		clear.setPreferredSize(new Dimension(68, 55));
		b7.setPreferredSize(buttonSize);
		b8.setPreferredSize(buttonSize);
		b9.setPreferredSize(buttonSize);
		b4.setPreferredSize(buttonSize);
		b5.setPreferredSize(buttonSize);
		b6.setPreferredSize(buttonSize);
		b1.setPreferredSize(buttonSize);
		neg.setPreferredSize(buttonSize);
		b0.setPreferredSize(buttonSize);
		fact.setPreferredSize(new Dimension(42, 55));
		b2.setPreferredSize(buttonSize);
		b3.setPreferredSize(buttonSize);
		plus.setPreferredSize(buttonSize);
		x.setPreferredSize(buttonSize);
		slash.setPreferredSize(buttonSize);
		minus.setPreferredSize(buttonSize);
		e.setPreferredSize(new Dimension(115, 55));
		Color backgroundofe = new Color(171, 255, 171);
		Color backgroundBlue = new Color(212, 240, 255);
		e.setBackground(backgroundofe);
		plus.setBackground(backgroundBlue);
		fact.setBackground(backgroundBlue);
		x.setBackground(backgroundBlue);
		slash.setBackground(backgroundBlue);
		minus.setBackground(backgroundBlue);
		f.setPreferredSize(new Dimension(280, 420));
		l.setPreferredSize(new Dimension(200, 55));
		l.setHorizontalAlignment(SwingConstants.RIGHT);
		dec.setPreferredSize(buttonSize);
		// adding comps
		p.add(l);
		p.add(clear);
		p.add(fact);
		p.add(slash);
		p.add(x);

		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(minus);

		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(plus);

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(dec);
		p.add(neg);
		p.add(b0);

		p.add(e);

		f.add(p);

		// adding actionlisteners
		clear.addActionListener(this);
		plus.addActionListener(this);
		x.addActionListener(this);
		slash.addActionListener(this);
		minus.addActionListener(this);
		e.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		neg.addActionListener(this);
		dec.addActionListener(this);
		fact.addActionListener(this);
		// op
		f.pack();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b7) {
			setn(7);
		}
		if (ae.getSource() == b8) {
			setn(8);
		}
		if (ae.getSource() == b9) {
			setn(9);
		}
		if (ae.getSource() == b6) {
			setn(6);
		}
		if (ae.getSource() == b5) {
			setn(5);
		}
		if (ae.getSource() == b4) {
			setn(4);
		}
		if (ae.getSource() == b3) {
			setn(3);
		}
		if (ae.getSource() == b2) {
			setn(2);
		}
		if (ae.getSource() == b1) {
			setn(1);
		}
		if (ae.getSource() == b0) {
			setn(0);
		}
		if (ae.getSource() == fact) {
			op = "^";
			opPressed = true;
			decPressed = false;
			decTimes = 0;
		}
		if (ae.getSource() == dec) {
			decPressed = true;
		}
		if (ae.getSource() == neg) {
			if (opPressed == false) {
				number1 = new BigDecimal(0).subtract(number1);
				labelText = "" + number1;
			}
			if (opPressed == true) {
				number2 = new BigDecimal(0).subtract(number2);
				labelText = "" + number2;
			}
			l.setText(labelText);
			f.pack();
		}
		if (ae.getSource() == plus) {
			op = "+";
			opPressed = true;
			decPressed = false;
			decTimes = 0;
		}
		if (ae.getSource() == x) {
			op = "x";
			opPressed = true;
			decPressed = false;
			decTimes = 0;
		}
		if (ae.getSource() == slash) {
			op = "/";
			opPressed = true;
			decPressed = false;
			decTimes = 0;
		}
		if (ae.getSource() == minus) {
			op = "-";
			opPressed = true;
			decPressed = false;
			decTimes = 0;
		}
		if (ae.getSource() == e) {
			MathContext m = new MathContext(8);
			if (op.equals("x")) {
				answer = number1.multiply(number2);
				answer = answer.round(m);
				labelText = "" + answer;
			}
			if (op.equals("/")) {
				double n1 = number1.doubleValue();
				double n2 = number2.doubleValue();
				double an = n1 / n2;
				if(n2 == 0) {
					labelText = "Undefined";
				} else {
				labelText = "" + an;
				}
				answer = new BigDecimal(an);
			}
			if (op.equals("+")) {
				answer = number1.add(number2);
				answer = answer.round(m);
				labelText = "" + answer;
			}
			if (op.equals("-")) {
				answer = number1.subtract(number2);
				answer = answer.round(m);
				labelText = "" + answer;
			}
			if (op.equals("^")) {
				double d1 = number1.doubleValue();
				double d2 = number2.doubleValue();
				double an = Math.pow(d1, d2);
				labelText = "" + an;
			}

			StringSelection stringSelection = new StringSelection(labelText);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			l.setText(labelText);
			f.pack();
		}
		if (ae.getSource() == clear) {
			number1 = new BigDecimal(0);
			number2 = new BigDecimal(0);
			labelText = "";
			l.setText(labelText);
			opPressed = false;
			decPressed = false;
			f.pack();
			decTimes = 0;

		}
	}

	private static double factorial(double a) {
		double runner = a;
		double forRunner = a - 1;
		for (long j = 0; j < forRunner - 1; j++) {
			runner -= 1;
			a *= runner;
		}
		return a;
	}

	private static void setn(double te) {
		if (opPressed == false) {
			if (decPressed == true) {
				decTimes += 1;
				dnumber1 = number1.doubleValue();
				double divisor = Math.pow(10, decTimes);
				te /= divisor;
				dnumber1 += te;
				number1 = new BigDecimal(dnumber1);
				labelText = "" + dnumber1;
				l.setText(labelText);
				f.pack();

			}
			if (decPressed == false) {
				BigDecimal take = new BigDecimal(te);
				labelText = "" + number1 + take;
				BigDecimal t = new BigDecimal(labelText);
				number1 = t;
			}
		}
		if (opPressed == true) {
			if (decPressed == true) {
				decTimes += 1;
				dnumber2 = number2.doubleValue();
				double divisor = Math.pow(10, decTimes);
				te /= divisor;
				dnumber2 += te;
				number2 = new BigDecimal(dnumber2);
				labelText = "" + dnumber2;
				l.setText(labelText);
				f.pack();

			}
			if (decPressed == false) {
				BigDecimal take = new BigDecimal(te);
				labelText = "" + number2 + take;
				BigDecimal t = new BigDecimal(labelText);
				number2 = t;
			}
		}

		l.setText(labelText);
		f.pack();
	}

}
