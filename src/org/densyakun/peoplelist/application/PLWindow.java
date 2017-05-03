package org.densyakun.peoplelist.application;

import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.densyakun.peoplelist.common.Person;

@SuppressWarnings("serial")
public class PLWindow extends JFrame implements ActionListener {
	public static final String version = "0.0.1";
	
	public static int width = 854;
	public static int height = 480;
	
	MenuItem menuFileExit;
	MenuItem menuReload;
	MenuItem menuNewPerson;
	PLListTable playerlistpanel;
	PLTreeDiagram treediagrampanel;
	
	public PLWindow() {
		super("PeopleList（仮） " + version);
		
		/*BufferedImage a = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
		Graphics b = a.getGraphics();
		b.setColor(Color.white);
		b.fillOval(0, 0, 64, 64);
		b.setColor(Color.cyan);
		b.fillPolygon(new int[] { 8, 55, 31 }, new int[] { 8, 8, 55 }, 3);
		b.setColor(Color.black);
		b.drawOval(0, 0, 16, 16);
		b.drawOval(48, 0, 16, 16);
		b.drawOval(24, 48, 16, 16);
		b.setColor(Color.red);
		b.setFont(new Font("Arial", Font.BOLD, 16));
		b.drawString("Srv-Ctrl", 0, 40);
		setIconImage(a);*/
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(width, height));
		pack();
		
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		
		Menu menuFile = new Menu("ファイル");
		
		menuBar.add(menuFile);
		
		/*
		MenuItem menuOpen = new MenuItem("Open...", new MenuShortcut('O'));
		menuFile.add(menuOpen);
		
		menuFile.addSeparator();
		
		MenuItem menuExit = new MenuItem("Exit");
		menuFile.add(menuExit);
		
		Menu menuView = new Menu("View");
		menuView.addActionListener(this);
		menuBar.add(menuView);
		
		CheckboxMenuItem menuStatusBar = new CheckboxMenuItem("Status Bar");
		menuStatusBar.addItemListener(this);
		menuView.add(menuStatusBar);
		
		Menu menuSize = new Menu("Size");
		menuSize.addActionListener(this);
		menuView.add(menuSize);*/
		
		Menu menuFileNew = new Menu("新規");
		menuFile.add(menuFileNew);
		
		menuNewPerson = new MenuItem("人物");
		menuNewPerson.addActionListener(this);
		menuFileNew.add(menuNewPerson);
		
		menuReload = new MenuItem("リロード", new MenuShortcut(KeyEvent.VK_F5));
		menuReload.addActionListener(this);
		menuFile.add(menuReload);
		
		menuFileExit = new MenuItem("終了");
		menuFileExit.addActionListener(this);
		menuFile.add(menuFileExit);
		
		JTabbedPane tp = new JTabbedPane();
		tp.add("人物一覧", new JScrollPane(playerlistpanel = new PLListTable()));
		tp.add("家系図", treediagrampanel = new PLTreeDiagram());
		
		reloadPeople();
		
		add(tp);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuFileExit) {
			System.exit(0);
		}
		if (e.getSource() == menuNewPerson) {
			new AddPersonDialog(this);
		}
		if (e.getSource() == menuReload) {
			reloadPeople();
		}
	}
	
	public void reloadPeople() {
		Person[] pl = PLApplication.app.people.toArray(new Person[0]);
		playerlistpanel.setPeopleList(pl);
		treediagrampanel.setPeopleList(pl);
	}
	
}
