
package playerBoundary;

import javax.swing.JButton;

import playerEntity.Level;
import playerEntity.ReleaseLevel;

public class ReleaseLevelView extends LevelView {

	public ReleaseLevelView(ReleaseLevel relLvl) {
		this.level = relLvl;
		goToMenu = new JButton("Main Menu");
	}

}
