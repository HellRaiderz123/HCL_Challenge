package com.tarun.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class CsvSFTPConn {
	
	public void getFilesFromServer() throws SftpException, JSchException, IOException {
		 File newFile;
		 byte[] buffer = new byte[1024];  
		//SFTP conn to get the files from oerticular folder from server and paste it to inbox folder and when insertion is done, will delte the files
		
		JSch jsch = new JSch();

		String user ="user";
		String password ="pass";

		String host = "ftp://something.some"; // remote host address
		Session session = jsch.getSession(user, host);
		session.setPassword(password);
		session.connect();

		ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
		try {
			sftpChannel.connect();
		} catch (JSchException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		Vector<LsEntry> directoryEntries = sftpChannel.ls("*.csv");
		for (LsEntry file : directoryEntries) {
			System.out.println(String.format("File - %s", file.getFilename()));
			
			//Check foe existing
			File f = new File("inbox//"+String.format("File - %s", file.getFilename()));
			if(!(f.exists() && !f.isDirectory())) { 
			  
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file.getFilename()));  
			newFile = new File("inbox//"+String.format("File - %s", file.getFilename())); 
	        OutputStream os = new FileOutputStream(newFile);  
	        BufferedOutputStream bos = new BufferedOutputStream(os);  
	        int readCount;  

	        while( (readCount = bis.read(buffer)) > 0) 
	        {  
	        System.out.println("Writing files to disk: " );  
	        bos.write(buffer, 0, readCount);  
	        }  
	        bis.close();  
	        bos.close();  
	        }
		}
      
		sftpChannel.exit();
		session.disconnect();
		
	}

}
