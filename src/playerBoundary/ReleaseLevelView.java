
package playerBoundary;

import playerEntity.Level;

public class ReleaseLevelView extends LevelView {

	public ReleaseLevelView(Level l) {
		super(l);
		// TODO Auto-generated constructor stub
	}

}
=======
package playerBoundary;

import playerEntity.Level;
import playerEntity.ReleaseLevel;

public class ReleaseLevelView extends LevelView {

	public ReleaseLevelView(ReleaseLevel relLvl) {
		this.level = relLvl;
	}

}