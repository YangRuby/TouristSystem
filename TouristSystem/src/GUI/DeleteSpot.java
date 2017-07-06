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

public class DeleteSpot extends JFrame {
	private JTextField textBox;
	BinaryTree BT;

	public DeleteSpot(BinaryTree BT) {
		this.BT = BT;
		this.setTitle("删除景点");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 400, 200);
		this.setVisible(true);
		addLabel();
		addButton();
	}

	private void addLabel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel label1 = new JLabel("景点编号");
		label1.setFont(new Font("宋体", Font.BOLD, 32));
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
		JButton button1 = new JButton("删除");
		JButton button0 = new JButton("返回");
		button1.setFont(new Font("宋体", Font.BOLD, 20));
		button0.setFont(new Font("宋体", Font.BOLD, 20));
		panel.add(button1);
		panel.add(button0);
		panel.setPreferredSize(new Dimension(0, 50));
		this.getContentPane().add(panel, "South");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNode node = BT.findNodeByNum(BT.root, textBox.getText());
				if (node == null) {
					new Message("请输入正确的景点编号！");
				} else {
					BT.deleteNode(node);
					BT.preOrder(BT.root);
					BT.inOrder(BT.root);
					DeleteSpot.this.setVisible(false);
					new PrintWindow(BT, BT.preList, BT.inList);
					BT.clearList();
				}
			}
		});

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteSpot.this.setVisible(false);
				new AdminMenu(BT);
			}
		});
	}
}