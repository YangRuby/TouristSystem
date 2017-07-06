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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Tree.BinaryTree;

public class Welcome extends JFrame {
	BinaryTree BT;
	ImageIcon image;

	public Welcome(BinaryTree BT) {
		this.BT = BT;
		image = new ImageIcon(".//files//images//Welcome.jpg");
		this.setTitle("�ο���Ϣ����ϵͳ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 900, 750);
		this.setVisible(true);
		addImage();
		addButton();
	}

	private void addImage() {
		JLabel label = new JLabel(image);
		label.setBounds(0, 0, 900, 600);
		this.add(label);
	}

	private void addButton() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		JButton button1 = new JButton("���ǹ���Ա");
		JButton button2 = new JButton("�����ο�");
		JButton button3 = new JButton("�˳�ϵͳ");
		button1.setFont(new Font("���Ĳ���", Font.BOLD, 42));
		button2.setFont(new Font("���Ĳ���", Font.BOLD, 42));
		button3.setFont(new Font("��������", Font.BOLD, 42));
		panel.setPreferredSize(new Dimension(0, 100));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		this.getContentPane().add(panel, BorderLayout.SOUTH);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Welcome.this.setVisible(false);
				new AdminMenu(BT);
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Welcome.this.setVisible(false);
				new GuestMenu(BT);
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ��", "��ܰ��ʾ", JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					System.exit(0);
				}
			}
		});
	}

	public static void main(String[] args) {
		BinaryTree BT = new BinaryTree();
		BT.root = BT.creatTree();
		new Welcome(BT);
	}
}