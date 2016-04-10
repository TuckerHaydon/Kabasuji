package playerController;

import playerBoundary.KabasujiPlayerApplication;

public interface IMove {
	boolean doMove(KabasujiPlayerApplication app);
	boolean isValid(KabasujiPlayerApplication app);
}
