/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balloons_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Uriel
 */
public class Juego extends Canvas implements Runnable{
    
    ArrayList<Hilo> enemigos;
    private Image background;
    private Graphics bufferGraphics; 
    private BufferedImage bufferImg;
    private int background_width = 1200;
    private int background_height = background_width/2;
    boolean firstTime = true;
    public Juego(){
        this.enemigos = new ArrayList<Hilo>();
        this.background = new ImageIcon(getClass().getClassLoader().getResource("clouds.png")).getImage();
        this.bufferImg = new BufferedImage(570,380,BufferedImage.TYPE_INT_RGB);
        this.bufferGraphics = this.bufferImg.createGraphics();
        this.bufferGraphics.drawImage(this.background, -100, 0, this.background_width,this.background_height, this);
        this.bufferGraphics.dispose();
    }
    @Override
    public void paint(Graphics g){
        update(g);
    }
    @Override
    public void update(Graphics g){
        if(firstTime){
            Dimension dim = getSize();
            int w = dim.width;
            int h = dim.height;
            this.bufferImg = (BufferedImage)createImage(w, h);
            this.bufferGraphics = this.bufferImg.createGraphics();
            firstTime = false;
        } 
        bufferGraphics.drawImage(this.background, -100, 0, this.background_width,this.background_height, this);
        for(Hilo enemigo : enemigos){
            bufferGraphics.drawImage(enemigo.get_img(), enemigo.get_x(), enemigo.get_y(),enemigo.get_width(), enemigo.get_height(), this);
       }
        g.drawImage(this.bufferImg,0,0,this);
    }
    @Override
    public void run(){
        while(true ){
            try{
                Thread.sleep(1000 / 60);
                repaint();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public void add_enemigo(Hilo h){
        this.enemigos.add(h);
        h.start();
    }

}
