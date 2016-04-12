package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

public class TileBankPageHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	boolean nextPage;
	
	TileBankPageHandler(KabasujiBuilderApplication app, boolean nextPage){
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
