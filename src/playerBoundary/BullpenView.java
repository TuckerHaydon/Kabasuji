
package playerBoundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import playerController.BullpenController;
import playerEntity.Bullpen;
import playerEntity.Square;
import playerEntity.Tile;


public class BullpenView extends View implements KeyListener {
	Bullpen bp;
	KabasujiPlayerApplication app;
	boolean controlKeyPressed;
	boolean shiftKeyPressed;
	
	static int WIDTH = 45;
	static int CELL_HEIGHT = 110;
	
	public BullpenView(KabasujiPlayerApplication app, Bullpen bp){
		this.bp = bp;
		this.app=app;
	}
	
	public void initView(){
		this.setBackground(Color.BLUE);
		this.setSize(4000, 120);
		this.setPreferredSize(new Dimension(7*WIDTH*bp.getTiles().size(), CELL_HEIGHT));
		
	}
	
	public void initControllers(){
		setMouseAdapter(new BullpenController(app, app.getGameModel(), bp));
	}
	
	public void keyPressed(KeyEvent k) {
		controlKeyPressed = k.isControlDown();
		shiftKeyPressed = k.isShiftDown();
	}
	
	public void keyReleased(KeyEvent k) {
		//TODO fill in method
	}
	
	public void keyTyped(KeyEvent k){
		//TODO fill in method
	}
	
	public boolean isControlPressed (){
		return controlKeyPressed;
	}
	
	public boolean isShiftPressed (){
		return shiftKeyPressed;
	}
	
	@Override
	public void paintComponent(Graphics g){
		ArrayList<Tile> tiles = bp.getTiles();
		int counter = 0;
		int boxWidth = 315;
		int boxHeight = 240;
		for(Tile t: tiles){
			paintTile(g, t, counter*boxWidth, 0, boxWidth, boxHeight);
			counter++;
		}
	}
	
	void paintTile(Graphics g, Tile t, int upperX, int upperY, int width, int height){
		Square squares[] = t.getSquares();
		
		for(Square s: squares){
			g.setColor(Color.GREEN);
			g.fillRect(upperX+s.getRelX()*WIDTH + width/2, upperY+s.getRelY()*WIDTH+height/2, WIDTH, WIDTH);
			g.setColor(Color.BLACK);
			g.drawRect(upperX+s.getRelX()*WIDTH+width/2, upperY+s.getRelY()*WIDTH+height/2, WIDTH, WIDTH);
		}
	}
}

