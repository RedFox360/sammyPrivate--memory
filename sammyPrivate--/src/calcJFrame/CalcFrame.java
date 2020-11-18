package calcJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("unused")
public class CalcFrame implements ActionListener {
	private static Dimension buttonSize = new Dimension(65, 65);
	private static Color backgroundBlue = new Color(212, 240, 255);
	private static Color numberColor = new Color(243, 245, 246);
	private static Color defaultColor = new Color(242, 251, 255);

	public static JFrame f = new JFrame();
	public static JFrame info = new JFrame();
	private JPanel pinfo = new JPanel();
	private static JLabel linfo = new JLabel();
	private JPanel p;
	private JButton plus = createButton("+", backgroundBlue, buttonSize);
	private JButton log10 = new JButton("log10");
	private JButton ln = new JButton("ln");
	private JButton minus = createButton("-", backgroundBlue, buttonSize);
	private JButton x = createButton("×", backgroundBlue, buttonSize);
	private JButton sqrt = new JButton("sqrt");
	private JButton slash = createButton("÷", backgroundBlue, buttonSize);
	private JButton e = new JButton("=");
	private static JLabel l = new JLabel();
	private JButton clear = new JButton("clear");
	private JButton factorial = new JButton("!");
	private JButton cubeRoot = new JButton("3rt");
	private JButton percent = createButton("%", backgroundBlue, buttonSize);
	private JButton b7 = createButton("7", numberColor, buttonSize);
	private JButton b8 = createButton("8", numberColor, buttonSize);
	private JButton b9 = createButton("9", numberColor, buttonSize);
	private JButton b4 = createButton("4", numberColor, buttonSize);
	private JButton b5 = createButton("5", numberColor, buttonSize);
	private JButton b6 = createButton("6", numberColor, buttonSize);
	private JButton b1 = createButton("1", numberColor, buttonSize);
	private JButton b2 = createButton("2", numberColor, buttonSize);
	private JButton b3 = createButton("3", numberColor, buttonSize);
	private JButton b0 = createButton("0", numberColor, buttonSize);
	private JButton dec = createButton(".", defaultColor, buttonSize);
	private JButton neg = createButton("n", defaultColor, buttonSize);
	private JButton fact = createButton("^", backgroundBlue, buttonSize);
	// advanced
	Border emptyBorder;
	private JButton choose = new JButton("choose");
	private JButton closeInfo = new JButton("Close");
	private JButton abs = new JButton("| abs |");
	private JMenuBar mb = new JMenuBar();
	private JMenuBar mbf = new JMenuBar();
	private JMenu m = new JMenu("Calculator");
	private JMenu file = new JMenu("File");
	private JMenuItem basic = new JMenuItem("Basic");
	private JMenuItem standard = new JMenuItem("Standard");
	private JMenuItem advanced = new JMenuItem("Advanced");
	private JMenuItem close = new JMenuItem("Exit");
	private JMenuItem infom = new JMenuItem("Info");
	private JMenuItem ctc = new JMenuItem("Copy answer");
	private static String op = "";
	static BigDecimal number1 = new BigDecimal(0);
	static BigDecimal number2 = new BigDecimal(0);
	static BigDecimal number3 = new BigDecimal(0);

	private static double dnumber1;
	private static double dnumber2;
	private static double decTimes = 0;
	private static boolean opPressed = false;
	private static boolean decPressed = false;
	private static String labelText;
	private BigDecimal answer = new BigDecimal(0);

	public void run() {
		
		info.setVisible(false);
	      l.setFont(new Font("Open Sans", Font.PLAIN, 18));
	      setFonts();
		emptyBorder = BorderFactory.createEmptyBorder();
		p = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		f.setTitle("Calculator");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pinfo.add(linfo);
		linfo.setText("This is a simple Java calculator. Use the 'Calculator' menu to switch between modes"
				+ " and use the File menu to activate simple actions."
				+ " Buttons colored blue are operations. They take in two numbers,"
				+ " Type 1 number, press the operation, and press another."
				+ " Buttons colored whitish-blue alter 1 number." + " Have fun with the calculator!");

		info.setTitle("Info");
		pinfo.add(closeInfo);
		info.add(pinfo);
		l.setText("");
		// ops
		clear.setPreferredSize(new Dimension(135, 65));
		// advanced
		
		log10.setBackground(defaultColor);
		ln.setBackground(defaultColor);
		abs.setBackground(defaultColor);
		sqrt.setBackground(defaultColor);
		factorial.setBackground(defaultColor);
		choose.setPreferredSize(new Dimension(135, 35));
		abs.setPreferredSize(new Dimension(134, 35));
		ln.setPreferredSize(new Dimension(89, 35));
		log10.setPreferredSize(new Dimension(88, 35));
		cubeRoot.setPreferredSize(new Dimension(89, 35));
		mb.setBorder(emptyBorder);
		mbf.setBorder(emptyBorder);
		// width: 235
		factorial.setPreferredSize(new Dimension(89, 35));
		percent.setPreferredSize(new Dimension(88, 35));
		sqrt.setPreferredSize(new Dimension(89, 35));

		e.setPreferredSize(new Dimension(buttonSize));
		p.setOpaque(false);
		mb.setOpaque(false);
		mbf.setOpaque(false);
		e.setBackground(new Color(171, 255, 171));
		clear.setBackground(new Color(233, 255, 233));
		choose.setBackground(backgroundBlue);
		cubeRoot.setBackground(defaultColor);
		f.setPreferredSize(new Dimension(290, 500));
		l.setPreferredSize(new Dimension(235, 55));
		l.setHorizontalAlignment(SwingConstants.RIGHT);
		dec.setPreferredSize(buttonSize);
		// adding comps

		file.add(ctc);
		file.add(infom);
		file.add(close);

		m.add(basic);
		m.add(standard);
		m.add(advanced);

		mb.add(m);
		mbf.add(file);
		p.add(mb);
		p.add(mbf);
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
		// adding menu
		// adding actionlisteners
		clear.addActionListener(this);
		e.addActionListener(this);
		log10.addActionListener(this);
		factorial.addActionListener(this);
		sqrt.addActionListener(this);

		closeInfo.setBackground(defaultColor);
		advanced.addActionListener(this);
		basic.addActionListener(this);
		standard.addActionListener(this);
		choose.addActionListener(this);
		abs.addActionListener(this);
		ln.addActionListener(this);
		close.addActionListener(this);
		cubeRoot.addActionListener(this);
		closeInfo.addActionListener(this);
		ctc.addActionListener(this);
		infom.addActionListener(this);
		clear.setBorder(emptyBorder);
		e.setBorder(emptyBorder);
		log10.setBorder(emptyBorder);
		factorial.setBorder(emptyBorder);
		sqrt.setBorder(emptyBorder);
		choose.setBorder(emptyBorder);
		abs.setBorder(emptyBorder);
		ln.setBorder(emptyBorder);
		e.setBorder(emptyBorder);
		cubeRoot.setBorder(emptyBorder);

		// op
		f.pack();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == closeInfo) {
			info.dispose();
			info.setVisible(false);
		}
		if (ae.getSource() == infom) {
			info.setVisible(true);
			info.pack();
		}
		if (ae.getSource() == close) {
			System.exit(0);
		}
		if (ae.getSource() == ctc) {
			StringSelection stringSelection = new StringSelection(labelText);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
		}
		if (ae.getSource() == basic) {
			p.removeAll();
			clear.setPreferredSize(new Dimension(200, 35));
			x.setPreferredSize(new Dimension(65, 35));
			f.setPreferredSize(new Dimension(290, 430));
			p.add(mb);
			p.add(mbf);
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
		if (ae.getSource() == standard) {
			clear.setPreferredSize(new Dimension(135, 65));
			f.setPreferredSize(new Dimension(290, 500));
			x.setPreferredSize(buttonSize);
			p.removeAll();
			p.add(mb);
			p.add(mbf);
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
		if (ae.getSource() == advanced) {
			clear.setPreferredSize(new Dimension(135, 65));
			f.setPreferredSize(new Dimension(295, 575));
			x.setPreferredSize(buttonSize);
			p.removeAll();
			p.add(mb);
			p.add(mbf);
			p.add(l);
			p.add(log10);
			p.add(ln);
			p.add(cubeRoot);
			p.add(abs);
			p.add(choose);

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
		if (ae.getSource() == cubeRoot) {
			if (opPressed == false) {
				double n1 = number1.doubleValue();
				n1 = Math.cbrt(n1);
				number1 = new BigDecimal(n1);
				labelText = "" + n1;
			}
			if (opPressed == true) {
				double n2 = number2.doubleValue();
				n2 = Math.cbrt(n2);
				number2 = new BigDecimal(n2);
				labelText = "" + n2;
			}
			l.setText(labelText);
			f.pack();
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
		}
		if (ae.getSource() == ln) {
			if (opPressed == false) {
				double n1 = number1.doubleValue();
				n1 = Math.log(n1);
				number1 = new BigDecimal(n1);
				labelText = "" + n1;
			}
			if (opPressed == true) {
				double n2 = number2.doubleValue();
				n2 = Math.log(n2);
				number2 = new BigDecimal(n2);
				labelText = "" + n2;
			}
			l.setText(labelText);
			f.pack();
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
			if (op.equals("c")) {
				double n = number1.doubleValue();
				double k = number2.doubleValue();
				double factorialn = factorial(n);
				double factorialk = factorial(k);
				double factorialnmk = factorial(n - k);

				double an = (factorialn) / ((factorialk) * (factorialnmk));
				an = Math.round(an);
				labelText = "" + an;
				answer = new BigDecimal(an);
			}
			number1 = answer;
			number2 = new BigDecimal(0);
			opPressed = false;
			decPressed = false;
			decTimes = 0;
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

	private JButton createButton(String text, Color background, Dimension d) {
		JButton j = new JButton();
		j.setText(text);
		j.setBackground(background);
		j.setPreferredSize(d);
		j.addActionListener(this);
		j.setFont(new Font("Poppins", Font.PLAIN, 15));
		j.setBorder(emptyBorder);
		return j;
	}
	private void setFonts() {
		clear.setFont(new Font("Poppins", Font.PLAIN, 15));
		choose.setFont(new Font("Poppins", Font.PLAIN, 15));
		factorial.setFont(new Font("Poppins", Font.PLAIN, 15));
		sqrt.setFont(new Font("Poppins", Font.PLAIN, 15));
		percent.setFont(new Font("Poppins", Font.PLAIN, 15));
		log10.setFont(new Font("Poppins", Font.PLAIN, 15));
		ln.setFont(new Font("Poppins", Font.PLAIN, 15));
		cubeRoot.setFont(new Font("Poppins", Font.PLAIN, 15));
		abs.setFont(new Font("Poppins", Font.PLAIN, 15));
		mb.setFont(new Font("Poppins", Font.PLAIN, 15));
		mbf.setFont(new Font("Poppins", Font.PLAIN, 15));
		standard.setFont(new Font("Poppins", Font.PLAIN, 14));
		advanced.setFont(new Font("Poppins", Font.PLAIN, 14));
		basic.setFont(new Font("Poppins", Font.PLAIN, 14));
		close.setFont(new Font("Poppins", Font.PLAIN, 14));
		closeInfo.setFont(new Font("Poppins", Font.PLAIN, 15));
		ctc.setFont(new Font("Poppins", Font.PLAIN, 14));
		infom.setFont(new Font("Poppins", Font.PLAIN, 14));
		m.setFont(new Font("Poppins", Font.PLAIN, 15));
		file.setFont(new Font("Poppins", Font.PLAIN, 15));
	}
}
