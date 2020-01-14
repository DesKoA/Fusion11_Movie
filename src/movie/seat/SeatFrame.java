package movie.seat;

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

import movie.mypage.MyPageFrame;

import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeatFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatFrame frame = new SeatFrame();
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
	public SeatFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./images/movie-symbol-of-video-camera_icon-icons.com_72981.png"));
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
		lblTitle.setFont(new Font("����", Font.BOLD, 35));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 51, 51));
		panel_3.setBounds(0, 99, 223, 472);
		panel_1.add(panel_3);
		
		JLabel mvInfoP = new JLabel("\uC601\uD654\uC815\uBCF4 \uD398\uC774\uC9C0");
		mvInfoP.setHorizontalAlignment(SwingConstants.CENTER);
		mvInfoP.setFont(new Font("����", Font.ITALIC, 25));
		mvInfoP.setBounds(12, 21, 199, 30);
		panel_3.add(mvInfoP);
		
		JLabel logOut = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		logOut.setHorizontalAlignment(SwingConstants.CENTER);
		logOut.setFont(new Font("����", Font.ITALIC, 25));
		logOut.setBounds(5, 135, 213, 47);
		panel_3.add(logOut);
		
		JLabel lblmyPage = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		lblmyPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("������������");
				MyPageFrame myPage = new MyPageFrame();
				myPage.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblmyPage.setForeground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblmyPage.setForeground(Color.black);
			}
		});
		lblmyPage.setBounds(5, 71, 213, 47);
		panel_3.add(lblmyPage);
		lblmyPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblmyPage.setFont(new Font("����", Font.ITALIC, 25));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 994, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 139, 34));
		panel_2.setBounds(223, 0, 770, 100);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMP = new JLabel("\uBE60\uB978 \uC608\uB9E4 \uC88C\uC11D \uC124\uC815");
		lblMP.setBounds(248, 21, 273, 41);
		lblMP.setForeground(Color.GREEN);
		panel_2.add(lblMP);
		lblMP.setFont(new Font("���� ����", Font.BOLD, 30));
		lblMP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(233, 110, 749, 451);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnSeat = new JButton("\uC88C\uC11D \uC124\uC815\uD558\uB7EC \uAC00\uAE30");
		btnSeat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSeat.setForeground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeat.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("�¼� ����");
				SelectSeatDialog selSeat = new SelectSeatDialog();
				selSeat.setVisible(true);
			}
		});
		btnSeat.setBounds(133, 174, 170, 73);
		panel_4.add(btnSeat);
		
		JButton btnTime = new JButton("\uC2DC\uAC04 \uC124\uC815\uD558\uB7EC \uAC00\uAE30");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTime.setBounds(440, 174, 170, 73);
		panel_4.add(btnTime);
	}
}
