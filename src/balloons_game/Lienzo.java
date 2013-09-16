package balloons_game;

import java.awt.Canvas;
import javax.swing.ImageIcon;

public class Lienzo extends Canvas {
    
    ImageIcon arco = new ImageIcon("../imagenes/Arco.png"); 
    
    public Lienzo(){
        setBackground(new java.awt.Color(255, 255, 255));
    }
}
