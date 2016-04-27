package playerBoundary;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import builderController.NavigateMainMenu;
import playerController.LevelController;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.ReleaseLevel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class ReleaseLevelView extends LevelView{
	
	ReleaseLevel level;
	
	public ReleaseLevelView(KabasujiPlayerApplication app, GameModel m, ReleaseLevel releaseLvl) {
		super(app, m, releaseLvl);
		
		level = releaseLvl;
		this.m=m;
		this.app = app;
		
		// Initialize the sub-view components
		bullpenView = new BullpenView(app, m, level.getBullpen());
		boardView = new BoardView(app, m, level.getBoard());
	}

	@Override
	public void initView() {
		
		// Init the subcomponets views
		bullpenView.initView();
		boardView.initView();
		
		//set properties of the view
		this.setSize(900, 900);
		
		// No layout; using exact coordinates.
		setLayout(null);
		
		// Create the scrollPane
		scrollPane = new JScrollPane(bullpenView, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(25, 25, 850, 7*bullpenView.getSquareWidth());
		add(scrollPane);		
		
		// Add the boardView
		boardView.setBounds(25, 8*bullpenView.getSquareWidth(), 12*bullpenView.getSquareWidth(), 12*bullpenView.getSquareWidth());
		add(boardView);
		
		//3 stars hence that max and min
		pBar = new JProgressBar(0,3);
		Border border = BorderFactory.createTitledBorder("Star Progress");
		pBar.setBorder(border);
		if (lvl.getStars() == 0){
			pBar.setIndeterminate(true);
			pBar.setString("No Stars Acheived");
		}
		else{
			pBar.setValue(lvl.getStars());
			pBar.setString(Integer.toString(lvl.getStars())+ "Stars Acheived");
		}	
		pBar.setStringPainted(true);
		pBar.setBounds(650, 500, 250, 50);
		add(pBar);
		
		setBackground(new Color(255, 228, 225));
		
	}
	
	@Override
	public void initControllers(){
		// Init the controllers of the subcomponents
		bullpenView.initControllers();
		boardView.initControllers();
		
		// Init own controllers
		setMouseAdapter(new LevelController(app, m, app.getGameWindow().getLevelView()));
	}
 
}