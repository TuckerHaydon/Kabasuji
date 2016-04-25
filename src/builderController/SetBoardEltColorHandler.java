package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderEntity.BuilderModel;

/**
 * Handler for setting the board element color. Creates/executes a SetBoardEltColorMove
 * @author tuckerhaydon
 */
public class SetBoardEltColorHandler implements ActionListener {

	BuilderModel m;
	JComboBox<String> box;
	
	/**
	 * Contructor. Validates that the parameters are non-null
	 * @param m
	 * @param box
	 */
	public SetBoardEltColorHandler(BuilderModel m, JComboBox<String> box) {
		
		if(m == null || box == null){
			throw new RuntimeException();
		}
		
		this.m = m;
		this.box = box;
	}
	
	/**
	 * Retrieves the selected color from the combo box and creates/executes a move to change that in the BuilderModel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		
		String selection = (String) box.getSelectedItem();
		SetBoardEltColorMove move = new SetBoardEltColorMove(m, selection);
		move.execute();
	}

}
