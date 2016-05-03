package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 *  Handler for setting the board element type. Creates/executes a SetBoardEltTypeMove
 * @author tuckerhaydon
 *
 */
public class SetBoardEltTypeHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JComboBox<String> box;
	
	/**
	 * constructor for setBoardEltTypeHandler
	 * @param app
	 * @param m
	 * @param box
	 */
	public SetBoardEltTypeHandler(KabasujiBuilderApplication app, BuilderModel m, JComboBox<String> box) {
		this.m = m;
		this.box = box;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selection = (String)box.getSelectedItem();
		
		SetBoardEltTypeMove move = new SetBoardEltTypeMove(app, m, selection);
		move.execute();
		
	}

}
