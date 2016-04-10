package playerEntity;

public class Achievement {
	boolean isEarned;
	String name;
	Image earnedPic;
	Image unEarnedPic;

	public Achievement(String name, Image pic, Image notPic){
		this.isEarned=false;
		this.name=name;
		this.earnedPic=pic;
		this.unEarnedPic=notPic;
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
	
	Image getEarnedPic(){
		return this.earnedPic;
	}
	
	void setEarnedPic(Image i){
		this.earnedPic = i;
	}
	
	Image getUnEarnedPic(){
		return this.unEarnedPic;
	}
	
	void setUnEarnedPic(Image i){
		this.unEarnedPic = i;
	}
	
	public boolean getisEarned(){
		return isEarned;
	}
	
}
