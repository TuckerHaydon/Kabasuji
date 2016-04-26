package playerEntity;

/**
 * Achievement entity that stores the name and whether or not it is earned
 * @author dorothy
 *
 */
public class Achievement {
	boolean isEarned;
	String name;

	/**
	 * Achievement constructor 
	 * @param name name of the achievement
	 */
	public Achievement(String name){
		this.isEarned=false;
		this.name=name;
	}
	
	/**
	 * Returns whether or not an achievement is earned
	 * @return
	 */
	public boolean getIsEarned(){
		return this.isEarned;
	}
	
	/**
	 * Sets the state of an achievement
	 * @param e
	 */
	public void setIsEarned(boolean e){
		this.isEarned = e;
	}
	
	/**
	 * Returns the name of an achievement
	 * @return
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Sets the name of the achievement
	 * @param n name of the achievement
	 */
	public void setName(String n){
		this.name = n;
	}
	
	/**
	 * Resets an achievement to an unearned state if it had
	 * previously been earned
	 * @return
	 */
	public boolean reset(){
		if(isEarned) {
			this.isEarned=false;
			return true;
		}
		return false;
		
	}
}
