package org.densyakun.peoplelist.application;

import java.awt.Choice;

import org.densyakun.peoplelist.common.Person.Gender;

@SuppressWarnings("serial")
public class GenderChoice extends Choice {
	
	public GenderChoice() {
		super();
		add("なし");
		add("男性");
		add("女性");
	}
	
	public Gender getGender() {
		return getSelectedIndex() == 1 ? Gender.Man : getSelectedIndex() == 2 ? Gender.Woman : Gender.None;
	}
	
}
