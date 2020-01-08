/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.ticketing;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import db.dao.MovieDBManager;
import db.dao.TheatersDBManager;
import db.util.OracleDBUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import java.awt.GridLayout;

/**
 *
 * @author alfo4-9
 */
public class MovieTicketingSeatTestBack extends JFrame {
	public int adPersons;
	public int stPersons;
	public String movTitle;
	
	public static OracleDBUtil db;
	public MovieDBManager movieMgr;
	public TheatersDBManager thMgr;
	
	public JDesktopPane desktop;
	
	public LinkedHashMap<String, ArrayList<String>> timeList;
	
	public MovieTicketingTest mov;
	

	/**
	 * Creates new form MovieReservation
	 */
	
	public MovieTicketingSeatTestBack(MovieTicketingTest mov) {
		this.mov = mov; 
		initComponents();
	}
	
	// �ʱ�ȭ 
	public void resetFrame() {
		
	}
	
	/**    
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	public void initComponents() {
		OracleDBUtil.connectDB();
		mov = MovieTicketingTest.mov;
		Object[] obj = mov.getObjects(); 
		movieMgr = new MovieDBManager();
		thMgr = new TheatersDBManager();
		Main = new JPanel();
		movieInfo = new JPanel();
		seatPanelLeft = new JPanel();
		resetRe = new JButton();
		movieInfoPoster = new JLabel();
		movieInfoName = new JLabel();
		movieInfoGrade = new JLabel();
		movieInfoMoney = new JLabel();
		movieInfoRating = new JLabel();
		movieInfoScreen = new JLabel();
		movieInfoDay = new JLabel();
		btnSeatSelect = new JButton();
		movieInfoTime = new JLabel();
		movieInfoPeople = new JLabel();
		movieInfoScreenName = new JLabel();
		movieInfoDayName = new JLabel();
		movieInfoPeopleName = new JLabel();
		movieInfoTimeName = new JLabel();
		movieInfoMoneyName = new JLabel();
		movieInfoStar = new JLabel();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));

		Main.setBackground(new Color(255, 255, 255));
		Main.setLayout(new AbsoluteLayout());
		
		movieInfo.setBackground(new Color(45, 45, 45));
		movieInfo.setLayout(new AbsoluteLayout());

		resetRe.setFont(new Font("����������", 1, 15)); // NOI18N
		resetRe.setText("���� �ٽ��ϱ�");
		resetRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFrame();
			}
		});
		movieInfo.add(resetRe, new AbsoluteConstraints(10, 10, 130, 30));
		
		movieInfoPoster.setOpaque(true);
		movieInfoPoster.setIcon((Icon)obj[0]);
		movieInfo.add(movieInfoPoster, new AbsoluteConstraints(40, 60, 200, 250));
		
		movieInfoName.setFont(new Font("����������", 0, 20)); // NOI18N
		movieInfoName.setForeground(new Color(255, 255, 255));
		movieInfoName.setText((String)obj[1]);
		movieInfo.add(movieInfoName, new AbsoluteConstraints(40, 320, -1, -1));

		movieInfoMoney.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoMoney.setForeground(new Color(255, 255, 255));
		movieInfoMoney.setText("�ݾ�");
		movieInfo.add(movieInfoMoney, new AbsoluteConstraints(40, 500, -1, -1));

		movieInfoRating.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoRating.setForeground(new Color(255, 0, 0));
		movieInfoRating.setText("\uD3C9\uC810");
		movieInfo.add(movieInfoRating, new AbsoluteConstraints(40, 350, -1, -1));
		
		movieInfoGrade.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoGrade.setForeground(new Color(255, 0, 0));
		movieInfoGrade.setText((String)obj[2]);
		movieInfo.add(movieInfoGrade, new AbsoluteConstraints(205, 350, -1, -1));
		
		movieInfoScreen.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoScreen.setForeground(new Color(255, 255, 255));
		movieInfoScreen.setText("\uADF9\uC7A5");
		movieInfo.add(movieInfoScreen, new AbsoluteConstraints(40, 380, -1, -1));

		movieInfoDay.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoDay.setForeground(new Color(255, 255, 255));
		movieInfoDay.setText("��¥");
		movieInfo.add(movieInfoDay, new AbsoluteConstraints(40, 410, -1, -1));

		btnSeatSelect.setBackground(new Color(255, 255, 255));
		btnSeatSelect.setFont(new Font("����������", 1, 24)); // NOI18N
		btnSeatSelect.setText("\uC88C\uC11D \uC120\uD0DD");
		btnSeatSelect.setOpaque(false);
		btnSeatSelect.setEnabled(false);
		btnSeatSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		movieInfo.add(btnSeatSelect, new AbsoluteConstraints(50, 540, 190, -1));

		movieInfoTime.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoTime.setForeground(new Color(255, 255, 255));
		movieInfoTime.setText("\uC2DC\uAC04");
		movieInfo.add(movieInfoTime, new AbsoluteConstraints(40, 470, -1, -1));

		movieInfoPeople.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoPeople.setForeground(new Color(255, 255, 255));
		movieInfoPeople.setText("�ο�");
		movieInfo.add(movieInfoPeople, new AbsoluteConstraints(40, 440, -1, -1));
		
		movieInfoScreenName.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoScreenName.setForeground(new Color(255, 255, 255));
		movieInfoScreenName.setText((String)obj[4]);
		movieInfo.add(movieInfoScreenName, new AbsoluteConstraints(80, 380, -1, -1));

		movieInfoDayName.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoDayName.setForeground(new Color(255, 255, 255));
		movieInfoDayName.setText((String)obj[5]);
		movieInfo.add(movieInfoDayName, new AbsoluteConstraints(80, 410, -1, -1));

		movieInfoPeopleName.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoPeopleName.setForeground(new Color(255, 255, 255));
		movieInfoPeopleName.setText((String)obj[6]);
		movieInfo.add(movieInfoPeopleName, new AbsoluteConstraints(80, 440, -1, -1));

		movieInfoTimeName.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoTimeName.setForeground(new Color(255, 255, 255));
		movieInfoTimeName.setText((String)obj[7]);
		movieInfo.add(movieInfoTimeName, new AbsoluteConstraints(80, 470, -1, -1));
		
		movieInfoMoneyName.setFont(new Font("����������", 0, 18)); // NOI18N
		movieInfoMoneyName.setForeground(new Color(255, 255, 255));
		movieInfoMoneyName.setText((String)obj[8]);
		movieInfo.add(movieInfoMoneyName, new AbsoluteConstraints(80, 500, 80, -1));

		Main.add(movieInfo, new AbsoluteConstraints(730, 0, 280, 610));
        Main.add(seatPanelLeft, new AbsoluteConstraints(0, 0, 730, 600));
        seatPanelLeft.setLayout(null);
        
        seatBtnPanel = new JPanel();
        seatBtnPanel.setBounds(148, 91, 535, 475);
        seatPanelLeft.add(seatBtnPanel);
        for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton btn = new JButton();
				btn.setVisible(true);
				btn.setPreferredSize(new Dimension(30, 30));
				seatBtnPanel.add(btn);
			}
		} 
        seatBtnPanel.setLayout(new GridLayout(10, 5, 5, 5));
        
		movieInfoStar.setBackground(new Color(255, 255, 255));
		movieInfoStar.setAlignmentY(0.0F);
		movieInfoStar.setIcon((Icon)obj[3]);
		movieInfo.add(movieInfoStar, new AbsoluteConstraints(78, 347, 120, 25));
		
        
		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(Main, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(Main, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		getContentPane().setLayout(layout);
		
		pack();
		// mov = this;
	}// </editor-fold>
	
	private JPanel Main;
	private JButton btnSeatSelect;
	private JPanel movieInfo;
	private JPanel seatPanelLeft;
	public JLabel movieInfoDayName;
	public JLabel movieInfoMoneyName;
	public JLabel movieInfoScreenName;
	public JLabel movieInfoTimeName;
	public JLabel movieInfoPeopleName;
	private JLabel movieInfoName;
	private JLabel movieInfoMoney;
	private JLabel movieInfoRating;
	private JLabel movieInfoScreen;
	private JLabel movieInfoDay;
	private JLabel movieInfoTime;
	private JLabel movieInfoPeople;
	private JLabel movieInfoPoster;
	private JLabel movieInfoStar;
	private JLabel movieInfoGrade;
	private JButton resetRe;
	private JPanel seatBtnPanel;
}
