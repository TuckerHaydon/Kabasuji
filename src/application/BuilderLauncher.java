package application;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class BuilderLauncher {
	
	public static void main(String args[])
	{
		System.out.println("Builder Application launched.");
		
		BuilderModel m = new BuilderModel();
		KabasujiBuilderApplication app = new KabasujiBuilderApplication(m);
	}
}
