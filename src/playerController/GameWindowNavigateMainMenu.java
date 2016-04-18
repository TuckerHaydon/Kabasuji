package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class GameWindowNavigateMainMenu implements ActionListener{
	KabasujiPlayerApplication app;
	GameModel m;
	
	public GameWindowNavigateMainMenu(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//DONT DELET THE COMMENT!!!!!!!!!!!!!!!!

		if(m.getCurrentAM().updateAchievement_whenquit()){
			m.getCurrentAM().popUpScreen();
		}
		m.getGAM().reset();
		
		System.out.println("AM is checking stuff");
		app.displayMainMenu();
	}

}
