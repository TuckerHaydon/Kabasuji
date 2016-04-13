
package playerBoundary;

import java.awt.Color;
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
	boolean controlKeyPressed;
	boolean shiftKeyPressed;
	
	static int WIDTH = 45;
	
	public BullpenView(Bullpen bp){
		this.bp = bp;
	}
	
	public void initView(){
		this.setBackground(Color.BLUE);
		this.setSize(4000, 120);
		//this.setBounds(0, 0, 4000, 120);
		
	}
	
	public void initControllers(){
		setMouseAdapter(new BullpenController(bp));
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
			g.fillRect(upperX+s.getRelX()*WIDTH, upperY+s.getRelY()*WIDTH, WIDTH, WIDTH);
			g.setColor(Color.BLACK);
			g.drawRect(upperX+s.getRelX()*WIDTH, upperY+s.getRelY()*WIDTH, WIDTH, WIDTH);
		}
	}
}

