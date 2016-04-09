package application;

import builderBoundary.KabasujiBuilderApplication;

public class BuilderLauncher {
	
	public static void main(String args[])
	{
		System.out.println("Builder Application launched.");
		
		KabasujiBuilderApplication app = new KabasujiBuilderApplication();
		app.init();
	}
}
