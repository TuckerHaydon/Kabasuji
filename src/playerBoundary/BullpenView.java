
package playerBoundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import playerController.BullpenController;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.Square;
import playerEntity.Tile;

/**
 * Bullpen View Class
 * 
 * This class is responsible for displaying the Bullpen.
 * @see Bullpen
 * @see BullpenController
 * @author tuckerhaydon
 * @author dgwalder
 *
 */
public class BullpenView extends View {
	Bullpen bp;
	boolean controlKeyPressed;
	boolean shiftKeyPressed;
	
	static int SQUARE_WIDTH = 40;
	static int CELL_WIDTH = 7*SQUARE_WIDTH;
	
	public BullpenView(KabasujiPlayerApplication app, GameModel m, Bullpen bp){
		super(app, m);
		this.bp = bp;
	}
	
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}
	
	public void initView(){
		this.setPreferredSize(new Dimension(CELL_WIDTH*bp.getTiles().size(), CELL_WIDTH));
		
	}
	
	public void initControllers(){
		setMouseAdapter(new BullpenController(app, m, bp, CELL_WIDTH));
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
			g.fillRect(upperX+s.getRelX()*SQUARE_WIDTH + width/2, upperY-(s.getRelY() + 1)*SQUARE_WIDTH+height/2, SQUARE_WIDTH, SQUARE_WIDTH);
			g.setColor(Color.BLACK);
			g.drawRect(upperX+s.getRelX()*SQUARE_WIDTH+width/2, upperY-(s.getRelY() + 1)*SQUARE_WIDTH+height/2, SQUARE_WIDTH, SQUARE_WIDTH);
		}
	}
}

