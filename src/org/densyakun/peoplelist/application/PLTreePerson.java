package org.densyakun.peoplelist.application;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PLTreePerson extends JButton {
	
	public static int width = 24 * 2;
	public static int height = 24 * 5;
	
	public PLTreePerson(int x, int y) {
		super(x + ", " + y);
		
		setPreferredSize(new Dimension(width, height));
		
		//setBorderPainted(false);
		setContentAreaFilled(false);
		
		Font font = getFont();
		font = font.deriveFont(14f);
		setFont(font);
		
		setMargin(new Insets(0, 0, 0, 0));
	}
	
}
