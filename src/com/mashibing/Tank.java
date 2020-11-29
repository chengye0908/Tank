package com.mashibing;

import java.awt.Graphics;
/**
 * �����tank��, ��װ�滭tank����
 * @author Administrator
 *
 */
public class Tank {
	private int x, y;
	private Dir dir = Dir.UP;
	private final static int SPEED = 10;
	private boolean moving = false;
	private TankFrame tf = null;
	public boolean isMoving() {
		return moving;
	}
	ResoureMgr resoure = null;
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Tank(int x, int y, Dir dir,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	/**
	 * ÿ����һ���������Զ����ø÷���
	 * Frame�Դ�����,�̳й���
	 */
	public void paint(Graphics g) {
		//��һ��̹��
		//g.fillRect(x, y, 60, 60);
		switch(dir){
			case LEFT:
				g.drawImage(resoure.tankL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(resoure.tankR,x,y,null);
				break;
			case DOWN:
				g.drawImage(resoure.tankD,x,y,null);
				break;
			case UP:
				g.drawImage(resoure.tankU,x,y,null);
				break;
		}




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

	public void fire() {
		tf.bulletList.add(new Bullet(this.x,this.y,this.dir,tf));
	}
}
