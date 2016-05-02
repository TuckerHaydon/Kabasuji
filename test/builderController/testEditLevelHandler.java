package builderController;

import java.util.ArrayList;

import org.junit.Test;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

public class testEditLevelHandler {

	@Test
	public void test() {
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication(m);
		builder.init();
		
		EditLevelHandler elh = new EditLevelHandler(builder, m);
		
		ArrayList<String> levelNames = elh.addLevels();
		elh.parseLevel("Level 11");
		//elh.processAction();
	}

}
