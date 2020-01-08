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

	// ������ ����Ʈ
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
	// �������� ������ ���� �ڵ鷯
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
					// System.out.println((i + 1) + "�� Movie ����: " + mov.getText());
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
//	//������ ����Ʈ �ʱ�ȭ
//	public void initPosterList() {
//		posterList = new ArrayList<Poster>();
//		//int selRow = ���콺��ư�̸�.getSelectedRow(); // ���콺 ���õ� ��ȣ
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

//		final String[] movNames1 = { "�ܿ�ձ�2", "��λ�", "�길��", "ũ��" };
//		final String[] movNames2 = { "�õ�", "�ǵ���", "�е���", "��" };
//		final String[] movNames3 = { "����", "����", "�˶��", "�ؿ��" };
//		final String[] movInfo1 = { "�ܿ�ձ�2", "��λ�", "�길��", "ũ��" };
//		final String[] movInfo2 = { "�õ�", "�ǵ���", "�е���", "��" };
//		final String[] movInfo3 = { "����", "����", "�˶��", "�ؿ��" };
		final String[] movNames = { "�ܿ�ձ�2", "��λ�", "�길��", "ũ��","�õ�", "�ǵ���", "�е���", "��","����", "����", "�˶��", "�ؿ��"};
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

		icon = new ImageIcon("./image/���ι��.jpeg");
		setTitle("\uB098\uBA3C\uC800\uC608\uB9E4 ver-2.00");
		JPanel pnBackground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), null);
				setOpaque(false); // �׸��� ǥ���ϼ� ����, �����ϰ� ����
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
		// ��ȭ ���� ȭ��
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
		btnWest.setBorderPainted(true); // ��ư �ܰ����� �����ش�.
		btnWest.setContentAreaFilled(true); // ���뿵�� ä��� ����
		btnWest.setFocusPainted(false); // ���� �Ǿ����� ����� �׵θ� ������
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
		btnEast.setBorderPainted(true); // ��ư �ܰ����� �����ش�.
		btnEast.setContentAreaFilled(true); // ���뿵�� ä��� ����
		btnEast.setFocusPainted(false); // ���� �Ǿ����� ����� �׵θ� ������
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
				JOptionPane.showMessageDialog(contentPane, "MyPage�� �̵��մϴ�");
			}
		});
		btnMyPage.setBorderPainted(true); // ��ư �ܰ����� �����ش�.
		btnMyPage.setContentAreaFilled(true); // ���뿵�� ä��� ����
		btnMyPage.setFocusPainted(false); // ���� �Ǿ����� ����� �׵θ� ������
		panel_7.add(btnMyPage);
		//
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(pnMovieInfo, "Logout �Ͻðڽ��ϱ�?", "�̿��� �ּż� �����մϴ�.",
						JOptionPane.OK_CANCEL_OPTION, 1);

				if (result == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.CANCEL_OPTION) {
					// JOptionPane.showMessageDialog(pnMovieInfo, "����Ͽ����ϴ�");
				}
			}
		});
		panel_7.add(btnLogout);
		btnLogout.setBorderPainted(true); // ��ư �ܰ����� �����ش�.
		btnLogout.setContentAreaFilled(true); // ���뿵�� ä��� ����
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
//			ImageIcon icon = new ImageIcon("./image/poster/�ܿ�ձ�2.jpg");
//	        Image img = icon.getImage();
//			public void paintComponent(Graphics g) {
//				g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
//				setOpaque(false); // �׸��� ǥ���ϼ� ����, �����ϰ� ����
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
				//System.out.println("1�� ī��"+i);
				lblMovieInfo = new JLabel() {

					ImageIcon icon = new ImageIcon(imagePaths[0] + mov.getImgPath());
					Image img = icon.getImage();

					public void paintComponent(Graphics g) {
						g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
						setOpaque(false); // �׸��� ǥ���ϼ� ����, �����ϰ� ����
						super.paintComponent(g);
					}
				};
				lblMovieInfo.setToolTipText("��ȭ Ŭ���� ���� �� �󼼺���");
				potoPanels[0].add(lblMovieInfo);
				//
				movieLabelList.add(lblMovieInfo);
				//
				lblMovieInfo.addMouseListener(movSelectHandle);
			} else if (i < index2) {
				//System.out.println("2�� ī��"+i);
				lblMovieInfo = new JLabel() {

					ImageIcon icon = new ImageIcon(imagePaths[1] + mov.getImgPath());
					Image img = icon.getImage();

					public void paintComponent(Graphics g) {
						g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
						setOpaque(false); // �׸��� ǥ���ϼ� ����, �����ϰ� ����
						super.paintComponent(g);
					}
				};
				lblMovieInfo.setToolTipText("��ȭ Ŭ���� ���� �� �󼼺���");
				potoPanels[1].add(lblMovieInfo);
				//
				movieLabelList.add(lblMovieInfo);
				//
				lblMovieInfo.addMouseListener(movSelectHandle);
			} else if (i < index3) {
				//System.out.println("3�� ī��"+i);
				lblMovieInfo = new JLabel() {

					ImageIcon icon = new ImageIcon(imagePaths[2] + mov.getImgPath());
					Image img = icon.getImage();

					public void paintComponent(Graphics g) {
						g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
						setOpaque(false); // �׸��� ǥ���ϼ� ����, �����ϰ� ����
						super.paintComponent(g);
					}
				};
				lblMovieInfo.setToolTipText("��ȭ Ŭ���� ���� �� �󼼺���");
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
//					setOpaque(false); // �׸��� ǥ���ϼ� ����, �����ϰ� ����
//					super.paintComponent(g);
//				}
//			};
//			
//			lblMovieInfo.setToolTipText("��ȭ Ŭ���� ���� �� �󼼺���");
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
//					setOpaque(false); // �׸��� ǥ���ϼ� ����, �����ϰ� ����
//					super.paintComponent(g);
//				}
//			};
//			
//			lblMovieInfo.setToolTipText("��ȭ Ŭ���� ���� �� �󼼺���");
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
