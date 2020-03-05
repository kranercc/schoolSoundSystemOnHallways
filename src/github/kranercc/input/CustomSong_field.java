package github.kranercc.input;

import javax.swing.JLabel;
import javax.swing.JTextField;

import github.kranercc.automations.SongPlayer;


public class CustomSong_field {

	private SongPlayer songPlayer;
	
	public CustomSong_field () {
		songPlayer = new SongPlayer();
	}
	//
	// delete what was in the tedxt box and then play the song it wanted
	//
	public void delete_and_play(JTextField jtf, JLabel currSongField)
	{
		
		currSongField.setText("Now Playing: " + jtf.getText());

		//play song
		songPlayer.playSong(jtf.getText());
		//System.out.println(jtf.getText());
		
		//remove the song from text search
		jtf.setText("");
	}
}
