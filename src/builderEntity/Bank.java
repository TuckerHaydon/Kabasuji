package builderEntity;

/**
 * 
 * Bank Class
 * 
 * Stores all the possible tiles that can be added to the Bullpen of the level 
 * which the Builder is creating. The Bank class extends the Bullpen class. 
 * The builder interacts with this class through the BankView.
 * 
 * @see Bullpen
 * @see BankController
 * @see BankView
 * 
 * @author tuckerhaydon
 *
 */
public class Bank extends Bullpen {

	/** Bank Constructor */
	public Bank(){
		super();
		
		for(int i = 1; i < 36; i++){
			this.addTile(i);
		}
	}
}
