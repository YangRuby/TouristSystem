package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Tree.BinaryTree;

public class GuestMenu extends JFrame {
	BinaryTree BT;
	ImageIcon image;

	public GuestMenu(BinaryTree BT) {
		this.BT = BT;
		image = new ImageIcon(".//files//images//GuestMenu.jpg");
		this.setTitle("�ο���Ϣ����ϵͳ���οͰ棩");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 1000, 400);
		this.setVisible(true);
		addImage();
		addButton();
	}

	private void addImage() {
		JLabel label = new JLabel(image);
		label.setBounds(200, 0, 800, 350);
		this.add(label);
	}

	private void addButton() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 10, 10));
		JButton button1 = new JButton("�鿴����");
		JButton button2 = new JButton("�ѱ���");
		JButton button0 = new JButton("����");
		button1.setFont(new Font("���Ĳ���", Font.BOLD, 36));
		button2.setFont(new Font("���Ĳ���", Font.BOLD, 36));
		button0.setFont(new Font("��������", Font.BOLD, 36));
		panel.setPreferredSize(new Dimension(200, 0));
		panel.add(button1);
		panel.add(button2);
		panel.add(button0);
		this.getContentPane().add(panel, BorderLayout.WEST);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BT.inOrder(BT.root);
				GuestMenu.this.setVisible(false);
				new PrintSpot(BT, BT.inList);
				BT.clearList();
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuestMenu.this.setVisible(false);
				new FindTourist(BT);
			}
		});

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuestMenu.this.setVisible(false);
				new Welcome(BT);
			}
		});
	}
}