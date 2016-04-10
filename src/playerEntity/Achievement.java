package playerEntity;

public class Achievement {
	boolean isEarned;
	String name;
	Image earnedPic;
	Image notEarnedPic;

	public Achievement(String name, Image pic, Image notPic){
		this.isEarned=false;
		this.name=name;
		this.earnedPic=pic;
		this.notEarnedPic=notPic;
	}
}
