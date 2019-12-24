package test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Graphics;

public class BackGround extends JFrame {
	JScrollPane scrollPane;
	ImageIcon icon;

	public BackGround() {
	        icon = new ImageIcon("C:\\Users\\alfo4-9\\Desktop\\sampleImage\\sample.jpg");
	         
	        JPanel background = new JPanel() {
	            public void paintComponent(Graphics g) {
	                g.drawImage(icon.getImage(), 0, 0, 640, 480, null);
	                setOpaque(false);
	                super.paintComponent(g);
	            }
	        };
	        scrollPane = new JScrollPane(background);
	        setContentPane(scrollPane);
	        setResizable(false);
	    }

	public static void main(String[] args) {
		BackGround frame = new BackGround();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
