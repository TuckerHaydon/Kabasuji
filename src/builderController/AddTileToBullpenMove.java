/**
 * 
 */
package builderController;

import builderBoundary.*;
import builderEntity.*;

/**
 * Adds a Tile to the Bullpen from the bank in the level builder.
 * This action is performed within the Level Editor and is called within the BankController
 * @see BankController
 * @author tuckerhaydon
 *
 */
public class AddTileToBullpenMove extends Move {
	
	Tile t;
	BullpenView bullpenView;
	
	/**
	 * Constructor for a Move
	 * @param m
	 * @param t
	 * @param bpv
	 */
	AddTileToBullpenMove(BuilderModel m, Tile t, BullpenView bpv) {
		super(m);
		this.t = t;
		this.bullpenView = bpv;
	}
	/**
	 * Do the move by obtaining the bullpen corresponding to the view
	 * and adding a Tile by reference number. 
	 */
	@Override
	boolean doMove() {
		
		// Add the tile to the bullpen
		Bullpen bullpen = bullpenView.getBullpen();
		bullpen.addTile(t.getReferenceNumber());
		
		// Repaint the component
		bullpenView.repaint();
		return true;
	}

	/**
	 * Returns the validity of a move
	 */
	@Override
	boolean isValid() {
		// TODO fix this.
		if(bullpenView.getBullpen() == null) return false;
		return true; 
	}
	
	/**
	 * Undoes the action performed in the doMove method
	 */
	@Override
	public boolean undoMove() {
		if(bullpenView.getBullpen().empty()) return false;
		bullpenView.getBullpen().remTile(t.getReferenceNumber());
		return true;
	}

}
