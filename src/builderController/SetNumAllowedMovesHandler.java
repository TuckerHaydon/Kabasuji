package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
/**
 * The handle of Scroll bar for selecting number allowed in builder side 
 */
public class SetNumAllowedMovesHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JTextField field;
	
	public SetNumAllowedMovesHandler(KabasujiBuilderApplication app, BuilderModel m, JTextField field) {
		this.app = app;
		this.m = m;
		this.field = field;
	}
	
	/**
	 * Perform the SetNumAllowedMovesMove
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		try{
			int numMoves = Integer.parseInt(field.getText());
			SetNumAllowedMovesMove move = new SetNumAllowedMovesMove(app, m, numMoves);
			move.execute();
		}
		catch(Exception e){System.err.println("Error parsing an integer from the time box");} // NOOP
	}

}
