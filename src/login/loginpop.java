package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;

public class loginpop extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpop frame = new loginpop();
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
	public loginpop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 32, 249, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\uB098 \uBA3C\uC800 \uC608\uBA54");
		label.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		label.setForeground(SystemColor.textHighlight);
		label.setBounds(71, 10, 126, 31);
		panel.add(label);
		
		JButton btnNewButton_1 = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton_1.setBounds(3, 155, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBounds(152, 155, 97, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(12, 46, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(12, 98, 57, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		textField.setBounds(12, 67, 139, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setText("\uBE44\uBC00\uBC88\uD638");
		textField_1.setBounds(12, 123, 139, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
