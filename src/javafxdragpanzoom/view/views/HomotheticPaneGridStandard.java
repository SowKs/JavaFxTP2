package javafxdragpanzoom.view.views;

import javafx.geometry.Point2D;

/**
 * Pane homothétique dont la mise à l'échelle est gérée par les méthodes standard de Node
 * @author saporito
 */
public class HomotheticPaneGridStandard extends AbstractHomotheticPaneGrid {

    public HomotheticPaneGridStandard() {
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
        scaleProperty().set(scale);
    }

    @Override
    public void setScale(double scale, double pivotX, double pivotY) {
        // Point de l'objet se trouvant sous le pointeur de la souris (dans le repère local) :
        Point2D pointedInPane = new Point2D(pivotX, pivotY);
        // coord de ce point dans le repère de l'ecran
        Point2D pointedInScreenBeforeScaling = localToScreen(pivotX, pivotY);
        // mise a l'echelle (par rapport au centre de cet ogjet)
        setScale(scale);
        // point de cet objet initialement sus le pointeur souris, dans le repère de l'écran apres mise a l'echelle
        // (a ete deplace pednant la mise a l'echelle puisque celle-ci se fait par rapport au centre de l'objet) :
        Point2D pointedInScreenAfterScaling = localToScreen(pointedInPane);
        // translation pour ramener ce point sous le curseur de la souris :
        setTranslateX(getTranslateX() + pointedInScreenBeforeScaling.getX() - pointedInScreenAfterScaling.getX());
        setTranslateY(getTranslateY() + pointedInScreenBeforeScaling.getY() - pointedInScreenAfterScaling.getY());
    }

    @Override
    public void addScale(double deltaScale, double pivotX, double pivotY) {
        
    }

    @Override
    public void translate(double dx, double dy) {
        setTranslateX(getTranslateX() + dx);
        setTranslateY(getTranslateY() + dy);
    }
}
