package com.mashibing;

import java.awt.Color;
import java.awt.Graphics;
/**
 * 抽象一个子弹类,封装子弹绘画方法
 * @author Administrator
 *
 */
public class Bullet {
	private int x,y;
	private Dir dir;
	private static final int SPEED = 1;
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
	public Bullet(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	/**
	 * 每创建一个窗口则自动调用该方法
	 * Frame自带方法,继承过来
	 */
	public void paint(Graphics g) {
		//画一个子弹
		Color c = g.getColor();
		g.setColor(c.RED);
		g.fillOval(x, y, WIDTH, WIDTH);
		switch(dir) {
		case LEFT:
			x = x - SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y = y - SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
	}
}
