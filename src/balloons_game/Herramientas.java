package balloons_game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Herramientas extends JPanel implements ActionListener{
    
    private JButton btnPausar;
    private JButton btnDibujar;
    private JTextField tiempotxt;
    private Lienzo li;
    
    public Herramientas(){
        btnPausar = new JButton("Pausar Globo");
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
    public void actionPerformed(ActionEvent e) {
        JButton elegido = (JButton) e.getSource();
        
        if(elegido == btnPausar){
            int tiempo = Integer.parseInt("0"+tiempotxt.getText());
            System.out.println(tiempo);
        } else if(elegido == btnDibujar){
            Globo ball= new Globo();
        }
    }
    int x=0;
    int y=0;
    
    public void setLienzo(Lienzo li){
        this.li = li;
    }
    
}
