package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class GameWindowNavigateMainMenu implements ActionListener{
	KabasujiPlayerApplication app;
	GameModel m;
	
	public GameWindowNavigateMainMenu(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		playCatScreech();
		if(m.getCurrentAM().updateAchievement_whenquit()){
			m.getCurrentAM().popUpScreen();
		}
		m.getGAM().reset();
		
		System.out.println("AM is checking stuff");
		app.displayMainMenu();
	}
	
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
