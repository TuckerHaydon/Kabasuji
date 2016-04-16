package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderEntity.BuilderModel;

public class SetBoardEltColorHandler implements ActionListener {

	BuilderModel m;
	JComboBox<String> box;
	
	public SetBoardEltColorHandler(BuilderModel m, JComboBox<String> box) {
		this.m = m;
		this.box = box;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selection = (String) box.getSelectedItem();
		
		SetBoardEltColorMove move = new SetBoardEltColorMove(m, selection);
		
		if(move.isValid()){
			move.doMove();
		}
		
	}

}
