package playerBoundary;

import java.awt.Color;
import java.awt.Graphics;

import playerEntity.Square;
import playerEntity.Tile;

public class TileView extends View {
	Tile t;
	int x;
	int y;
	
	public TileView(Tile t){
		this.t = t;
	}
	
	public void setLocation (int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public void initView() {
		this.setSize(100, 100);
		
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
		paintTile(g, t, 0, 0, 100, 100);
	}
	
	void paintTile(Graphics g, Tile t, int upperX, int upperY, int width, int height){
		Square squares[] = t.getSquares();
		
		int SQUARE_WIDTH = 10;
		
		for(Square s: squares){
			g.setColor(Color.GREEN);
			g.fillRect(upperX+s.getRelX()*SQUARE_WIDTH + width/2, upperY+s.getRelY()*SQUARE_WIDTH+height/2, SQUARE_WIDTH, SQUARE_WIDTH);
			g.setColor(Color.BLACK);
			g.drawRect(upperX+s.getRelX()*SQUARE_WIDTH+width/2, upperY+s.getRelY()*SQUARE_WIDTH+height/2, SQUARE_WIDTH, SQUARE_WIDTH);
		}
	}
}
