package application;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class PlayerLauncher {
	
	public static void main(String args[])
	{
		System.out.println("Player Application launched.");
		GameModel m = GameModel.instance();
		KabasujiPlayerApplication app = new KabasujiPlayerApplication(m);
	}	
}
