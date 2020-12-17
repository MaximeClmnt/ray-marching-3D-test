
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Sphere extends Objet3D{
    private Vector centre;
    private double rayon;
    public Sphere(Vector centre, double rayon){
        super(Matiere.GRIS);
        this.centre=centre;
        this.rayon=rayon;
    }
    public Sphere(Vector centre, double rayon,Matiere mat){
        super(mat);
        this.centre=centre;
        this.rayon=rayon;
    }
    
    @Override
    public double distance(Vector A) {
        return A.minus(centre).norme()-rayon;
    }

    @Override
    public Vector coordPlusProche(Vector A) {
        return centre.plus(A.minus(centre).normalized().times(rayon));
    }

    @Override
    public Color getCouleur(Vector A) {
        return this.getCouleur();
    }
    
}
