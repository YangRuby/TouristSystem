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

import Tree.BTNode;
import Tree.BinaryTree;

public class PrintNode extends JFrame {
	BinaryTree BT;
	BTNode node;
	int n;

	public PrintNode(BinaryTree BT, BTNode node) {
		this.BT = BT;
		this.node = node;
		n = node.getTouristNum();
		this.setTitle("景点信息");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 400, 500);
		this.setVisible(true);
		addLabel();
		addButton();
	}

	private void addLabel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2, 10, 10));
		JLabel label1 = new JLabel("景点编号");
		JLabel label2 = new JLabel(node.data.num);
		JLabel label3 = new JLabel("景点名称");
		JLabel label4 = new JLabel(node.data.name);
		JLabel label5 = new JLabel("景点简介");
		JLabel label6 = new JLabel(node.data.intro);
		JLabel label7 = new JLabel("门票价格");
		JLabel label8 = new JLabel(node.data.price);
		JLabel label9 = new JLabel("所在地");
		JLabel label10 = new JLabel(node.data.locat);
		JLabel label11 = new JLabel("游客人数");
		JLabel label12 = new JLabel(String.valueOf(n));
		label1.setFont(new Font("宋体", Font.BOLD, 32));
		label2.setFont(new Font("华文中宋", Font.BOLD, 16));
		label3.setFont(new Font("宋体", Font.BOLD, 32));
		label4.setFont(new Font("华文中宋", Font.BOLD, 16));
		label5.setFont(new Font("宋体", Font.BOLD, 32));
		label6.setFont(new Font("华文中宋", Font.BOLD, 16));
		label7.setFont(new Font("宋体", Font.BOLD, 32));
		label8.setFont(new Font("华文中宋", Font.BOLD, 16));
		label9.setFont(new Font("宋体", Font.BOLD, 32));
		label10.setFont(new Font("华文中宋", Font.BOLD, 16));
		label11.setFont(new Font("宋体", Font.BOLD, 32));
		label12.setFont(new Font("华文中宋", Font.BOLD, 16));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label3.setHorizontalAlignment(JLabel.CENTER);
		label4.setHorizontalAlignment(JLabel.CENTER);
		label5.setHorizontalAlignment(JLabel.CENTER);
		label6.setHorizontalAlignment(JLabel.CENTER);
		label7.setHorizontalAlignment(JLabel.CENTER);
		label8.setHorizontalAlignment(JLabel.CENTER);
		label9.setHorizontalAlignment(JLabel.CENTER);
		label10.setHorizontalAlignment(JLabel.CENTER);
		label11.setHorizontalAlignment(JLabel.CENTER);
		label12.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		panel.add(label10);
		panel.add(label11);
		panel.add(label12);
		panel.setPreferredSize(new Dimension(0, 300));
		this.getContentPane().add(panel, "North");
	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton("报名");
		JButton button2 = new JButton("取消报名");
		JButton button0 = new JButton("返回");
		button1.setFont(new Font("宋体", Font.BOLD, 20));
		button2.setFont(new Font("宋体", Font.BOLD, 20));
		button0.setFont(new Font("宋体", Font.BOLD, 20));
		panel.add(button1);
		panel.add(button2);
		panel.add(button0);
		panel.setPreferredSize(new Dimension(0, 50));
		this.getContentPane().add(panel, "South");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BT.getNum(BT.root);
				if (n >= 20) {
					new Message("人数过多，建议报名其他景点。");
					BT.inOrder(BT.root);
					PrintNode.this.setVisible(false);
					new PrintSpot(BT, BT.inList);
					BT.clearList();
				} else {
					if (n < 3 && (BT.tNum >= (BT.sNum * 10))) {
						BT.deleteNode(node);
						new Message("人数不够，建议报名其他景点。");
						BT.inOrder(BT.root);
						PrintNode.this.setVisible(false);
						new PrintSpot(BT, BT.inList);
						BT.clearList();
					} else {
						PrintNode.this.setVisible(false);
						new AddTourist(BT, node);
					}
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (n == 0) {
					new Message("该景点没有游客，不能取消报名！");
				} else {
					PrintNode.this.setVisible(false);
					new DeleteTourist(BT,node);
				}
			}
		});

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintNode.this.setVisible(false);
				new FindSpot(BT);
			}
		});
	}
}