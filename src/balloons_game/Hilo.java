/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balloons_game;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Uriel
 */
public class Hilo extends Thread{
    private int x = 0;
    private int y = 15;
    private int counter = 0;
    private int width = 50;
    private int height = 70;
    
    private boolean pausa = false;
    private long tiempoPausa;
    
    public Image img;
    public final String url = "balloon.png";
    public boolean is_alive = true;
    public Hilo(){
        this.img = new ImageIcon(getClass().getClassLoader().getResource(this.url)).getImage();
    }
    @Override
    public void run() {
            while(is_alive){
                try{
                    Thread.sleep(1000 / 60);                
                    updateMovement();                
                }
                catch (Exception e){
                    System.out.println(e);
                }
                
                if(pausa){
                    try {
                        Thread.sleep(this.tiempoPausa);
                        pausa = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
    }
    
    public void pausar(int tiempoPausa){
        
        this.tiempoPausa = tiempoPausa;
        pausa = true;
    }
    public void morir(){
        this.img = new ImageIcon(getClass().getClassLoader().getResource("deadBallon.png")).getImage();
    }
    public void updateMovement(){
        counter++;
        Double speed = (Math.sin(this.counter * Math.PI / 117)*8);
        this.x += speed.intValue();
    }
    public boolean get_is_alive(){
        return this.is_alive;
    }
    public Image get_img(){
        return this.img;
    }
    public int get_x(){
        return this.x;
    }
    public int get_y(){
        return this.y;
    }
    public int get_width(){
        return this.width;
    }
    public int get_height(){
        return this.height;
    }
    public void kill(){
        this.is_alive = false;
    }
}
