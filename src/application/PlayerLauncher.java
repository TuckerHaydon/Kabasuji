package application;

import playerBoundary.KabasujiPlayerApplication;

public class PlayerLauncher {
	
	public static void main(String args[])
	{
		System.out.println("Player Application launched.");
		
		KabasujiPlayerApplication app = new KabasujiPlayerApplication();
		app.init();
	}	
}
