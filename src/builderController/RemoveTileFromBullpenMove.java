package builderController;

import builderBoundary.BullpenView;
import builderEntity.Bullpen;
import builderEntity.Tile;

public class RemoveTileFromBullpenMove implements IMove{

	Tile t;
	BullpenView bullpenView;
	
	RemoveTileFromBullpenMove(Tile t, BullpenView bpv){
		this.t = t;
		this.bullpenView = bpv;
	}
	
	@Override
	public boolean doMove() {
		
		Bullpen bullpen = bullpenView.getBullpen();
		
		// Remove the tile from the bullpen
		bullpen.remTile(t.getReferenceNumber());
		
		// Repaint the component
		bullpenView.repaint();
		
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		bullpenView.getBullpen().addTile(t.getReferenceNumber());
		bullpenView.repaint();
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		boolean valid = false;
		for(int i:bullpenView.getBullpen().getTileReferenceNumbers()) {
			if(t.getReferenceNumber() == i) {
				valid = true;
			}
		}
		return valid;
	}

}
