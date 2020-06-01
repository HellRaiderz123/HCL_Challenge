package com.tarun.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpateCSVToDB {
	
	public void insertIntoDB(ArrayList<String[]> alData) throws ClassNotFoundException, SQLException {
		
		//Oracle DB Conn
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
		
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("Insert into call_rec_data () values (?,?,?,?,?)");
		
		PreparedStatement pstmt = con.prepareStatement(sbInsert.toString()); 
		
		for(String[] strData : alData) {
			
			pstmt.setString(0, strData[0]);
			pstmt.setString(0, strData[1]);
			pstmt.setString(0, strData[2]);
			pstmt.setString(0, strData[3]);
			pstmt.setString(0, strData[4]);
			
			pstmt.addBatch();
			
		}
		pstmt.executeBatch();
		
	}

}
