package playerBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import playerEntity.GameModel;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;

public class GameWindow extends JFrame {
	
	LevelView currentLevelView;
	TileView draggedTile;
	KabasujiPlayerApplication app;
	GameModel m;
	
	public GameWindow(KabasujiPlayerApplication app, GameModel m)
	{
		super();
		this.app = app;
		this.m = m;
		this.setSize(1000, 1000);
		this.setTitle("Game Window");
		
		
		
	}
	
	public void initView(){
		
	}
	
	public void initControllers(){
		
	}
	
	public void setDraggedTile(TileView tv){
		this.draggedTile = tv;
	}
	
	public void setLevelView(LevelView lv){
		this.currentLevelView = lv;
	}
	
	public LevelView getLevelView(){
		return this.currentLevelView;
	}
	
}
