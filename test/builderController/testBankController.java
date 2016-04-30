/**
 * 
 */
package builderController;
import static org.junit.Assert.*;

import org.junit.Test;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
/**
 * @author kacper
 *
 */
public class testBankController {
	
	@Test
	public void Test() {
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication app = new KabasujiBuilderApplication(m);
		app.displayLevelEditor();
	
	}
}
