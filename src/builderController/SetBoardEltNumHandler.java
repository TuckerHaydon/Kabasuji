package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderEntity.BuilderModel;

/**
 * Handler in charge retrieving the selected board element number and creating/executing a move to update the game model
 * @author tuckerhaydon
 *
 */
public class SetBoardEltNumHandler implements ActionListener {
	
	JComboBox<String> box;
	BuilderModel m;
	
	/**
	 * Constructor. Validates that the passed in parameters are non-null
	 * @param m BuilderModel The top-level builder model
	 * @param box JComboBox The combo box containing the various element numbers
	 */
	public SetBoardEltNumHandler(BuilderModel m, JComboBox<String> box) {
		
		if(m == null || box == null){
			throw new RuntimeException();
		}
		
		this.box = box;
		this.m = m;
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		int selection = Integer.parseInt((String) box.getSelectedItem());
		
		SetBoardEltNumMove move = new SetBoardEltNumMove(m, selection);
		move.execute();
	}

}
