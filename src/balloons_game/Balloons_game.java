package balloons_game;

import javax.swing.SwingUtilities;

/**
 *
 * @author Marcos Uriel & Luis Santiago & Jorge Fernando
 */
public class Balloons_game {

    public static void main(String[] args) {
         
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Ventana();
            }
            
        });
    }
}