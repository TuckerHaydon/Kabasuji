package playerBoundary;

import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

public abstract class View extends JPanel {
	
	public View(){
		
	}
	
	public void setMouseAdapter(MouseAdapter ma){
		this.addMouseListener(ma);
		this.addMouseMotionListener(ma);
	}
	
	public abstract void initView();
	public abstract void initControllers();
	
}
