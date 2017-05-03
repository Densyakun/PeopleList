package org.densyakun.peoplelist.common;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String name_key = "name";
	private static final String gender_key = "gender";
	private static final String papa_key = "papa";
	private static final String mama_key = "mama";
	
	//写真
	//地図
	
	public enum Gender {
		Man, Woman, None;
	}
	
	public HashMap<String, Object> metadata = new HashMap<String, Object>();
	
	public Person(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		if (name == null) {
			metadata.put(name_key, "");
		} else {
			metadata.put(name_key, name);
		}
	}
	
	public String getName() {
		return (String) metadata.get(name_key);
	}
	
	public void setGender(Gender gender) {
		if (gender == null) {
			metadata.remove(gender_key);
		} else if (gender == Gender.None) {
			metadata.remove(gender_key);
		} else {
			metadata.put(gender_key, gender == Gender.Woman);
		}
	}
	
	public Gender getGender() {
		Object obj = metadata.get(gender_key);
		if (obj != null && obj instanceof Boolean) {
			return (Boolean) obj ? Gender.Woman : Gender.Man;
		} else {
			return Gender.None;
		}
	}
	
	public boolean isMan() {
		return getGender() == Gender.Man;
	}

	public boolean isWoman() {
		return getGender() == Gender.Woman;
	}
	
	public void setPapa(Person papa) {
		if (papa == null) {
			metadata.remove(papa_key);
		} else if (papa.isMan()) {
			metadata.put(papa_key, papa);
		}
	}
	
	public Person getPapa() {
		Object obj = metadata.get(papa_key);
		if (obj != null && obj instanceof Person) {
			return (Person) obj;
		} else {
			return null;
		}
	}
	
	public void setMama(Person mama) {
		if (mama == null) {
			metadata.remove(mama_key);
		} else if (mama.isWoman()) {
			metadata.put(mama_key, mama);
		}
	}
	
	public Person getMama() {
		Object obj = metadata.get(mama_key);
		if (obj != null && obj instanceof Person) {
			return (Person) obj;
		} else {
			return null;
		}
	}
	
	public static List<Person> getMens(List<Person> people) {
		List<Person> a = new ArrayList<Person>(people);
		for (int b = 0; b < a.size();) {
			if (!a.get(b).isMan()) {
				a.remove(b);
			} else {
				b++;
			}
		}
		return a;
	}
	
	public static List<Person> getWomens(List<Person> people) {
		List<Person> a = new ArrayList<Person>(people);
		for (int b = 0; b < a.size();) {
			if (!a.get(b).isWoman()) {
				a.remove(b);
			} else {
				b++;
			}
		}
		return a;
	}
	
}
