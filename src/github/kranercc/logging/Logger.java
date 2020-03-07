package github.kranercc.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import javax.swing.text.DateFormatter;

import javazoom.jl.player.advanced.jlap;

public class Logger {

	private String fileNameString = "log.txt";
	
	
	public void log(String whatToLog)
	{
		Date date = new Date();
		String dataString = date.getDay() + "-" + date.getMonth() + "-" + date.getYear() + "-" + date.getHours() + "-" + date.getMinutes() + " <> " + whatToLog;
		
		File logFile = new File(fileNameString);
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(logFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedWriter outBufferedWriter = new BufferedWriter(fileWriter);
		try {
			outBufferedWriter.write(dataString);
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//date.getDay() + "-" + date.getMonth() + "-" + date.getYear() + "-" + date.getHours() + "-" + date.getMinutes() + " <> " + whatToLog
		
	}
	
	
}
