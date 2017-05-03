package org.densyakun.peoplelist.application;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.densyakun.peoplelist.common.Person;

@SuppressWarnings("serial")
public class AddPersonDialog extends JDialog implements ActionListener, KeyListener, TextListener {
	
	public static int width = 640;
	public static int height = 24 * 5;
	public static int margin = 120;
	
	private TextField name_tf;
	private GenderChoice gender_choice;
	private Button add_button;
	private Button close_button;
	private PersonChoice papa_choice;
	private PersonChoice mama_choice;
	
	public AddPersonDialog(Frame owner) {
		super(owner, "人物を追加", true);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(width, height));
		pack();
		
		setFocusable(true);
		addKeyListener(this);
		
		setLayout(null);
		
		reload();
		
		setVisible(true);
	}
	
	public void reload() {
		getContentPane().removeAll();
		
		Label name_label = new Label("名前:");
		name_label.setBounds(0, 0, margin, 24);
		add(name_label);
		
		name_tf = new TextField();
		name_tf.setBounds(margin, 0, width - margin * 2, 24);
		name_tf.addKeyListener(this);
		name_tf.addTextListener(this);
		add(name_tf);
		
		Label gender_label = new Label("性別:");
		gender_label.setBounds(0, 24, margin, 24);
		add(gender_label);
		
		gender_choice = new GenderChoice();
		gender_choice.setBounds(margin, 24, width - margin * 2, 24);
		gender_choice.addKeyListener(this);
		add(gender_choice);
		
		Label papa_label = new Label("父親:");
		papa_label.setBounds(0, 24 * 2, margin, 24);
		add(papa_label);
		
		papa_choice = new PersonChoice(Person.getMens(PLApplication.app.people).toArray(new Person[0]));
		papa_choice.setBounds(margin, 24 * 2, width - margin * 2, 24);
		papa_choice.addKeyListener(this);
		add(papa_choice);
		
		Label mama_label = new Label("母親:");
		mama_label.setBounds(0, 24 * 3, margin, 24);
		add(mama_label);
		
		mama_choice = new PersonChoice(Person.getWomens(PLApplication.app.people).toArray(new Person[0]));
		mama_choice.setBounds(margin, 24 * 3, width - margin * 2, 24);
		mama_choice.addKeyListener(this);
		add(mama_choice);
		
		add_button = new Button("追加");
		add_button.setBounds(margin, 24 * 4, width / 2 - margin, 24);
		add_button.addActionListener(this);
		add_button.addKeyListener(this);
		add(add_button);
		
		close_button = new Button("閉じる");
		close_button.setBounds(width / 2, 24 * 4, width / 2 - margin, 24);
		close_button.addActionListener(this);
		close_button.addKeyListener(this);
		add(close_button);
		
		addable_check();
	}
	
	public String getPersonName() {
		return name_tf.getText().trim();
	}
	
	public void addable_check() {
		add_button.setEnabled(!getPersonName().isEmpty());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add_button) {
			Person test = new Person(getPersonName());
			
			test.setGender(gender_choice.getGender());
			
			for (int a = 0; a < 20; a++) {
				PLApplication.app.addPerson(test);
			}
			
			reload();
		}
		
		if (e.getSource() == close_button) {
			setVisible(false);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 27) {
			setVisible(false);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void textValueChanged(TextEvent e) {
		addable_check();
	}
	
}
