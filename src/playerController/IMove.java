package playerController;

import playerBoundary.KabasujiPlayerApplication;

/**
 * 
 * @author tuckerhaydon
 *
 */
public interface IMove {
	boolean doMove(KabasujiPlayerApplication app);
	boolean isValid(KabasujiPlayerApplication app);
}
