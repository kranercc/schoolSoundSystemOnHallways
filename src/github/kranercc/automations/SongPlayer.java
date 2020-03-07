package github.kranercc.automations;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.Skeleton;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.text.DateFormatter;
import javax.xml.ws.AsyncHandler;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class SongPlayer {

	//special cases
	public void fireAlarm()
	{
		//playSong("fire.mp3");

	}
	public void bellRing()
	{
		playSong("bell.mp3");
		System.out.println("Canta colopotelu :D");
	}
	
	//ONLY MP3 AND WAV SUPPORT
	public void playSong(String songToBePlayedString){
		
		String songExtensionString = songToBePlayedString.substring(songToBePlayedString.lastIndexOf(".")+1);
				
		if(songExtensionString.equals("wav"))
		{
			System.out.println("Using WAV Logics...");
			Play_WAV(songToBePlayedString);
		}
		if(songExtensionString.equals("mp3"))
		{
			System.out.println("Using MP3 Logics...");
			Play_MP3(songToBePlayedString);
		
		}
		
	}
	
	public boolean shouldPlayBell()
	{
		ArrayList<Integer> musicHours = new ArrayList<Integer>(Arrays.asList(8,9,10,11,12,13,14));
		ArrayList<Integer> musicDaysArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		
		int hourNow = new Date().getHours();
		int minuteNow = new Date().getMinutes();
		int dayNow = new Date().getDay(); // luni e 1 
		
		//check for day
		if (musicDaysArrayList.contains(dayNow)) {
			//hour check
			if (musicHours.contains(hourNow)) {
				//iesire pana la orao 10 inclusiv
				if (minuteNow == 50 && hourNow <= 10 ) {
					return true;
				}
				//intrare pana la ora 10 inclusiv
				if (minuteNow == 0 && hourNow <= 10) {
					return true;
				}
				//iesire dupa ora 10
				if (minuteNow == 0 && hourNow > 10) {
					return true;
				}
				//intrare dupa ora 10
				if (minuteNow == 10 && hourNow > 10) {
					return true;
				}
			}
		}
		System.out.format("Checked for bell at H:%d-M:%d\n", hourNow,minuteNow);
		return false;
	}
	
	public boolean shouldPlayMusic()
	{
		
		ArrayList<Integer> musicHours = new ArrayList<Integer>(Arrays.asList(8,9,10,11,12,13,14));
		ArrayList<Integer> musicDaysArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		
		
		int hourNow = new Date().getHours();
		int minuteNow = new Date().getMinutes();
		int dayNow = new Date().getDay(); // luni e 1 
		
		//check for day
		if (musicDaysArrayList.contains(dayNow)) {
			//hour and minute check
			if (musicHours.contains(hourNow)) {
				
				if (hourNow <= 10 && minuteNow >= 51 ) {
					return true;
				}
				
				
				if (hourNow > 10 && minuteNow >= 1) {
					return true;
				}
				
				
			}			
			
		}	
		
		//System.out.println(hourNow + "<>" + minuteNow + "<>" + dayNow);
		return false;
	}
	
	private void Play_WAV(String nameString)
	{	
		//wav support
				File file = new File(nameString);
				AudioInputStream audioStream = null;
				try {
					audioStream = AudioSystem.getAudioInputStream(file);
				} catch (UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				AudioFormat format = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip audioClip = null;
				try {
					audioClip = (Clip) AudioSystem.getLine(info);
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					audioClip.open(audioStream);
				} catch (LineUnavailableException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				audioClip.start();
				
	}
	
	private void Play_MP3(String nameString)
	{
		//mp3 support
				try {
					FileInputStream fileInputStream = new FileInputStream(nameString);
					Player player = new Player(fileInputStream);
					player.play();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
				
	}
	
}