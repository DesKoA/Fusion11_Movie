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

import data.Movie;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieMain extends JFrame {

	// 포스터 리스트
//	ArrayList<Poster> posterList = null;

	private JPanel contentPane;
	ImageIcon icon;
	JLabel lblMovie1;
	JPanel pnMovieInfo;
	JLabel lblMovieInfo;
	JPanel PotoList1;
	JPanel PotoList2;
	JPanel PotoList3;
	CardLayout cardMgr;
//	File folder;
	int index;
	JButton btnWest;
	JButton btnEast;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieMain frame = new MovieMain();
					frame.setVisible(true);
					OracleDBUtil.connectDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// 동적으로 구현된 공통 핸들러
	public class MovieSelectHandle extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel movMenu = (JLabel) e.getSource();

			for (int i = 0; i < movieLabelList.size(); i++) {
				// JLabel mov = movieLabelList.get(i);
				JLabel mov = movieLabelList.get(i);
				//System.out.println(mov);
				if (movMenu == mov) {
					Movie selMovie = MovieList.get(i);
					//System.out.println(selMovie);
					// System.out.println((i + 1) + "번 Movie 선택: " + mov.getText());
					Test t1 = new Test(selMovie);
					t1.setVisible(true);
					t1.setSize(810, 635);

					break;
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel movMenu = (JLabel) e.getSource();
//			movMenu.setBackground(Color.CYAN);
//			super.mouseEntered(e);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel movMenu = (JLabel) e.getSource();
//			movMenu.setBackground(Color.YELLOW);
//			super.mouseExited(e);
		}

	}

	public static ArrayList<Movie> MovieList = new ArrayList<>();
	public static ArrayList<JLabel> movieLabelList;
	//
//	//포스터 리스트 초기화
//	public void initPosterList() {
//		posterList = new ArrayList<Poster>();
//		//int selRow = 마우스버튼이름.getSelectedRow(); // 마우스 선택된 번호
//		Poster poster = new Poster();
//		poster.setFile("./image/poster1/");
//		posterList.add(poster);
//		
//		poster = new Poster();
//		poster.setFile("./image/poster2/");
//		posterList.add(poster);
//		
//		poster = new Poster();
//		poster.setFile("./image/poster3/");
//		posterList.add(poster);
//	}
	//
	ArrayList<Movie> postList = new ArrayList<>();
	
	
	public void prepareDummyMovieList() {

//		final String[] movNames1 = { "겨울왕국2", "백두산", "쥬만지", "크롤" };
//		final String[] movNames2 = { "시동", "판도라", "패딩턴", "폐교" };
//		final String[] movNames3 = { "버닝", "사자", "알라딘", "해운대" };
//		final String[] movInfo1 = { "겨울왕국2", "백두산", "쥬만지", "크롤" };
//		final String[] movInfo2 = { "시동", "판도라", "패딩턴", "폐교" };
//		final String[] movInfo3 = { "버닝", "사자", "알라딘", "해운대" };
		final String[] movNames = { "겨울왕국2", "백두산", "쥬만지", "크롤","시동", "판도라", "패딩턴", "폐교","버닝", "사자", "알라딘", "해운대"};
		//final String[][] movs = { movNames1, movNames2, movNames3 };

		//for (int j = 0; j < movs.length; j++) {
			//System.out.println("mov"+j);
			//String[] movNames = movs[j];
			//for (int i = 0; i < movNames.length; i++) {
				for (int i = 0; i < movNames.length; i++) {
				//System.out.println("movNames"+ i);
				// if(index == 0) {
				Movie movie = new Movie(i + 1, movNames[i], movNames[i] + ".jpg", movNames[i]);
				//System.out.println(movie1);
				MovieList.add(movie);
				// postList.add(movie1);
				// Movie movie2 = new Movie(i + 1, movNames2[i], movNames2[i] + ".jpg",
				// movNames2[i]);
				// postList.add(movie2);
				// Movie movie3 = new Movie(i + 1, movNames3[i], movNames3[i] + ".jpg",
				// movNames3[i]);
				// postList.add(movie3);
				// } else if (index == 1) {
				// Movie movie2 = new Movie(i + 1, movNames2[i], movNames2[i] + ".jpg",
				// movNames2[i]);
				// MovieList.add(movie2);
				// } else if (index == 2) {
				// Movie movie3 = new Movie(i + 1, movNames3[i], movNames3[i] + ".jpg",
				// movNames3[i]);
				// MovieList.add(movie3);
				// }
			}
		//}
	}

	MovieMain movMain;

	private ImageIcon[] imgIconList;

	public MovieMain() {
		this.movMain = movMain;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 1000, 600);
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

		prepareDummyMovieList();
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
		PotoList1.setLayout(new GridLayout(0, 4, 0, 0));

		PotoList2 = new JPanel();
		PotoList2.setLayout(new GridLayout(0, 4, 0, 0));
		PotoList3 = new JPanel();

		PotoList3.setLayout(new GridLayout(0, 4, 0, 0));

		pnMovieInfo = new JPanel();

//		for (int i = 0; i < posterList.size(); i++) {
//			Poster p = posterList.get(i);
//			//folder = new File(p.File);
//			BufferedImage img;
//			try {
//				img = ImageIO.read(new File(p.getFile()));
//				Image dimg = img.getScaledInstance(280, 380, Image.SCALE_SMOOTH);
//				ImageIcon imageIcon = new ImageIcon(dimg);
//				JLabel l = new JLabel(imageIcon);
//				pnMovieInfo.add(l, "CARD_" + (i+1));
//			} catch (IOException e1) {
//				
//				e1.printStackTrace();
//			}
//		}
		//
//		for (Movie pos : postList) {
//			MovieList.add(pos);
//		}
		//
		pnMovieList.add(pnMovieInfo, BorderLayout.CENTER);
		cardMgr = new CardLayout(0, 0);

		pnMovieInfo.setLayout(cardMgr);
		pnMovieInfo.add("A", PotoList1);
		pnMovieInfo.add("B", PotoList2);
		pnMovieInfo.add("C", PotoList3);
		//

		//

//		ArrayList<Movie> movList = MovieMain.MovieList;
//		for (int i = 0; i < movList.size(); i++) {
//			Movie mov = movList.get(i);
//			pnMovieInfo.add(String.valueOf("mov"+mov.getId()),PotoList1);
//		}
//		
//		//pnMovieInfo.setLayout(new GridLayout(0, 4, 0, 0));

//		lblMovie1 = new JLabel() {
//			ImageIcon icon = new ImageIcon("./image/poster/겨울왕국2.jpg");
//	        Image img = icon.getImage();
//			public void paintComponent(Graphics g) {
//				g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
//				setOpaque(false); // 그림을 표시하세 설정, 투명하게 조절
//				super.paintComponent(g);
//			}
//		};
//		lblMovie1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				System.out.println(MovieList.get(0));
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//			}
//		});
//		pnMovieInfo.add(lblMovie1);
//		movieLabelList.add(lblMovie1);
		//
		String imagePaths[] = { "./image/poster1/", "./image/poster2/", "./image/poster3/" };
		JPanel potoPanels[] = { PotoList1, PotoList2, PotoList3 };
		MovieSelectHandle movSelectHandle = new MovieSelectHandle();
		int index1 = 4;
		int index2 = 8;
		int index3 = 12;
		//
		for (int i = 0; i < MovieList.size(); i++) {
			Movie mov = MovieList.get(i);
			//System.out.println("mov"+mov);
			if (i < index1) {
				//System.out.println("1번 카드"+i);
				lblMovieInfo = new JLabel() {

					ImageIcon icon = new ImageIcon(imagePaths[0] + mov.getImgPath());
					Image img = icon.getImage();

					public void paintComponent(Graphics g) {
						g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
						setOpaque(false); // 그림을 표시하세 설정, 투명하게 조절
						super.paintComponent(g);
					}
				};
				lblMovieInfo.setToolTipText("영화 클릭시 예매 및 상세보기");
				potoPanels[0].add(lblMovieInfo);
				//
				movieLabelList.add(lblMovieInfo);
				//
				lblMovieInfo.addMouseListener(movSelectHandle);
			} else if (i < index2) {
				//System.out.println("2번 카드"+i);
				lblMovieInfo = new JLabel() {

					ImageIcon icon = new ImageIcon(imagePaths[1] + mov.getImgPath());
					Image img = icon.getImage();

					public void paintComponent(Graphics g) {
						g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
						setOpaque(false); // 그림을 표시하세 설정, 투명하게 조절
						super.paintComponent(g);
					}
				};
				lblMovieInfo.setToolTipText("영화 클릭시 예매 및 상세보기");
				potoPanels[1].add(lblMovieInfo);
				//
				movieLabelList.add(lblMovieInfo);
				//
				lblMovieInfo.addMouseListener(movSelectHandle);
			} else if (i < index3) {
				//System.out.println("3번 카드"+i);
				lblMovieInfo = new JLabel() {

					ImageIcon icon = new ImageIcon(imagePaths[2] + mov.getImgPath());
					Image img = icon.getImage();

					public void paintComponent(Graphics g) {
						g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
						setOpaque(false); // 그림을 표시하세 설정, 투명하게 조절
						super.paintComponent(g);
					}
				};
				lblMovieInfo.setToolTipText("영화 클릭시 예매 및 상세보기");
				potoPanels[2].add(lblMovieInfo);
				//
				movieLabelList.add(lblMovieInfo);
				//
				lblMovieInfo.addMouseListener(movSelectHandle);
			}
		}
		//
//		for (int i = 0; i < MovieList.size(); i++) {
//			
//			Movie mov = MovieList.get(i);
//			lblMovieInfo = new JLabel() {
//				
//				//String Path[] = {"./image/poster1/","./image/poster2/","./image/poster3/"};
//				ImageIcon icon = new ImageIcon("./image/poster2/" + mov.getImgPath());
//				
//				Image img = icon.getImage();
//				
//				public void paintComponent(Graphics g) {
//					g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
//					setOpaque(false); // 그림을 표시하세 설정, 투명하게 조절
//					super.paintComponent(g);
//				}
//			};
//			
//			lblMovieInfo.setToolTipText("영화 클릭시 예매 및 상세보기");
//			PotoList2.add(lblMovieInfo);
//			//
//			movieLabelList.add(lblMovieInfo);
//			//
//			lblMovieInfo.addMouseListener(movSelectHandle);
//		}
//		//
//		for (int i = 0; i < MovieList.size(); i++) {
//			
//			Movie mov = MovieList.get(i);
//			
//			lblMovieInfo = new JLabel() {
//				//String Path[] = {"./image/poster1/","./image/poster2/","./image/poster3/"};
//				ImageIcon icon = new ImageIcon("./image/poster3/" + mov.getImgPath());
//				
//				Image img = icon.getImage();
//				
//				public void paintComponent(Graphics g) {
//					g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
//					setOpaque(false); // 그림을 표시하세 설정, 투명하게 조절
//					super.paintComponent(g);
//				}
//			};
//			
//			lblMovieInfo.setToolTipText("영화 클릭시 예매 및 상세보기");
//			PotoList3.add(lblMovieInfo);
//			//
//			movieLabelList.add(lblMovieInfo);
//			//
//			lblMovieInfo.addMouseListener(movSelectHandle);
//		}
		// cardMgr.show(pnMovieInfo, "A");
		// cardMgr.first(parent);

	}
// class Poster {
//	 String File;
//	 String content;
//	 
//	 public String getFile() {
//		 return File;
//	 }
//	 
//	 public void setFile(String File) {
//		 
//	 }
//	 
//	 public String getConrent() {
//		 return content;
//	 }
//	 
//	 public void setContent() {
//		 this.content = content;
//	 }
// }
}
