package github.kranercc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import github.kranercc.input.CustomSong_field;
import github.kranercc.randomMusic.RandomMusicChooser;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainControlUI extends JFrame {

	private JPanel mainContentPane;
	private JTextField textFieldSongName;
	private CustomSong_field customSong_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainControlUI frame = new MainControlUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainControlUI() {
		customSong_field = new CustomSong_field();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainContentPane = new JPanel();
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainContentPane);
		mainContentPane.setLayout(null);
		
		JLabel lblCustomSongName = new JLabel("Custom song name");
		lblCustomSongName.setBounds(30, 16, 160, 16);
		mainContentPane.add(lblCustomSongName);
		
		textFieldSongName = new JTextField();
		textFieldSongName.setToolTipText("Song name...");
		textFieldSongName.setBounds(30, 36, 130, 26);
		mainContentPane.add(textFieldSongName);
		textFieldSongName.setColumns(10);
		

		JLabel lblCurrentSong = new JLabel("Now Playing: ");
		lblCurrentSong.setBounds(30, 115, 395, 16);
		mainContentPane.add(lblCurrentSong);
		
		JButton btnChangeSong = new JButton("Change Song");
	
		ArrayList<Thread> threads = new ArrayList<Thread>();
		btnChangeSong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//la threadu asta n-am stat muult decat vreo 3 episoade din riverdale
				Thread t1 = new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	customSong_field.delete_and_play(textFieldSongName, lblCurrentSong);
				    }
				});
				threads.add(t1);
				try {
					threads.get(0).start();
				} catch (Exception e2) {
					// TODO: handle exception
				}

				if(threads.size() > 1)
				{
					threads.get(0).stop();
					threads.get(1).start();
					threads.remove(0);
				}
			}
		});
		btnChangeSong.setBounds(172, 36, 117, 29);
		mainContentPane.add(btnChangeSong);
		
		JCheckBox chckbxAutoPlay = new JCheckBox("Auto Play (Random)");
		chckbxAutoPlay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckbxAutoPlay.isSelected())
				{
					new RandomMusicChooser().playRandomMusic();
				}
			}
		});
		
		chckbxAutoPlay.setBounds(30, 159, 160, 23);
		mainContentPane.add(chckbxAutoPlay);
		
	}
}
