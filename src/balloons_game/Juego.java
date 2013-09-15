/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balloons_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Uriel
 */
public class Juego extends Canvas implements Runnable{
    
    ArrayList<Thread> enemigos;
    public Juego(){
        this.enemigos = new ArrayList<Thread>();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D draw = (Graphics2D) g;
        draw.setColor(Color.white);
        draw.fillRect(0, 0, this.getWidth(), this.getHeight());
        for(Thread enemigo : enemigos){
//            g.drawImage(enemigo.get, WIDTH, WIDTH, this);
       }
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

}
