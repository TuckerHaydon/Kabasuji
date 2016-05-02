package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * The handler of the scroll bar of setting hint boxes
 * @author
 *
 */
public class SetHintHandler implements ActionListener {

	BuilderModel model;
	JCheckBox hintBox;
	KabasujiBuilderApplication app;
	
	public SetHintHandler(KabasujiBuilderApplication app, BuilderModel model, JCheckBox hintBox) {
		this.model = model;
		this.hintBox = hintBox;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean isHint = hintBox.isSelected();
		
		SetHintMove move = new SetHintMove(app, model, isHint);
		move.execute();
	}

}
