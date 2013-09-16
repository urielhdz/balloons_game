package balloons_game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Lienzo extends Canvas {
    
    Image imagen;
    int h;
    int w;
    final int  initx = 300;
    final int  inity = 570;
    BufferedImage img = null;
    
    public Lienzo(){
        
        URL url;
        //Image img=null;
        
        try {
            

            img = ImageIO.read(new File("C:/Users/shagm_000/Documents/GitHub/balloons_game/imagenes/Arco.png"));

            //url = new URL("");
            //img = ImageIO.read(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        setBackground(new java.awt.Color(255, 255, 255));
        for(int x= 20; x< 380;x+=20){
            repaint();
        }
    }
    
    public void rotar(double angle){
        BufferedImage newImage = new BufferedImage(img.getHeight(), img.getWidth(), img.getType());
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.rotate(Math.toRadians(angle), newImage.getWidth() / 2, newImage.getHeight() / 2);
        graphics.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
        img = newImage;
        repaint();
}
    
    public void paint(Graphics g){
        g.drawImage(img, initx, inity, this);
    }
}
