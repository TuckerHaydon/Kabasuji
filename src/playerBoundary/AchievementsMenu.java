package playerBoundary;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import playerController.NavigateMainMenu;
import playerController.ResetAchievementController;
import playerEntity.GameModel;
import javax.swing.ImageIcon;

/**
 * This class is in charge of displaying the status of achievement
 * @author dorothy
 *
 */
public class AchievementsMenu extends JFrame {
	KabasujiPlayerApplication app;
	GameModel m;
	private JPanel contentPane;
	JButton mainMenuButton;
	JButton resetButton;
	Hashtable<String, JLabel> pics;
	Hashtable<String, JLabel> lbs;
	
	public AchievementsMenu(KabasujiPlayerApplication app, GameModel m) {
		super();
		this.m=m;
		this.app=app;
		this.pics=new Hashtable<String, JLabel>();
		this.lbs=new Hashtable<String, JLabel>();
	}	
	
	public void initView(){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Achievements Menu");
		setBounds(0, 0, 1000, 1000);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setBackground(new Color(255, 228, 225));
		
		
		pics.put("NoRegrets", new JLabel("NoRegrets")); 
		pics.get("NoRegrets").setBounds(818, 217, 80, 80);
		pics.get("NoRegrets").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("NoRegrets"));
		
		pics.put("Rebel", new JLabel("Rebel")); 
		pics.get("Rebel").setBounds(818, 416, 80, 80);
		pics.get("Rebel").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("Rebel"));
		
		pics.put("OverAchiever", new JLabel("OverAchiever"));
		pics.get("OverAchiever").setBounds(94, 217, 80, 80);
		pics.get("OverAchiever").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("OverAchiever"));
		
		pics.put("K-komboBreaker", new JLabel("K-komboBreaker"));
		pics.get("K-komboBreaker").setBounds(94, 416, 80, 80);
		pics.get("K-komboBreaker").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("K-komboBreaker"));
		
		pics.put("VictoryLap", new JLabel("VictoryLap"));
		pics.get("VictoryLap").setBounds(94, 622, 80, 80);
		pics.get("VictoryLap").setIcon(new ImageIcon("src/resources/pictures/VictoryLap.jpg"));
		contentPane.add(pics.get("VictoryLap"));
		
		pics.put("SpeedyGonzales", new JLabel("SpeedyGonzales"));
		pics.get("SpeedyGonzales").setBounds(818, 622, 80, 80);
		pics.get("SpeedyGonzales").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("SpeedyGonzales"));

		pics.put("BabySteps", new JLabel("BabySteps"));
		pics.get("BabySteps").setBounds(818, 809, 80, 80);
		pics.get("BabySteps").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("BabySteps"));
		
		pics.put("RageQuit", new JLabel("RageQuit"));
		pics.get("RageQuit").setBounds(94, 809, 80, 80);
		pics.get("RageQuit").setIcon(new ImageIcon("src/resources/pictures/RageQuit.jpg"));
		contentPane.add(pics.get("RageQuit"));
		
		pics.put("SlowPoke", new JLabel("SlowPoke"));
		pics.get("SlowPoke").setBounds(472, 809, 80, 80);
		pics.get("SlowPoke").setIcon(new ImageIcon("src/resources/pictures/SlowPoke.jpg"));
		contentPane.add(pics.get("SlowPoke"));
		
		pics.put("JustUnderTheWire", new JLabel("JustUnderTheWire"));
		pics.get("JustUnderTheWire").setBounds(472, 217, 80, 80);
		pics.get("JustUnderTheWire").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("JustUnderTheWire"));

		
		pics.put("WhatANerd", new JLabel("What a Nerd"));
		pics.get("WhatANerd").setIcon(new ImageIcon("src/resources/pictures/nerd.jpg"));
		pics.get("WhatANerd").setBounds(415, 441, 200, 200);
		contentPane.add(pics.get("WhatANerd"));
		
		
		mainMenuButton= new JButton("Main Menu");
		mainMenuButton.setBounds(12, 13, 190, 47);
		mainMenuButton.setBackground(new Color(128, 128, 128));
		mainMenuButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(mainMenuButton);
		

		resetButton= new JButton("Reset All");
		resetButton.setBounds(763, 13, 207, 47);
		resetButton.setBackground(new Color(128, 128, 128));
		resetButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(resetButton);
		
		JLabel lblNoRegrets = new JLabel("????????");
		lblNoRegrets.setBounds(828, 310, 140, 16);
		lblNoRegrets.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		contentPane.add(lblNoRegrets);
		lbs.put("NoRegrets", lblNoRegrets);
		
		
		JLabel lblRebel = new JLabel("?????");
		lblRebel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblRebel.setBounds(830, 509, 140, 16);
		contentPane.add(lblRebel);
		lbs.put("Rebel", lblRebel);
		
		JLabel lblSpeedygonzales = new JLabel("?????????????");
		lblSpeedygonzales.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblSpeedygonzales.setBounds(800, 718, 140, 16);
		contentPane.add(lblSpeedygonzales);
		lbs.put("SpeedyGonzales", lblSpeedygonzales);
		
		JLabel lblSlowpoke = new JLabel("??????");
		lblSlowpoke.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblSlowpoke.setBounds(468, 902, 140, 16);
		contentPane.add(lblSlowpoke);
		lbs.put("SlowPoke", lblSlowpoke);
		
		JLabel lblBabysteps = new JLabel("??????");
		lblBabysteps.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblBabysteps.setBounds(820, 902, 140, 16);
		contentPane.add(lblBabysteps);
		lbs.put("BabySteps", lblBabysteps);
		
		JLabel lblOverachiever = new JLabel("??????");
		lblOverachiever.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblOverachiever.setBounds(84, 310, 140, 16);
		contentPane.add(lblOverachiever);
		lbs.put("OverAchiever", lblOverachiever);
		
		JLabel labelRageQuit = new JLabel("???????");
		labelRageQuit.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		labelRageQuit.setBounds(90, 902, 140, 16);
		contentPane.add(labelRageQuit);
		lbs.put("RageQuit", labelRageQuit);
		
		JLabel lblKkombobreaker = new JLabel("???????????????");
		lblKkombobreaker.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblKkombobreaker.setBounds(84, 509, 150, 16);
		contentPane.add(lblKkombobreaker);
		lbs.put("K-komboBreaker", lblKkombobreaker);
		
		JLabel lblJustunderthewire = new JLabel("????????????????");
		lblJustunderthewire.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblJustunderthewire.setBounds(432, 310, 150, 16);
		contentPane.add(lblJustunderthewire);
		lbs.put("JustUnderTheWire", lblJustunderthewire);
		
		JLabel lblVictorylap = new JLabel("??????");
		lblVictorylap.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblVictorylap.setBounds(84, 718, 140, 16);
		contentPane.add(lblVictorylap);
		lbs.put("VictoryLap", lblVictorylap);
		
		
		JLabel lblWhatANerd = new JLabel("??????");
		lblWhatANerd.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblWhatANerd.setBounds(462, 654, 140, 16);
		contentPane.add(lblWhatANerd);
		lbs.put("WhatANerd", lblWhatANerd);
	}
	
	public void updateView(){
		for(String key: this.pics.keySet()){
			this.pics.get(key).setVisible(this.m.getAchievements().get(key).getIsEarned());
		}
		for(String key: this.lbs.keySet()){
			if(this.m.getAchievements().get(key).getIsEarned()){
				this.lbs.get(key).setText(key);
			}
		}
	}
	public void initControllers(){
		mainMenuButton.addActionListener(new NavigateMainMenu(app,m));
		this.resetButton.addActionListener(new ResetAchievementController(app,m));

	}
}