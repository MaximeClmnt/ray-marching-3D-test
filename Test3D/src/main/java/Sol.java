
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
public class Sol extends Objet3D{
    public Sol(){
        super(Matiere.SOL);
    }
    
    @Override
    public Color getCouleur(Vector A){
        Color[] couleurs = {new Color(Color.HSBtoRGB(0, 0, 1)),new Color(Color.HSBtoRGB(0.58f, 1f, 1f))};
        return couleurs[(int)Math.abs(Math.floor(A.getX())+Math.floor(A.getY()))%2];
    }

    @Override
    public double distance(Vector A) {
        return Math.abs(A.getZ());
    }

    @Override
    public Vector coordPlusProche(Vector A) {
        return new Vector(A.getX(),A.getY(),0);
    }
    
}
