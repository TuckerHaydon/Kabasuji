package builderBoundary;

import java.awt.Color;

import javax.swing.JPanel;

import builderEntity.Bullpen;

public class BullpenView extends JPanel {
	
	Bullpen bp;
	
	public BullpenView(Bullpen bp){
		this.bp = bp;
	}
	
	void initView(){
		this.setBackground(Color.RED);
		this.setBounds(0, 0, 4000, 200);
	}

}
