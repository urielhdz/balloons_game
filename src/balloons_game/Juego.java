/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balloons_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Uriel
 */
public class Juego extends Canvas implements Runnable{
    
    ArrayList<Hilo> enemigos;
    ArrayList<Flecha> flechas;
    private Image background;
    private Graphics bufferGraphics; 
    private BufferedImage bufferImg;
    private int background_width = 1200;
    private int background_height = background_width/2;
    private boolean is_playing = true;
    private Arco arco; 
    boolean firstTime = true;
    public Juego(){
        this.enemigos = new ArrayList<Hilo>();
        this.flechas = new ArrayList<Flecha>();
        this.background = new ImageIcon(getClass().getClassLoader().getResource("clouds.png")).getImage();
        this.bufferImg = new BufferedImage(570,380,BufferedImage.TYPE_INT_RGB);
        this.bufferGraphics = this.bufferImg.createGraphics();
        this.bufferGraphics.drawImage(this.background, -100, 0, this.background_width,this.background_height, this);
        this.bufferGraphics.dispose();
        this.arco = new Arco(570/2, 500,570);
        addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                arco.setX(e.getX());
            }
        });
        
        addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                Flecha f = new Flecha(arco.getX() + 35,arco.getY(),arco);
                add_flecha(f);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
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
            if(enemigo.get_is_alive()){
                bufferGraphics.drawImage(enemigo.get_img(), enemigo.get_x(), enemigo.get_y(),enemigo.get_width(), enemigo.get_height(), this);
                if(enemigo.get_y() > 470){
                    bufferGraphics.setColor(Color.black);
                    bufferGraphics.fillRect(0, 0, 800, 700);
                    is_playing = false;
                    break;
                }
            }
            
       }
        
        for(Flecha flecha : flechas){
            if(flecha.isInterrupted()){
                flechas.remove(flecha);
                break;
            } 
            if(flecha.is_alive){
                bufferGraphics.drawImage(flecha.get_img(), flecha.get_x(), flecha.get_y(),flecha.get_width(), flecha.get_height(), this);
                for(Hilo enemigo : enemigos){
                    if(colision(flecha,enemigo)){
                        enemigo.morir();
                        bufferGraphics.drawImage(enemigo.get_img(), enemigo.get_x(), enemigo.get_y(),enemigo.get_width(), enemigo.get_height(), this);
                        enemigo.kill();
                        enemigos.remove(enemigo);
                        flecha.is_alive = false;
                        break;
                    }
                }
            }
            else{
                flecha.interrupt();
            }
            
       }
        bufferGraphics.drawImage(this.arco.img,this.arco.getX(),this.arco.getY(),this);
        g.drawImage(this.bufferImg,0,0,this);
    }
    @Override
    public void run(){
        while(is_playing){
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
    public void add_flecha(Flecha f){
        this.flechas.add(f);
        f.start();
    }
    public Arco getArco(){
        return this.arco;
    }
    public boolean colision(Flecha b, Hilo a){
	boolean hit = false;
	//Colsiones horizontales
	if(b.get_x() + b.get_width() >= a.get_x() && b.get_x() < a.get_x() + a.get_width())
	{
		//Colisiones verticales
		if(b.get_y() + b.get_height() >= a.get_y() && b.get_y() < a.get_y() + a.get_height())
			hit = true;
	}
	//Colisión de a con b
	if(b.get_x() <= a.get_x() && b.get_x() + b.get_width() >= a.get_x() + a.get_width())
	{
		if(b.get_y() <= a.get_y() && b.get_y() + b.get_height() >= a.get_y() + a.get_height())
			hit = true;
	}
	//Colisión b con a
	if(a.get_x() <= b.get_x() && a.get_x() + a.get_width() >= b.get_x() + b.get_width())
	{
		if(a.get_y() <= b.get_y() && a.get_y() + a.get_height() >= b.get_y() + b.get_height())
			hit = true;
	}
	return hit;
    }
    
    public void pausar(int pausa){
        for(Hilo enemigo : enemigos){
            enemigo.pausar(pausa);
       }
    }
}
