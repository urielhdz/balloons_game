package balloons_game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Herramientas extends JPanel implements ActionListener,KeyListener{
    
    private JButton btnPausar;
    private JButton btnDibujar;
    private JTextField tiempotxt;
    private Juego li;
    
    public Herramientas(){
        btnPausar = new JButton("Pausar juego");
        btnDibujar = new JButton("Dibujar Globo");
        tiempotxt = new JTextField(15);
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        ///Verifica que no se escriban letras en el textfield
        tiempotxt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char caracter = e.getKeyChar();
                if(((caracter < '0') || (caracter > '9')) && (caracter != '\b' )){
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        btnPausar.addActionListener(this);
        btnDibujar.addActionListener(this);
      
        add(btnDibujar);
        add(btnPausar);
        add(tiempotxt);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 32){
            Arco a = this.li.getArco();
            Flecha f = new Flecha(a.getX() + 35,a.getY(),a);
            this.li.add_flecha(f);
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton elegido = (JButton) e.getSource();
        
        if(elegido == btnPausar){
            int tiempo = Integer.parseInt("0"+tiempotxt.getText());
        } else if(elegido == btnDibujar){
            this.li.add_enemigo(new Hilo());
        }
        
    }
    
    int angulo=0;
    public void setLienzo(Juego li){
        this.li = li;
        li.addKeyListener(this);
        Thread t = new Thread(this.li);
        t.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 39){
            Arco a = this.li.getArco();
            a.mover_derecha();
        }
        if(e.getKeyCode() == 37){
            Arco a = this.li.getArco();
            a.mover_izquierda();
        }
    }
    
    
}
