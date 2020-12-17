
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
public class Lumiere extends Noeud{
    private Color couleur;
    private double intensite;
    private double rayon;
    public Lumiere(Vector coord){
        super(coord);
    }
    
    public Lumiere(double x, double y , double z){
        super(x,y,z);
    }
    
}
