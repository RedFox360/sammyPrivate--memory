package calcJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

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
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("unused")
public class CalcFrame implements ActionListener {
	ArrayList<BigDecimal> answersList = new ArrayList<BigDecimal>();
	private static Dimension buttonSize = new Dimension(80, 65);
	private static Color backgroundBlue = new Color(212, 240, 255);
	private static Color numberColor = new Color(243, 245, 246);
	private static Color defaultColor = new Color(242, 251, 255);
	private JTextField randomMin = new JTextField();
	private JTextField randomMax = new JTextField();
	private JButton randGen = new JButton("Generate");
	private JButton randSet = new JButton("Reset");
	private JButton mplus = new JButton("M+");
	private JButton memory = new JButton("M");
	public static JFrame f = new JFrame();
	private static boolean inRand = false;
	public static JFrame info = new JFrame();
	private JPanel pinfo = new JPanel();
	private static JLabel linfo = new JLabel();
	private JLabel randMinL, randMaxL;
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
	private static String[] menus = { "Standard", "Basic", "Advanced", "RNG" };
	private JComboBox dropdown = new JComboBox(menus);
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
	private JButton abs = new JButton("| x |");
	private JMenuBar mb = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu memoryMenu = new JMenu("Memory");
	private JMenuItem close = new JMenuItem("Exit");
	private JMenuItem infom = new JMenuItem("Info");
	private JMenuItem clearMemory = new JMenuItem("MC");
	private JMenuItem removeLastItem = new JMenuItem("M-");
	private JMenuItem ctc = new JMenuItem("Copy answer");
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
		random();
		info.setVisible(false);
		setFonts();
		emptyBorder = BorderFactory.createEmptyBorder();
		p = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		p.setOpaque(false);
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
		clear.setPreferredSize(new Dimension(162, 65));
		// advanced

		log10.setBackground(defaultColor);
		ln.setBackground(defaultColor);
		abs.setBackground(defaultColor);
		sqrt.setBackground(defaultColor);
		factorial.setBackground(defaultColor);
		choose.setPreferredSize(new Dimension(162, 35));
		abs.setPreferredSize(new Dimension(162, 35));
		mplus.setPreferredSize(new Dimension(53, 35));
		memory.setPreferredSize(new Dimension(53, 35));
		ln.setPreferredSize(new Dimension(107, 35));
		log10.setPreferredSize(new Dimension(107, 35));
		cubeRoot.setPreferredSize(new Dimension(108, 35));
		dropdown.setPreferredSize(new Dimension(80, 15));
		mb.setBorder(emptyBorder);
		mplus.setBorder(emptyBorder);
		memory.setBorder(emptyBorder);
		mplus.setBackground(numberColor);
		memory.setBackground(numberColor);
		// width: 235
		mplus.setPreferredSize(new Dimension(53, 35));
		memory.setPreferredSize(new Dimension(53, 35));
		factorial.setPreferredSize(new Dimension(53, 35));
		percent.setPreferredSize(new Dimension(52, 35));
		sqrt.setPreferredSize(new Dimension(107, 35));
		
		e.setPreferredSize(new Dimension(buttonSize));
		p.setOpaque(false);
		mb.setOpaque(false);
		e.setBackground(new Color(171, 255, 171));
		clear.setBackground(new Color(233, 255, 233));
		choose.setBackground(backgroundBlue);
		cubeRoot.setBackground(defaultColor);
		f.setPreferredSize(new Dimension(350, 500));
		l.setPreferredSize(new Dimension(300, 55));
		l.setHorizontalAlignment(SwingConstants.RIGHT);
		dec.setPreferredSize(buttonSize);
		// adding comps
		file.add(ctc);
		file.add(infom);
		file.add(close);
		memoryMenu.setBorder(emptyBorder);
		memoryMenu.add(removeLastItem);
		memoryMenu.add(clearMemory);
		mb.add(file);
		mb.add(memoryMenu);
		p.add(dropdown);
		p.add(mb);
		p.add(l);
		
		p.add(sqrt);
		p.add(factorial);
		p.add(mplus);
		p.add(memory);
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
		randSet.addActionListener(this);
		closeInfo.setBackground(defaultColor);
		choose.addActionListener(this);
		abs.addActionListener(this);
		ln.addActionListener(this);
		close.addActionListener(this);
		cubeRoot.addActionListener(this);
		closeInfo.addActionListener(this);
		ctc.addActionListener(this);
		mplus.addActionListener(this);
		memory.addActionListener(this);
		memoryMenu.addActionListener(this);
		clearMemory.addActionListener(this);
		removeLastItem.addActionListener(this);
		dropdown.addActionListener(this);
		infom.addActionListener(this);
		randGen.addActionListener(this);
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
			if (inRand == false) {
				StringSelection stringSelection = new StringSelection(labelText);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
			if (inRand == true) {
				StringSelection stringSelection = new StringSelection(randGen.getText());
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		}
		if (dropdown.getSelectedItem().toString().equals("Basic")) {
			p.removeAll();
			inRand = false;
			clear.setPreferredSize(new Dimension(140, 35));
			mplus.setPreferredSize(new Dimension(50, 35));
			memory.setPreferredSize(new Dimension(50, 35));
			x.setPreferredSize(new Dimension(80, 35));
			f.setPreferredSize(new Dimension(350, 430));
			p.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
			p.add(dropdown);
			p.add(mb);
			p.add(l);

			p.add(clear);
			p.add(mplus);
			p.add(memory);
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
		if (ae.getSource() == randGen) {
			generateRand();
		}
		if (ae.getSource() == randSet) {
			randomMin.setText("");
			randomMax.setText("");
			randGen.setText("Generate");
		}
		if (dropdown.getSelectedItem().toString().equals("Standard")) {
			inRand = false;
			clear.setPreferredSize(new Dimension(162, 65));
			f.setPreferredSize(new Dimension(350, 500));
			x.setPreferredSize(buttonSize);
			p.removeAll();
			p.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
			p.add(dropdown);
			p.add(mb);
			p.add(l);

			p.add(sqrt);
			p.add(factorial);
			p.add(mplus);
			p.add(memory);
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
		if (dropdown.getSelectedItem().toString().equals("Advanced")) {
			inRand = false;
			clear.setPreferredSize(new Dimension(162, 65));
			f.setPreferredSize(new Dimension(350, 575));
			x.setPreferredSize(buttonSize);
			p.removeAll();
			p.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
			p.add(dropdown);
			p.add(mb);
			p.add(l);
			p.add(log10);
			p.add(ln);
			p.add(cubeRoot);
			p.add(abs);
			p.add(choose);

			p.add(sqrt);
			p.add(factorial);
			p.add(mplus);
			p.add(memory);
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
		if (dropdown.getSelectedItem().toString().equals("RNG")) {
			inRand = true;
			p.removeAll();
			f.setPreferredSize(new Dimension(700, 80));
			p.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
			p.add(dropdown);
			p.add(mb);
			p.add(randMinL);
			p.add(randomMin);
			p.add(randMaxL);
			p.add(randomMax);
			p.add(randGen);
			p.add(randSet);
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
		if (ae.getSource() == clearMemory) {
			answersList.clear();
		}
		if (ae.getSource() == removeLastItem) {
			answersList.remove(answersList.size()-1);
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
		if (ae.getSource() == mplus) {
			answersList.add(answer);
		}
		if (ae.getSource() == memory) {
			labelText = "Memory: " + answersList.toString();
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
		j.setFont(new Font("Consolas", Font.PLAIN, 16));
		j.setBorder(emptyBorder);
		return j;
	}

	private void setFonts() {
		linfo.setFont(new Font("Consolas", Font.PLAIN, 13));
		l.setFont(new Font("Consolas", Font.PLAIN, 16));
		clear.setFont(new Font("Consolas", Font.PLAIN, 16));
		choose.setFont(new Font("Consolas", Font.PLAIN, 14));
		factorial.setFont(new Font("Consolas", Font.PLAIN, 16));
		sqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
		percent.setFont(new Font("Consolas", Font.PLAIN, 16));
		log10.setFont(new Font("Consolas", Font.PLAIN, 14));
		ln.setFont(new Font("Consolas", Font.PLAIN, 14));
		cubeRoot.setFont(new Font("Consolas", Font.PLAIN, 14));
		mplus.setFont(new Font("Consolas", Font.PLAIN, 14));
		memory.setFont(new Font("Consolas", Font.PLAIN, 14));
		abs.setFont(new Font("Consolas", Font.PLAIN, 14));
		mb.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		close.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		closeInfo.setFont(new Font("Consolas", Font.PLAIN, 14));
		ctc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		infom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		file.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		memoryMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		clearMemory.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		removeLastItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		dropdown.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		dropdown.setUI(new BasicComboBoxUI());
		dropdown.setOpaque(false);
	}

	private void transparentNums() {
		b0.setOpaque(false);
		b1.setOpaque(false);
		b2.setOpaque(false);
		b3.setOpaque(false);
		b4.setOpaque(false);
		b5.setOpaque(false);
		b6.setOpaque(false);
		b7.setOpaque(false);
		b8.setOpaque(false);
		b9.setOpaque(false);
		b0.setOpaque(false);
	}

	private void random() {
		randomMin.setBorder(emptyBorder);
		randomMax.setBorder(emptyBorder);
		randGen.setBorder(emptyBorder);
		randSet.setBorder(emptyBorder);
		randSet.setBackground(defaultColor);
		randomMin.setPreferredSize(new Dimension(100, 20));
		randomMax.setPreferredSize(new Dimension(100, 20));
		randGen.setPreferredSize(new Dimension(100, 40));
		randSet.setPreferredSize(new Dimension(100, 40));
		randomMin.setFont(new Font("Consolas", Font.PLAIN, 14));
		randomMax.setFont(new Font("Consolas", Font.PLAIN, 14));
		randGen.setFont(new Font("Consolas", Font.PLAIN, 14));
		randSet.setFont(new Font("Consolas", Font.PLAIN, 14));
		randGen.setBackground(defaultColor);
		randMinL = new JLabel(" Min");
		randMaxL = new JLabel(" Max");
		randMinL.setFont(new Font("Consolas", Font.PLAIN, 14));
		randMaxL.setFont(new Font("Consolas", Font.PLAIN, 14));
	}

	private void generateRand() {
		Random r = new Random();
		int min = Integer.parseInt(randomMin.getText());
		int max = Integer.parseInt(randomMax.getText());
		int rsan = r.nextInt(max - min + 1) + min;
		randGen.setText("" + rsan);
		f.pack();
	}
}
