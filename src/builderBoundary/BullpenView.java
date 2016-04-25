package builderBoundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import builderEntity.Bullpen;
import builderEntity.Square;
import builderEntity.Tile;

/**
 * The View object that displays the Bullpen
 * @author tuckerhaydon
 *
 */
public class BullpenView extends View {
	
	Bullpen bp;
	static int CELL_HEIGHT = 190;
	static int CELL_WIDTH = CELL_HEIGHT;
	static int SQUARE_WIDTH = 20;
	
	/**
	 * Constructor for the BullpenView object. 
	 * @param bp Bullpen the bullpen object to be displayed. Cannot be null.
	 */
	public BullpenView(Bullpen bp){
		super();
		
		if(bp == null){
			throw new RuntimeException();
		}
		this.bp = bp;
	}
	
	/**
	 * Sets the preferred size of this View. Necessary for embedding this view in a scrollpane.
	 */
	public void initView(){
		this.setPreferredSize(new Dimension(CELL_WIDTH*bp.getTileReferenceNumbers().size(), CELL_HEIGHT));
	}
	
	/**
	 * Paints the Bullpen. The Bullpen is divided into cells, bounding rectangles around each tile. First draws the bounding rectangle, then iterates through all of the squares in each tile and draws them.
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ArrayList<Tile> tiles = bp.getTiles();
		this.setPreferredSize(new Dimension(CELL_WIDTH*bp.getTileReferenceNumbers().size(), CELL_HEIGHT));

		for(int i = 0; i < tiles.size(); i++){
			g.setColor(Color.black);
			g.drawRect(i*CELL_WIDTH, 0, CELL_WIDTH, CELL_HEIGHT);
			drawTile(tiles.get(i), i*CELL_WIDTH+CELL_WIDTH/2, CELL_HEIGHT/2, g);
		}
	}
	
	void drawTile(Tile t, int anchorLocationX, int anchorLocationY, Graphics g){
		Square[] squares = t.getSquares();
		
		for(Square s: squares){
			g.setColor(Color.GREEN);
			g.fillRect(SQUARE_WIDTH*s.getAnchorRelX()+anchorLocationX, SQUARE_WIDTH*s.getAnchorRelY()+anchorLocationY, SQUARE_WIDTH, SQUARE_WIDTH);
			g.setColor(Color.BLACK);
			g.drawRect(SQUARE_WIDTH*s.getAnchorRelX()+anchorLocationX, SQUARE_WIDTH*s.getAnchorRelY()+anchorLocationY, SQUARE_WIDTH, SQUARE_WIDTH);
		}
	}
	
	/**
	 * Returns the height of a cell, the bounding rectangle around each drawn tile.
	 * @return int the height of a cell
	 */
	public int getCellHeight(){
		return CELL_HEIGHT;
	}
	
	/**
	 * Returns the width of a cell, the bounding rectangle around each drawn tile.
	 * @return int the width of a cell
	 */
	public int getCellWidth(){
		return CELL_WIDTH;
	}
	
	/**
	 * Returns the width of each square in a Tile.
	 * @return int The width of each square in a Tile.
	 */
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}
	
	/**
	 * Return the Bullpen object drawn by this object.
	 * @return Bullpen The Bullpen object drawn by this object
	 */
	public Bullpen getBullpen(){
		return this.bp;
	}

}
