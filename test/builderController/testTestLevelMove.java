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


public class testTestLevelMove {
	@Test
	public void test(){
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication(m);
		builder.init();
		builder.displayLevelEditor();
		
		TestLevelMove tlm = new TestLevelMove(builder, m);
		assertTrue(tlm.execute());
		assertFalse(builder.getLevelEditor().isVisible());
		assertFalse(tlm.undoMove());
	}

}
