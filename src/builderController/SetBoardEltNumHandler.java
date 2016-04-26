package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * Handler in charge retrieving the selected board element number and creating/executing a move to update the game model
 * @author tuckerhaydon
 *
 */
public class SetBoardEltNumHandler implements ActionListener {
	
	JComboBox<String> box;
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	/**
	 * Constructor. Validates that the passed in parameters are non-null
	 * @param m BuilderModel The top-level builder model
	 * @param box JComboBox The combo box containing the various element numbers
	 */
	public SetBoardEltNumHandler(KabasujiBuilderApplication app, BuilderModel m, JComboBox<String> box) {
		
		if(app == null || m == null || box == null){
			throw new RuntimeException();
		}
		
		this.app = app;
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
		
		SetBoardEltNumMove move = new SetBoardEltNumMove(app, m, selection);
		move.execute();
	}

}
