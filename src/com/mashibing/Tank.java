package com.mashibing;

import java.awt.Graphics;
/**
 * 抽象出tank类, 封装绘画tank方法
 * @author Administrator
 *
 */
public class Tank {
	private int x, y;
	private Dir dir = Dir.UP;
	private final static int SPEED = 10;
	private boolean moving = false;

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	/**
	 * 每创建一个窗口则自动调用该方法
	 * Frame自带方法,继承过来
	 */
	public void paint(Graphics g) {
		//画一个坦克
		g.fillRect(x, y, 60, 60);
		if(!moving) return;
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
