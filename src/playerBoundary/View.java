package playerBoundary;

import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public abstract class View extends JPanel {
	
	KabasujiPlayerApplication app;
	GameModel m;
	
	public View(KabasujiPlayerApplication app, GameModel m) {
		super();
		this.app = app;
		this.m = m;
	}
	
	public void setMouseAdapter(MouseAdapter ma){
		this.addMouseListener(ma);
		this.addMouseMotionListener(ma);
	}
	
	public abstract void initView();
	public abstract void initControllers();
	
}
