package javafxdragpanzoom.view.views;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * Classe abstraite décrivant un Pane contenant un rectangle et dont la mise à l'échelle est toujours homothétique 
 * @author saporito
 */
public abstract class AbstractHomotheticPaneRectangle extends AbstractHomotheticPane {

    /**
     * Initialiser le composant et créer le rectangle 
     * (ce constructeur de classe abstraite sera appelé depuis le constructeur de ses réalisations) 
     */
    public AbstractHomotheticPaneRectangle() {
        // Créer le rectangle
        // Option 1 : origine en haut à gauche
        Rectangle rect = new Rectangle(100, 100);
        // Option 2 : origine sur un pivot choisi à l'avance (par exemple centre du composant)
        //Rectangle rect1 = new Rectangle(-50, -50, 100, 100); 
        rect.setStroke(Color.BLUE);
        rect.setStrokeType(StrokeType.INSIDE);
        rect.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.5));
        getChildren().add(rect);
    }
    
}
