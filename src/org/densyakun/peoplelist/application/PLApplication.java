package org.densyakun.peoplelist.application;

import java.util.ArrayList;

import org.densyakun.peoplelist.common.Person;

public class PLApplication {
	
	public static PLApplication app;
	
	public static void main(String[] args) {
		new PLApplication();
	}
	
	public ArrayList<Person> people;
	public PLWindow window;
	
	public PLApplication() {
		app = this;
		
		people = new ArrayList<Person>();
		window = new PLWindow();
	}
	
	public void addPerson(Person person) {
		people.add(person);
		window.reloadPeople();
	}
	
}
