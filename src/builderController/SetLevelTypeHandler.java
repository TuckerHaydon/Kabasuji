package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.LevelBuilderView;
import builderEntity.BuilderModel;
import builderEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetLevelTypeHandler implements ActionListener {

	JComboBox<String> box;
	BuilderModel m;
	KabasujiBuilderApplication app;
	
	public SetLevelTypeHandler(KabasujiBuilderApplication app, BuilderModel m, JComboBox<String> box) {
		this.app = app;
		this.m = m;
		this.box = box;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selection = (String) box.getSelectedItem();
		
		SetLevelTypeMove move = new SetLevelTypeMove(app, m, selection);
		move.execute();
	}

}
