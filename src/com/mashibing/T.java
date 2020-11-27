package com.mashibing;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {

	public static void main(String[] args) {
		TankFrame tf = new TankFrame();
		
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tf.repaint();//ÖØÐÂ»­tank
		}

	}

}
