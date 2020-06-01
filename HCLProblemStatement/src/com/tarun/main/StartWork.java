package com.tarun.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.tarun.other.CsvSFTPConn;
import com.tarun.other.ReadCSV;
import com.tarun.other.UpateCSVToDB;

public class StartWork {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, SftpException, JSchException {
		ArrayList<String[]> alData = new ArrayList<String[]>();
		//will update the inbox folder
		CsvSFTPConn objCsvSFTPConn = new CsvSFTPConn();
		objCsvSFTPConn.getFilesFromServer();
		
		//Will read from inbox folder
		ReadCSV objReadCSV = new ReadCSV();
		alData = objReadCSV.getDataFromCSV().get("Result");
		
		//Update DB
		UpateCSVToDB objUpateCSVToDB = new UpateCSVToDB();
		objUpateCSVToDB.insertIntoDB(alData);
		
		//if insertion is successful we can records from inbox folder as well
	}

}
