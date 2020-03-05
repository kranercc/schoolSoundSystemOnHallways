package github.kranercc.utilities;

import java.io.File;
import java.util.ArrayList;

import javax.naming.spi.DirectoryManager;

public class Utils {

	public ArrayList<File> getAllFileStrings()
	{
		ArrayList<File> filesInDirectoryArrayList = new ArrayList<File>();
		File folderFile = new File(".");
		
		
		for (File f : folderFile.listFiles()) {
			
			filesInDirectoryArrayList.add(f);
		}
		
		return filesInDirectoryArrayList;
	}
	
	
	public ArrayList<String> getAllSongs()
	{
		ArrayList<String> songsInFiles = new ArrayList<String>();
		
		
		for (File f : getAllFileStrings()) {
			
			if(f.toString().contains(".mp3") || f.toString().contains(".wav"))
			{
				songsInFiles.add(f.getName());
			}
		}
		
		
		
		return songsInFiles;
	}
	
	
}
