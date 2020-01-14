package Join;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class noJoin extends JFrame {

	private JPanel contentPane;
	private JTextField idEnter;
	private JTextField pwField;
	private JTextField pwpwField;
	private JTextField phoneMid;
	private JTextField emailField;
	private JTextField phoneEnd;
	private BufferedImage background;
	private JPanel panel_2;
	private JTextField phone1st;
	private JTextField emailAddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					noJoin frame = new noJoin();
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
	
	public noJoin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 537);
		contentPane = new JPanel();
		//불투명
		//contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(219,93,92)); //(88,105,219));//(124, 166, 150));
		panel.setBounds(0, 86, 210, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton fstbutton = new JButton("\uCC98\uC74C\uD654\uBA74\uC73C\uB85C");
		fstbutton.setFont(new Font("굴림", Font.BOLD, 15));
		fstbutton.setBackground(new Color(219, 86, 114));
		fstbutton.setBounds(19, 50, 133, 35);
		panel.add(fstbutton);
		
		JButton nojoinBtn = new JButton("\uAC00\uC785\uD558\uAE30");
		nojoinBtn.setFont(new Font("굴림", Font.BOLD, 15));
		nojoinBtn.setBackground(new Color(219, 86, 114));
		nojoinBtn.setBounds(19, 119, 133, 35);
		panel.add(nojoinBtn);
		
		JPanel liftTitle = new JPanel();
		liftTitle.setBackground(new Color(249,127,105));//(100, 159, 249)); //(98, 140, 150));
		liftTitle.setBounds(0, 0, 210, 86);
		contentPane.add(liftTitle);
		liftTitle.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		ImageIcon icn = new ImageIcon(
//				final String ic = 
						"C:\\Users\\alfo4-11\\Desktop\\1차 프로젝트\\회원가입제목1.png");
						
		panel_2 = new JPanel() {
	   public void paintComponent(Graphics g) {
	    // Approach 1: Dispaly image at at full size
	    g.drawImage(icn.getImage(), 0, 0, null);
	    // Approach 2: Scale image to size of component
	    // Dimension d = getSize();
	    // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	    // Approach 3: Fix the image position in the scroll pane
	    // Point p = scrollPane.getViewport().getViewPosition();
	    // g.drawImage(icon.getImage(), p.x, p.y, null);
	    setOpaque(false);
	    super.paintComponent(g);
	   }
	  };
		
		panel_2.setBounds(294, 10, 669, 86);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel title = new JLabel("  \uBE44   \uD68C   \uC6D0   \uC815   \uBCF4   \uC785   \uB825");
		title.setBounds(0, 10, 511, 53);
		panel_2.add(title);
		title.setForeground(new Color(85, 71, 89));
		title.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setFont(new Font("돋움", Font.BOLD, 21));
		label.setBounds(54, 10, 108, 37);
		liftTitle.add(label);
		
		
     //   File file = new File("C:\\Users\\alfo4-11\\Desktop\\1차 프로젝트\\티켓보라색.png");
		ImageIcon ic = new ImageIcon(
//		final String ic = 
				"C:\\Users\\alfo4-11\\Desktop\\1차 프로젝트\\티켓분홍색.png");
				
				JPanel centens = new JPanel() {
			   public void paintComponent(Graphics g) {
			    // Approach 1: Dispaly image at at full size
			    g.drawImage(ic.getImage(), 0, 0, null);
			    // Approach 2: Scale image to size of component
			    // Dimension d = getSize();
			    // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
			    // Approach 3: Fix the image position in the scroll pane
			    // Point p = scrollPane.getViewport().getViewPosition();
			    // g.drawImage(icon.getImage(), p.x, p.y, null);
			    setOpaque(false);
			    super.paintComponent(g);
			   }
			  };
		
		//JPanel centens = new JPanel();
//        try {
//            background = ImageIO.read(file);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//		contentPane = new ImagePanel(ic.getImage(), 
//				"bg_cafe.jpg");
    	centens.setBounds(222, 86, 727, 387);
		contentPane.add(centens);
		centens.setLayout(null);
		
		JButton canel = new JButton("\uCDE8\uC18C\uD558\uAE30");
		canel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		canel.setBackground(new Color(123, 104, 238));
		canel.setBounds(206, 332, 90, 23);
		centens.add(canel);
		
		JButton pwCheck = new JButton("\uC911\uBCF5\uD655\uC778");
		pwCheck.setForeground(new Color(240, 248, 255));
		pwCheck.setBackground(new Color(47, 79, 79));
		pwCheck.setBounds(191, 103, 90, 23);
		centens.add(pwCheck);
		pwCheck.setBorderPainted(false);
		
		JLabel emailWhelk = new JLabel("  @");
		emailWhelk.setBounds(431, 76, 24, 21);
		centens.add(emailWhelk);
		
		JButton OKButton = new JButton("\uB4F1\uB85D\uD558\uAE30");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		OKButton.setBounds(397, 332, 97, 23);
		centens.add(OKButton);
		OKButton.setOpaque(true); //투명화
		OKButton.setForeground(UIManager.getColor("CheckBox.shadow"));
		OKButton.setBackground(new Color(123, 104, 238));
		
		JLabel yymmdd = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		yymmdd.setBounds(104, 262, 140, 25);
		centens.add(yymmdd);
		yymmdd.setFont(new Font("한컴돋움", Font.PLAIN, 20));
		
		phoneMid = new JTextField();
		phoneMid.setBounds(431, 297, 54, 21);
		centens.add(phoneMid);
		phoneMid.setColumns(4);
		
		phoneEnd = new JTextField();
		phoneEnd.setBounds(497, 297, 54, 21);
		centens.add(phoneEnd);
		phoneEnd.setColumns(4);
		
		JLabel _2 = new JLabel(" -");
		_2.setBounds(485, 300, 18, 15);
		centens.add(_2);
		
		JLabel _1 = new JLabel("   -");
		_1.setBounds(411, 298, 18, 18);
		centens.add(_1);
		
		pwField = new JTextField();
		pwField.setBounds(114, 195, 116, 21);
		centens.add(pwField);
		pwField.setColumns(10);
		
		JLabel pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pw.setBounds(104, 160, 140, 25);
		centens.add(pw);
		pw.setFont(new Font("한컴돋움", Font.PLAIN, 20));
		
		pwpwField = new JTextField();
		pwpwField.setBounds(364, 195, 116, 21);
		centens.add(pwpwField);
		pwpwField.setColumns(10);
		
		JLabel phone = new JLabel("\uC804\uD654\uBC88\uD638");
		phone.setBounds(350, 262, 140, 25);
		centens.add(phone);
		phone.setFont(new Font("한컴돋움", Font.PLAIN, 20));
		
		JLabel pwpw = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pwpw.setBounds(354, 160, 140, 25);
		centens.add(pwpw);
		pwpw.setFont(new Font("한컴돋움", Font.PLAIN, 20));
		
		idEnter = new JTextField();
		idEnter.setBounds(114, 76, 116, 21);
		centens.add(idEnter);
		idEnter.setText("\uC544\uC774\uB514 \uC785\uB825");
		idEnter.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(335, 76, 97, 21);
		centens.add(emailField);
		emailField.setColumns(10);
		
		JLabel email = new JLabel("\uC774\uBA54\uC77C");
		email.setBounds(354, 39, 140, 25);
		centens.add(email);
		email.setFont(new Font("한컴돋움", Font.PLAIN, 20));
		
		JLabel id = new JLabel("\uC544\uC774\uB514");
		id.setBounds(104, 39, 140, 25);
		centens.add(id);
		id.setFont(new Font("한컴돋움", Font.PLAIN, 20));
		
		JSpinner mm = new JSpinner();
		mm.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		mm.setBounds(172, 300, 40, 22);
		centens.add(mm);
		
		JSpinner yy = new JSpinner();
		yy.setModel(new SpinnerListModel(new String[] {"1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980"}));
		yy.setBounds(114, 300, 59, 22);
		centens.add(yy);
		
		JSpinner dd = new JSpinner();
		dd.setModel(new SpinnerNumberModel(new Integer(15), null, null, new Integer(1)));
		dd.setBounds(211, 300, 41, 22);
		centens.add(dd);
		
		phone1st = new JTextField();
		phone1st.setColumns(4);
		phone1st.setBounds(364, 297, 54, 21);
		centens.add(phone1st);
		
		emailAddress = new JTextField();
		emailAddress.setColumns(10);
		emailAddress.setBounds(453, 76, 97, 21);
		centens.add(emailAddress);
		
		JComboBox emailCombo = new JComboBox();
		emailCombo.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com"}));
		emailCombo.setBounds(566, 76, 109, 21);
		centens.add(emailCombo);
		

	}
}
