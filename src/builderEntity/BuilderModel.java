package builderEntity;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
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
	
	public BuilderModel(){
		this.level = new Level();
		this.game = null;
		this.selectedBoardEltType = "playable";
		this.selectedNumber = 1;
		this.selectedColor = "red";
	}
	
	public void setLevel(Level lvl){
		this.level = lvl;
	}
	
	public void setGame(Game g){
		this.game = g;
	}
	
	public Game getGame(){
		return this.game;
	}
		
	public boolean isHintSelected(){
		return isHint;
	}
	
	public void setHintSelected(boolean isHint){
		this.isHint = isHint;
	}
	
	public void setSelectedBoardEltType(String type){
		this.selectedBoardEltType = type;
	}
	
	public String getSelectedBoardEltType(){
		return this.selectedBoardEltType;
	}
	
	public void setSelectedColor(String c){
		this.selectedColor = c;
	}
	
	public String getSelectedColor(){
		return this.selectedColor;
	}
	
	public void setSelectedNumber(int num){
		this.selectedNumber = num;
	}
	
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
