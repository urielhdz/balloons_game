package balloons_game;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Flecha extends Thread{
    
    private int x;
    private Image img;
    private String url = "flecha.png";
    private int limite = 0;
    private int y;
    private int width = 10;
    private int height = 20;
    private int velocidad = 5;
    private Arco arco;
    boolean is_alive = true;
    public Flecha(int x, int y, Arco a){
        this.arco = a;
        this.img = new ImageIcon(getClass().getClassLoader().getResource(this.url)).getImage();
        this.y = y;
        this.x = x;
        this.arco = a;
    }
    @Override
    public void run() {
        while(is_alive){
            if(this.y<0) is_alive = false;
            try{
                Thread.sleep(1000 / 60);
                this.y-= this.velocidad;               
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public int get_x() {
        return x;
    }

    public int get_y() {
        return y;
    }
    public int get_width() {
        return width;
    }

    public int get_height() {
        return height;
    }
    public Image get_img(){
        return img;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
