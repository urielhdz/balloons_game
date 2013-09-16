package balloons_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author shagm_000
 */
public class Arco {
    int h;
    int w;
    int  x;
    int  y;
    int speed = 10;
    public Image img = null;

    public Arco(int x, int y,int limite){
        this.x = x;
        this.y = y;
        this.img = new ImageIcon(getClass().getClassLoader().getResource("arco.png")).getImage();
    }
    
    public void mover_derecha(){
        this.x += this.speed;
        if(this.x > 570) this.x = 570;
    }
    public void mover_izquierda(){
        this.x -= this.speed;
        if(this.x < 0) this.x = 0;
    }
    public void dibujarArco(){
        
    }
    
    public void disparar(){
        
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
