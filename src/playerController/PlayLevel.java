package playerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;

public class PlayLevel implements ActionListener {

	KabasujiPlayerApplication app;
	GameModel m;
	Level l;

	public PlayLevel(KabasujiPlayerApplication app, GameModel m, Level l){
		this.app = app;
		this.m = m;
		this.l = l;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(l.isUnlocked){
			app.displayGameWindow();
		}
	}

}
