package builderBoundary;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import builderEntity.TileBank;

public class BankView extends View{
	
	TileBank tb;
	
	public BankView(TileBank tb){
		this.tb = tb;
	}
	
	public void initView(){
		this.setBackground(new Color(255, 50, 50));
		this.setSize(1000, 200);
		this.setPreferredSize(new Dimension(1000, 200));
	}

}
