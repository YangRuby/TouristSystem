package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Tree.BinaryTree;
import Tree.TouristData;

public class CheckTourist extends JFrame {
	BinaryTree BT;

	public CheckTourist(BinaryTree BT, ArrayList<TouristData> touristList) {
		this.BT = BT;
		this.setTitle("�鿴�ο���Ϣ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 200, 1000, 600);
		this.setVisible(true);
		addLabel(touristList);
		addButton();
	}

	private void addLabel(ArrayList<TouristData> touristList) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(touristList.size() + 1, 5, 0, 0));
		JLabel label1 = new JLabel("�οͺ�");
		JLabel label2 = new JLabel("�ο�����");
		JLabel label3 = new JLabel("�ο��Ա�");
		JLabel label4 = new JLabel("�ο�����");
		JLabel label5 = new JLabel("�ο���Դ��");
		label1.setFont(new Font("����", Font.BOLD, 32));
		label2.setFont(new Font("����", Font.BOLD, 32));
		label3.setFont(new Font("����", Font.BOLD, 32));
		label4.setFont(new Font("����", Font.BOLD, 32));
		label5.setFont(new Font("����", Font.BOLD, 32));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label3.setHorizontalAlignment(JLabel.CENTER);
		label4.setHorizontalAlignment(JLabel.CENTER);
		label5.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		for (int i = 0; i < touristList.size(); i++) {
			JLabel jl1 = new JLabel(touristList.get(i).num);
			JLabel jl2 = new JLabel(touristList.get(i).name);
			JLabel jl3 = new JLabel(touristList.get(i).sex);
			JLabel jl4 = new JLabel(touristList.get(i).age);
			JLabel jl5 = new JLabel(touristList.get(i).origin);
			jl1.setFont(new Font("��������", Font.BOLD, 16));
			jl2.setFont(new Font("��������", Font.BOLD, 16));
			jl3.setFont(new Font("��������", Font.BOLD, 16));
			jl4.setFont(new Font("��������", Font.BOLD, 16));
			jl5.setFont(new Font("��������", Font.BOLD, 16));
			jl1.setHorizontalAlignment(JLabel.CENTER);
			jl2.setHorizontalAlignment(JLabel.CENTER);
			jl3.setHorizontalAlignment(JLabel.CENTER);
			jl4.setHorizontalAlignment(JLabel.CENTER);
			jl5.setHorizontalAlignment(JLabel.CENTER);
			panel.add(jl1);
			panel.add(jl2);
			panel.add(jl3);
			panel.add(jl4);
			panel.add(jl5);
		}
		panel.setPreferredSize(new Dimension(0, touristList.size() * 100));
		this.getContentPane().add(panel, "North");
	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button0 = new JButton("����");
		button1.setVisible(false);
		button2.setVisible(false);
		button3.setVisible(false);
		button4.setVisible(false);
		button0.setFont(new Font("����", Font.BOLD, 20));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button0);
		panel.setPreferredSize(new Dimension(0, 50));
		this.getContentPane().add(panel, "South");

		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckTourist.this.setVisible(false);
				new AdminMenu(BT);
			}
		});
	}
}