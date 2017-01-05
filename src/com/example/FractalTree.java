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
	private JLabel length, angle, red, green, blue;// ��ʾ��Ϣ
	private JTextField input_length, input_angle, input_red, input_green,
			input_blue;// �����ֵ
	private JButton ok;
	// �洢�����ֵ
	private int vLength;
	private int vRed, vGreen, vBlue, vAngle;

	private DrawLine mPanel1;// ���ڴ洢��ͼ����

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
		length = new JLabel("����");
		angle = new JLabel("�Ƕ�");
		red = new JLabel("��ɫ");
		green = new JLabel("��ɫ");
		blue = new JLabel("��ɫ");

		input_length = new JTextField(8);
		input_red = new JTextField(8);
		input_angle = new JTextField(8);
		input_green = new JTextField(8);
		input_blue = new JTextField(8);

		ok = new JButton("ȷ��");
		// ��Ӱ�ť������
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

	// �ж�ֵ�Ƿ�Ϊnull
	public boolean isNull(String value) {
		if (value.equals("")) {
			return true;
		}
		return false;
	}

	// ��ȡ�����ֵ
	public boolean getValue() {
		String vLength1 = input_length.getText();
		if (isNull(vLength1)) {
			System.out.println("�����볤��");
			return false;
		}
		vLength = Integer.parseInt(vLength1);
		String vAngle1 = input_angle.getText();
		if (isNull(vAngle1)) {
			System.out.println("������Ƕ�");
			return false;
		}
		vAngle = Integer.parseInt(vAngle1);
		String vRed1 = input_red.getText();
		if (isNull(vRed1)) {
			System.out.println("���������ֺ�ɫ");
			return false;
		}
		vRed = Integer.parseInt(vRed1);
		String vGreen1 = input_green.getText();
		if (isNull(vGreen1)) {
			System.out.println("������������ɫ");
			return false;
		}
		vGreen = Integer.parseInt(vGreen1);
		String vBlue1 = input_blue.getText();
		if (isNull(vBlue1)) {
			System.out.println("������������ɫ");
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
