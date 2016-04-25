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
public class AddTileToBullpenMove extends Move {
	
	Tile t;
	BullpenView bullpenView;
	
	AddTileToBullpenMove(BuilderModel m, Tile t, BullpenView bpv) {
		super(m);
		this.t = t;
		this.bullpenView = bpv;
	}

	@Override
	boolean doMove() {
		
		// Add the tile to the bullpen
		Bullpen bullpen = bullpenView.getBullpen();
		bullpen.addTile(t.getReferenceNumber());
		
		// Repaint the component
		bullpenView.repaint();
		return true;
	}

	@Override
	boolean isValid() {
		// TODO fix this.
		return true; 
	}
	
	@Override
	public boolean undoMove() {
		if(bullpenView.getBullpen().empty()) return false;
		bullpenView.getBullpen().remTile(t.getReferenceNumber());
		return true;
	}

}
