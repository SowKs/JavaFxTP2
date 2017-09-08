/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdragpanzoom.view.controls;

import javafx.scene.input.ScrollEvent;
import javafxdragpanzoom.view.views.AbstractHomotheticPane;

/**
 *
 * @author bailleso
 */
public class HomotheticPaneZoomManager {
    AbstractHomotheticPane pane;

    public HomotheticPaneZoomManager(AbstractHomotheticPane pane) {
        this.pane = pane;
        
        addHandlerZoom();
    }
    
    private void addHandlerZoom() {
        pane.addEventHandler(ScrollEvent.SCROLL, (event) -> {
            pane.setScale(pane.getScale()*Math.pow(1.005, event.getDeltaY()), event.getX(), event.getY());
        });
    }
}
