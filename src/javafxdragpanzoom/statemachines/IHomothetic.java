package javafxdragpanzoom.statemachines;

/**
 * Interface décrivant un objet dont la mise à l'échelle est toujours homothétique
 * @author saporito
 */
public interface IHomothetic {

    /**
     * Obtenir le facteur de zoom
     * @return facteur d'échelle
     */
    public abstract double getScale();

    /**
     * Fixer le facteur de zoom
     * @param scale facteur de zoom
     */
    public abstract void setScale(double scale);

    /**
     * Fixer le facteur de zoom
     * @param scale facteur de zoom
     * @param pivotX abscisse du centre de zoom
     * @param pivotY ordonnée du centre de zoom
     */
    public abstract void setScale(double scale, double pivotX, double pivotY);

    /**
     * Appliquer une mise à l'échelle supplémentaire
     *
     * @param deltaScale facteur de zoom supplémentaire à appliquer
     * @param pivotX abscisse du centre de zoom
     * @param pivotY ordonnée du centre de zoom
     */
    public void addScale(double deltaScale, double pivotX, double pivotY);
}
