package github.kranercc.automations;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.Skeleton;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class SongPlayer {

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