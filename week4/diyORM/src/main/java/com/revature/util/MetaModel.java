package com.revature.util;

import java.lang.reflect.Field;
import java.util.List;

import com.revature.annotations.Column;

public class MetaModel<T> {

	private Class<T> clazz;
	// private IdField primarykeyField;
	private List<ColumnField> columnFields;
	// private List<ForeignKeyField> foreignKeyFields
	
	// of() method to take in a class and transform it to a meta model
	
	
	public List<ColumnField> getColumns() {
		
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			
			Column column = field.getAnnotation(Column.class);
			if (column != null) {
				columnFields.add(new ColumnField(field));
			}
		}
		
		return columnFields;		
	}
	
	
	
	
	
	
}
