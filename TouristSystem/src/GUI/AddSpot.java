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

import Tree.BinaryTree;
import Tree.SpotData;

public class AddSpot extends JFrame {
	private JTextField textBox1;
	private JTextField textBox2;
	private JTextField textBox3;
	private JTextField textBox4;
	private JTextField textBox5;
	BinaryTree BT;

	public AddSpot(BinaryTree BT) {
		this.BT = BT;
		this.setTitle("添加景点");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 400, 500);
		this.setVisible(true);
		addLabel();
		addButton();
	}

	private void addLabel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2, 10, 10));
		JLabel label1 = new JLabel("景点编号");
		textBox1 = new JTextField();
		JLabel label2 = new JLabel("景点名称");
		textBox2 = new JTextField();
		JLabel label3 = new JLabel("景点简介");
		textBox3 = new JTextField();
		JPanel pn1 = new JPanel();
		pn1.setLayout(new GridLayout(2, 1, 0, 0));
		JLabel label4 = new JLabel("门票价格");
		JLabel jl1 = new JLabel("(请输入浮点型数值)");
		textBox4 = new JTextField();
		JLabel label5 = new JLabel("所在地");
		textBox5 = new JTextField();
		label1.setFont(new Font("宋体", Font.BOLD, 32));
		label2.setFont(new Font("宋体", Font.BOLD, 32));
		label3.setFont(new Font("宋体", Font.BOLD, 32));
		label4.setFont(new Font("宋体", Font.BOLD, 32));
		jl1.setFont(new Font("黑体", Font.BOLD, 16));
		label5.setFont(new Font("宋体", Font.BOLD, 32));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label3.setHorizontalAlignment(JLabel.CENTER);
		label4.setHorizontalAlignment(JLabel.CENTER);
		jl1.setHorizontalAlignment(JLabel.CENTER);
		label5.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		panel.add(textBox1);
		panel.add(label2);
		panel.add(textBox2);
		panel.add(label3);
		panel.add(textBox3);
		pn1.add(label4);
		pn1.add(jl1);
		panel.add(pn1);
		panel.add(textBox4);
		panel.add(label5);
		panel.add(textBox5);
		panel.setPreferredSize(new Dimension(0, 400));
		this.getContentPane().add(panel, "North");
	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton("添加");
		JButton button0 = new JButton("返回");
		button1.setFont(new Font("宋体", Font.BOLD, 20));
		button0.setFont(new Font("宋体", Font.BOLD, 20));
		panel.setPreferredSize(new Dimension(0, 50));
		panel.add(button1);
		panel.add(button0);
		this.getContentPane().add(panel, "South");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textBox1.getText().length() < 1 || textBox2.getText().length() < 1
						|| textBox3.getText().length() < 1 || textBox4.getText().length() < 1
						|| textBox5.getText().length() < 1) {
					new Message("请将信息输入完整！");
				} else {
					SpotData data = new SpotData(textBox1.getText(), textBox2.getText(), textBox3.getText(),
							textBox4.getText(), textBox5.getText());
					BT.repeat(BT.root, data);
					if (BT.i == 0) {
						new Message("编号或名称重复，请重新输入！");
						BT.i = 1;
					} else {
						BT.insertNode(BT.root, data);
						BT.preOrder(BT.root);
						BT.inOrder(BT.root);
						AddSpot.this.setVisible(false);
						new PrintWindow(BT, BT.preList, BT.inList);
						BT.clearList();
					}
				}
			}
		});

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddSpot.this.setVisible(false);
				new AdminMenu(BT);
			}
		});
	}
}