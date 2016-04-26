
package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
 
/**
 * 
 * @author tuckerhaydon
 *
 */
public class ExportGameHandler implements ActionListener{
	
	BuilderModel bm;
	KabasujiBuilderApplication app;

	public ExportGameHandler(KabasujiBuilderApplication app, BuilderModel bm){
		this.app = app;
		this.bm = bm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		// Create the filepath
		String name = JOptionPane.showInputDialog("Name the game.");
		
		String path = "src/resources/games/"+name;
				
		// Create an export move and do it
		ExportGameMove move = new ExportGameMove(app, bm, path);
		move.execute();
	}
}