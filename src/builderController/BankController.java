package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankController extends MouseAdapter {

	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
		
		System.out.println("Bank Clicked.");
	}
}
