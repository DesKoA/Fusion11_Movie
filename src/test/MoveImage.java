package test;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MoveImage extends JFrame implements ActionListener {
	ImageIcon movie1, movie2, movie3, movie4, movie5, movie6;
	JLabel label1, label2, label3, label4, label5, label6;
	// JButton button1;
	int moving = 600;

	public MoveImage(String title) {
		super(title);
		
		getContentPane().setLayout(null);// getContentPane()현재의 패널
		movie1 = new ImageIcon("C:\\Users\\alfo4-9\\Desktop\\sampleImage\\movie_image.jpg");
		movie2 = new ImageIcon("C:\\Users\\alfo4-9\\Desktop\\sampleImage\\movie_image.jpg");
		movie3 = new ImageIcon("C:\\Users\\alfo4-9\\Desktop\\sampleImage\\movie_image.jpg");
		movie4 = new ImageIcon("C:\\Users\\alfo4-9\\Desktop\\sampleImage\\movie_image.jpg");
		movie5 = new ImageIcon("C:\\Users\\alfo4-9\\Desktop\\sampleImage\\movie_image.jpg");
		movie6 = new ImageIcon("C:\\Users\\alfo4-9\\Desktop\\sampleImage\\movie_image.jpg");

		label1 = new JLabel(movie1);
		label2 = new JLabel(movie2);
		label3 = new JLabel(movie3);
		label4 = new JLabel(movie3);
		label5 = new JLabel(movie3);
		label6 = new JLabel(movie3);
		try {
			while (true) {
				for (int i = 1; i < moving; i += 5) {

					getContentPane().add(label1);
					getContentPane().add(label2);
					getContentPane().add(label3);
					getContentPane().add(label4);
					getContentPane().add(label5);
					getContentPane().add(label6);
					// getContentPane().add(button1);

					label1.setBounds(i, 125, 150, 200);

					label2.setBounds(i + 200, 125, 150, 200);

					label3.setBounds(i + 400, 125, 150, 200);

					label4.setBounds(i - 200, 125, 150, 200);

					label5.setBounds(i - 400, 125, 150, 200);

					label6.setBounds(i - 600, 125, 150, 200);

					Thread.sleep(50);
					repaint();
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					setSize(500, 500);
					setVisible(true);

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MoveImage("");
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
