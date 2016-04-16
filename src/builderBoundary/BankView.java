package builderBoundary;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import builderEntity.Bank;

public class BankView extends View{
	
	Bank tb;
	
	public BankView(Bank tb){
		this.tb = tb;
	}
	
	public void initView(){
		this.setBackground(new Color(255, 50, 50));
		this.setSize(1000, 200);
		this.setPreferredSize(new Dimension(1000, 200));
	}

}
