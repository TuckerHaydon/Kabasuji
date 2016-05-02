package playerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.LevelEditor;
import playerBoundary.KabasujiPlayerApplication;
/**
 * Used for the builder testing level purpose
 * @author Dorothy
 *
 */
public class TestLevelNavigateLevelEditorMove implements ActionListener{
	KabasujiPlayerApplication playerapp;
	KabasujiBuilderApplication builderapp;
	
	/**
	 * Constructor for TestLevelNavigateLevelEditorMove
	 * @param playerapp KabasujiPlayerApplication
	 * @param builderapp KabasujiBuilderApplication
	 */
	public TestLevelNavigateLevelEditorMove(KabasujiPlayerApplication playerapp,KabasujiBuilderApplication builderapp){
		this.playerapp=playerapp;
		this.builderapp=builderapp;
	}
	
	/**
	 * Displaying LevelEditor in builder side and hide the GameWindow
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.playerapp.getGameWindow().setVisible(false);
		this.builderapp.getLevelEditor().setVisible(true);
	}
	
}
