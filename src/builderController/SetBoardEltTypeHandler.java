package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltTypeHandler implements ActionListener {
	
	BuilderModel m;
	JComboBox<String> box;
	
	public SetBoardEltTypeHandler(BuilderModel m, JComboBox<String> box) {
		this.m = m;
		this.box = box;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selection = (String)box.getSelectedItem();
		
		SetBoardEltTypeMove move = new SetBoardEltTypeMove(m, selection);
		
		if(move.isValid()){
			move.doMove();
		}
		
	}

}
