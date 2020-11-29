package com.mashibing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResoureMgr {
    public static BufferedImage tankL,tankR,tankU,tankD;
    static {

        try {
            tankL = ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("tankR"));
            tankD = ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("tankR"));
            tankU = ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("tankR"));
            tankR = ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("tankR"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
