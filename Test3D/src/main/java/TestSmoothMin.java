
import java.awt.Color;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class TestSmoothMin extends Objet3D{
    Objet3D objet1;
    Objet3D objet2;

    public TestSmoothMin(Matiere mat,Objet3D o1,Objet3D o2) {
        super(mat);
        objet1=o1;
        objet2=o2;
    }
    public double distance(Vector A) {
        double k = 64;
        return smoothMin(objet1.distance(A),objet2.distance(A));
        //return -Math.log(Math.exp(-k*objet1.distance(A))+Math.exp(-k*objet2.distance(A)));
    
    }
    
    public double smoothMin(double a, double b){
        
//        double k = 0.2;
//        double delta=Math.max(k-Math.abs(a-b), 0);
//        return(Math.min(a,b)-delta*delta*k/4);

        double k=16;
        return -Math.log(Math.exp(-k*a)+Math.exp(-k*b))/k;
    }
    
    public Vector coordPlusProche(Vector A) {
        //return objet1.coordPlusProche(A).plus(objet2.coordPlusProche(A)).normalized().times(this.distance(A));
        return objet1.coordPlusProche(A);
    }
    
//    public Vector getNormale(Vector A){
//        double d=this.distance(A);
//        return new Vector(d-this.distance(A.plus(Vector.dx)),
//                d-this.distance(A.plus(Vector.dy)),
//                d-this.distance(A.plus(Vector.dz))
//        ).normalized();
//    }

    @Override
    public Color getCouleur(Vector A) {
        Color c1=objet1.getCouleur(A);
        Color c2=objet2.getCouleur(A);
        double d1 = objet1.distance(A);
        double d2 = objet2.distance(A);
        double coef1=((d2-d1)/(d1+d2)+1)/2;//1 si d1=0 , 0 si d2=0
        double coef2=1-coef1;
        
        return new Color((int)(c1.getRed()*coef1+c2.getRed()*coef2),
                (int)(c1.getGreen()*coef1+c2.getGreen()*coef2),
                (int)(c1.getBlue()*coef1+c2.getBlue()*coef2));
    }


    
}
