
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


public class BullpenView extends View {
	Bullpen bp;
	KabasujiPlayerApplication app;
	boolean controlKeyPressed;
	boolean shiftKeyPressed;
	
	static int SQUARE_WIDTH = 40;
	static int CELL_WIDTH = 7*SQUARE_WIDTH;
	
	public BullpenView(KabasujiPlayerApplication app, Bullpen bp){
		super();
		this.bp = bp;
		this.app=app;
	}
	
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}
	
	public void initView(){
		this.setPreferredSize(new Dimension(CELL_WIDTH*bp.getTiles().size(), CELL_WIDTH));
		
	}
	
	public void initControllers(){
		setMouseAdapter(new BullpenController(app, app.getGameModel(), bp, CELL_WIDTH));
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		ArrayList<Tile> tiles = bp.getTiles();
		int counter = 0;
		for(Tile t: tiles){
			paintTile(g, t, counter*CELL_WIDTH, 0, CELL_WIDTH, CELL_WIDTH);
			g.setColor(Color.BLACK);
			g.drawLine(counter*CELL_WIDTH, 0, counter*CELL_WIDTH, CELL_WIDTH);
			counter++;
		}
	}
	
	void paintTile(Graphics g, Tile t, int upperX, int upperY, int width, int height){
		Square squares[] = t.getSquares();
		
		for(Square s: squares){
			g.setColor(Color.ORANGE);
			g.fillRect(upperX+s.getRelX()*SQUARE_WIDTH + width/2, upperY-s.getRelY()*SQUARE_WIDTH+height/2, SQUARE_WIDTH, SQUARE_WIDTH);
			g.setColor(Color.BLACK);
			g.drawRect(upperX+s.getRelX()*SQUARE_WIDTH+width/2, upperY-s.getRelY()*SQUARE_WIDTH+height/2, SQUARE_WIDTH, SQUARE_WIDTH);
		}
	}
}

