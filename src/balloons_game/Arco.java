package balloons_game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author shagm_000
 */
public class Arco {
    int h;
    int w;
    int  x;
    int  y;
    BufferedImage img = null;

    
    public Arco(int x, int y){
        this.x = x;
        this.y = y;
        try {
            img = ImageIO.read(new File("C:/Users/shagm_000/Documents/GitHub/balloons_game/imagenes/Arco.png"));

        }  catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage getImagen(){
        return img;
    }
    
    public void moverArco(){
        
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
