/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balloons_game;

import java.awt.Image;
import java.net.URL;
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
        }
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
