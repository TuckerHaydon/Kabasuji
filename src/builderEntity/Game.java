package builderEntity;

/**
 * Game Class
 * Used to represent a game which consist of levels
 * @see Level
 * 
 * @author tuckerhaydon
 *
 */
public class Game {

	String name;
	Level levels[];
	
	/**
	 * Game Constructor
	 * @param name
	 * @param levels
	 */
	public Game(String name, Level levels[]){
		this.name = name;
		this.levels = levels;
	}
	
	public Game() {
		levels = new Level[15];
	}
	
	/**
	 * sets the name of the game
	 * @param n
	 */
	public void setName(String n){
		this.name = n;
	}
	
	/**
	 * returns the name of the game
	 * @return name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * sets the levels of the game
	 * @param l
	 */
	public void setLevels(Level l[]){
		this.levels = l;
	}
	
	/**
	 * returns the levels of the game
	 * @return
	 */
	public Level[] getLevels(){
		return this.levels;
	}
	
	/**
	 * sets the level at the particular index
	 * @param l
	 * @param index
	 */
	public void setLevel(Level l, int index){
		levels[index] = l;
	}
}
