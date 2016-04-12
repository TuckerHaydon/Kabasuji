package playerBoundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import playerController.NavigateMainMenu;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;


public class GameWindow extends JFrame {
	
	LevelView currentLevelView;
	TileView draggedTile;
	KabasujiPlayerApplication app;
	GameModel m;
	JButton menuButton;
	JButton resetButton;
	JPanel contentPane;
	
	public GameWindow(KabasujiPlayerApplication app, GameModel m)
	{
		super();
		this.app = app;
		this.m = m;

		// Initialize the buttons
		menuButton = new JButton("Main Menu");
		resetButton = new JButton("Reset Level");
		
		//initialize the levelView
		// TODO fix this to load the level from the default game
		Level currLev = m.getCurrentLevel();
		int currLevNum = currLev.getLevelNum();
		if(currLevNum == 1 || currLevNum == 4 || currLevNum == 7 || currLevNum == 10 || currLevNum == 13){
			currentLevelView = new PuzzleLevelView((PuzzleLevel)currLev);
		}
		else if(currLevNum == 2 || currLevNum == 5 || currLevNum == 6 || currLevNum == 11 || currLevNum == 14){
			currentLevelView = new LightningLevelView((LightningLevel)currLev);
		}
		else if(currLevNum == 3 || currLevNum == 6 || currLevNum == 9 || currLevNum == 12 || currLevNum == 15){
			currentLevelView = new ReleaseLevelView((ReleaseLevel)currLev);
		}
		
		this.initFrame();
		this.currentLevelView.initView();
	}
	
	public void initView(){
		
		// Add the components
		this.add(menuButton);
		this.add(resetButton);
		this.add(currentLevelView);

	}
	
	public void initControllers(){
		
		// Register the button controllers
		menuButton.addActionListener(new NavigateMainMenu(app));
		// resetButton.addActionListener(new resetLevelController());
	}
	
	public void setDraggedTile(TileView tv){
		this.draggedTile = tv;
	}
	
	public void setLevelView(LevelView lv){
		this.currentLevelView = lv;
	}
	
	public TileView getDraggedTile(){
		return this.draggedTile;
	}

	public LevelView getLevelView(){
		return this.currentLevelView;
	}
	
	void initFrame(){
		
		// Set Frame properties
		this.setSize(1000, 1000);
		this.setTitle("Game Window");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		currentLevelView.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(currentLevelView, GroupLayout.PREFERRED_SIZE, 957, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(menuButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resetButton)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(menuButton)
						.addComponent(resetButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(currentLevelView, GroupLayout.PREFERRED_SIZE, 902, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		GroupLayout gl_levelViewThing = new GroupLayout(currentLevelView);
		gl_levelViewThing.setHorizontalGroup(
			gl_levelViewThing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 957, Short.MAX_VALUE)
		);
		gl_levelViewThing.setVerticalGroup(
			gl_levelViewThing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 902, Short.MAX_VALUE)
		);
		currentLevelView.setLayout(gl_levelViewThing);
		contentPane.setLayout(gl_contentPane);
	
		
		
	}
	
	
}
