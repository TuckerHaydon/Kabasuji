package playerBoundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class levelViewTest extends JPanel {

	/**
	 * Create the panel.
	 */
	public levelViewTest() {
		setBackground(Color.RED);
		setSize(900,900);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel BoardViewThing = new JPanel();
		BoardViewThing.setBackground(Color.GREEN);
		
		JLabel lblTimeAndStuff = new JLabel("Time and stuff");
		
		JLabel lblScore = new JLabel("Score");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 785, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(BoardViewThing, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
							.addComponent(BoardViewThing, GroupLayout.PREFERRED_SIZE, 748, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		JLabel lblStuff = new JLabel("Stuff");
		BoardViewThing.add(lblStuff);
		
		JPanel bullpenViewThing = new JPanel();
		bullpenViewThing.setBackground(Color.BLUE);
		scrollPane.setViewportView(bullpenViewThing);
		setLayout(groupLayout);

	}
}
