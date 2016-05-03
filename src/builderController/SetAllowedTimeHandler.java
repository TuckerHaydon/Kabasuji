package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * The handler in charge of setting allowed time in builder window
 * @author Dorothy
 *
 */
public class SetAllowedTimeHandler implements ActionListener {

	KabasujiBuilderApplication app;
	BuilderModel m;
	JTextField field;
	
	 public SetAllowedTimeHandler(KabasujiBuilderApplication app, BuilderModel m, JTextField field) {
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
			int seconds = Integer.parseInt(field.getText());
			SetAllowedTimeMove move = new SetAllowedTimeMove(app, m, seconds);
			move.execute();
		}
		catch(Exception e){System.err.println("Error parsing an integer from the time box");} // NOOP
		
	}

}
