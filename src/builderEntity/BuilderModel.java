package builderEntity;

/**
 * 
 * BuilderModel class
 * 
 * Contains features beyond the scope of Levels
 * This includes the Bank, selectedBoardEltType (Playable or Unplayable),
 * isHint, selectedColor, selectedNumber. 
 * 
 * @author tuckerhaydon
 *
 */

public class BuilderModel {
	
	Level level;
	Game game;
	String selectedBoardEltType;
	String selectedColor;
	int selectedNumber;
	boolean isHint;
	Bank tb;
	
	static BuilderModel model = null;
	
	public static BuilderModel instance(){
		if(model == null){
			model = new BuilderModel();
		}
		
		return model;
	}
	
	/**
	 * BuilderModelConstructor
	 */
	BuilderModel(){
		this.level = new Level();
		this.game = null;
		this.selectedBoardEltType = "playable";
		this.selectedNumber = 1;
		this.selectedColor = "red";
	}
	
	/**
	 * 
	 * @param lvl
	 */
	public void setLevel(Level lvl){
		this.level = lvl;
	}
	
	/**
	 * 
	 * @param g
	 */
	public void setGame(Game g){
		this.game = g;
	}
	
	/**
	 * 
	 * @return
	 */
	public Game getGame(){
		return this.game;
	}
	
	/**
	 * returns whether hint is selected 
	 * @return
	 */
	public boolean isHintSelected(){
		return isHint;
	}
	
	/**
	 * sets hintSelected to the given param
	 * @param isHint
	 */
	public void setHintSelected(boolean isHint){
		this.isHint = isHint;
	}
	
	/**
	 * sets the type of board elt that the builder is currently specifying
	 * @param type
	 */
	public void setSelectedBoardEltType(String type){
		this.selectedBoardEltType = type;
	}
	
	/**
	 * returns the type of board elt that is being specified
	 * @return
	 */
	public String getSelectedBoardEltType(){
		return this.selectedBoardEltType;
	}
	
	/**
	 * sets the selected color to the param
	 * @param c
	 */
	public void setSelectedColor(String c){
		this.selectedColor = c;
	}
	
	/**
	 * returns the selected color as a string 
	 * @return color
	 */
	public String getSelectedColor(){
		return this.selectedColor;
	}
	
	/**
	 * sets the selected number 
	 * @param num
	 */
	public void setSelectedNumber(int num){
		this.selectedNumber = num;
	}
	
	/**
	 * returns the selected number
	 * @return
	 */
	public int getSelectedNumber(){
		return this.selectedNumber;
	}
	
	public void setTileBank(Bank tb){
		this.tb = tb;
	}
	
	public Bank getTileBank(){
		return this.tb;
	}
	
	public Level getLevel(){
		return this.level;
	}
	
	@Override
	public String toString(){
		return "Level: "+level+"\nGame: "+game+"\nBoard Elt Type: "+selectedBoardEltType+"\nColor: "+selectedColor+"\nNumber: "+selectedNumber;
	}
	

}
