package playerBoundary;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import playerController.LevelController;
import playerController.TimerHandler;
import playerEntity.GameModel;
import playerEntity.LightningLevel;
import javax.swing.Timer;


/**
 * 
 * @author tuckerhaydon, dgwalder
 *
 */
public class LightningLevelView extends LevelView{
	JLabel timeLabel; 
	LightningLevel level;
	
	public final static int ONE_SECOND = 1000;
	
	public LightningLevelView(KabasujiPlayerApplication app, GameModel m, LightningLevel lightningLvl) {
		super(app, m);
		this.level = lightningLvl;
		
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
		timeLabel.setBounds(650, 400, 150, 300);
		add(timeLabel);
		
		
		setBackground(new Color(255, 228, 225));
		
	}
	
	@Override
	public void initControllers(){
		// Init the controllers of the subcomponents
		bullpenView.initControllers();
		boardView.initControllers();
		
		level.setTimer(new Timer(ONE_SECOND, new TimerHandler(level, app)));
		
		// Init own controllers
		setMouseAdapter(new LevelController(app, m, app.getGameWindow().getLevelView()));
	}
	
	public JLabel getJLabel(){
		return timeLabel;
	}
	
	public void refreshTimeLabel(){
		this.remove(timeLabel);
		timeLabel = new JLabel("<html>" + "Time Remaining: " + (Integer.toString(level.getRemainingTime())) + " " + "</html>");
		timeLabel.setBounds(650, 400, 150, 300);
		this.add(timeLabel, 0);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
}
