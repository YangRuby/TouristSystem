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
import Tree.SpotData;

public class SetWindow extends JFrame {
	JTextField textBox1;
	JTextField textBox2;
	JTextField textBox3;
	JTextField textBox4;
	BinaryTree BT;
	BTNode node;

	public SetWindow(BinaryTree BT, BTNode node) {
		this.BT = BT;
		this.node = node;
		this.setTitle("修改景点");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 1000, 800);
		this.setVisible(true);
		addLabel();
		addButton();
	}

	private void addLabel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 3, 10, 10));
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel("原数据");
		JLabel label3 = new JLabel("修改后的数据");
		JLabel label4 = new JLabel("景点编号");
		JLabel label5 = new JLabel(node.data.num);
		JLabel label6 = new JLabel(node.data.num);
		JLabel label7 = new JLabel("景点名称");
		JLabel label8 = new JLabel(node.data.name);
		textBox1 = new JTextField();
		JLabel label9 = new JLabel("景点简介");
		JLabel label10 = new JLabel(node.data.intro);
		textBox2 = new JTextField();
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(2, 1, 0, 0));
		JLabel label11 = new JLabel("门票价格");
		JLabel jl = new JLabel("(请输入浮点型数值)");
		JLabel label12 = new JLabel(node.data.price);
		textBox3 = new JTextField();
		JLabel label13 = new JLabel("所在地");
		JLabel label14 = new JLabel(node.data.locat);
		textBox4 = new JTextField();
		label1.setVisible(false);
		label2.setFont(new Font("宋体", Font.BOLD, 24));
		label3.setFont(new Font("宋体", Font.BOLD, 24));
		label4.setFont(new Font("宋体", Font.BOLD, 32));
		label5.setFont(new Font("宋体", Font.BOLD, 20));
		label6.setFont(new Font("宋体", Font.BOLD, 20));
		label7.setFont(new Font("宋体", Font.BOLD, 32));
		label8.setFont(new Font("宋体", Font.BOLD, 20));
		label9.setFont(new Font("宋体", Font.BOLD, 32));
		label10.setFont(new Font("宋体", Font.BOLD, 20));
		label11.setFont(new Font("宋体", Font.BOLD, 32));
		jl.setFont(new Font("黑体", Font.BOLD, 16));
		label12.setFont(new Font("宋体", Font.BOLD, 20));
		label13.setFont(new Font("宋体", Font.BOLD, 32));
		label14.setFont(new Font("宋体", Font.BOLD, 20));
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
		jl.setHorizontalAlignment(JLabel.CENTER);
		label12.setHorizontalAlignment(JLabel.CENTER);
		label13.setHorizontalAlignment(JLabel.CENTER);
		label14.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(textBox1);
		panel.add(label9);
		panel.add(label10);
		panel.add(textBox2);
		pn.add(label11);
		pn.add(jl);
		panel.add(pn);
		panel.add(label12);
		panel.add(textBox3);
		panel.add(label13);
		panel.add(label14);
		panel.add(textBox4);
		panel.setPreferredSize(new Dimension(0, 500));
		this.getContentPane().add(panel, "North");

	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton("修改景点名称");
		JButton button2 = new JButton("修改景点简介");
		JButton button3 = new JButton("修改门票价格");
		JButton button4 = new JButton("修改所在地");
		JButton button0 = new JButton("取消");
		button1.setFont(new Font("宋体", Font.BOLD, 20));
		button2.setFont(new Font("宋体", Font.BOLD, 20));
		button3.setFont(new Font("宋体", Font.BOLD, 20));
		button4.setFont(new Font("宋体", Font.BOLD, 20));
		button0.setFont(new Font("宋体", Font.BOLD, 20));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button0);
		panel.setPreferredSize(new Dimension(0, 50));
		this.getContentPane().add(panel, "South");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textBox1.getText().length() < 1) {
					new Message("景点名称不能为空！");
				} else {
					BT.nameRepeat(BT.root, textBox1.getText());
					if (BT.i == 0) {
						new Message("景点名称重复，请重新输入！");
						BT.i = 1;
					} else {
						BT.setName(node, textBox1.getText());
						new Message("修改成功！");
					}
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textBox2.getText().length() < 1) {
					new Message("景点简介不能为空！");
				} else {
					BT.setIntro(node, textBox2.getText());
					new Message("修改成功！");
				}
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textBox3.getText().length() < 1) {
					new Message("门票价格不能为空！");
				} else {
					BT.setPrice(node, textBox3.getText());
					new Message("修改成功！");
				}
			}
		});

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textBox4.getText().length() < 1) {
					new Message("所在地不能为空！");
				} else {
					BT.setLocat(node, textBox4.getText());
					new Message("修改成功！");
				}
			}
		});

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetWindow.this.setVisible(false);
				new SetSpot(BT);
			}
		});
	}
}