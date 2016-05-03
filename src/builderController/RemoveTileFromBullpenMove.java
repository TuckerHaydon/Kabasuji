package builderController;

import builderBoundary.BullpenView;
import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import builderEntity.Bullpen;
import builderEntity.Tile;

/**
 * RemoveTileFromBullpenMove class
 * removes a tile from the bullpen
 * @author dgwalder
 *
 */
public class RemoveTileFromBullpenMove extends Move{

	Tile t;
	BullpenView bullpenView;
	
	/**
	 * RemoveTileFromBullpenMove constructor
	 * @param app
	 * @param m
	 * @param t
	 * @param bpv
	 */
	RemoveTileFromBullpenMove(KabasujiBuilderApplication app, BuilderModel m, Tile t, BullpenView bpv){
		super(app, m);
		this.t = t;
		this.bullpenView = bpv;
	}
	
	@Override
	boolean doMove() {
		
		Bullpen bullpen = bullpenView.getBullpen();
		
		// Remove the tile from the bullpen
		bullpen.remTile(t.getReferenceNumber());
		
		// Repaint the component
		bullpenView.repaint();
		
		return true;
	}

	@Override
	public boolean undoMove() {
		bullpenView.getBullpen().addTile(t.getReferenceNumber());
		bullpenView.repaint();
		return false;
	}

	@Override
	boolean isValid() {
		boolean valid = false;
		for(int i:bullpenView.getBullpen().getTileReferenceNumbers()) {
			if(t.getReferenceNumber() == i) {
				valid = true;
			}
		}
		return valid;
	}

}
