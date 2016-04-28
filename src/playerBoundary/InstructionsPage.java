package playerBoundary;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class InstructionsPage extends JFrame {
	
	public InstructionsPage(){
		super();
		
	}
	
	public void initView(){
		
		
		setResizable(false);
		// Set properties of the frame
		this.setSize(1000,1000);
		
		JLabel instructionLabel = new JLabel();
		instructionLabel.setBounds(0, 0, 1000, 1000);
		String labelText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 1000, 
				"Wmohicwncwinugcwngctngictnigtwngiuctwngiu ctwiug ctwg nctwgin etw guiwet guiwtcgu ictwgu ictwgu ictwgu ictwugi ctwgiu ctwgiu ctwgui ctwugi cwgiu ctwgiu ctwugi ctwugi ctwugi crfi ctwiu fcwgiu ctwgui ctiug giu ctwgiu cwgiu tgui ");
		instructionLabel.setText(labelText);
		this.add(instructionLabel);
		
	}

}
