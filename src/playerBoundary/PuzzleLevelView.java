package playerBoundary;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import playerEntity.Level;
import playerEntity.PuzzleLevel;

public class PuzzleLevelView extends LevelView{
	JLabel movesLeft;
	
	
	public PuzzleLevelView(PuzzleLevel puzzleLvl) {
		this.level = puzzleLvl;
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard());
		

	}

	@Override
	public void initView() {
		//set properties of the view
		this.setSize(900, 900);
		this.setBounds(50, 50, 900, 900);
		setBackground(Color.RED);
//		this.add(bullpenView);
//		this.add(boardView);
		
		JScrollPane scrollPane = new JScrollPane();
		
		// JPanel BoardViewThing = new JPanel();
		boardView.setBackground(Color.GREEN);
		
		JLabel lblTimeAndStuff = new JLabel("Num levels left");
		
		JLabel lblScore = new JLabel(""+this.level.getScore());
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 785, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(boardView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTimeAndStuff, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(lblScore)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblTimeAndStuff, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(267)
							.addComponent(lblScore))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 748, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		JLabel lblStuff = new JLabel("Stuff");
		boardView.add(lblStuff);
		
		
		// JPanel bullpenViewThing = new JPanel();
		bullpenView.setBackground(Color.BLUE);
		scrollPane.setViewportView(bullpenView);
		setLayout(groupLayout);
	}
	
	@Override
	public void initControllers(){
		//goToMenu.addActionListener(new NavigateMainMenu(app));
		//resetLvl.addActionListener(new ResetLevel());
	}

}