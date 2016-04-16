package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderEntity.BuilderModel;
import builderEntity.Level;

public class SetLevelTypeHandler implements ActionListener {

	Level l;
	JComboBox box;
	
	public SetLevelTypeHandler(Level l, JComboBox<String> box) {
		this.l = l;
		this.box = box;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selection = (String) box.getSelectedItem();
		
		SetLevelTypeMove move = new SetLevelTypeMove(l, selection);
		
		if(move.isValid()){
			move.doMove();
		}

	}

}
