package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Tree.BTNode;
import Tree.BinaryTree;

public class DeleteTourist extends JFrame {
	JTextField textBox;
	BinaryTree BT;
	BTNode node;

	public DeleteTourist(BinaryTree BT, BTNode node) {
		this.BT = BT;
		this.node = node;
		this.setTitle("ȡ������");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 400, 200);
		this.setVisible(true);
		addLabel();
		addButton();
	}

	private void addLabel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel label1 = new JLabel("�οͺ�");
		label1.setFont(new Font("����", Font.BOLD, 32));
		label1.setHorizontalAlignment(JLabel.CENTER);
		textBox = new JTextField();
		panel.add(label1);
		panel.add(textBox);
		panel.setPreferredSize(new Dimension(0, 50));
		this.getContentPane().add(panel, "North");
	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton("ɾ��");
		JButton button0 = new JButton("����");
		button1.setFont(new Font("����", Font.BOLD, 20));
		button0.setFont(new Font("����", Font.BOLD, 20));
		panel.add(button1);
		panel.add(button0);
		panel.setPreferredSize(new Dimension(0, 50));
		this.getContentPane().add(panel, "South");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				node.deleteLink(textBox.getText());
				if (node.i == 0) {
					DeleteTourist.this.setVisible(false);
					new GuestMenu(BT);
					new Message("ȡ���ɹ���");
				} else {
					new Message("�þ���û�д��οͣ�ȡ��ʧ�ܣ�");
					node.i = 1;
				}
			}
		});

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BT.inOrder(BT.root);
				DeleteTourist.this.setVisible(false);
				new PrintSpot(BT, BT.inList);
				BT.clearList();
			}
		});
	}
}