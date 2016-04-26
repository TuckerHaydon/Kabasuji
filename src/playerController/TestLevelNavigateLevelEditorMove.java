package playerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.LevelEditor;
import playerBoundary.KabasujiPlayerApplication;

public class TestLevelNavigateLevelEditorMove implements ActionListener{
	KabasujiPlayerApplication playerapp;
	KabasujiBuilderApplication builderapp;
	
	public TestLevelNavigateLevelEditorMove(KabasujiPlayerApplication playerapp,KabasujiBuilderApplication builderapp){
		this.playerapp=playerapp;
		this.builderapp=builderapp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.playerapp.getGameWindow().setVisible(false);
		this.builderapp.getLevelEditor().setVisible(true);
	}
	
}
