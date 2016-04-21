package playerEntity;

/**
 * 
 * @author dorothy
 *
 */
public class Achievement {
	boolean isEarned;
	String name;

	public Achievement(String name){
		this.isEarned=false;
		this.name=name;
	}
	
	boolean getIsEarned(){
		return this.isEarned;
	}
	
	void setIsEarned(boolean e){
		this.isEarned = e;
	}
	
	String getName(){
		return this.name;
	}
	
	void setName(String n){
		this.name = n;
	}
	
	public boolean getisEarned(){
		return isEarned;
	}
	
	public void setEarned(){
		this.isEarned=true;
	}
	
	public boolean reset(){
		if(isEarned) {
			this.isEarned=false;
			return true;
		}
		return false;
		
	}
}
