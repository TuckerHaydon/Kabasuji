package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltTypeHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JComboBox<String> box;
	
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
