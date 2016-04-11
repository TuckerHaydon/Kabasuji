package playerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Level;

public class PlayLevel implements ActionListener {

	KabasujiPlayerApplication app;
	GameModel m;
	int levelNum;

	public PlayLevel(KabasujiPlayerApplication app, GameModel m, int ln){
		this.app = app;
		this.m = m;
		this.levelNum = ln;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if(m.getLevels()[levelNum].getIsUnlocked())
		{
			app.displayGameWindow();
		}
		
		
		//app.displayGameWindow();
	}

}
