package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderBoundary.LevelBuilderView;
import builderEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetLevelTypeHandler implements ActionListener {

	Level l;
	JComboBox<String> box;
	LevelBuilderView editorView;
	
	public SetLevelTypeHandler(Level l, JComboBox<String> box, LevelBuilderView editorView) {
		this.l = l;
		this.box = box;
		this.editorView = editorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selection = (String) box.getSelectedItem();
		
		SetLevelTypeMove move = new SetLevelTypeMove(l, selection, editorView);
		
		if(move.isValid()){
			move.doMove();
		}

	}

}
