package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

public class SetNumAllowedMovesHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JTextField field;
	
	public SetNumAllowedMovesHandler(KabasujiBuilderApplication app, BuilderModel m, JTextField field) {
		this.app = app;
		this.m = m;
		this.field = field;
	}

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
