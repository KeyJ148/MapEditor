package gui.control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.FrameMain;

public class PanelControl extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton button1, button2;
	
	public PanelControl() {
		setLayout(new FlowLayout(FlowLayout.LEADING, 5, 3));
		
		setPreferredSize(new Dimension(getWidth(), 30));
		
		button1 = new JButton();
		button1.setPreferredSize(new Dimension(25, 25));
		button1.addActionListener(this);
		add(button1);
		
		button2 = new JButton();
		button2.setPreferredSize(new Dimension(25, 25));
		button2.addActionListener(this);
		add(button2);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(122, 138, 153));
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) actionButton1();
		if (e.getSource().equals(button2)) actionButton2();
	}

	private void actionButton1() {
		FrameMain.getInstance().getPanelMain().getPanelMap().getGrid().turn();
	}

	private void actionButton2() {
		System.out.println("Button 2!");
	}

}
