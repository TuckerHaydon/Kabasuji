package builderBoundary;

import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

/**
 * Abstract class for all builder windows.
 * @author tuckerhaydon
 *
 */
public abstract class View extends JPanel{
	
	public void addMouseAdapter(MouseAdapter ma){
		this.addMouseListener(ma);
		this.addMouseMotionListener(ma);
	}
	
	public abstract void initView();

}
