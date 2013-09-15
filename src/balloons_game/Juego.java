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
    
    ArrayList<Hilo> enemigos;
    public Juego(){
        this.enemigos = new ArrayList<Hilo>();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D draw = (Graphics2D) g;
        draw.setColor(Color.white);
        draw.fillRect(0, 0, this.getWidth(), this.getHeight());
        for(Hilo enemigo : enemigos){
            g.drawImage(enemigo.get_img(), enemigo.get_x(), enemigo.get_y(),30, 50, this);
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
