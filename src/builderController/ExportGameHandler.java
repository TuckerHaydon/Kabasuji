
package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
 
/**
 * handles the exportGame action
 * @author tuckerhaydon
 *
 */
public class ExportGameHandler implements ActionListener{
	
	BuilderModel bm;
	KabasujiBuilderApplication app;

	/**
	 * ExportGameHandler constructor
	 * @param app
	 * @param bm
	 */
	public ExportGameHandler(KabasujiBuilderApplication app, BuilderModel bm){
		this.app = app;
		this.bm = bm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		// Create the filepath
		String name = JOptionPane.showInputDialog("Name the game.");
		
		// If cancel was hit or no name was typed, do nothing
		if(name == null){
			return;
		}
		
		String path = "src/resources/games/"+name;
				
		// Create an export move and do it
		ExportGameMove move = new ExportGameMove(app, bm, path);
		move.execute();
	}
}