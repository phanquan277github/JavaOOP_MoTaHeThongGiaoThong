package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.text.AttributedCharacterIterator;
import java.util.Iterator;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import model.TrafficLightModel;

public class TrafficLightView extends JFrame{
	private TrafficLightModel tflModel;
	private JLabel label11;
	private JLabel label21;
	private JLabel label12;
	private JLabel label22;
	
	private JLabel lbTime11;
	private JLabel lbTime12;
	private JLabel lbTime21;
	private JLabel lbTime22;

	public TrafficLightView() {
		this.tflModel = new TrafficLightModel();
		TrafficThread th = new TrafficThread();
		th.start();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Mô phỏng đèn giao thông ngã tư");
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon imgBackGround = new ImageIcon(
				new ImageIcon("src/image/backGroundVip.jpg").getImage()
						.getScaledInstance(1000, 20000, Image.SCALE_SMOOTH));
		JPanel mainPanel = new JPanel() {
			@Override
			protected void paintComponent(java.awt.Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgBackGround.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			};
		};
		
		label11 = new JLabel();
		label12 = new JLabel();
		label21 = new JLabel();
		label22 = new JLabel();
		
		label11.setBounds(260, 220, 70, 50);
		label21.setBounds(450, 195, 50, 70);
		label12.setBounds(290, 360, 50, 70);
		label22.setBounds(450, 360, 70, 50);

		
		lbTime11 = new JLabel();
		lbTime11.setForeground(Color.red);
		
		lbTime12 = new JLabel();
		lbTime21 = new JLabel();
		lbTime22 = new JLabel();
		
		lbTime11.setBounds(0, 0, 20, 20);
		lbTime22.setBounds(0, 20, 10, 10);
		
		
		
		mainPanel.add(lbTime11);
	
		mainPanel.add(label11);
		mainPanel.add(label21);
		mainPanel.add(label12);
		mainPanel.add(label22);
		mainPanel.setLayout(null);
		this.dialog();
		this.add(mainPanel);
	}

	
	
	private void thoiGian(int time,JLabel lbtime) {
		for(int i=time; i>=0; i-- ) {
			lbtime.setText(i+"");
		}
	}
	
	
	class TrafficThread extends Thread {
		@Override
		public void run() {
			// Đọc hình ảnh dưới dạng BufferedImage
			BufferedImage imgRedHor = null;
			BufferedImage imgGreenHor = null;
			BufferedImage imgYellowHor = null;
			BufferedImage imgRedVer = null;
			BufferedImage imgGreenVer = null;
			BufferedImage imgYellowVer = null;
			try {
				imgRedHor = ImageIO.read(new File("src/image/redLightHor.png"));
				imgGreenHor = ImageIO.read(new File("src/image/greenLightHor.png"));
				imgYellowHor = ImageIO.read(new File("src/image/yellowLightHor.png"));
				imgRedVer = ImageIO.read(new File("src/image/redLightVer.png"));
				imgGreenVer = ImageIO.read(new File("src/image/greenLightVer.png"));
				imgYellowVer = ImageIO.read(new File("src/image/yellowLightVer.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Thay đổi kích thước của BufferedImage
			Image dimgRedHor = imgRedHor.getScaledInstance(70, 40, Image.SCALE_SMOOTH);
			Image dimgGreenHor = imgGreenHor.getScaledInstance(70, 40, Image.SCALE_SMOOTH);
			Image dimgYellowHor = imgYellowHor.getScaledInstance(70, 40, Image.SCALE_SMOOTH);
			Image dimgRedVer = imgRedVer.getScaledInstance(40, 70, Image.SCALE_SMOOTH);
			Image dimgGreenVer = imgGreenVer.getScaledInstance(40, 70, Image.SCALE_SMOOTH);
			Image dimgYellowVer = imgYellowVer.getScaledInstance(40, 70, Image.SCALE_SMOOTH);

			// Tạo icon
			ImageIcon imgIconRedHor = new ImageIcon(dimgRedHor);
			ImageIcon imgIconGreenHor = new ImageIcon(dimgGreenHor);
			ImageIcon imgIconYellowHor = new ImageIcon(dimgYellowHor);
			ImageIcon imgIconRedVer = new ImageIcon(dimgRedVer);
			ImageIcon imgIconGreenVer = new ImageIcon(dimgGreenVer);
			ImageIcon imgIconYellowVer = new ImageIcon(dimgYellowVer);

			
			int i = tflModel.getTimeRed() + tflModel.getTimeGreen() + tflModel.getTimeYellow();
			while(true) {
				i--;
				try {
					sleep(1000);// moi lan thuc hien vong lap se ngu 1s
				} catch (InterruptedException ex) {
				}
				
//				lbTime11.setText(i+"");
				if (i < tflModel.getTimeRed() + tflModel.getTimeGreen() + tflModel.getTimeYellow()) {
					label11.setIcon(imgIconRedHor);
					label22.setIcon(imgIconRedHor);
					if (i > tflModel.getTimeRed() + tflModel.getTimeYellow()) {
						label21.setIcon(imgIconGreenVer);
						label12.setIcon(imgIconGreenVer);
					} else if (i > tflModel.getTimeRed()) {
						label21.setIcon(imgIconYellowVer);
						label12.setIcon(imgIconYellowVer);
					}
				}
				if (i < tflModel.getTimeGreen() + tflModel.getTimeYellow()) {
					label11.setIcon(imgIconGreenHor);
					label21.setIcon(imgIconRedVer);

					label22.setIcon(imgIconGreenHor);
					label12.setIcon(imgIconRedVer);
				}
				if (i < tflModel.getTimeYellow()) {
					label11.setIcon(imgIconYellowHor);
					label21.setIcon(imgIconRedVer);

					label22.setIcon(imgIconYellowHor);
					label12.setIcon(imgIconRedVer);
				}
				//reset giá trị i
				if (i == 0) {
					i = tflModel.getTimeRed() + tflModel.getTimeGreen() + tflModel.getTimeYellow();
				}
			}
						
		}
	}
	
	private void dialog() {
		JDialog dialog = new JDialog(this, "Manager");
		JTextField txtR = new JTextField("Đỏ");
		JTextField txtG = new JTextField("Xanh");
		JTextField txtY = new JTextField("Vàng");
		JButton bt = new JButton("OK");
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tflModel.setTimeRed(Integer.parseInt(txtR.getText() + ""));
				tflModel.setTimeGreen(Integer.parseInt(txtG.getText() + ""));
				tflModel.setTimeYellow(Integer.parseInt(txtY.getText() + ""));
				JOptionPane.showMessageDialog(null, "Đã thay đổi thời gian của đèn");
			}
		});

		dialog.add(txtR);
		dialog.add(txtG);
		dialog.add(txtY);
		dialog.add(bt);
		dialog.setSize(100, 100);
		dialog.setLayout(new GridLayout(4, 1));
		dialog.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TrafficLightView();
	}
}
