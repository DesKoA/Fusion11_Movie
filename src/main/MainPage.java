package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 537);
		ImageIcon ic = new ImageIcon(".\\image\\시작화면투.png");
		contentPane = new JPanel() {
		   public void paintComponent(Graphics g) { //투명도 조절크기 조절
			    g.drawImage(ic.getImage(), 0, 0, null);
			    setOpaque(false);
			    super.paintComponent(g);
			   }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(49, 21, 909, 93);
		contentPane.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText("\uB098\uBA3C\uC800\uC608\uB9E4 \uC0AC\uC774\uD2B8\uC5D0 \uC624\uC2E0\uAC83\uC744 \uD658\uC601\uD569\uB2C8\uB2E4.");
		formattedTextField_1.setBounds(132, 34, 637, 35);
		//formattedTextField_1.setVisible(false);
		panel.add(formattedTextField_1);
		
		
		ImageIcon icon = new ImageIcon(	".\\image\\movie-camera.png");
		JPanel moviepanel = new JPanel() {
			   public void paintComponent(Graphics g) { //투명도 조절크기 조절
				    g.drawImage(icon.getImage(), 0, 0, null);
				    setOpaque(false);
				    super.paintComponent(g);
				   }
			};

		moviepanel.setBounds(33, 8, 89, 83);
		panel.add(moviepanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(45, 124, 913, 287);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		
		JButton joinBtn = new JButton(new ImageIcon(".\\image\\빨강1.png"));
		joinBtn.setBorderPainted(false);//버튼 테두리 설정 테두리 설정을 없애니까 클릭 모션이 안되네
		joinBtn.setContentAreaFilled(false);//버튼 영역 배경 표시 설정
		joinBtn.setFocusPainted(false);
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		joinBtn.setBounds(90, 36, 192, 175);
		panel_1.add(joinBtn);
		
		JButton loginBtn = new JButton(new ImageIcon(".\\image\\초록.png"));
		//loginBtn.setBorderPainted(false);//버튼 테두리 설정
		loginBtn.setContentAreaFilled(false);//버튼 영역 배경 표시 설정
		loginBtn.setFocusPainted(false);
		loginBtn.setBounds(309, 36, 192, 175);
		panel_1.add(loginBtn);
		
		JButton nojoinBtn = new JButton(new ImageIcon(".\\image\\파랑.png"));
		//nojoinBtn.setBorderPainted(false);//버튼 테두리 설정
		nojoinBtn.setContentAreaFilled(false);//버튼 영역 배경 표시 설정
		nojoinBtn.setFocusPainted(false);
		nojoinBtn.setBounds(531, 36, 192, 175);
		panel_1.add(nojoinBtn);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("굴림", Font.BOLD, 16));
		formattedTextField.setText("\uD68C\uC6D0\uAC00\uC785\uC2DC \uBE60\uB978 \uC608\uB9E4 \uAC00\uB2A5");
		formattedTextField.setBounds(142, 222, 218, 35);
		panel_1.add(formattedTextField);

						
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
