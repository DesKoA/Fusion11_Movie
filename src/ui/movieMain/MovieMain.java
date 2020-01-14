package ui.movieMain;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import data.Movie;
import data.MovieInfo;
import db.dao.MovieDBManager;
import db.util.OracleDBUtil;

import java.awt.FlowLayout;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovieMain extends JFrame {
	MovieDBManager mvDB;
	private JPanel contentPane;
	ImageIcon icon;
	ImageIcon Icon;
	JLabel lblMovie1;
	JPanel pnMovieInfo;
	JLabel lblMovieInfo;
	JPanel PotoList1;
	JPanel PotoList2;
	JPanel PotoList3;
	CardLayout cardMgr;
	int index;
	JButton btnWest;
	JButton btnEast;
	/**
	 * Launch the application.
	 */
	static ArrayList<MovieInfo> mf;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieMain frame = new MovieMain();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		OracleDBUtil.closeDB();
	}

	/**
	 * Create the frame.
	 */
	// 동적으로 구현된 공통 핸들러
	public class MovieSelectHandle extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel movMenu = (JLabel) e.getSource();
			for (int i = 0; i < mf.size(); i++) {
				JLabel mov = movieLabelList.get(i);
				//System.out.println("m"+mov);
				if (movMenu == mov) {
					MovieInfo selMovie = mf.get(i);
					//System.out.println("s"+selMovie);
					MoviePosterInfo t1 = new MoviePosterInfo(selMovie);
					t1.setVisible(true);
					t1.setSize(810, 635);

					break;
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel movMenu = (JLabel) e.getSource();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel movMenu = (JLabel) e.getSource();
		}

	}

	public static ArrayList<MovieInfo> MovieList = new ArrayList<MovieInfo>();
	ArrayList<MovieInfo> titleList;
	public static ArrayList<JLabel> movieLabelList;
	//
	ArrayList<MovieInfo> postList = new ArrayList<>();

	MovieMain movMain;

	private ImageIcon[] imgIconList;

	public MovieMain() {
		OracleDBUtil.connectDB();
		this.movMain = movMain;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 1000, 600);
		// TODO 포커스를 받을수 있게 설정
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		icon = new ImageIcon("./image/메인배경.jpeg");
		setTitle("\uB098\uBA3C\uC800\uC608\uB9E4 ver-2.00");
		JPanel pnBackground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), null);
				setOpaque(false); // 그림을 표시하세 설정, 투명하게 조절
				super.paintComponent(g);
			}
		};
		contentPane.add(pnBackground, BorderLayout.CENTER);
		pnBackground.setLayout(new BorderLayout(0, 0));
		
		// prepareDummyMovieList();
		mvDB = new MovieDBManager();
		titleList = mvDB.movieTitle_selectAll();
		this.movieLabelList = new ArrayList<JLabel>();

		JPanel pnNorth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnNorth.getLayout();
		flowLayout.setVgap(55);
		pnNorth.setOpaque(false);
		pnBackground.add(pnNorth, BorderLayout.NORTH);

		JPanel pnSouth = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnSouth.getLayout();
		flowLayout_1.setVgap(71);
		pnSouth.setOpaque(false);
		pnBackground.add(pnSouth, BorderLayout.SOUTH);

		JPanel pnWest = new JPanel();
		FlowLayout fl_pnWest = (FlowLayout) pnWest.getLayout();
		fl_pnWest.setHgap(54);
		pnWest.setOpaque(false);
		pnBackground.add(pnWest, BorderLayout.WEST);

		JPanel pnEast = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnEast.getLayout();
		flowLayout_2.setHgap(54);
		pnEast.setOpaque(false);
		pnBackground.add(pnEast, BorderLayout.EAST);
		// 영화 정보 화면
		JPanel pnMovieList = new JPanel();
		pnMovieList.setOpaque(false);
		pnBackground.add(pnMovieList, BorderLayout.CENTER);
		pnMovieList.setLayout(new BorderLayout(0, 0));
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int code = e.getKeyCode();
				switch (code) {
				case KeyEvent.VK_LEFT:
						cardMgr.previous(pnMovieInfo);
					break;
					
				case KeyEvent.VK_RIGHT:
						cardMgr.next(pnMovieInfo);
					break;	
				default:
					break;
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		pnMovieList.add(panel, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		pnMovieList.add(panel_1, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		pnMovieList.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_2.add(panel_5, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		panel_5.add(lblNewLabel);
		//
		btnWest = new JButton("\u25C0");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardMgr.previous(pnMovieInfo);

			}
		});
		btnWest.setBorderPainted(true); // 버튼 외각선을 없애준다.
		btnWest.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnWest.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		panel_5.add(btnWest);
		//
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		panel_2.add(panel_6, BorderLayout.EAST);
		//
		btnEast = new JButton("\u25B6");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnEast) {
					cardMgr.next(pnMovieInfo);

				}
			}
		});
		btnEast.setBorderPainted(true); // 버튼 외각선을 없애준다.
		btnEast.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnEast.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		panel_6.add(btnEast);
		//
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		panel_6.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		pnMovieList.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_3.add(panel_7, BorderLayout.WEST);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		panel_7.add(lblNewLabel_2);
		//
		JButton btnMyPage = new JButton("MyPage");
		btnMyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "MyPage로 이동합니다");
			}
		});
		btnMyPage.setBorderPainted(true); // 버튼 외각선을 없애준다.
		btnMyPage.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnMyPage.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용안함
		panel_7.add(btnMyPage);
		//
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(pnMovieInfo, "Logout 하시겠습니까?", "이용해 주셔서 감사합니다.",
						JOptionPane.OK_CANCEL_OPTION, 1);

				if (result == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.CANCEL_OPTION) {
					// JOptionPane.showMessageDialog(pnMovieInfo, "취소하였습니다");
				}
			}
		});
		panel_7.add(btnLogout);
		btnLogout.setBorderPainted(true); // 버튼 외각선을 없애준다.
		btnLogout.setContentAreaFilled(true); // 내용영역 채우기 않함
		btnLogout.setFocusPainted(false);
		//

		//
		PotoList1 = new JPanel();

		PotoList2 = new JPanel();
		
		PotoList3 = new JPanel();

		pnMovieInfo = new JPanel();
		
		//
		pnMovieList.add(pnMovieInfo);
		cardMgr = new CardLayout(0, 0);

		pnMovieInfo.setLayout(cardMgr);
		pnMovieInfo.add("A", PotoList1);
		PotoList1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
			//ImageIcon Oicon = new ImageIcon(mf.get(0));
//			Image img = Oicon.getImage();
//			Image cimg = img.getScaledInstance(186, 234, Image.SCALE_SMOOTH);
//			ImageIcon icon = new ImageIcon(cimg);
		//}
		
		JLabel lblNewLabel_3 = new JLabel();
		PotoList1.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		PotoList1.add(label);
		
		JLabel label_1 = new JLabel("");
		PotoList1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		PotoList1.add(label_2);

		JLabel lblNewLabel_4 = new JLabel();
		PotoList1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel();
		PotoList1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel();
		PotoList1.add(lblNewLabel_6);
		
		//
		pnMovieInfo.add("B", PotoList2);
		PotoList2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel();
		PotoList2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel();
		PotoList2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel();
		PotoList2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel();
		PotoList2.add(lblNewLabel_10);
		//
		pnMovieInfo.add("C", PotoList3);
		PotoList3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel();
		PotoList3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel();
		PotoList3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel();
		PotoList3.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel();
		PotoList3.add(lblNewLabel_14);
		//
		JLabel l[] = {lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6,lblNewLabel_7,
				lblNewLabel_8,lblNewLabel_9,lblNewLabel_10,lblNewLabel_11,lblNewLabel_12,lblNewLabel_13,lblNewLabel_14};
		JPanel potoPanels[] = { PotoList1, PotoList2, PotoList3 };
		MovieSelectHandle movSelectHandle = new MovieSelectHandle();
		int index1 = 4;
		mf = mvDB.movieTitle_selectAll();
		for (int i = 0; i < mf.size(); i++) {
			if (i < 4) {
				//System.out.println("1번 카드"+i);
					String strURL = mf.get(i).getMoviePoster();
					URL url;
					try {
						url = new URL(strURL);
						Image image = ImageIO.read(url);
						Image changedImg = image.getScaledInstance(186, 234, Image.SCALE_SMOOTH);
						Icon = new ImageIcon(changedImg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					l[i] = new JLabel(Icon);
					l[i].setToolTipText("영화 클릭시 예매 및 상세보기");
					potoPanels[0].add(l[i]);
				//
				movieLabelList.add(l[i]);
				//
				l[i].addMouseListener(movSelectHandle);
				} else if (i < 8) {
						//System.out.println("1번 카드"+i);
							String strURL = mf.get(i).getMoviePoster();
							URL url;
							try {
								url = new URL(strURL);
								Image image = ImageIO.read(url);
								Image changedImg = image.getScaledInstance(186, 234, Image.SCALE_SMOOTH);
								Icon = new ImageIcon(changedImg);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							l[i] = new JLabel(Icon);
							l[i].setToolTipText("영화 클릭시 예매 및 상세보기");
							potoPanels[1].add(l[i]);
						//
						movieLabelList.add(l[i]);
						//
						l[i].addMouseListener(movSelectHandle);
				} else if (i < 12) {
					String strURL = mf.get(i).getMoviePoster();
					URL url;
					try {
						url = new URL(strURL);
						Image image = ImageIO.read(url);
						Image changedImg = image.getScaledInstance(186, 234, Image.SCALE_SMOOTH);
						Icon = new ImageIcon(changedImg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					l[i] = new JLabel(Icon);
					l[i].setToolTipText("영화 클릭시 예매 및 상세보기");
					potoPanels[2].add(l[i]);
				//
				movieLabelList.add(l[i]);
				//
				l[i].addMouseListener(movSelectHandle);
				}
			}
	}
}
