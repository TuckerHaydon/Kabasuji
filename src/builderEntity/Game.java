package builderEntity;

public class Game {

	String name;
	Level levels[];
	
	Game(String name, Level levels[]){
		this.name = name;
		this.levels = levels;
	}
	
	public Game() {
		levels = new Level[15];
	}
	
	void setName(String n){
		this.name = n;
	}
	
	String getName(){
		return this.name;
	}
	
	void setLevels(Level l[]){
		this.levels = l;
	}
	
	public Level[] getLevels(){
		return this.levels;
	}
}
