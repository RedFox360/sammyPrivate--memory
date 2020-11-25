package _00_calcJFrame;

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
import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class CalcFrame implements ActionListener, KeyListener {
	ArrayList<Double> answersList = new ArrayList<Double>();
	ArrayList<Double> history = new ArrayList<Double>();
	private static Dimension buttonSize = new Dimension(80, 65);
	private static Color backgroundBlue = new Color(212, 240, 255);
	private static Color numberColor = new Color(243, 245, 246);
	private static Color defaultColor = new Color(242, 251, 255);
	private JTextField randomMin = new JTextField();
	private JTextField randomMax = new JTextField();
	private JButton randGen = new JButton("Generate");
	private JButton randSet = new JButton("Reset");
	private JButton rollDice = new JButton("Roll A Die");
	private JButton roll2Dice = createButton("Roll 2 Dice", defaultColor, new Dimension(100, 40));
	private JButton mplus = new JButton("M+");
	private JButton memory = new JButton("M");
	public static JFrame f = new JFrame();
	private static boolean inRand = false;
	public static JFrame info = new JFrame();
	public static JFrame memFrame = new JFrame();
	private static JPanel memPanel;
	private JMenuItem memoryItem = new JMenuItem("Memory");

	public static JFrame historyFrame = new JFrame();
	private static JPanel historyPanel;
	private JButton historyClose = createButton("Close", defaultColor, new Dimension(55, 35));
	private static JLabel historyLabel = new JLabel();
	private JMenuItem historyMenuItem = new JMenuItem("History");
	private JMenuItem historyClear = new JMenuItem("Clear History");

	private JButton memClose = createButton("Close", defaultColor, new Dimension(55, 35));
	private static JLabel memLabel = new JLabel();
	private static JLabel linfo = new JLabel();
	private JLabel randMinL, randMaxL;
	private JPanel p, pinfo;
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
	private JButton neg = createButton("+/-", defaultColor, buttonSize);
	private JButton fact = createButton("^", backgroundBlue, buttonSize);
	// advanced

	Border emptyBorder;
	private JButton choose = new JButton("choose");
	private JButton closeInfo = new JButton("Close");
	private JButton abs = new JButton("| x |");
	private JMenuBar mb = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu memoryMenu = new JMenu("Memory");
	private JMenu historyMenu = new JMenu("History");
	private JMenu viewMenu = new JMenu("Navigate");
	private JMenu editMenu = new JMenu("Edit");
	private JMenuItem close = new JMenuItem("Exit");
	private JMenuItem infom = new JMenuItem("Info");
	private JMenuItem clearMemory = new JMenuItem("Clear Memory");
	private JMenuItem removeLastItem = new JMenuItem("Remove Last Item");
	private JMenuItem ctc = new JMenuItem("Copy answer");
	private JMenuItem undo = new JMenuItem("Undo");
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

	public static void main(String[] calcualtorArgs) {
		new CalcFrame().run();
	}

	public void run() {

		random();
		info.setVisible(false);
		memFrame.setVisible(false);
		historyFrame.setVisible(false);
		memFrame.setTitle("Memory");
		historyFrame.setTitle("History");

		setFonts();
		emptyBorder = BorderFactory.createEmptyBorder();
		pinfo = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		p = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		memPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		historyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		p.setOpaque(false);
		f.setTitle("Calculator");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pinfo.add(linfo);
		linfo.setText("<html>This is a simple Java calculator. Use the dropdown to switch between modes"
				+ " and use the File menu to activate simple actions. The navigate menu allows you"
				+ " to open the memory (where you can save answers manually by pressing the M+ button) and history."
				+ " Buttons colored blue are operations. They take in two numbers,"
				+ " Type 1 number, press the operation, and press another."
				+ " Buttons colored whitish-blue alter 1 number." + " Have fun with the calculator!"
				+ "<br> Developed by Sameer Prakash 2020</html>");
		info.setTitle("Info");
		pinfo.add(closeInfo);
		info.add(pinfo);
		l.setText("");
		// ops
		clear.setPreferredSize(new Dimension(162, 65));
		// advanced
		linfo.setPreferredSize(new Dimension(600, 215));
		pinfo.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		info.setPreferredSize(new Dimension(700, 300));
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
		historyPanel.add(historyLabel);
		historyPanel.add(historyLabel);
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
		l.setPreferredSize(new Dimension(325, 55));
		l.setHorizontalAlignment(SwingConstants.RIGHT);
		dec.setPreferredSize(buttonSize);
		// adding comps

		editMenu.add(ctc);
		editMenu.add(undo);
		file.add(infom);
		file.add(close);
		viewMenu.add(memoryMenu);
		viewMenu.add(historyMenu);
		memoryMenu.setBorder(emptyBorder);
		memoryMenu.add(removeLastItem);
		memoryMenu.add(memoryItem);
		memoryMenu.add(clearMemory);
		historyMenu.add(historyMenuItem);
		historyMenu.add(historyClear);
		historyFrame.add(historyPanel);
		historyPanel.add(historyLabel);
		historyPanel.add(historyClose);
		mb.add(file);
		mb.add(editMenu);
		mb.add(viewMenu);
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
		f.addKeyListener(this);
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
		rollDice.addActionListener(this);
		mplus.addActionListener(this);
		memory.addActionListener(this);
		memoryMenu.addActionListener(this);
		clearMemory.addActionListener(this);
		historyMenuItem.addActionListener(this);
		historyClose.addActionListener(this);
		historyClear.addActionListener(this);
		removeLastItem.addActionListener(this);
		memoryItem.addActionListener(this);
		dropdown.addActionListener(this);
		infom.addActionListener(this);
		undo.addActionListener(this);
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

		// memframe
		memPanel.add(memLabel);
		memPanel.add(memClose);
		memFrame.add(memPanel);
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
			clear.setPreferredSize(new Dimension(135, 35));
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
			p.add(randMinL);
			p.add(randomMin);
			p.add(randMaxL);
			p.add(randomMax);
			p.add(randGen);
			p.add(randSet);
			p.add(rollDice);
			f.pack();
		}
		if (ae.getSource() == rollDice) {
			p.add(roll2Dice);
			f.setPreferredSize(new Dimension(800, 600));
			rollDiceS();
			f.pack();
		}
		if (ae.getSource() == roll2Dice) {
			p.add(roll2Dice);
			f.setPreferredSize(new Dimension(1100, 600));
			rollTwoDice();
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
			answersList.remove(answersList.size() - 1);
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

		if (ae.getSource() == historyMenuItem) {
			historyLabel.setText("History: " + history.toString());
			historyFrame.setVisible(true);
			historyFrame.pack();
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
		if (ae.getSource() == undo) {
			if (opPressed == false) {
				String number = number1.toString();
				number = number.substring(0, number.length() - 1);
				number1 = new BigDecimal(number);
				labelText = "" + number1;
				l.setText(labelText);
				f.pack();
			}
			if (opPressed == true) {
				if (number2.doubleValue() == 0) {
					opPressed = false;
				} else {
					String number = number2.toString();
					number = number.substring(0, number.length() - 1);
					number2 = new BigDecimal(number);
					labelText = "" + number2;
					l.setText(labelText);
					f.pack();
				}
			}
		}
		if (ae.getSource() == historyClose) {
			historyFrame.dispose();
			historyFrame.setVisible(false);
		}
		if (ae.getSource() == historyClear) {
			history.clear();
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
			double dy1 = answer.doubleValue();
			dy1 *= 1000000;
			dy1 = Math.round(dy1);
			dy1 /= 1000000;
			answer = new BigDecimal(dy1);
			answersList.add(dy1);
		}
		if (ae.getSource() == memory || ae.getSource() == memoryItem) {
			memLabel.setText("Memory: " + answersList.toString());
			memFrame.setVisible(true);
			memFrame.pack();
		}
		if (ae.getSource() == memClose) {
			memFrame.dispose();
			memFrame.setVisible(false);
		}
		if (ae.getSource() == memClose) {

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
				double an;
				if (n2 == 0) {
					an = 0;
					labelText = "Undefined";
				} else {
					an = n1 / n2;
					an *= 1000000;
					an = Math.round(an);
					an /= 1000000;
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
			double dy1 = answer.doubleValue();
			dy1 *= 1000000;
			dy1 = Math.round(dy1);
			dy1 /= 1000000;
			history.add(dy1);
			historyLabel.setText("History: " + history.toString());
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

		linfo.setFont(new Font("Consolas", Font.PLAIN, 16));
		l.setFont(new Font("Consolas", Font.PLAIN, 16));
		clear.setFont(new Font("Consolas", Font.PLAIN, 16));
		choose.setFont(new Font("Consolas", Font.PLAIN, 14));
		factorial.setFont(new Font("Consolas", Font.PLAIN, 16));
		sqrt.setFont(new Font("Consolas", Font.PLAIN, 16));
		percent.setFont(new Font("Consolas", Font.PLAIN, 16));
		log10.setFont(new Font("Consolas", Font.PLAIN, 14));
		ln.setFont(new Font("Consolas", Font.PLAIN, 14));
		cubeRoot.setFont(new Font("Consolas", Font.PLAIN, 14));
		memClose.setFont(new Font("Consolas", Font.PLAIN, 13));
		mplus.setFont(new Font("Consolas", Font.PLAIN, 14));
		memory.setFont(new Font("Consolas", Font.PLAIN, 14));
		abs.setFont(new Font("Consolas", Font.PLAIN, 14));
		mb.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		close.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		historyMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		closeInfo.setFont(new Font("Consolas", Font.PLAIN, 14));
		memoryItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ctc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		infom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		file.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		memoryMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		historyMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		historyClear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		historyLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		historyClose.setFont(new Font("Consolas", Font.PLAIN, 13));
		clearMemory.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		removeLastItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		viewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		undo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		memLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		dropdown.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		editMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
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
		rollDice.setBorder(emptyBorder);
		rollDice.setBackground(defaultColor);
		randSet.setBackground(defaultColor);
		randomMin.setPreferredSize(new Dimension(100, 20));
		randomMax.setPreferredSize(new Dimension(100, 20));
		rollDice.setPreferredSize(new Dimension(100, 40));
		randGen.setPreferredSize(new Dimension(100, 40));
		randSet.setPreferredSize(new Dimension(100, 40));
		randomMin.setFont(new Font("Consolas", Font.PLAIN, 14));
		randomMax.setFont(new Font("Consolas", Font.PLAIN, 14));
		randGen.setFont(new Font("Consolas", Font.PLAIN, 14));
		randSet.setFont(new Font("Consolas", Font.PLAIN, 14));
		rollDice.setFont(new Font("Consolas", Font.PLAIN, 14));
		randGen.setBackground(defaultColor);
		randMinL = new JLabel(" Min");
		randMaxL = new JLabel(" Max");
		randMinL.setFont(new Font("Consolas", Font.PLAIN, 14));
		randMaxL.setFont(new Font("Consolas", Font.PLAIN, 14));
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

	private void generateRand() {
		Random r = new Random();
		int min = Integer.parseInt(randomMin.getText());
		int max = Integer.parseInt(randomMax.getText());
		int rsan = r.nextInt(max - min + 1) + min;
		randGen.setText("" + rsan);
		f.pack();
	}

	private void rollTwoDice() {
		Random r = new Random();
		int rsan = r.nextInt(6 - 1 + 1) + 1;
		p.add(roll2Dice);
		if (rsan == 6) {
			new Voids().Image(p, "dice-six-faces-six.png");
			rollDiceS();
		}
		if (rsan == 5) {
			new Voids().Image(p, "dice-six-faces-five.png");
			rollDiceS();
		}
		if (rsan == 4) {
			new Voids().Image(p, "dice-six-faces-four.png");
			rollDiceS();
		}
		if (rsan == 3) {
			new Voids().Image(p, "dice-six-faces-three.png");
			rollDiceS();
		}
		if (rsan == 2) {
			new Voids().Image(p, "dice-six-faces-two.png");
			rollDiceS();
		}
		if (rsan == 1) {
			new Voids().Image(p, "dice-six-faces-one.png");
			rollDiceS();
		}
		f.pack();
	}

	private void rollDiceS() {
		Random r = new Random();
		int rsan = r.nextInt(6 - 1 + 1) + 1;
		if (rsan == 6) {
			new Voids().Image(p, "dice-six-faces-six.png");
		}
		if (rsan == 5) {
			new Voids().Image(p, "dice-six-faces-five.png");
		}
		if (rsan == 4) {
			new Voids().Image(p, "dice-six-faces-four.png");
		}
		if (rsan == 3) {
			new Voids().Image(p, "dice-six-faces-three.png");
		}
		if (rsan == 2) {
			new Voids().Image(p, "dice-six-faces-two.png");
		}
		if (rsan == 1) {
			new Voids().Image(p, "dice-six-faces-one.png");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	boolean shiftPressed = false;

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		boolean continueB = true;
		if (e.getKeyChar() == '1') {
			setn(1);
		}
		if (e.getKeyChar() == '2') {
			setn(2);
		}
		if (e.getKeyChar() == '3') {
			setn(3);
		}
		if (e.getKeyChar() == '4') {
			setn(4);
		}
		if (e.getKeyChar() == '5') {
			if (shiftPressed == true) {
				op = "%";
				opPressed = true;
				decPressed = false;
				decTimes = 0;
				shiftPressed = false;
				continueB = false;
			} else if (shiftPressed == false && continueB == true) {
				setn(5);
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_MINUS) {
			op = "-";
			opPressed = true;
			decPressed = false;
			decTimes = 0;
			shiftPressed = false;
		}
		if (e.getKeyChar() == '6') {
			if (shiftPressed == true) {
				op = "^";
				opPressed = true;
				decPressed = false;
				decTimes = 0;
				shiftPressed = false;
				continueB = false;
			} else if (shiftPressed == false && continueB == true) {
				setn(6);
			}
		}
		if (e.getKeyChar() == '7') {
			setn(7);
		}
	
		if (e.getKeyChar() == '8') {
			if (shiftPressed == true) {
				op = "x";
				opPressed = true;
				decPressed = false;
				decTimes = 0;
				shiftPressed = false;
				continueB = false;
			} else if (shiftPressed == false && continueB == true) {
				setn(8);
			}
		}
		if (e.getKeyChar() == '9') {
			setn(9);
		}
		if (e.getKeyChar() == '0') {
			setn(0);
		}
		if (e.getKeyChar() == 'c') {
			number1 = new BigDecimal(0);
			number2 = new BigDecimal(0);
			labelText = "";
			l.setText(labelText);
			opPressed = false;
			decPressed = false;
			f.pack();
			decTimes = 0;
		}
		if (e.getKeyChar() == '/') {
			op = "/";
			opPressed = true;
			decPressed = false;
			decTimes = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			shiftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_EQUALS) {
			if (shiftPressed == true) {
				op = "+";
				opPressed = true;
				decPressed = false;
				decTimes = 0;
				shiftPressed = false;
				continueB = false;
			} else if (shiftPressed == false && continueB == true) {
				MathContext m = new MathContext(6);
				if (op.equals("x")) {
					answer = number1.multiply(number2);
					answer = answer.round(m);
					labelText = "" + answer;
				}
				if (op.equals("/")) {
					double n1 = number1.doubleValue();
					double n2 = number2.doubleValue();
					double an;
					if (n2 == 0) {
						an = 0;
						labelText = "Undefined";
					} else {
						an = n1 / n2;
						an *= 1000000;
						an = Math.round(an);
						an /= 1000000;
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
				double dy1 = answer.doubleValue();
				dy1 *= 1000000;
				dy1 = Math.round(dy1);
				dy1 /= 1000000;
				history.add(dy1);
				historyLabel.setText("History: " + history.toString());
				number1 = answer;
				number2 = new BigDecimal(0);
				opPressed = false;
				decPressed = false;
				decTimes = 0;
				l.setText(labelText);
				f.pack();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}