package com.Test;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TTest {
    @Test
    public void test(){
        try {
            BufferedImage bif = ImageIO.read(new File("C:/Users/Administrator/Desktop/jietu.png"));
            BufferedImage bif2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            assertNotNull(bif2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}