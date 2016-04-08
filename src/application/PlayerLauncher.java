package application;

import java.util.Scanner;

import playerBoundary.*;

public class PlayerLauncher {
	
	static GameWindow gameWindow;
	static MainMenu mainMenu;
	static LevelSelectionMenu levelSelectionMenu;
	static AchievementsMenu achievementsMenu;
	
	public static void main(String args[])
	{
		System.out.println("Player Application launched.");
		init();
	}
	
	public static void init(){
		initModel();
		initView();
		initControllers();
		
		/* TESTING */
		Scanner scan = new Scanner(System.in);
		
		displayMainMenu();
		scan.nextLine();
		displayGameWindow();
		scan.nextLine();
		displayLevelSelectionMenu();
		scan.nextLine();
		displayAchievementsMenu();
		/* TESTING */
	}
	
	public static void initModel(){
		
	}
	
	public static void initView(){
		gameWindow = new GameWindow();
		mainMenu = new MainMenu();
		levelSelectionMenu = new LevelSelectionMenu();
		achievementsMenu = new AchievementsMenu();
	}
	
	public static void initControllers(){
		
	}
	
	public static void displayMainMenu(){
		mainMenu.setVisible(true);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
	}
	
	public static void displayGameWindow(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(true);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
	}
	
	public static void displayLevelSelectionMenu(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(true);
		achievementsMenu.setVisible(false);
	}
	
	public static void displayAchievementsMenu(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(true);
	}
}
