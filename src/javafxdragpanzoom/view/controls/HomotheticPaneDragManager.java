/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdragpanzoom.view.controls;

import javafx.scene.input.MouseEvent;
import javafxdragpanzoom.statemachines.EventTypes;
import javafxdragpanzoom.view.views.AbstractHomotheticPane;

/**
 *
 * @author bailleso
 */
public class HomotheticPaneDragManager {
    private AbstractHomotheticPane pane;
    private DragStateMachine dragStateMachine;

    public HomotheticPaneDragManager(AbstractHomotheticPane pane, DragStateMachine dragStateMachine) {
        this.pane = pane;
        this.dragStateMachine = dragStateMachine;
        
        addHandler();
    }
    
    private void addHandler() {
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, (event) -> {
            dragStateMachine.event(EventTypes.PRESSED, event.getX(), event.getY(), pane);
            event.consume();
        });
        
        pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, (event) -> {
            dragStateMachine.event(EventTypes.MOVED, event.getX(), event.getY(), pane);
            event.consume();
        });
        
        pane.addEventHandler(MouseEvent.MOUSE_RELEASED, (event) -> {
            dragStateMachine.event(EventTypes.RELEASED, event.getX(), event.getY(), pane);
            event.consume();
        });
    }
}
