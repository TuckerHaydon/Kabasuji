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
public class SetBoardEltNumHandler implements ActionListener {
	
	JComboBox<String> box;
	BuilderModel m;
	
	public SetBoardEltNumHandler(BuilderModel m, JComboBox<String> box) {
		this.box = box;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int selection = Integer.parseInt((String) box.getSelectedItem());
		
		SetBoardEltNumMove move = new SetBoardEltNumMove(m, selection);
		
		if(move.isValid()){
			move.doMove();
		}
		
	}

}
