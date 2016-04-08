package playerBoundary;

import javax.swing.JButton;
import javax.swing.JFrame;

import playerEntity.GameModel;

public class GameWindow extends JFrame {
	
	LevelView currentLevelView;
	TileView draggedTile;
	GameModel m;
	
	public GameWindow()
	{
		super();
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
	
	public void updateLevelView(LevelView lv){
		this.currentLevelView = lv;
	}

}
