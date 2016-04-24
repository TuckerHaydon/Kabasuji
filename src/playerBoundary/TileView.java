package playerBoundary;

import java.awt.Color;
import java.awt.Graphics;

import playerEntity.Square;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class TileView extends View {
	Tile t;
	int x;
	int y;
	
	int SQUARE_WIDTH = 40;
	
	public TileView(Tile t){
		super();
		this.t = t;
		this.setSize(8*SQUARE_WIDTH, 8*SQUARE_WIDTH);
	}
	
	public void setLocation (int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public void initView() {
		this.setSize(8*SQUARE_WIDTH, 8*SQUARE_WIDTH);
	}
	
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}
	

	@Override
	public void initControllers() {
		// TODO Auto-generated method stub
		
	}
	
	public Tile getTile(){
		return t;
	}

	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void paintComponent(Graphics g){
		paintTile(g, t, 0, 0, 6*SQUARE_WIDTH, 6*SQUARE_WIDTH);
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
