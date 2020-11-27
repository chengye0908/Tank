package com.mashibing;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
	Tank myTk = new Tank(200, 200, Dir.UP);
	Bullet bt = new Bullet(200,200,Dir.UP);
	private static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;
	//���췽��, ��������
	public TankFrame() {
		this.setSize(GAME_WIDTH, GAME_HEIGHT);//���ô��ڴ�С
		this.setTitle("tank war");//���ñ���
		this.setResizable(false);//���ô����Ƿ���ƶ�
		this.setVisible(true);//���ô����Ƿ���ʾ
		//���window������, �رմ���
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new MyKeyListener());
	}
	/**
	 * ÿ����һ���������Զ����ø÷���
	 * Frame�Դ�����,�̳й���
	 */
	@Override
	public void paint(Graphics g) {
		
		myTk.paint(g);//����tank�໭һ��̹��
		bt.paint(g);//����tank��һ���ӵ�
	}
	
	/**
	 * ���Ӽ��̷����,���,����tank����
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
		//���ݼ��̷������tank���߷���
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
