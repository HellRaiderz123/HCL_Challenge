package com.tarun.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadCSV {
	
	public HashMap<String, ArrayList<String[]>> getDataFromCSV() throws IOException{
		
		ArrayList<String[]> alData = new ArrayList<String[]>();
		BufferedReader bfr;
		String strPath = "inbox";
		File inbox = new File(strPath);
		File[] fileNames = inbox.listFiles();
		String[] data;
		HashMap<String, ArrayList<String[]>> hmData = new HashMap<String, ArrayList<String[]>>();
		for(File file : fileNames) {
			
			bfr = new BufferedReader(new FileReader(file));
			String values;
			while ((values = bfr.readLine()) != null) {
	            data = values.split(",");
//	            String strResTime = data[0];
//	            String strGPrd = data[1];
//	            String strObjName = data[2];
//	            String strCellId = data[3];
//	            String strCallAtmpt = data[4];
	
//	            System.out.println(strResTime + " ----" + strGPrd);
	            alData.add(data);
	            hmData.put("Result", alData);
	            
	        }
	
	        bfr.close();
			
		}
		
		return hmData;
		
	}

}
