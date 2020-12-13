package com.mashibing;

import java.awt.Graphics;
/**
 * 抽象出tank类, 封装绘画tank方法
 * @author Administrator
 *
 */
public class Tank {
	private int x, y;
	public static int HEIGHT = ResoureMgr.tankD.getHeight();//获取坦克高度
	public static int WIDTH = ResoureMgr.tankD.getWidth();//获取坦克宽度
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
	 * 每创建一个窗口则自动调用该方法
	 * Frame自带方法,继承过来
	 */
	public void paint(Graphics g) {
		//画一个坦克
		//g.fillRect(x, y, 60, 60);
	//	g.drawImage(ResoureMgr.tankL,x,y,null);

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
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		tf.bulletList.add(new Bullet(bX,bY,this.dir,tf));
	}
}
