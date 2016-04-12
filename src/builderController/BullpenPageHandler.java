package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

public class BullpenPageHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	boolean nextPage;
	
	BullpenPageHandler(KabasujiBuilderApplication app, boolean nextPage){
		this.app = app;
		this.nextPage = nextPage;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//if (nextPage)
		//	showNextTileBankPage()
		//else 
		//	showPrevPage()
	}

}