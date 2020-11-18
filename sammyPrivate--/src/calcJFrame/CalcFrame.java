package calcJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CalcFrame implements ActionListener {
	public static JFrame f = new JFrame();
	private JPanel p = new JPanel();
	private JButton plus = new JButton("+");
	private JButton log10 = new JButton("log10");
	private JButton minus = new JButton("-");
	private JButton x = new JButton("×");
	private JButton sqrt = new JButton("sqrt");
	private JButton slash = new JButton("÷");
	private JButton e = new JButton("=");
	static JLabel l = new JLabel();
	private JButton clear = new JButton("clear");
	private JButton factorial = new JButton("!");
	private JButton percent = new JButton("%");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b1 = new JButton("1");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b0 = new JButton("0");
	private JButton dec = new JButton(".");
	private JButton neg = new JButton("n");
	private JButton fact = new JButton("^");
	
	//advanced 
	private JButton choose = new JButton("choose");
	private JButton abs = new JButton("| abs |");
	
	private JMenuBar mb = new JMenuBar();
	private JMenu m = new JMenu("Calculator");
	private JMenuItem basic = new JMenuItem("Basic");
	private JMenuItem standard = new JMenuItem("Standard");
	private JMenuItem advanced = new JMenuItem("Advanced");
	private static String op = "";
	static BigDecimal number1 = new BigDecimal(0);
	static BigDecimal number2 = new BigDecimal(0);
	static BigDecimal number3 = new BigDecimal(0);
	private static double dnumber1;
	private static double dnumber2;
	private static double decTimes = 0;
	private static boolean opPressed = false;
	private static boolean decPressed = false;
	private static boolean opPressedTwice = false;
	private static String labelText;
	private BigDecimal answer = new BigDecimal(0);
	
	public void run() {

		f.setTitle("Calculator");
		f.setVisible(true);
		
		// ops
		Dimension buttonSize = new Dimension(55, 55);
		clear.setPreferredSize(new Dimension(115, 55));
		b7.setPreferredSize(buttonSize);
		b8.setPreferredSize(buttonSize);
		b9.setPreferredSize(buttonSize);
		b4.setPreferredSize(buttonSize);
		b5.setPreferredSize(buttonSize);
		b6.setPreferredSize(buttonSize);
		b1.setPreferredSize(buttonSize);
		neg.setPreferredSize(buttonSize);
		b0.setPreferredSize(buttonSize);
		fact.setPreferredSize(buttonSize);
		b2.setPreferredSize(buttonSize);
		b3.setPreferredSize(buttonSize);
		plus.setPreferredSize(buttonSize);
		x.setPreferredSize(buttonSize);
		slash.setPreferredSize(buttonSize);
		minus.setPreferredSize(buttonSize);
		//advanced
		choose.setPreferredSize(new Dimension(85, 35));
		abs.setPreferredSize(new Dimension(75, 35));

		log10.setPreferredSize(new Dimension(65, 35));
		
		// width: 235
		factorial.setPreferredSize(new Dimension(75, 35));
		percent.setPreferredSize(new Dimension(75, 35));
		sqrt.setPreferredSize(new Dimension(75, 35));
		
		e.setPreferredSize(new Dimension(buttonSize));
		Color backgroundBlue = new Color(212, 240, 255);
		e.setBackground(new Color(171, 255, 171));
		clear.setBackground(new Color(233, 255, 233));
		percent.setBackground(backgroundBlue);
		plus.setBackground(backgroundBlue);
		fact.setBackground(backgroundBlue);
		x.setBackground(backgroundBlue);
		slash.setBackground(backgroundBlue);
		minus.setBackground(backgroundBlue);
		f.setPreferredSize(new Dimension(280, 485));
		l.setPreferredSize(new Dimension(200, 55));
		l.setHorizontalAlignment(SwingConstants.RIGHT);
		dec.setPreferredSize(buttonSize);
		// adding comps
		m.add(basic);
		m.add(standard);
		m.add(advanced);
		mb.add(m);
		
		p.add(mb);
		p.add(l);
		
		p.add(sqrt);
		p.add(factorial);
		p.add(percent);
		p.add(clear);
		p.add(fact);
		
		p.add(x);

		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(slash);

		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(minus);

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(plus);
		
		p.add(neg);
		p.add(b0);
		p.add(dec);
		p.add(e);

		f.add(p);
		//adding menu
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
		log10.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		neg.addActionListener(this);
		dec.addActionListener(this);
		fact.addActionListener(this);
		factorial.addActionListener(this);
		percent.addActionListener(this);
		sqrt.addActionListener(this);
		advanced.addActionListener(this);
		basic.addActionListener(this);
		standard.addActionListener(this);
		choose.addActionListener(this);
		abs.addActionListener(this);
		// op
		f.pack();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==basic) {
			p.removeAll();
			clear.setPreferredSize(new Dimension(175, 55));
			f.setPreferredSize(new Dimension(280, 450));
			p.add(mb);
			p.add(l);
			

			p.add(clear);
			
			p.add(x);

			p.add(b7);
			p.add(b8);
			p.add(b9);
			p.add(slash);

			p.add(b4);
			p.add(b5);
			p.add(b6);
			p.add(minus);

			p.add(b1);
			p.add(b2);
			p.add(b3);
			p.add(plus);
			
			p.add(neg);
			p.add(b0);
			p.add(dec);
			p.add(e);
			f.pack();

		}
		if(ae.getSource()==standard) {
			clear.setPreferredSize(new Dimension(115, 55));
			f.setPreferredSize(new Dimension(280, 485));
			p.removeAll();
			p.add(mb);
			p.add(l);
			
			p.add(sqrt);
			p.add(factorial);
			p.add(percent);
			p.add(clear);
			p.add(fact);
			
			p.add(x);

			p.add(b7);
			p.add(b8);
			p.add(b9);
			p.add(slash);

			p.add(b4);
			p.add(b5);
			p.add(b6);
			p.add(minus);

			p.add(b1);
			p.add(b2);
			p.add(b3);
			p.add(plus);
			
			p.add(neg);
			p.add(b0);
			p.add(dec);
			p.add(e);
			f.pack();
		}
		if(ae.getSource()==advanced) {
			f.setPreferredSize(new Dimension(280, 520));
			p.removeAll();
			p.add(mb);
			p.add(l);
			p.add(log10);
			p.add(choose);
			p.add(abs);
			p.add(log10);
			p.add(sqrt);
			p.add(factorial);
			p.add(percent);
			p.add(clear);
			p.add(fact);
			
			p.add(x);

			p.add(b7);
			p.add(b8);
			p.add(b9);
			p.add(slash);

			p.add(b4);
			p.add(b5);
			p.add(b6);
			p.add(minus);

			p.add(b1);
			p.add(b2);
			p.add(b3);
			p.add(plus);
			
			p.add(neg);
			p.add(b0);
			p.add(dec);
			p.add(e);
			f.pack();
		}
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
		if (ae.getSource() == percent) {
			op = "%";
			opPressed = true;
			decPressed = false;
			decTimes = 0;

		}
		if (ae.getSource() == choose) {
			op = "c";
			opPressed = true;
			decPressed = false;
			decTimes = 0;
		}
		if (ae.getSource() == abs) {
			if (opPressed == false) {
				double n1 = number1.doubleValue();
				n1 = Math.abs(n1);
				number1 = new BigDecimal(n1);
				labelText = "" + n1;
			}
			if (opPressed == true) {
				double n2 = number2.doubleValue();
				n2 = Math.abs(n2);
				number2 = new BigDecimal(n2);
				labelText = "" + n2;
			}
			l.setText(labelText);
			f.pack();
			StringSelection stringSelection = new StringSelection(labelText);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
		}
		if (ae.getSource() == sqrt) {
			if (opPressed == false) {
				double n1 = number1.doubleValue();
				n1 = Math.sqrt(n1);
				number1 = new BigDecimal(n1);
				labelText = "" + n1;
			}
			if (opPressed == true) {
				double n2 = number2.doubleValue();
				n2 = Math.sqrt(n2);
				number2 = new BigDecimal(n2);
				labelText = "" + n2;
			}
			l.setText(labelText);
			f.pack();
			StringSelection stringSelection = new StringSelection(labelText);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
		}
		if (ae.getSource() == factorial) {
			if (opPressed == false) {
				double n1 = number1.doubleValue();
				n1 = factorial(n1);
				number1 = new BigDecimal(n1);
				labelText = "" + n1;
			}
			if (opPressed == true) {
				double n2 = number2.doubleValue();
				n2 = factorial(n2);
				number2 = new BigDecimal(n2);
				labelText = "" + n2;
			}
			l.setText(labelText);
			f.pack();
			StringSelection stringSelection = new StringSelection(labelText);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
		}
		if (ae.getSource() == log10) {
			if (opPressed == false) {
				double n1 = number1.doubleValue();
				n1 = Math.log10(n1);
				number1 = new BigDecimal(n1);
				labelText = "" + n1;
			}
			if (opPressed == true) {
				double n2 = number2.doubleValue();
				n2 = Math.log10(n2);
				number2 = new BigDecimal(n2);
				labelText = "" + n2;
			}
			l.setText(labelText);
			f.pack();
			StringSelection stringSelection = new StringSelection(labelText);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
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
			MathContext m = new MathContext(6);
			if (op.equals("x")) {
				answer = number1.multiply(number2);
				answer = answer.round(m);
				labelText = "" + answer;
			}
			if (op.equals("/")) {
				double n1 = number1.doubleValue();
				double n2 = number2.doubleValue();
				double an = n1 / n2;
				if (n2 == 0) {
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
				answer = new BigDecimal(an);
				answer = answer.round(m);
				labelText = "" + answer;
				answer = new BigDecimal(an);
			}
			if (op.equals("%")) {
				double d1 = number1.doubleValue();
				double d2 = number2.doubleValue();
				double mul = d1 / 100;
				double an = d2 * mul;
				labelText = "" + an;
				answer = new BigDecimal(an);
			}
			if(op.equals("c")) {
				double n = number1.doubleValue();
				double k = number2.doubleValue();
				double factorialn = factorial(n);
				double factorialk = factorial(k);
				double factorialnmk = factorial(n-k);
			
				double an = (factorialn)/((factorialk)*(factorialnmk));

				an = Math.round(an);
				labelText = "" + an;
				answer = new BigDecimal(an);
			}
			number1 = answer;
			number2 = new BigDecimal(0);
			opPressed = false;
			decPressed = false;
			decTimes = 0;
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
