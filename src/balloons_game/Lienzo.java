package balloons_game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Lienzo extends Canvas implements KeyListener{
    
    
    Arco bow;
    public Lienzo(){
        addKeyListener(this);
        setBackground(new java.awt.Color(255, 255, 255));
        bow = new Arco(300,560);
        
    }
    
    public void paint(Graphics g){
        //g.drawImage(bow.getImagen(), bow.getX(), bow.getY(), this);
    }
    
    public void dibujarAlgo(Image img, int coorx, int coory){
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if(tecla == 37 || tecla == 65){//ir a izquierda por medio de flechas o la letra "a"
            System.out.println("Izquierda");
            bow.setX(bow.getX() - 10);
        }else if(tecla== 38 || tecla == 87){
            System.out.println("Arriba");
        }else if(tecla == 39 || tecla == 68){//ir a derecha por medio de flechas o la letra "d"
            System.out.println("Derecha");
            bow.setX(bow.getX() + 10);
        }else if(tecla == 40 || tecla == 83){
            System.out.println("Abajo");
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
