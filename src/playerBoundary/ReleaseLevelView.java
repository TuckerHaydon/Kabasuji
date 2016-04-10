package playerBoundary;

import javax.swing.JButton;
import javax.swing.JFrame;

import playerEntity.Level;
import playerEntity.ReleaseLevel;

public class ReleaseLevelView extends LevelView {

	public ReleaseLevelView(ReleaseLevel relLvl) {
		this.level = relLvl;
		goToMenu = new JButton("Main Menu");
	}
	
	public void initView(){
		/*// Set properties of the frame
		this.setSize(1000,1000);
		this.setTitle("Release Level");
		
		
		
		// Add the buttons
		this.add(goToMenu);
		*/
	}

}
