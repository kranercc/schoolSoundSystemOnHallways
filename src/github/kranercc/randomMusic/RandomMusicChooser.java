package github.kranercc.randomMusic;

import java.util.ArrayList;
import java.util.Random;

import github.kranercc.automations.SongPlayer;
import github.kranercc.utilities.Utils;

public class RandomMusicChooser {
	public SongPlayer songPlayer;
	
	ArrayList<String> songStrings;
	
	private Utils utils;
	
	public RandomMusicChooser()
	{
		utils = new Utils();
		songStrings = utils.getAllSongs();
		songPlayer = new SongPlayer();
	}
	
	
	public void playRandomMusic()
	{
		Random random = new Random();
		int songNumberToBePlayed = random.nextInt(songStrings.size());
		
		songPlayer.playSong(songStrings.get(songNumberToBePlayed));
		
	}
	
	
}
