package com.mashibing;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame{
	Tank myTk = new Tank(200, 200, Dir.UP,this);
	//Bullet bt = new Bullet(200,200,Dir.UP);
	List<Bullet> bulletList = new ArrayList<>();
	int GAME_WIDTH = 800,GAME_HEIGHT = 600;
	//构造方法, 创建窗口
	public TankFrame() {
		this.setSize(GAME_WIDTH, GAME_HEIGHT);//设置窗口大小
		this.setTitle("tank war");//设置标题
		this.setResizable(false);//设置窗口是否可移动
		this.setVisible(true);//设置窗口是否显示
		//添加window监听器, 关闭窗口
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new MyKeyListener());
	}
	/**
	 * 每创建一个窗口则自动调用该方法
	 * Frame自带方法,继承过来
	 */
	@Override
	public void paint(Graphics g) {
		g.drawString("子弹数量："+bulletList.size(),60,80);
		myTk.paint(g);//调用tank类画一个坦克
		for(int i = 0; i < bulletList.size(); i++){//循环画子弹
			bulletList.get(i).paint(g);
		}
	}
	
	/**
	 * 增加键盘方向键,监控,设置tank方向
	 */
	class MyKeyListener extends KeyAdapter{
		boolean bL = false;
		boolean bR = false;
		boolean bU = false;
		boolean bD = false;
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			move(key);
			
		}


		private void move(int key) {
			
			switch(key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			case KeyEvent.VK_CONTROL:
				myTk.fire();
				break;
			default:
				break;
			}
			setMainTankDir();
			
		}


		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			default:
				break;
			}
			setMainTankDir();
		}
		//根据键盘方向控制tank行走方向
		private void setMainTankDir() {
			if(!bL && !bR && !bU && !bD) myTk.setMoving(false);
			else {
				myTk.setMoving(true);
				if(bL) myTk.setDir(Dir.LEFT);
				if(bR) myTk.setDir(Dir.RIGHT);
				if(bU) myTk.setDir(Dir.UP);
				if(bD) myTk.setDir(Dir.DOWN);
			}
		}
	}
}
