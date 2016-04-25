package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import builderEntity.BuilderModel;

public class SetHintHandler implements ActionListener {

	BuilderModel model;
	JCheckBox hintBox;
	
	public SetHintHandler(BuilderModel model, JCheckBox hintBox) {
		this.model = model;
		this.hintBox = hintBox;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean isHint = hintBox.isSelected();
		
		SetHintMove move = new SetHintMove(model, isHint);
		move.execute();
	}

}
