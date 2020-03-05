package github.kranercc.randomMusic;

import java.util.ArrayList;
import java.util.Random;

import github.kranercc.utilities.Utils;

public class RandomMusicChooser {

	ArrayList<String> songStrings;
	
	private Utils utils;
	
	public RandomMusicChooser()
	{
		utils = new Utils();
		songStrings = utils.getAllSongs();

	}
	
	
	public void playRandomMusic()
	{
		Random random = new Random();
		int songNumberToBePlayed = random.nextInt(songStrings.size());
		
		
	}
	
	
}
