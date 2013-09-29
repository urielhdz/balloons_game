package Xbox;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

/**
 * @author Luis Santiago
 */
public class XboxController implements Runnable{
    
    private RightAxisListener rightAxis;
    private TriggersListener triggers;
    private ButtonListener buttons;
    
    static Controller controller;
    public static boolean Start;
    
    public XboxController(){
        
        try {
            Controllers.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(XboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0; i< Controllers.getControllerCount();i++){
            controller = Controllers.getController(i);
            System.out.println(controller.getName() + "  "+i);
        }
        
        controller = Controllers.getController(0);
        controller.setDeadZone(0, (float) 0.3);
        controller.setDeadZone(1, (float) 0.3);
        controller.setDeadZone(4, (float) 0.4);
    }
    
    public void addRightAxisListener(RightAxisListener rightAxis){
        this.rightAxis = rightAxis;
    }
    
    public void addTriggersListener(TriggersListener triggers){
        this.triggers = triggers;
    }
    
    public void addButtonListener(ButtonListener buttonPress){
        this.buttons = buttonPress;
    }
    
    public void run(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(XboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){
            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(XboxController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Start = controller.isButtonPressed(7);
            
            if(controller != null){
                controller.poll();
                if(controller.getAxisValue(0)!=0){
                    this.rightAxis.rightAxisMoveVertical(controller.getAxisValue(0));
                    //System.out.print("Valor del Axis 0 :"+controller.getAxisValue(0) +"\n");
                }
                if(controller.getAxisValue(1)!= 0){
                    this.rightAxis.rightAxisMoveHorizontal(controller.getAxisValue(1));
                    //System.out.print("   Valor del Axis 1 : "+controller.getAxisValue(1)+"\n");
                }
                if(controller.getAxisValue(4)>0 && controller.getAxisValue(4)!=-1){
                    this.triggers.rightTriggerPressed(true);
                    
                }else if(controller.getAxisValue(4)< 0&&controller.getAxisValue(4)!=-1){
                    this.triggers.leftTriggerPressed(true);
                }
                
                if(controller.isButtonPressed(0))
                    buttons.aButtonPressed();
                if(controller.isButtonPressed(1))
                    buttons.bButtonPressed();
                if(controller.isButtonPressed(2))
                    buttons.xButtonPressed();
                if(controller.isButtonPressed(3))
                    buttons.yButtonPressed();
                if(controller.isButtonPressed(4))
                    buttons.lbButtonPressed();
                if(controller.isButtonPressed(5))
                    buttons.rbButtonPressed();
                if(controller.isButtonPressed(6))
                    buttons.backButtonPressed();
                if(controller.isButtonPressed(7))
                    buttons.startButtonPressed();
                if(controller.isButtonPressed(8))
                    buttons.leftStickButtonPressed();
                if(controller.isButtonPressed(9))
                    buttons.rightStickButtonPressed();
                
            }
            /*
            System.out.print(controller.getAxisValue(0) + "  :  ");
            System.out.print(controller.getAxisValue(1)+ "  :  ");
            System.out.print(controller.getAxisValue(2)+ "  :  ");
            System.out.print(controller.getAxisValue(3)+ "  :  ");
            System.out.print(controller.getAxisValue(4)+ "\n");*/
            
        }
    }
}
