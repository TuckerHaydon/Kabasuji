/**
 * 
 */
package builderController;

import builderBoundary.KabasujiBuilderApplication;

/**
 * @author kacper
 *
 */
public interface IBuildMove {

	public boolean doMove(KabasujiBuilderApplication app);
	public boolean isValid(KabasujiBuilderApplication app);
	public boolean undoMove(KabasujiBuilderApplication app);
}
