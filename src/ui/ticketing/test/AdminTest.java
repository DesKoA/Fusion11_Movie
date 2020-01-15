/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.ticketing.test;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import data.MovieInfo;
import data.Theaters;
import db.dao.MovieDBManager;
import db.dao.TheatersDBManager;
import db.util.OracleDBUtil;
import ui.ticketing.MovieTicketingSeat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

/**
 *
 * @author alfo4-9
 */
public class AdminTest extends JFrame {
	public int adPersons;
	public int stPersons;
	public String movTitle;
	public CalendarAdmin calFrame = new CalendarAdmin();
	
	public ButtonGroup bgAdult; 
	public ButtonGroup bgStudent;
	public ButtonGroup bg;
	
	public static OracleDBUtil db;
	public MovieDBManager movieMgr;
	public TheatersDBManager thMgr;
	
	public JPanel timeBtPanel;
	
	public JDesktopPane desktop;
	
	public ImageIcon Icon;
	public ImageIcon Icon2; 
	
	public Date movDate;
	
	public LinkedHashMap<String, ArrayList<String>> timeList;
	
	public static AdminTest mov;
	
	public void setFrame() {
		setBounds(0, 0, 500, 400);

		setAlwaysOnTop(false);
		desktop = new JDesktopPane(); // a specialized layered pane
		createFrame(); // create first "window"
		setContentPane(desktop);
	}

	protected void createFrame() {
		setAlwaysOnTop(false);
		// frame.setBounds(470, 30, 260, 370);
		calFrame.setBounds(269, 35, 460, 304); // 364
		calFrame.setVisible(true);
		BasicInternalFrameUI bi = (BasicInternalFrameUI) calFrame.getUI();
		calFrame.setBorder(new LineBorder(Color.BLACK, 1));
		bi.setNorthPane(null);
		desktop.add(calFrame);
		try {
			calFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
			
		}
	}

	/**
	 * Creates new form MovieReservation
	 */
	
	public AdminTest() {
		CalendarAdmin.mov = this;
		initComponents();
	}
	
	// ÃÊ±âÈ­ 
	public void resetFrame() {
		adPersons = 0;
		stPersons = 0;
		calFrame.showCal();
		bg.clearSelection();
		movieList.clearSelection();
		bgAdult.clearSelection();
		btnAllot.setEnabled(false);
		timePanel.setVisible(false);
		movieInfoName.setFont(new Font("³ª´®½ºÄù¾î", 0, 20)); // NOI18N
		movieInfoName.setText("¿µÈ­¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä");
		movieInfoName.setForeground(new Color(255, 255, 255));
		movieInfoScreenName.setText("-");
		
		try {
			Image image = ImageIO.read(new File(".\\files\\image\\no_poster.png"));
			Image changedImg = image.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
			movieInfoPoster.setIcon(Icon);
			
			Image image2 = ImageIO.read(new File("./files/image/starRating/star0.png"));
			Image changedImg2 = image2.getScaledInstance(120, 25, Image.SCALE_SMOOTH);
			Icon2 = new ImageIcon(changedImg2);
			movieInfoStar.setIcon(Icon2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// DB¿¡¼­ ¹Þ¾Æ¿À±â
	public void showTableDB() {
		String[] header = { "Á¦¸ñ", "±ØÀå", "ÀÏÀÚ", "½ÃÀÛ", "Á¾·á"};
		// select movie_title, screen_name, movie_date, movie_start, movie_end from movie_theaters where screen_name = '1°ü' and TO_CHAR(movie_date, 'YYYYMMDD')='20200124' order by screen_name, movie_start asc;
		TheatersDBManager thMgr = new TheatersDBManager();
		ArrayList<Theaters> thList = thMgr.selectOneMovie(movTitle);
		Object[][] data = new Object[thList.size()][header.length];
		for (int i = 0; i < thList.size(); i++) {
			Theaters row = thList.get(i);
			// data[i][0] 
		}
		DefaultTableModel dtm = new DefaultTableModel(data, header);
		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
	}
	
	/**    
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	public void initComponents() {
		OracleDBUtil.connectDB();
		movieMgr = new MovieDBManager();
		thMgr = new TheatersDBManager();
		Main = new JPanel();
		allotMovie = new JPanel();
		labelMovie = new JLabel();
		order = new JPanel();
		ganadaB = new JToggleButton();
		gradeB = new JToggleButton();
		movieListSC = new JScrollPane();
		movieList = new JList<>();
		movieInfo = new JPanel();
		resetRe = new JButton();
		movieInfoPoster = new JLabel();
		movieInfoGrade = new JLabel();
		movieInfoName = new JLabel();
		movieInfoRating = new JLabel();
		movieInfoScreen = new JLabel();
		movieInfoDay = new JLabel();
		movieTimeLabel = new JLabel();
		btnAllot = new JButton();
		movieInfoScreenName = new JLabel();
		movieInfoDayName = new JLabel();
		timePanel = new JPanel();
		movieInfoStar = new JLabel();
		selCal = new JPanel();
		calSel = new JLabel();
		allotMovieTimeTheaters = new JPanel();
		lblSelMovieTime = new JLabel();
		movieTimeLabelName = new JLabel();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));

		Main.setBackground(new Color(255, 255, 255));
		Main.setLayout(new AbsoluteLayout());

		allotMovie.setBackground(new Color(218, 210, 180));
		allotMovie.setBorder(BorderFactory.createEtchedBorder());
		allotMovie.setLayout(new AbsoluteLayout());

		labelMovie.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 0, 18)); // NOI18N
		labelMovie.setForeground(new Color(0, 0, 0));
		labelMovie.setText("\uC601\uD654 \uBC30\uC815");
		allotMovie.add(labelMovie, new AbsoluteConstraints(10, 3, 70, 30));

		Main.add(allotMovie, new AbsoluteConstraints(0, 0, 270, 35));

		order.setBackground(new Color(204, 204, 204));
		order.setLayout(new AbsoluteLayout());
		
		bg = new ButtonGroup();
		
		bg.add(gradeB);
		bg.add(ganadaB);
		
		ganadaB.setBackground(new Color(255, 255, 255));
		ganadaB.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 1, 13)); // NOI18N
		ganadaB.setForeground(new Color(0, 0, 0));
		ganadaB.setText("°¡³ª´Ù¼ø");
		ganadaB.setAlignmentY(0.0F);
		ganadaB.setBorder(null);
		ganadaB.setOpaque(false);
		ganadaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ganadaBActionPerformed(evt);
				resetFrame();
			}
		});
		
		order.add(ganadaB, new AbsoluteConstraints(70, 2, 60, 30));

		gradeB.setBackground(new Color(255, 255, 255));
		gradeB.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 1, 13)); // NOI18N
		gradeB.setForeground(new Color(0, 0, 0));
		gradeB.setText("ÆòÁ¡¼ø");
		gradeB.setAlignmentY(0.0F);
		gradeB.setBorder(null);
		gradeB.setOpaque(false);
		gradeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gradeBActionPerformed(evt);
				resetFrame();
			}
		});
		
		order.add(gradeB, new AbsoluteConstraints(2, 2, 60, 30));

		Main.add(order, new AbsoluteConstraints(0, 34, 268, 35));

		movieListSC.setBackground(new Color(255, 255, 255));
		movieListSC.setAlignmentX(0.0F);
		movieListSC.setAlignmentY(0.0F);

		movieList.setBackground(Color.WHITE);
		movieList.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16)); // NOI18N
		
		movieList.setModel(new AbstractListModel<String>() {
			String[] strings = movieMgr.movie_selectAllTitle(true);
			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		
		// ¿µÈ­ ¸®½ºÆ® Å¬¸¯½Ã ¿µÈ­ Á¤º¸ º¯°æ
		movieList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String selection = movieList.getSelectedValue();
					movTitle = selection;
					movieInfoName.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
					movieInfoName.setText(selection);
					if (selection != null) {
						try {
							MovieInfo movieInfo = movieMgr.movie_selectOneByTitle(selection);
							String strURL = movieInfo.getMoviePoster();
							URL url = new URL(strURL);
							Image image = ImageIO.read(url);
							Image changedImg = image.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
							Icon = new ImageIcon(changedImg);
							movieInfoPoster.setIcon(Icon);
							movieInfoGrade.setText(String.valueOf(movieInfo.getMovieRating()));
							movieInfoDayName.setText("-");
							float rating = movieInfo.getMovieRating();
							
							String ratingPath = "0";
							if (rating >= 0 && rating < 1.5) ratingPath = "0.5"; 
							else if (rating >= 1.5 && rating < 2.5) ratingPath = "1";
							else if (rating >= 2.5 && rating < 3.5) ratingPath = "1.5";
							else if (rating >= 3.5 && rating < 4.5) ratingPath = "2";
							else if (rating >= 4.5 && rating < 5.5) ratingPath = "2.5";
							else if (rating >= 5.5 && rating < 6.5) ratingPath = "3";
							else if (rating >= 6.5 && rating < 7.5) ratingPath = "3.5";
							else if (rating >= 7.5 && rating < 8.5) ratingPath = "4";
							else if (rating >= 8.5 && rating < 9.5) ratingPath = "4.5";
							else if (rating >= 9.5) ratingPath = "5";
							
							Image image2 = ImageIO.read(new File("./files/image/starRating/star" + ratingPath + ".png"));
							Image changedImg2 = image2.getScaledInstance(120, 25, Image.SCALE_SMOOTH);
							Icon2 = new ImageIcon(changedImg2);
							movieInfoStar.setIcon(Icon2);
							TheatersDBManager thMgr = new TheatersDBManager();
							if (thMgr.selectOneMovie(selection).size() == 0) {
								timePanel.setVisible(false);
							}
							// calFrame.setVisible(true);
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
				}
			}
		});
		
		movieList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		movieListSC.setViewportView(movieList);
		movieListSC.setBorder(new LineBorder(Color.BLACK, 1));
		Main.add(movieListSC, new AbsoluteConstraints(1, 70, 269, 269)); // 10, 3, 180, 30

		movieInfo.setBackground(new Color(45, 45, 45));
		movieInfo.setLayout(new AbsoluteLayout());

		resetRe.setFont(new Font("³ª´®½ºÄù¾î", 1, 15)); // NOI18N
		resetRe.setText("\uBC30\uC815 \uB2E4\uC2DC\uD558\uAE30");
		resetRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFrame();
			}
		});
		movieInfo.add(resetRe, new AbsoluteConstraints(10, 10, 130, 30));
		
		try {
			Image image = ImageIO.read(new File(".\\files\\image\\no_poster.png"));
			Image changedImg = image.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
			movieInfoPoster.setIcon(Icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		movieInfoPoster.setOpaque(true);
		movieInfo.add(movieInfoPoster, new AbsoluteConstraints(40, 60, 200, 250));

		movieInfoGrade.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoGrade.setForeground(new Color(255, 0, 0));
		movieInfo.add(movieInfoGrade, new AbsoluteConstraints(205, 350, -1, -1));
		
		movieInfoName.setFont(new Font("³ª´®½ºÄù¾î", 0, 20)); // NOI18N
		movieInfoName.setForeground(new Color(255, 255, 255));
		movieInfoName.setText("¿µÈ­¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä");
		movieInfo.add(movieInfoName, new AbsoluteConstraints(40, 320, -1, -1));

		movieInfoRating.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoRating.setForeground(new Color(255, 0, 0));
		movieInfoRating.setText("\uD3C9\uC810");
		movieInfo.add(movieInfoRating, new AbsoluteConstraints(40, 350, -1, -1));

		movieInfoScreen.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoScreen.setForeground(new Color(255, 255, 255));
		movieInfoScreen.setText("\uADF9\uC7A5");
		movieInfo.add(movieInfoScreen, new AbsoluteConstraints(40, 380, -1, -1));

		movieInfoDay.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoDay.setForeground(new Color(255, 255, 255));
		movieInfoDay.setText("³¯Â¥");
		movieInfo.add(movieInfoDay, new AbsoluteConstraints(40, 410, -1, -1));
		
		movieTimeLabel.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieTimeLabel.setForeground(new Color(255, 255, 255));
		movieTimeLabel.setText("½Ã°£");
		movieInfo.add(movieTimeLabel, new AbsoluteConstraints(40, 440, -1, -1));

		btnAllot.setBackground(new Color(255, 255, 255));
		btnAllot.setFont(new Font("³ª´®½ºÄù¾î", 1, 24)); // NOI18N
		btnAllot.setText("\uBC30\uC815 \uD558\uAE30");
		btnAllot.setOpaque(false);
		btnAllot.setEnabled(false);
		btnAllot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		movieInfo.add(btnAllot, new AbsoluteConstraints(50, 540, 190, -1));
		
		movieInfoScreenName.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoScreenName.setForeground(new Color(255, 255, 255));
		movieInfoScreenName.setText("-");
		movieInfo.add(movieInfoScreenName, new AbsoluteConstraints(80, 380, -1, -1));

		movieInfoDayName.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieInfoDayName.setForeground(new Color(255, 255, 255));
		movieInfoDayName.setText("-");
		movieInfo.add(movieInfoDayName, new AbsoluteConstraints(80, 410, -1, -1));
		
		movieTimeLabelName.setFont(new Font("³ª´®½ºÄù¾î", 0, 18)); // NOI18N
		movieTimeLabelName.setForeground(new Color(255, 255, 255));
		movieTimeLabelName.setText("-");
		movieInfo.add(movieTimeLabelName, new AbsoluteConstraints(80, 440, -1, -1));

		Main.add(movieInfo, new AbsoluteConstraints(730, 0, 280, 610));

		selCal.setBackground(new Color(218, 210, 180));
		selCal.setBorder(BorderFactory.createEtchedBorder());
		selCal.setLayout(new AbsoluteLayout());

		calSel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 0, 18)); // NOI18N
		calSel.setForeground(new Color(0, 0, 0));
		calSel.setText("´Þ·Â ¼±ÅÃ");
		selCal.add(calSel, new AbsoluteConstraints(10, 3, 70, 30));

		Main.add(selCal, new AbsoluteConstraints(270, 0, 460, 35));
		
		bgAdult = new ButtonGroup();
		
		allotMovieTimeTheaters.setBackground(new Color(218, 210, 180));
		allotMovieTimeTheaters.setBorder(BorderFactory.createEtchedBorder());
		allotMovieTimeTheaters.setLayout(new AbsoluteLayout());
		
		lblSelMovieTime.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 0, 18)); // NOI18N
		lblSelMovieTime.setForeground(new Color(0, 0, 0));
		lblSelMovieTime.setText("\uBC30\uC815 \uAC00\uB2A5\uD55C \uADF9\uC7A5\uACFC \uC2DC\uAC04");
		allotMovieTimeTheaters.add(lblSelMovieTime, new AbsoluteConstraints(10, 3, 180, 30));
		
		movieInfoStar.setBackground(new Color(255, 255, 255));
		movieInfoStar.setAlignmentY(0.0F);
		try {
			Image image = ImageIO.read(new File("./files/image/starRating/star0.png"));
			Image changedImg = image.getScaledInstance(120, 25, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
			movieInfoStar.setIcon(Icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		movieInfo.add(movieInfoStar, new AbsoluteConstraints(78, 347, 120, 25));
		
		setFrame();
		Main.add(allotMovieTimeTheaters, new AbsoluteConstraints(1, 340, 730, 35));
		timePanel.setBackground(new Color(255, 255, 255));
        // timePanel.setAlignmentX(0.0F);
        // timePanel.setAlignmentY(0.0F);
		timePanel.setBorder(new LineBorder(Color.BLACK, 1));
		// timePanel.setLayout(new GridLayout(1, 0));
		// timePanel.setLayout(new GridLayout(0, 1));
        Main.add(timePanel, new AbsoluteConstraints(1, 375, 728, 235));
        timePanel.setLayout(null);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(2, 2, 332, 232);
        timePanel.add(tablePanel);
        tablePanel.setLayout(new BorderLayout(0, 0));
        
        JPanel inPanel = new JPanel();
        tablePanel.add(inPanel, BorderLayout.NORTH);
        inPanel.setLayout(new BorderLayout(0, 0));
        
        north = new JPanel();
        inPanel.add(north);
        north.setLayout(new BorderLayout(0, 0));
        
        in = new JPanel();
        north.add(in, BorderLayout.EAST);
        
        lblNewLabel = new JLabel("\uADF9\uC7A5 \uC120\uD0DD");
        lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        in.add(lblNewLabel);
        
        comboBox = new JComboBox();
        comboBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"1\uAD00", "2\uAD00", "3\uAD00", "4\uAD00", "5\uAD00"}));
        in.add(comboBox);
        
        inTxtLb = new JLabel("\uADF9\uC7A5\uC5D0 \uBC30\uC815\uB41C \uC601\uD654 \uBAA9\uB85D \uD14C\uC774\uBE14");
        inTxtLb.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
        north.add(inTxtLb, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        showTableDB();
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Main, GroupLayout.PREFERRED_SIZE,
				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Main, GroupLayout.DEFAULT_SIZE,
				GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		
		pack();
		mov = this;
	}// </editor-fold>
	
	private void ganadaBActionPerformed(ActionEvent evt) {
		movieList.setModel(new AbstractListModel<String>() {
			String[] strings = movieMgr.movie_selectAllTitle(false);
			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});	
	}

	private void gradeBActionPerformed(ActionEvent evt) {
		movieList.setModel(new AbstractListModel<String>() {
			String[] strings = movieMgr.movie_selectAllTitle(true);
			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
//		try {
//			System.setProperty("awt.useSystemAAFontSettings", "on");
//			System.setProperty("swing.aatext", "true");
//			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (ClassNotFoundException ex) {
//			java.util.logging.Logger.getLogger(MovieTicketingTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (InstantiationException ex) {
//			java.util.logging.Logger.getLogger(MovieTicketingTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (IllegalAccessException ex) {
//			java.util.logging.Logger.getLogger(MovieTicketingTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(MovieTicketingTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		}

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			System.setProperty("awt.useSystemAAFontSettings", "on");
			System.setProperty("swing.aatext", "true");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AdminTest().setVisible(true);
			}
		});
		OracleDBUtil.closeDB();
	}
	
	// ±ØÀå ½Ã°£ ¼±ÅÃ -> ´Þ·ÂÃ¼Å©
	public void setTheaters() {
		Calendar today = Calendar.getInstance();
		// JPanel timeBtPanel = new JPanel();
		timeBtPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		timeList = thMgr.selectOneMovieStartByName(movTitle, movDate);
		String[] keyList = timeList.keySet().toArray(new String[timeList.size()]);
		for (int i = 0; i < keyList.length; i++) {
			JLabel lbt = new JLabel();
			lbt.setVisible(true);
			lbt.setOpaque(true);
			lbt.setBackground(Color.BLACK);
			lbt.setPreferredSize(new Dimension(469, 0));
			ArrayList<String> tempList = timeList.get(keyList[i]);
			JLabel lb = new JLabel(keyList[i]);
			lb.setVisible(true);
			lb.setFont(new Font("³ª´®¹Ù¸¥½ºÄù¾î", 0, 18));
			lb.setPreferredSize(new Dimension(30, 30));
			lb.setLayout(new FlowLayout(FlowLayout.LEFT));
			timeBtPanel.add(lb);
			timeBtPanel.add(lbt);
			JLabel lbt2 = new JLabel();
			lbt2.setVisible(true);
			lbt2.setPreferredSize(new Dimension(469, 0));
			for (int j = 0; j < tempList.size(); j++) {
				int todayHourInt = today.get(Calendar.HOUR_OF_DAY) * 60 + today.get(Calendar.MINUTE);
				int movieDate = Integer.parseInt(tempList.get(j).substring(0, 2)) * 60
						+ Integer.parseInt(tempList.get(j).substring(3, 5));
				JButton btn = new JButton(tempList.get(j));
				btn.setVisible(true);
				
				if (movDate.getDay() == today.getTime().getDay() && todayHourInt >= movieDate) {
					btn.setEnabled(false);
				}
				// btn.setBorder(new EmptyBorder(0, 10, 0, 10));
				btn.setMargin(new Insets(0, 0, 0, 0)); // top left bottom right
				btn.setFont(new Font("³ª´®¹Ù¸¥°íµñ", 0, 12));
				btn.setPreferredSize(new Dimension(65, 30));
				btn.addActionListener(new ActionListener() {
					public String getKeyFromValue(LinkedHashMap<String, ArrayList<String>> map,
							ArrayList<String> value) {
						for (String key : map.keySet()) {
							if (map.get(key).equals(value)) {
								return key;
							}
						}
						return "";
					}

					@Override
					public void actionPerformed(ActionEvent e) {
						movieInfoScreenName.setText(getKeyFromValue(timeList, tempList));
						timeAddMovie();
					}

					// ½Ã°£ ´Ã¸®±â
					public void timeAddMovie() {
						MovieInfo mov = movieMgr.movie_selectOneByTitle(movTitle);
						int hour = Integer.parseInt(btn.getText().substring(0, 2));
						int min = Integer.parseInt(btn.getText().substring(3, 5));
						int movHour = (mov.getMovieTimes() / 60);
						int movMin = mov.getMovieTimes() - (movHour * 60);
						String startTime = String.format("%02d:%02d", hour, min);

						hour += movHour;
						min += movMin;
						if (min >= 60) {
							min -= 60;
							hour++;
						}
						if (hour >= 24) {
							hour -= 24;
						}
						String addTime = String.format("%02d:%02d", hour, min);
					}
				});
				timeBtPanel.add(btn);
			}
			timeBtPanel.add(lbt2);
		}
		timeBtPanel.setBackground(Color.WHITE);
		timeBtPanel.setBorder(null);
		timeBtPanel.setAlignmentX(0);
		timeBtPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));
		// timeBtPanel.setLayout(new GridLayout(5, 3, 5, 5));
		timeBtPanel.setVisible(true);
		timePanel.add(timeBtPanel);
	}
	
	public void setJlistValue(String title) {
		movieList.setSelectedValue(title, false);
	}
	
	// Variables declaration - do not modify
	private JPanel Main;
	private JLabel calSel;
	private JToggleButton ganadaB;
	private JToggleButton gradeB;
	private JButton btnAllot;
	private JLabel labelMovie;
	private JLabel lblSelMovieTime;
	private JPanel movieInfo;
	public JLabel movieInfoDayName;
	public JLabel movieInfoScreenName;
	public JList<String> movieList;
	public JScrollPane movieListSC;
	public JLabel movieInfoGrade;
	public JLabel movieInfoName;
	public JLabel movieInfoRating;
	public JLabel movieInfoScreen;
	public JLabel movieInfoDay;
	public JLabel movieInfoPoster;
	public JLabel movieInfoStar;
	public JPanel order;
	public JButton resetRe;
	public JPanel selCal;
	public JPanel allotMovie;
	public JPanel allotMovieTimeTheaters;
	public JPanel timePanel;
	private JPanel north;
	public JLabel movieTimeLabel;
	public JLabel movieTimeLabelName;
	private JPanel in;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel inTxtLb;
	private JTable table;
}