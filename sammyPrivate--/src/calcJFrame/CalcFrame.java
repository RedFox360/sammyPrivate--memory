package calcJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CalcFrame implements ActionListener {
	public JFrame f = new JFrame();
	private JPanel p = new JPanel();
	private JButton plus = new JButton();
	private JButton minus = new JButton();
	private JButton x = new JButton();
	private JButton slash = new JButton();
	private JButton e = new JButton();
	private JLabel l = new JLabel();
	private JButton clear = new JButton();
	//numbers
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
	int number1;
	int number2;
	public void run() {
		f.setTitle("Calculator");
		f.setVisible(true);
		//text setting
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
			l.setText("TEST");
			dec.setText(".");
		//ops
			clear.setPreferredSize(new Dimension(105, 50));
			b7.setPreferredSize(new Dimension(50, 50));
			b8.setPreferredSize(new Dimension(50, 50));
			b9.setPreferredSize(new Dimension(50, 50));
			b4.setPreferredSize(new Dimension(50, 50));
			b5.setPreferredSize(new Dimension(50, 50));
			b6.setPreferredSize(new Dimension(50, 50));
			b1.setPreferredSize(new Dimension(50, 50));
			b0.setPreferredSize(new Dimension(55, 50));
			b2.setPreferredSize(new Dimension(50, 50));
			b3.setPreferredSize(new Dimension(50, 50));
			plus.setPreferredSize(new Dimension(50, 50));
			x.setPreferredSize(new Dimension(50, 50));
			slash.setPreferredSize(new Dimension(50, 50));
			minus.setPreferredSize(new Dimension(50, 50));
			e.setPreferredSize(new Dimension(155, 50));
			Color backgroundofe = new Color(153, 255, 153);
			e.setBackground(backgroundofe);
			f.setPreferredSize(new Dimension(250, 380));
			l.setPreferredSize(new Dimension(200, 50));
			dec.setPreferredSize(new Dimension(50, 50));
		//adding comps
			p.add(l);
			p.add(clear);
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
			p.add(b0);
			
			p.add(e);
			
			f.add(p);
			
		//adding actionlisteners
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
		//op
			f.pack();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b7) {
			
		}
	}
}