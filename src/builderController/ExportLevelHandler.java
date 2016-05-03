package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
<<<<<<< HEAD
 * The handler of the export level button
=======
 * ExportLevelHandler class
 * handles the exportLevel action
>>>>>>> 0b7486af1ba7e90d583f640414741910ff8180d6
 * @author tuckerhaydon
 *
 */
public class ExportLevelHandler implements ActionListener {
	
	BuilderModel m;
	String fileName;
	KabasujiBuilderApplication app;
	
	/**
	 * ExportLevelHandler constructor
	 * @param app
	 * @param m
	 */
	public ExportLevelHandler(KabasujiBuilderApplication app, BuilderModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		parseInput();
		processAction();
	}
	
	/**
	 * retrieves the fileName
	 */
	void parseInput(){
		fileName = JOptionPane.showInputDialog("Name the level.");
	}
	
	/**
	 * processes the exportLevel action
	 */
	void processAction(){
		
		// Create an export move and do it
		ExportLevelMove move = new ExportLevelMove(app, m, fileName, false);
		move.execute();
	}

}
