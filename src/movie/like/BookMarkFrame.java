package movie.like;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import movie.mypage.ImagePanel;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BookMarkFrame extends JFrame {
	private JPanel contentPane;
	private ImagePanel contentPaneIg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMarkFrame frame = new BookMarkFrame();
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
	public BookMarkFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\predi\\eclipse-workspace\\movie\\images\\movie-symbol-of-video-camera_icon-icons.com_72981.png"));
		setTitle("\uB098 \uBA3C\uC800 \uC608\uB9E4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 223, 571);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setLayout(null);
		
		JLabel lblTitle = new JLabel("\uB098 \uBA3C\uC800 \uC608\uB9E4");
		lblTitle.setBounds(5, 30, 213, 41);
		lblTitle.setForeground(new Color(255, 255, 255));
		panel_1.add(lblTitle);
		lblTitle.setFont(new Font("±¼¸²", Font.BOLD, 35));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("±¼¸²", Font.ITALIC, 25));
		label.setBounds(5, 171, 213, 47);
		panel_1.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 51, 51));
		panel_3.setBounds(0, 99, 223, 472);
		panel_1.add(panel_3);
		
		JLabel label_1 = new JLabel("\uC601\uD654\uC815\uBCF4 \uD398\uC774\uC9C0");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("±¼¸²", Font.ITALIC, 25));
		label_1.setBounds(12, 21, 199, 30);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("±¼¸²", Font.ITALIC, 25));
		label_2.setBounds(5, 135, 213, 47);
		panel_3.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 994, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("textHighlight"));
		panel_2.setBounds(223, 0, 770, 100);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMP = new JLabel("\uC88B\uC544\uC694 \uD55C \uC601\uD654");
		lblMP.setBounds(233, 28, 305, 41);
		lblMP.setForeground(Color.BLUE);
		panel_2.add(lblMP);
		lblMP.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblMP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel like1 = new JPanel();
		like1.setBounds(285, 287, 115, 130);
		ImageIcon frozen = new ImageIcon("./mages/poster/°Ü¿ï¿Õ±¹2.PNG");
		contentPaneIg = new ImagePanel(frozen.getImage(), "°Ü¿ï¿Õ±¹2.PNG");
		contentPaneIg.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneIg.setLayout(new BorderLayout(0, 0));
		panel.add(like1);
		like1.setLayout(null);
		
		JPanel like2 = new JPanel();
		like2.setBounds(468, 287, 115, 130);
		ImageIcon ctDown = new ImageIcon("./mages/poster/Ä«¿îÆ®´Ù¿î.PNG");
		contentPaneIg = new ImagePanel(ctDown.getImage(), "Ä«¿îÆ®´Ù¿î.PNG");
		contentPaneIg.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneIg.setLayout(new BorderLayout(0, 0));
		panel.add(like2);
		like2.setLayout(null);
		
		JLabel lblLike = new JLabel("\uC88B\uC544\uC694");
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblLike.setBounds(285, 248, 68, 21);
		panel.add(lblLike);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.PINK);
		panel_4.setBounds(250, 110, 223, 107);
		panel.add(panel_4);
		
		JLabel label_3 = new JLabel("minmin\uB2D8");
		label_3.setBounds(31, 0, 192, 105);
		panel_4.add(label_3);
		label_3.setFont(new Font("±¼¸²", Font.PLAIN, 35));
	}
}
