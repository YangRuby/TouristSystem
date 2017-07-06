package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Message extends JFrame {
	public Message(String message) {
		this.setTitle("提示");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 300, 300, 200);
		this.setLayout(null);
		JLabel label = new JLabel(message);
		label.setFont(new Font("黑体", Font.BOLD, 12));
		label.setBounds(70, 50, 300, 20);
		this.add(label);
		this.setVisible(true);
		addButton();
	}

	private void addButton() {
		JButton button = new JButton("确定");
		button.setFont(new Font("黑体", Font.BOLD, 12));
		button.setBounds(110, 120, 60, 30);
		this.add(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Message.this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				Message.this.setVisible(false);
			}
		});
	}
}