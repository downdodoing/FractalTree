package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FractalTree extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel length, angle, red, green, blue;// 提示信息
	private JTextField input_length, input_angle, input_red, input_green,
			input_blue;// 输入的值
	private JButton ok;
	// 存储输入的值
	private int vLength;
	private int vRed, vGreen, vBlue, vAngle;

	private DrawLine mPanel1;// 用于存储画图界面

	public FractalTree() {
		mPanel1 = new DrawLine();

		JPanel mPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
		init();
		mPanel2.add(length);
		mPanel2.add(input_length);
		mPanel2.add(angle);
		mPanel2.add(input_angle);
		mPanel2.add(red);
		mPanel2.add(input_red);
		mPanel2.add(green);
		mPanel2.add(input_green);
		mPanel2.add(blue);
		mPanel2.add(input_blue);
		mPanel2.add(ok);

		add(mPanel1, BorderLayout.CENTER);
		add(mPanel2, BorderLayout.SOUTH);
	}

	public void init() {
		length = new JLabel("长度");
		angle = new JLabel("角度");
		red = new JLabel("红色");
		green = new JLabel("绿色");
		blue = new JLabel("蓝色");

		input_length = new JTextField(8);
		input_red = new JTextField(8);
		input_angle = new JTextField(8);
		input_green = new JTextField(8);
		input_blue = new JTextField(8);

		ok = new JButton("确定");
		// 添加按钮监听器
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getValue();
				mPanel1.setAngle(vAngle);
				mPanel1.setColor(new Color(vRed, vGreen, vBlue));
				mPanel1.setLength(vLength);
				mPanel1.re();
			}
		});
	}

	// 判断值是否为null
	public boolean isNull(String value) {
		if (value.equals("")) {
			return true;
		}
		return false;
	}

	// 获取输入的值
	public boolean getValue() {
		String vLength1 = input_length.getText();
		if (isNull(vLength1)) {
			System.out.println("请输入长度");
			return false;
		}
		vLength = Integer.parseInt(vLength1);
		String vAngle1 = input_angle.getText();
		if (isNull(vAngle1)) {
			System.out.println("请输入角度");
			return false;
		}
		vAngle = Integer.parseInt(vAngle1);
		String vRed1 = input_red.getText();
		if (isNull(vRed1)) {
			System.out.println("请输入数字红色");
			return false;
		}
		vRed = Integer.parseInt(vRed1);
		String vGreen1 = input_green.getText();
		if (isNull(vGreen1)) {
			System.out.println("请输入数字绿色");
			return false;
		}
		vGreen = Integer.parseInt(vGreen1);
		String vBlue1 = input_blue.getText();
		if (isNull(vBlue1)) {
			System.out.println("请输入数字蓝色");
			return false;
		}
		vBlue = Integer.parseInt(vBlue1);
		return true;
	}

	public static void main(String[] args) {
		FractalTree f = new FractalTree();
		f.setTitle("da");
		f.setSize(800, 750);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
