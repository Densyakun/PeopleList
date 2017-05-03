package org.densyakun.peoplelist.application;

import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JScrollPane;

import org.densyakun.peoplelist.common.Person;

@SuppressWarnings("serial")
public class PLTreeDiagram extends JScrollPane {
	
	public PLTreeDiagram() {
		super();
		
		Panel panel = new Panel();
		
		FlowLayout layout = new FlowLayout();
		layout.setHgap(40);
		layout.setVgap(40);
		
		panel.setLayout(layout);
		
		int w = 10;
		int h = 10;
		
		//setSize(w * PLTreePerson.width, h * PLTreePerson.height);
		
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				panel.add(new PLTreePerson(x, y));
			}
		}
	}
	
	public void setPeopleList(Person[] people) {
		
	}
	
}
