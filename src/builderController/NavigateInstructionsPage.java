package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

/**
 * Controller class that handles navigating to the instructions menu in the builder
 * @author tuckerhaydon
 *
 */
public class NavigateInstructionsPage implements ActionListener{

	KabasujiBuilderApplication app;
	
	/**
	 * Constructor
	 * @param app - The top-level application
	 */
	public NavigateInstructionsPage(KabasujiBuilderApplication app) {
		this.app = app;
	}

	/**
	 * This method is called when a button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
		
	}
	
	/**
	 * Displays the instructions page
	 */
	void processAction(){
		app.displayInstructionsPage();
	}
	
	
}
