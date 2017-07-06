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

public class AdminMenu extends JFrame {
	BinaryTree BT;
	ImageIcon image;

	public AdminMenu(BinaryTree BT) {
		this.BT = BT;
		image = new ImageIcon(".//files//images//AdminMenu.jpg");
		this.setTitle("�ο���Ϣ����ϵͳ������Ա�棩");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 1000, 600);
		this.setVisible(true);
		addImage();
		addButton();
	}

	private void addImage() {
		JLabel label = new JLabel(image);
		label.setBounds(200, 0, 800, 550);
		this.add(label);
	}

	private void addButton() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1, 10, 10));
		JButton button1 = new JButton("��Ӿ���");
		JButton button2 = new JButton("ɾ������");
		JButton button3 = new JButton("�޸ľ���");
		JButton button4 = new JButton("�鿴����");
		JButton button0 = new JButton("����");
		button1.setFont(new Font("���Ĳ���", Font.BOLD, 36));
		button2.setFont(new Font("���Ĳ���", Font.BOLD, 36));
		button3.setFont(new Font("���Ĳ���", Font.BOLD, 36));
		button4.setFont(new Font("���Ĳ���", Font.BOLD, 36));
		button0.setFont(new Font("��������", Font.BOLD, 36));
		panel.setPreferredSize(new Dimension(200, 0));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button0);
		this.getContentPane().add(panel, BorderLayout.WEST);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMenu.this.setVisible(false);
				new AddSpot(BT);
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMenu.this.setVisible(false);
				new DeleteSpot(BT);
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMenu.this.setVisible(false);
				new SetSpot(BT);
			}
		});

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMenu.this.setVisible(false);
				new CheckSpot(BT);
			}
		});

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMenu.this.setVisible(false);
				new Welcome(BT);
			}
		});
	}
}