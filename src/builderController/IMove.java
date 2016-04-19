/**
 * 
 */
package builderController;

/**
 * 
 * @author tuckerhaydon
 *
 */
public interface IMove {

	public boolean doMove();
	public boolean isValid();
	public boolean undoMove();
}
