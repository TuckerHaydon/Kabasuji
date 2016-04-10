package playerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class PlayLevel implements ActionListener {

	KabasujiPlayerApplication app;
	GameModel m;
	int levelNum;
	
	public PlayLevel(KabasujiPlayerApplication app, GameModel m, int levelNum){
		this.app = app;
		this.m = m;
		this.levelNum = levelNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		app.displayGameWindow();
		
	}

}
