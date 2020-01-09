package movie.ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class TicketInfoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketInfoFrame frame = new TicketInfoFrame();
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
	public TicketInfoFrame() {
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
		
		JLabel lblLogout = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("±¼¸²", Font.ITALIC, 25));
		lblLogout.setBounds(5, 135, 213, 47);
		panel_3.add(lblLogout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 994, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(32, 178, 170));
		panel_2.setBounds(223, 0, 770, 100);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMP = new JLabel("\uC608\uB9E4 \uC815\uBCF4");
		lblMP.setBounds(248, 21, 273, 41);
		lblMP.setForeground(Color.CYAN);
		panel_2.add(lblMP);
		lblMP.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblMP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.PINK);
		panel_4.setBounds(250, 110, 223, 107);
		panel.add(panel_4);
		
		JLabel label_2 = new JLabel("minmin\uB2D8");
		label_2.setFont(new Font("±¼¸²", Font.PLAIN, 35));
		label_2.setBounds(31, 0, 192, 105);
		panel_4.add(label_2);
	}
}
