package ui.ticketing.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import ui.ticketing.MyCalendar;
import ui.ticketing.MyCalendar.listenForDateButs;

import javax.swing.JLabel;

public class InternalFrameDemo extends JFrame {
	public JDesktopPane desktop;
	public static JLabel dayLb;
	public int day;
	
	public InternalFrameDemo() {
		setBounds(0, 0, 500, 400);

		desktop = new JDesktopPane(); // a specialized layered pane
		createFrame(); // create first "window"
		setContentPane(desktop);
		toBack();
		dayLb = new JLabel("New label");
		dayLb.setBounds(48, 337, 57, 15);
		desktop.add(dayLb);
		
	}

	protected void createFrame() {
		MyCalendar frame = new MyCalendar();
		frame.setBounds(000, 000, 380, 300);
		frame.setVisible(true); // necessary as of 1.3
		BasicInternalFrameUI bi = (BasicInternalFrameUI) frame.getUI();
		frame.setBorder(null);
		bi.setNorthPane(null);
		desktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
			
		}
	}

	public static void createAndShowGUI() {

		InternalFrameDemo frame = new InternalFrameDemo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}