package playerBoundary;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import playerEntity.Achievement;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class AchievementPanel extends JPanel {
	Hashtable<String, Achievement> achievements;
	Hashtable<String, JLabel> achievementlabels;
	JButton mainmenu;
	JButton reset;
	
	/**
	 * Create the panel.
	 */
	public AchievementPanel(Hashtable<String, Achievement> achievements) {
		this.achievements=achievements;
		this.achievementlabels = new Hashtable<String, JLabel>();
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(255, 228, 225));
		
		reset = new JButton("Reset Achievements");
		reset.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		reset.setForeground(Color.GRAY);
		reset.setBackground(new Color(255, 228, 196));
		
		mainmenu = new JButton("Main Menu");
		mainmenu.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mainmenu.setForeground(Color.GRAY);
		mainmenu.setBackground(new Color(255, 228, 196));
		
		
		achievementlabels.put("Rebel", new JLabel("Rebel"));
		achievementlabels.get("Rebel").setIcon(new ImageIcon("src\\resources\\pictures\\Rebl.png"));
		achievementlabels.get("Rebel").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("Rebel").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("Rebel").setBackground(Color.WHITE);
		
		achievementlabels.put("BabySteps", new JLabel("BabySteps"));
		achievementlabels.get("BabySteps").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("BabySteps").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievementlabels.get("BabySteps").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("BabySteps").setBackground(Color.WHITE);
		
		achievementlabels.put("OverAchiever", new JLabel("OverAchiever"));
		achievementlabels.get("OverAchiever").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievementlabels.get("OverAchiever").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("OverAchiever").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("OverAchiever").setBackground(Color.WHITE);
		
		achievementlabels.put("SlowPoke", new JLabel("SlowPoke"));
		achievementlabels.get("SlowPoke").setIcon(new ImageIcon("src\\resources\\pictures\\Rebl.png"));
		achievementlabels.get("SlowPoke").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("SlowPoke").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("SlowPoke").setBackground(Color.WHITE);
		
		achievementlabels.put("SpeedyGonzales", new JLabel("SpeedyGonzales"));
		achievementlabels.get("SpeedyGonzales").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievementlabels.get("SpeedyGonzales").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("SpeedyGonzales").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("SpeedyGonzales").setBackground(Color.WHITE);
		
		achievementlabels.put("RageQuit", new JLabel("RageQuit"));
		achievementlabels.get("RageQuit").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievementlabels.get("RageQuit").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("RageQuit").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("RageQuit").setBackground(Color.WHITE);
		
		achievementlabels.put("NoRegrets", new JLabel("NoRegrets"));
		achievementlabels.get("NoRegrets").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievementlabels.get("NoRegrets").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("NoRegrets").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("NoRegrets").setBackground(Color.WHITE);
		
		achievementlabels.put("K-komboBreaker", new JLabel("K-komboBreaker"));
		achievementlabels.get("K-komboBreaker").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievementlabels.get("K-komboBreaker").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("K-komboBreaker").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("K-komboBreaker").setBackground(Color.WHITE);
		
		achievementlabels.put("VictoryLap", new JLabel("VictoryLap"));
		achievementlabels.get("VictoryLap").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievementlabels.get("VictoryLap").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("VictoryLap").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("VictoryLap").setBackground(Color.WHITE);
		
		achievementlabels.put("JustUnderTheWire", new JLabel("JustUnderTheWire"));
		achievementlabels.get("JustUnderTheWire").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievementlabels.get("JustUnderTheWire").setHorizontalAlignment(SwingConstants.LEFT);
		achievementlabels.get("JustUnderTheWire").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievementlabels.get("JustUnderTheWire").setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(mainmenu, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED, 596, Short.MAX_VALUE)
					.addGap(575)
					.addComponent(reset)
					.addGap(183))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(117)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(achievementlabels.get("Rebel"), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(achievementlabels.get("SpeedyGonzales"), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
								.addComponent(achievementlabels.get("JustUnderTheWire"), Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
								.addComponent(achievementlabels.get("OverAchiever"), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(achievementlabels.get("BabySteps"), Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
						.addComponent(achievementlabels.get("RageQuit"), GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievementlabels.get("K-komboBreaker"), GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(achievementlabels.get("VictoryLap"), GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievementlabels.get("NoRegrets"), GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievementlabels.get("SlowPoke"), GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
					.addGap(304))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mainmenu, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(reset, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(achievementlabels.get("BabySteps"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(achievementlabels.get("Rebel"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievementlabels.get("SlowPoke"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievementlabels.get("SpeedyGonzales"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(105)
					.addComponent(achievementlabels.get("OverAchiever"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(achievementlabels.get("RageQuit"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievementlabels.get("NoRegrets"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(achievementlabels.get("JustUnderTheWire"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(achievementlabels.get("K-komboBreaker"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievementlabels.get("VictoryLap"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		setLayout(groupLayout);
	}
	
	public JButton getMainMenuButton(){
		return this.mainmenu;
	}
	
	public JButton getResetAchievementButton(){
		return this.reset;
	}
	
	public void displayAllAchievements(){
		for(String key: this.achievementlabels.keySet()){
			this.achievementlabels.get(key).setVisible(true);
		}
	}
	
	public void hideAllAchievements(){
		for(String key: this.achievementlabels.keySet()){
			this.achievementlabels.get(key).setVisible(false);
		}
	}
	
	public void redraw(){
		for(String key: this.achievementlabels.keySet()){
			this.achievementlabels.get(key).setVisible(this.achievements.get(key).getisEarned());
		}
	}
}
