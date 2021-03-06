package com.revature.objectmapper;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

import com.revature.util.MetaModel;

public class ObjectRemover extends ObjectMapper{
	
	public boolean removeObjectFromDb(Object obj, Connection conn) {
		
		MetaModel<?> model = MetaModel.of(obj.getClass()); // use this to creaet an instance of the object
		
		
		String primaryKey = model.getPrimaryKey().getName(); // change this to IdField
		String sql 		  = "DELETE from " + model.getSimpleClassName() + " where " + primaryKey + "= ?"; // create some type of method that returns the table name in MetaModel;
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		// we want to grab meta data from this statement
		ParameterMetaData pd = pstmt.getParameterMetaData();
		
		// instead of Method, maybe pass in a hashmap containing info about the object that you
		setStatement(pstmt, pd, obj, 1);
		
		//ObjectCache class...
		
		
		
		
		// then call acustom setStatement method
		
		
		pstmt.executeUpdate();
		
	}
	
	
	

}
