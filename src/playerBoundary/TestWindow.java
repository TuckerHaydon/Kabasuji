package playerBoundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;

public class TestWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow frame = new TestWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestWindow() {
		setTitle("This is the title");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnMainMenu = new JButton("Main Menu");
		
		JButton btnReset = new JButton("Reset");
		
		levelViewTest levelViewThing = new levelViewTest();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(levelViewThing, GroupLayout.PREFERRED_SIZE, 957, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnMainMenu)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMainMenu)
						.addComponent(btnReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(levelViewThing, GroupLayout.PREFERRED_SIZE, 902, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		GroupLayout gl_levelViewThing = new GroupLayout(levelViewThing);
		gl_levelViewThing.setHorizontalGroup(
			gl_levelViewThing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 957, Short.MAX_VALUE)
		);
		gl_levelViewThing.setVerticalGroup(
			gl_levelViewThing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 902, Short.MAX_VALUE)
		);
		levelViewThing.setLayout(gl_levelViewThing);
		contentPane.setLayout(gl_contentPane);
	}
}
