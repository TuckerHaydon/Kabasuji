package builderBoundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import builderEntity.Bank;
import builderEntity.Square;
import builderEntity.Tile;

public class BankView extends View{
	
	Bank bank;
	static int CELL_HEIGHT = 200;
	static int CELL_WIDTH = 200;
	static int SQUARE_WIDTH = 20;
	
	public BankView(Bank tb){
		this.bank = tb;
	}
	
	public void initView(){
		this.setSize(1000, 200);
		this.setPreferredSize(new Dimension(1000, 200));
	}
	
	@Override
	public void paintComponent(Graphics g){
		ArrayList<Tile> tiles = bank.getTiles();
		
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
	
	public int getCellHeight(){
		return CELL_HEIGHT;
	}
	
	public int getCellWidth(){
		return CELL_WIDTH;
	}
	
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}

}
