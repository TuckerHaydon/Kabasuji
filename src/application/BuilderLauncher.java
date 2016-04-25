package application;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * The main launcher for the Kabasuji Builder Application.
 * @author tuckerhaydon
 *
 */
public class BuilderLauncher {
	
	/**
	 * The static main method for the launcher
	 * @param args - Command line arguments for the launcher. 
	 */
	public static void main(String args[])
	{
		System.out.println("Builder Application launched.");
		
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication app = new KabasujiBuilderApplication(m);
		app.init();
	}
}
