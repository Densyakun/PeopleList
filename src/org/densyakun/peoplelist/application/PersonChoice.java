package org.densyakun.peoplelist.application;

import java.awt.Choice;

import org.densyakun.peoplelist.common.Person;

@SuppressWarnings("serial")
public class PersonChoice extends Choice {
	
	private Person[] people;
	
	public PersonChoice(Person[] people) {
		super();
		
		this.people = people;
		
		add("なし");
		
		for (int a = 0; a < people.length; a++) {
			add(people[a].getName());
		}
	}
	
	public Person getPerson() {
		int i = getSelectedIndex();
		return i == 0 ? null : people[i + 1];
	}
	
}
