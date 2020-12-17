
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
public abstract class Objet3D {
    Matiere mat;
    
    public Objet3D(Matiere mat){
        this.mat=mat;
    }
    public abstract double distance(Vector A);
    public abstract Vector coordPlusProche(Vector A);

    public abstract Color getCouleur(Vector A);
    
    
    public Color getCouleur(){
        return mat.getCouleur();
    }
    public double getCoefReflexion(){
        return mat.getCoefReflexion();
    }
    
    public Vector getNormale(Vector A){
        double d=this.distance(A);
        return new Vector(this.distance(A.plus(Vector.dx))-d,
                this.distance(A.plus(Vector.dy))-d,
                this.distance(A.plus(Vector.dz))-d
        ).normalized();
    }
}
