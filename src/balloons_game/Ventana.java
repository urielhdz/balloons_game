package balloons_game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Luis Santiago
 */
public class Ventana extends JFrame{
    
    private Herramientas toolbar;
    private Juego li;
    
    public Ventana (){
        super("Juego Globos");
        
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        setLayout(new BorderLayout());
        
        toolbar = new Herramientas();
        li = new Juego();
        li.setBounds(0,0, 570, 370);
        
        
        add(toolbar, BorderLayout.NORTH);
        add(li, BorderLayout.CENTER);
        
        setSize(650,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        toolbar.setLienzo(li);
        setVisible(true);
        
    }
    
}
