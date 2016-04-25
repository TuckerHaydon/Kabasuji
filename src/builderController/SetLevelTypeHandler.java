package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builderBoundary.LevelBuilderView;
import builderEntity.BuilderModel;
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
	BuilderModel m;
	
	public SetLevelTypeHandler(BuilderModel m, Level l, JComboBox<String> box, LevelBuilderView editorView) {
		this.m = m;
		this.l = l;
		this.box = box;
		this.editorView = editorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selection = (String) box.getSelectedItem();
		
		SetLevelTypeMove move = new SetLevelTypeMove(m, l, selection, editorView);
		move.execute();
	}

}
