package builderBoundary;

import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

public abstract class View extends JPanel{
	
	public void addMouseAdapter(MouseAdapter ma){
		this.addMouseListener(ma);
		this.addMouseMotionListener(ma);
	}
	
	public abstract void initView();

}
