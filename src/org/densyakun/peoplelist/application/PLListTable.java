package org.densyakun.peoplelist.application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.densyakun.peoplelist.common.Person;

@SuppressWarnings("serial")
public class PLListTable extends JTable {
	
	private static Object[] columnNames = new Object[] { "名前", "性別" };
	
	private DefaultTableModel tableModel;
	
	public PLListTable() {
		super();
		
		setModel(tableModel = new DefaultTableModel(null, columnNames));
		
		//TODO 編集可能。編集した場合に変更を反映させる
		//table.setEnabled(false);
		
	}
	
	public void setPeopleList(Person[] people) {
		List<Object[]> dataVector = new ArrayList<Object[]>();
		for (int a = 0; a < people.length; a++) {
			dataVector.add(new Object[] { people[a].getName(), people[a].isMan() ? "男" : people[a].isWoman() ? "女" : "なし" });
		}
		tableModel.setDataVector(dataVector.toArray(new Object[0][0]), columnNames);
	}
	
}
