package builderEntity;

public class Game {

	String name;
	Level levels[];
	
	public Game(String name, Level levels[]){
		this.name = name;
		this.levels = levels;
	}
	
	public Game() {
		levels = new Level[15];
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setLevels(Level l[]){
		this.levels = l;
	}
	
	public Level[] getLevels(){
		return this.levels;
	}
	
	public void setLevel(Level l, int index){
		levels[index] = l;
	}
}
