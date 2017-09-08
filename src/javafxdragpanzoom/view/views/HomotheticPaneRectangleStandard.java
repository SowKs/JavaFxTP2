package javafxdragpanzoom.view.views;

/**
 * Pane contenant un rectangle et dont la mise à l'échelle, toujours homothétique, est gérée par les méthodes standard de Node
 * @author saporito
 */
public class HomotheticPaneRectangleStandard extends AbstractHomotheticPaneRectangle {

    public HomotheticPaneRectangleStandard() {
        super();
        // La seule chose à faire ici est de lier le mécanisme de mise à l'échelle
        // lié au choix d'implémentation (les méthodes standard setScaleX...)
        // au mécanisme de gestion de la mise à l'échelle homothétique 
        // et au modèle issus d'AbstractHomotheticPane.
        // Toutes les transformations se feront ensuite directement sur le modèle 
        // via les méthodes setScale(...) réalisées dans cette classe.
        scaleXProperty().bind(scaleProperty());
        scaleYProperty().bind(scaleProperty());
    }

    @Override
    public void setScale(double scale) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setScale(double scale, double pivotX, double pivotY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addScale(double deltaScale, double pivotX, double pivotY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void translate(double dx, double dy) {
        setTranslateX(getTranslateX() + dx);
        setTranslateY(getTranslateY() + dy);
    }
    
}
