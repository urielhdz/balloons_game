/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package balloons_game;

import javax.swing.SwingUtilities;

/**
 *  
 * @author Uriel
 */
public class Balloons_game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Ventana();
            }
            
        });
    }
}
