package playerBoundary;

import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public abstract class View extends JPanel {
	
	public View() {
		super();
	}
	
	public void setMouseAdapter(MouseAdapter ma){
		this.addMouseListener(ma);
		this.addMouseMotionListener(ma);
	}
	
	public abstract void initView();
	public abstract void initControllers();
	
}
