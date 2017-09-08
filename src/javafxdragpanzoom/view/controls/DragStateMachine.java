/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdragpanzoom.view.controls;

import javafxdragpanzoom.statemachines.EventTypes;
import javafxdragpanzoom.statemachines.ITranslatable;
import javafxdragpanzoom.statemachines.States;

/**
 *
 * @author bailleso
 */
public class DragStateMachine {
    private States state = States.IDLE;
    private double oldX = 0.0;
    private double oldY = 0.0;
    
    public void event(EventTypes eventType, double posX, double posY, ITranslatable translatable) {
        
        switch (state) {
            case IDLE :
                switch (eventType) {
                    case PRESSED :
                        saveCoord(posX, posY);
                        state = States.DRAGGING;
                        break;
                    case MOVED :
                        // ne rien faire
                        break;
                    case RELEASED :
                        // impossible
                        break;
                }
                break;
                
            case DRAGGING :
                switch (eventType) {
                    case PRESSED :
                        // interdit
                        break;
                    case MOVED :
                        translate(posX, posY, translatable);
                        state = States.DRAGGING;
                        break;
                    case RELEASED :
                        saveCoord(posX, posY);
                        state = States.IDLE;
                        break;
                }
                break;
                
            default :
                break;
        }
    }
    
    private void saveCoord(double newX, double newY) {
        oldX = newX;
        oldY = newY;
    }
    
    private void translate(double posX, double posY, ITranslatable translatable) {
        translatable.translate(posX - oldX, posY - oldY);
    }
}
