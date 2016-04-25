package application;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * The main launcher for the Kabasuji Player Application.
 * @author tuckerhaydon
 *
 */
public class PlayerLauncher {
	
	/**
	 * The static main method to launch the application
	 * @param args - Command line arguments for the launcher
	 */
	public static void main(String args[])
	{
		System.out.println("Player Application launched.");
		GameModel m = GameModel.instance();
		KabasujiPlayerApplication app = new KabasujiPlayerApplication(m);
	}	
}
