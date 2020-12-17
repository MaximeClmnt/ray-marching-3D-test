
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
public enum Matiere {
    GRIS(Color.GRAY,0),
    SOL(null,0),
    MIRROIR(Color.WHITE,1),
    BLEU_BRILLANT(new Color(100,100,200),0.5),
    VERT_BRILLANT(new Color(10,255,10),0.8),
    ROUGE_BRILLANT(new Color(255,100,100),0.5),
    BLEU(new Color(100,100,255),0.2),
    VERT(new Color(100,255,100),0.2),
    ROUGE(new Color(255,0,0),0.2);
    
    
    private Color couleur;
    private double coefReflexion;
    
    private Matiere(Color c,double coef){
        this.couleur=c;
        this.coefReflexion=coef;
    }
    
    public Color getCouleur(){
        return couleur;
    }
    
    public double getCoefReflexion(){
        return coefReflexion;
    }
}
