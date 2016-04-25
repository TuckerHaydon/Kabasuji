package playerBoundary;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import playerController.LevelController;
import playerController.LightningLevelTimer;
import playerEntity.GameModel;
import playerEntity.LightningLevel;
import javax.swing.Timer;


/**
 * 
 * @author tuckerhaydon
 *
 */
public class LightningLevelView extends LevelView{
	JLabel timeLeft; 
	LightningLevel level;
	
	javax.swing.Timer timer;
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
		
		
		String remTime = new String (Integer.toString(level.getRemainingTime()));
		JLabel lblTimeLeft = new JLabel("<html>" + "Time Remaining: " + remTime + " " + "</html>");
		lblTimeLeft.setBounds(770, 400, 60, 300);
		add(lblTimeLeft);
		
		timeLeft = lblTimeLeft;
		
		//JLabel lblTimeLeft = new JLabel("Time Allowed");
		//lblTimeLeft.setBounds(770, 770, 60, 15);
		//add(lblTimeLeft);
		
		JLabel lblScoreNStuff = new JLabel("Score n stuff");
		lblScoreNStuff.setBounds(770, 850, 60, 15);
		add(lblScoreNStuff);
		
		setBackground(new Color(255, 228, 225));
		
	}
	
	public Timer getTimer(){
		return timer;
	}
	
	@Override
	public void initControllers(){
		// Init the controllers of the subcomponents
		bullpenView.initControllers();
		boardView.initControllers();
		
		timer = new Timer(ONE_SECOND, new LightningLevelTimer(level, app));
		
		// Init own controllers
		setMouseAdapter(new LevelController(app, m, app.getGameWindow().getLevelView()));
	}
	
	public JLabel getJLabel(){
		return timeLeft;
	}
}