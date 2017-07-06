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
		this.setTitle("�޸ľ���");
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
		JLabel label2 = new JLabel("ԭ����");
		JLabel label3 = new JLabel("�޸ĺ������");
		JLabel label4 = new JLabel("������");
		JLabel label5 = new JLabel(node.data.num);
		JLabel label6 = new JLabel(node.data.num);
		JLabel label7 = new JLabel("��������");
		JLabel label8 = new JLabel(node.data.name);
		textBox1 = new JTextField();
		JLabel label9 = new JLabel("������");
		JLabel label10 = new JLabel(node.data.intro);
		textBox2 = new JTextField();
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(2, 1, 0, 0));
		JLabel label11 = new JLabel("��Ʊ�۸�");
		JLabel jl = new JLabel("(�����븡������ֵ)");
		JLabel label12 = new JLabel(node.data.price);
		textBox3 = new JTextField();
		JLabel label13 = new JLabel("���ڵ�");
		JLabel label14 = new JLabel(node.data.locat);
		textBox4 = new JTextField();
		label1.setVisible(false);
		label2.setFont(new Font("����", Font.BOLD, 24));
		label3.setFont(new Font("����", Font.BOLD, 24));
		label4.setFont(new Font("����", Font.BOLD, 32));
		label5.setFont(new Font("����", Font.BOLD, 20));
		label6.setFont(new Font("����", Font.BOLD, 20));
		label7.setFont(new Font("����", Font.BOLD, 32));
		label8.setFont(new Font("����", Font.BOLD, 20));
		label9.setFont(new Font("����", Font.BOLD, 32));
		label10.setFont(new Font("����", Font.BOLD, 20));
		label11.setFont(new Font("����", Font.BOLD, 32));
		jl.setFont(new Font("����", Font.BOLD, 16));
		label12.setFont(new Font("����", Font.BOLD, 20));
		label13.setFont(new Font("����", Font.BOLD, 32));
		label14.setFont(new Font("����", Font.BOLD, 20));
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
		JButton button1 = new JButton("�޸ľ�������");
		JButton button2 = new JButton("�޸ľ�����");
		JButton button3 = new JButton("�޸���Ʊ�۸�");
		JButton button4 = new JButton("�޸����ڵ�");
		JButton button0 = new JButton("ȡ��");
		button1.setFont(new Font("����", Font.BOLD, 20));
		button2.setFont(new Font("����", Font.BOLD, 20));
		button3.setFont(new Font("����", Font.BOLD, 20));
		button4.setFont(new Font("����", Font.BOLD, 20));
		button0.setFont(new Font("����", Font.BOLD, 20));
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
					new Message("�������Ʋ���Ϊ�գ�");
				} else {
					BT.nameRepeat(BT.root, textBox1.getText());
					if (BT.i == 0) {
						new Message("���������ظ������������룡");
						BT.i = 1;
					} else {
						BT.setName(node, textBox1.getText());
						new Message("�޸ĳɹ���");
					}
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textBox2.getText().length() < 1) {
					new Message("�����鲻��Ϊ�գ�");
				} else {
					BT.setIntro(node, textBox2.getText());
					new Message("�޸ĳɹ���");
				}
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textBox3.getText().length() < 1) {
					new Message("��Ʊ�۸���Ϊ�գ�");
				} else {
					BT.setPrice(node, textBox3.getText());
					new Message("�޸ĳɹ���");
				}
			}
		});

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textBox4.getText().length() < 1) {
					new Message("���ڵز���Ϊ�գ�");
				} else {
					BT.setLocat(node, textBox4.getText());
					new Message("�޸ĳɹ���");
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