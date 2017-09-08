package javafxdragpanzoom.view.views;

import javafxdragpanzoom.statemachines.IHomothetic;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafxdragpanzoom.statemachines.ITranslatable;

/**
 * Classe abstraite décrivant un Pane dont la mise à l'échelle est toujours homothétique
 * @author saporito
 */
public abstract class AbstractHomotheticPane extends Pane implements IHomothetic, ITranslatable {
    
    /** Modèle stockant le facteur de zoom */
    private final DoubleProperty scale = new SimpleDoubleProperty(1.0);
    
    /**
     * accesseur de la property gérant le facteur de zoom
     * @return poignée vers la property gérant le facteur de zoom
     */
    public final DoubleProperty scaleProperty() {
        return scale;
    }
    
    @Override
    public final double getScale() {
        return scale.get();
    }
}
