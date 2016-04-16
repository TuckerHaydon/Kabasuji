package builderEntity;

import java.util.ArrayList;

public class Bank extends Bullpen {

	public Bank(){
		super();
		
		for(int i = 1; i < 36; i++){
			this.addTile(i);
		}
	}
}
