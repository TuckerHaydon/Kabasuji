package builderBoundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import builderEntity.Bank;
import builderEntity.Square;
import builderEntity.Tile;

/**
 * The view object for a player bank. It is responsible for drawing the player bank.
 * @author tuckerhaydon
 *
 */
public class BankView extends View{
	
	Bank bank;
	static int CELL_HEIGHT = 190;
	static int CELL_WIDTH = CELL_HEIGHT;
	static int SQUARE_WIDTH = 20;
	
	/**
	 * BankView constructor. The Bank given to this object cannot be null.
	 * @param tb - The Bank to be displayed.
	 */
	public BankView(Bank tb){
		super();
		
		if(tb == null){
			throw new RuntimeException();
		}
		this.bank = tb;
	}
	
	/**
	 * Sets the preferred size of the view. Necessary for embedding in a scrollpane.
	 */
	public void initView(){
		this.setPreferredSize(new Dimension(CELL_WIDTH*bank.getTileReferenceNumbers().size(), CELL_HEIGHT));
	}
	
	/**
	 * Draws the Bank. The Bank is divided into cells, bounding squares around each tile. Draws the bounding square and then iterates through all of the squares in a tile and draws them.
	 */
	@Override
	public void paintComponent(Graphics g){
		ArrayList<Tile> tiles = bank.getTiles();
		super.paintComponent(g);
		
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
	 * Returns the height of the bounding rectangle around a tile in the Bank.
	 * @return int this is the height of the bounding cell
	 */
	public int getCellHeight(){
		return CELL_HEIGHT;
	}
	
	/**
	 * Returns the width of the bounding rectangle around a tile in the Bank.
	 * @return int this is the width of the bounding cell
	 */
	public int getCellWidth(){
		return CELL_WIDTH;
	}
	
	/**
	 * Returns the width of the square drawn in each tile
	 * @return int the width of a tile's square
	 */
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}
	
	/**
	 * Returns the Bank object that this view draws
	 * @return Bank the bank that is drawn
	 */
	public Bank getBank(){
		return this.bank;
	}

}
