package balloons_game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Luis Santiago
 */
public class Ventana extends JFrame{
    
    private Herramientas toolbar;
    private Lienzo li;
    
    public Ventana (){
        super("Juego Globos");
        
        setLayout(new BorderLayout());
        
        toolbar = new Herramientas();
        li = new Lienzo();
        
        toolbar.setLienzo(li);
        
        add(toolbar, BorderLayout.NORTH);
        add(li, BorderLayout.CENTER);
        
        setSize(650,730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
