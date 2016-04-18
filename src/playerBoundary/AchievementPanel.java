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
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class AchievementPanel extends JPanel {
	JButton mainmenu;
	JButton reset;
	Hashtable<String, JLabel> achievements;
	
	/**
	 * Create the panel.
	 */
	public AchievementPanel() {
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
		
		this.achievements = new Hashtable<String, JLabel>();
		achievements.put("Rebel", new JLabel("Rebel"));
		achievements.get("Rebel").setIcon(new ImageIcon("src\\resources\\pictures\\Rebl.png"));
		achievements.get("Rebel").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("Rebel").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("Rebel").setBackground(Color.WHITE);
		
		achievements.put("BabySteps", new JLabel("BabySteps"));
		achievements.get("BabySteps").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("BabySteps").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievements.get("BabySteps").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("BabySteps").setBackground(Color.WHITE);
		
		achievements.put("OverAchiever", new JLabel("OverAchiever"));
		achievements.get("OverAchiever").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievements.get("OverAchiever").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("OverAchiever").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("OverAchiever").setBackground(Color.WHITE);
		
		achievements.put("SlowPoke", new JLabel("SlowPoke"));
		achievements.get("SlowPoke").setIcon(new ImageIcon("src\\resources\\pictures\\Rebl.png"));
		achievements.get("SlowPoke").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("SlowPoke").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("SlowPoke").setBackground(Color.WHITE);
		
		achievements.put("SpeedyGonzales", new JLabel("SpeedyGonzales"));
		achievements.get("SpeedyGonzales").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievements.get("SpeedyGonzales").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("SpeedyGonzales").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("SpeedyGonzales").setBackground(Color.WHITE);
		
		achievements.put("RageQuit", new JLabel("RageQuit"));
		achievements.get("RageQuit").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievements.get("RageQuit").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("RageQuit").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("RageQuit").setBackground(Color.WHITE);
		
		achievements.put("NoRegrets", new JLabel("NoRegrets"));
		achievements.get("NoRegrets").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievements.get("NoRegrets").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("NoRegrets").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("NoRegrets").setBackground(Color.WHITE);
		
		achievements.put("K-komboBreaker", new JLabel("K-komboBreaker"));
		achievements.get("K-komboBreaker").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievements.get("K-komboBreaker").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("K-komboBreaker").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("K-komboBreaker").setBackground(Color.WHITE);
		
		achievements.put("VictoryLap", new JLabel("VictoryLap"));
		achievements.get("VictoryLap").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievements.get("VictoryLap").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("VictoryLap").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("VictoryLap").setBackground(Color.WHITE);
		
		achievements.put("JustUnderTheWire", new JLabel("JustUnderTheWire"));
		achievements.get("JustUnderTheWire").setIcon(new ImageIcon("src\\resources\\pictures\\Baby_Step.png"));
		achievements.get("JustUnderTheWire").setHorizontalAlignment(SwingConstants.LEFT);
		achievements.get("JustUnderTheWire").setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		achievements.get("JustUnderTheWire").setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(mainmenu, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 596, Short.MAX_VALUE)
					.addComponent(reset)
					.addGap(183))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(117)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(achievements.get("Rebel"), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(achievements.get("SpeedyGonzales"), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
								.addComponent(achievements.get("JustUnderTheWire"), Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
								.addComponent(achievements.get("OverAchiever"), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(achievements.get("BabySteps"), Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
						.addComponent(achievements.get("RageQuit"), GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievements.get("K-komboBreaker"), GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(achievements.get("VictoryLap"), GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievements.get("NoRegrets"), GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievements.get("SlowPoke"), GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(achievements.get("BabySteps"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(achievements.get("Rebel"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievements.get("SlowPoke"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievements.get("SpeedyGonzales"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(105)
					.addComponent(achievements.get("OverAchiever"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(achievements.get("RageQuit"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievements.get("NoRegrets"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(achievements.get("JustUnderTheWire"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(achievements.get("K-komboBreaker"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(achievements.get("VictoryLap"), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
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
	
	public void labelAppear(String name){
		this.achievements.get(name).setVisible(true);
	}
	
	public void setAllInvisible(){
		this.achievements.get("BabySteps").setVisible(false);
		this.achievements.get("Rebel").setVisible(false);
		this.achievements.get("OverAchiever").setVisible(false);
		this.achievements.get("SpeedyGonzales").setVisible(false);
		this.achievements.get("JustUnderTheWire").setVisible(false);
		this.achievements.get("NoRegrets").setVisible(false);
		this.achievements.get("SlowPoke").setVisible(false);
		this.achievements.get("RageQuit").setVisible(false);
		this.achievements.get("VictoryLap").setVisible(false);
		this.achievements.get("K-komboBreaker").setVisible(false);
	}
}
