package playerBoundary;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import playerController.LevelController;
import playerController.TimerHandler;
import playerEntity.GameModel;
import playerEntity.LightningLevel;
import javax.swing.Timer;
import javax.swing.border.Border;


/**
 * The view object of a lightning level. 
 * @author tuckerhaydon, dgwalder
 *
 */
public class LightningLevelView extends LevelView{
	JLabel timeLabel; 
	
	public final static int ONE_SECOND = 1000;
	
	LightningLevel level;
	
	public LightningLevelView(KabasujiPlayerApplication app, GameModel m, LightningLevel lightningLvl) {
		super(app, m, lightningLvl);
		
		level = lightningLvl;
		
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
		
		timeLabel = new JLabel("<html>" + "Time Remaining: " + (Integer.toString(level.getRemainingTime())) + " " + "</html>");
		timeLabel.setBounds(650, 400, 150, 100);
		add(timeLabel);
		

		//3 stars hence that max and min
		pBar = new JProgressBar(0,3);
		Border border = BorderFactory.createTitledBorder("Star Progress...");
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
		
		level.setTimer(new Timer(ONE_SECOND, new TimerHandler(level, app, m)));
		
		// Init own controllers
		setMouseAdapter(new LevelController(app, m, app.getGameWindow().getLevelView()));
	}
	
	public JLabel getJLabel(){
		return timeLabel;
	}
	
	public void refreshTimeLabel(){
		this.remove(timeLabel);
		timeLabel = new JLabel("<html>" + "Time Remaining: " + (Integer.toString(level.getRemainingTime())) + " " + "</html>");
		timeLabel.setBounds(650, 400, 150, 100);
		this.add(timeLabel, 0);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
}
