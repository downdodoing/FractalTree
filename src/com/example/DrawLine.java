package com.example;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawLine extends JPanel {
	private static final long serialVersionUID = 1L;
	private Color color;
	private int angle, length;

	public DrawLine() {
		this(400, 30, Color.BLACK);
	}

	public DrawLine(int length, int angle, Color color) {
		this.length = length;
		this.angle = angle;
		this.color = color;
		this.angle = angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	// 从调用paintComponent进行视图刷新
	public void re() {
		repaint();
	}

	public void paintLine(Graphics g, int length, Point starPoint,
			Point endPoint, int angle) {

		int l1 = (int) (length * 2.0 / 3.0);
		if (l1 < this.length / 200.0) {
			return;
		}
		// 分支1
		int startX0 = (int) (2.0 / 3.0 * starPoint.getX() + 1.0 / 3.0 * endPoint
				.getX());
		int startY0 = (int) (2.0 / 3.0 * starPoint.getY() + 1.0 / 3.0 * endPoint
				.getY());

		int endX0 = (int) (startX0 + l1 * Math.sin(angle / 180.0 * Math.PI));
		int endY0 = (int) (startY0 - l1 * Math.cos(angle / 180.0 * Math.PI));

		g.setColor(color);
		g.drawLine(startX0, startY0, endX0, endY0);

		Point starPoint1 = new Point(startX0, startY0);
		Point endPoint1 = new Point(endX0, endY0);
		paintLine(g, l1, starPoint1, endPoint1, this.angle + angle);

		// 分支2
		int l2 = (int) (length / 3.0);

		int startX0_1 = (int) (1.0 / 3.0 * starPoint.getX() + 2.0 / 3.0 * endPoint
				.getX());
		int startY0_1 = (int) (1.0 / 3.0 * starPoint.getY() + 2.0 / 3.0 * endPoint
				.getY());

		int endX0_1 = (int) (startX0_1 - l2
				* Math.sin((this.angle * 2 - angle) / 180.0 * Math.PI));
		int endY0_1 = (int) (startY0_1 - l2
				* Math.cos((this.angle * 2 - angle) / 180.0 * Math.PI));

		g.setColor(color);
		g.drawLine(startX0_1, startY0_1, endX0_1, endY0_1);

		starPoint1 = new Point(startX0_1, startY0_1);
		endPoint1 = new Point(endX0_1, endY0_1);
		paintLine(g, l2, starPoint1, endPoint1, angle - this.angle);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		Point startPoint = new Point(width / 2, length + 10);
		Point endPoint = new Point(width / 2, 10);
		g.setColor(color);
		//主干绘制
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(),
				endPoint.getY());
		this.paintLine(g, length, startPoint, endPoint, angle);
	}
}
