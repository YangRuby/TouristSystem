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
import Tree.TouristData;

public class AddTourist extends JFrame {
	JTextField textBox1;
	JTextField textBox2;
	JTextField textBox3;
	JTextField textBox4;
	JTextField textBox5;
	BinaryTree BT;
	BTNode node;

	public AddTourist(BinaryTree BT, BTNode node) {
		this.BT = BT;
		this.node = node;
		this.setTitle("报名景点（输入游客信息）");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 400, 500);
		this.setVisible(true);
		addTextBox();
		addButton();
	}

	private void addTextBox() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2, 10, 10));
		JLabel label1 = new JLabel("游客号");
		textBox1 = new JTextField();
		JLabel label2 = new JLabel("姓名");
		textBox2 = new JTextField();
		JPanel pn1 = new JPanel();
		pn1.setLayout(new GridLayout(2, 1, 0, 0));
		JLabel label3 = new JLabel("性别");
		JLabel jl1 = new JLabel("(男/女)");
		textBox3 = new JTextField();
		JPanel pn2 = new JPanel();
		pn2.setLayout(new GridLayout(2, 1, 0, 0));
		JLabel label4 = new JLabel("年龄");
		JLabel jl2 = new JLabel("(请输入整型数值)");
		textBox4 = new JTextField();
		JLabel label5 = new JLabel("来源地");
		textBox5 = new JTextField();
		label1.setFont(new Font("宋体", Font.BOLD, 32));
		label2.setFont(new Font("宋体", Font.BOLD, 32));
		label3.setFont(new Font("宋体", Font.BOLD, 32));
		jl1.setFont(new Font("黑体", Font.BOLD, 16));
		label4.setFont(new Font("宋体", Font.BOLD, 32));
		jl2.setFont(new Font("黑体", Font.BOLD, 16));
		label5.setFont(new Font("宋体", Font.BOLD, 32));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label3.setHorizontalAlignment(JLabel.CENTER);
		jl1.setHorizontalAlignment(JLabel.CENTER);
		label4.setHorizontalAlignment(JLabel.CENTER);
		jl2.setHorizontalAlignment(JLabel.CENTER);
		label5.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		panel.add(textBox1);
		panel.add(label2);
		panel.add(textBox2);
		pn1.add(label3);
		pn1.add(jl1);
		panel.add(pn1);
		panel.add(textBox3);
		pn2.add(label4);
		pn2.add(jl2);
		panel.add(pn2);
		panel.add(textBox4);
		panel.add(label5);
		panel.add(textBox5);
		panel.setPreferredSize(new Dimension(0, 400));
		this.getContentPane().add(panel, "North");
	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton("确认报名");
		JButton button0 = new JButton("取消");
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
					TouristData data = new TouristData(textBox1.getText(), textBox2.getText(), textBox3.getText(),
							textBox4.getText(), textBox5.getText());
					BT.touristNumRepeat(BT.root, data.num, data.name);
					node.signUpRepeat(data.num);
					if (BT.o == 0 || node.i == 0) {
						new Message("游客号重复，请重新输入！");
						BT.o = 1;
						node.i = 1;
					} else {
						node.insertLink(data);
						AddTourist.this.setVisible(false);
						new GuestMenu(BT);
						new Message("报名成功");
					}
				}
			}
		});

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BT.inOrder(BT.root);
				AddTourist.this.setVisible(false);
				new PrintSpot(BT, BT.inList);
				BT.clearList();
			}
		});
	}
}