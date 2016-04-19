/**
 * 
 */
package builderController;

import builderBoundary.*;
import builderEntity.*;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class AddTileToBullpenMove implements IMove {
	
	Tile t;
	BullpenView bullpenView;

	
	AddTileToBullpenMove(Tile t, BullpenView bpv) {
		this.t = t;
		this.bullpenView = bpv;
	}

	
	public boolean doMove() {
		
		// Add the tile to the bullpen
		Bullpen bullpen = bullpenView.getBullpen();
		bullpen.addTile(t.getReferenceNumber());
		
		// Repaint the component
		bullpenView.repaint();
		return true;
	}


	
	public boolean isValid() {
		// TODO fix this.
		return true; 
	}
	
	public boolean undoMove() {
		return false;
	}

}
