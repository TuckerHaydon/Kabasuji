package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.LightningLevel;

/**
 * Controller for going to the main menu
 * @author tuckerhaydon
 *
 */
public class GameWindowNavigateMainMenu implements ActionListener{
	KabasujiPlayerApplication app;
	GameModel m;
	
	/**
	 * Constructor for GameWindowNavigateMainMenu
	 * @param app - top-level kabasuji player application
	 * @param m - top-level game model
	 */
	public GameWindowNavigateMainMenu(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
	}
	
	/**
	 * Handles action events on the main menu.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	/**
	 * Resets certain game details when the player goes back to the main menu
	 * If the lightning level is being played, the timer is stopped
	 * If RageQuit is unlocked, a cat screeches
	 */
	void processAction(){
		
		// Release any dragged tiles
		try{
		app.getGameWindow().releaseDraggedTile();}
		catch(NullPointerException e){} // noop
		
		// Stop any timers
		try{
			((LightningLevel)(m.getCurrentLevel())).stopTimer();
		}
		catch(Exception e){} // Noop
		
		playCatScreech();
		if(m.getCurrentAM().updateAchievement_whenquit()){
			m.getCurrentAM().popUpScreen();
		}
		m.getGAM().reset();
		
		app.displayMainMenu();
	}
	
	/**
	 * Plays the sound of a glorious screeching cat. Provides a feeling similar to listening to our splash screen song.
	 */
	void playCatScreech(){
		try {
			File f = new File("src/resources/audio/cat_screech.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(f));
			clip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
