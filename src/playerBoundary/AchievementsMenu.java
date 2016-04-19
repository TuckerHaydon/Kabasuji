package playerBoundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class AchievementsMenu extends JFrame {
	KabasujiPlayerApplication app;
	GameModel m;
	private JPanel contentPane;
	JButton mainMenuButton;
	JButton resetButton;
	Hashtable<String, JLabel> pics;

	
	public AchievementsMenu(KabasujiPlayerApplication app, GameModel m) {
		super();
		this.m=m;
		this.app=app;
		this.pics=new Hashtable<String, JLabel>();
		
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
		pics.get("NoRegrets").setBounds(441, 262, 80, 80);
		pics.get("NoRegrets").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("NoRegrets"));
		
		pics.put("Rebel", new JLabel("Rebel")); 
		pics.get("Rebel").setBounds(719, 434, 80, 80);
		pics.get("Rebel").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("Rebel"));
		
		pics.put("OverAchiever", new JLabel("OverAchiever"));
		pics.get("OverAchiever").setBounds(148, 647, 80, 80);
		pics.get("OverAchiever").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("OverAchiever"));
		
		pics.put("K-komboBreaker", new JLabel("K-komboBreaker"));
		pics.get("K-komboBreaker").setBounds(441, 521, 80, 80);
		pics.get("K-komboBreaker").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("K-komboBreaker"));
		
		pics.put("VictoryLap", new JLabel("VictoryLap"));
		pics.get("VictoryLap").setBounds(719, 647, 80, 80);
		pics.get("VictoryLap").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("VictoryLap"));
		
		pics.put("SpeedyGonzales", new JLabel("SpeedyGonzales"));
		pics.get("SpeedyGonzales").setBounds(148, 434, 80, 80);
		pics.get("SpeedyGonzales").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("SpeedyGonzales"));

		pics.put("BabySteps", new JLabel("BabySteps"));
		pics.get("BabySteps").setBounds(441, 65, 80, 80);
		pics.get("BabySteps").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("BabySteps"));
		
		pics.put("RageQuit", new JLabel("RageQuit"));
		pics.get("RageQuit").setBounds(719, 220, 80, 80);
		pics.get("RageQuit").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("RageQuit"));
		
		pics.put("SlowPoke", new JLabel("SlowPoke"));
		pics.get("SlowPoke").setBounds(148, 220, 80, 80);
		pics.get("SlowPoke").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("SlowPoke"));
		
		pics.put("JustUnderTheWire", new JLabel("JustUnderTheWire"));
		pics.get("JustUnderTheWire").setBounds(441, 765, 80, 80);
		pics.get("JustUnderTheWire").setIcon(new ImageIcon("src/resources/pictures/Baby_Step.png"));
		contentPane.add(pics.get("JustUnderTheWire"));


		mainMenuButton= new JButton("Main Menu");
		mainMenuButton.setBounds(12, 13, 190, 47);
		mainMenuButton.setBackground(new Color(128, 128, 128));
		mainMenuButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(mainMenuButton);
		

		resetButton= new JButton("Reset Achievement");
		resetButton.setBounds(763, 13, 207, 47);
		resetButton.setBackground(new Color(128, 128, 128));
		resetButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(resetButton);
		
		JLabel lblRagequit = new JLabel("NoRegrets");
		lblRagequit.setBounds(441, 344, 94, 37);
		lblRagequit.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		contentPane.add(lblRagequit);
		
		JLabel lblRebel = new JLabel("Rebel");
		lblRebel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblRebel.setBounds(735, 521, 116, 37);
		contentPane.add(lblRebel);
		
		JLabel lblSpeedygonzales = new JLabel("SpeedyGonzales");
		lblSpeedygonzales.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblSpeedygonzales.setBounds(121, 521, 138, 37);
		contentPane.add(lblSpeedygonzales);
		
		JLabel lblSlowpoke = new JLabel("SlowPoke");
		lblSlowpoke.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblSlowpoke.setBounds(148, 305, 94, 37);
		contentPane.add(lblSlowpoke);
		
		JLabel lblBabysteps = new JLabel("BabySteps");
		lblBabysteps.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblBabysteps.setBounds(441, 148, 94, 37);
		contentPane.add(lblBabysteps);
		
		JLabel lblOverachiever = new JLabel("OverAchiever");
		lblOverachiever.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblOverachiever.setBounds(133, 730, 138, 37);
		contentPane.add(lblOverachiever);
		
		JLabel label_10 = new JLabel("RageQuit");
		label_10.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		label_10.setBounds(719, 305, 94, 37);
		contentPane.add(label_10);
		
		JLabel lblKkombobreaker = new JLabel("K-komboBreaker");
		lblKkombobreaker.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblKkombobreaker.setBounds(409, 603, 153, 37);
		contentPane.add(lblKkombobreaker);
		
		JLabel lblJustunderthewire = new JLabel("JustUnderTheWire");
		lblJustunderthewire.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblJustunderthewire.setBounds(409, 858, 199, 37);
		contentPane.add(lblJustunderthewire);
		
		JLabel lblVictorylap = new JLabel("VictoryLap");
		lblVictorylap.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblVictorylap.setBounds(715, 730, 94, 37);
		contentPane.add(lblVictorylap);
	}
	
	public void updateView(){
		for(String key: this.pics.keySet()){
			this.pics.get(key).setVisible(this.m.getAchievements().get(key).getisEarned());
		}
	}
	public void initControllers(){
		mainMenuButton.addActionListener(new NavigateMainMenu(app,m));
		this.resetButton.addActionListener(new ResetAchievementController(app,m));

	}
}