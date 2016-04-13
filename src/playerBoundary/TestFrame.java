package playerBoundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class TestFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(6, 6, 117, 29);
		contentPane.add(btnMenu);
		
		JButton btnReset = new JButton("reset");
		btnReset.setBounds(135, 6, 117, 29);
		contentPane.add(btnReset);
		
		JPanel levelViewThing = new JPanel();
		levelViewThing.setBounds(16, 42, 936, 638);
		contentPane.add(levelViewThing);
	}
}
