
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
public class Ray {
    public static final double pasMax =0.4;
    public static final double longeurRayMax = 40;
    public static final double longeurSeuil = 1E-5;
    
    
    private Noeud source;
    private Vector u;
    private int numReflection;
    
    private Vector coordImpact;
    private double longeurRay;
    private boolean maxAtteint;
    private Objet3D objetPlusProche;
    
    private int procheParois;
    
    
    
    public Ray(Noeud source,double theta,double phi){
        this.source=source;
        u=new Vector(Math.cos(theta)*Math.cos(phi),
                     Math.sin(theta)*Math.cos(phi),
                     Math.sin(phi));
        numReflection=0;
        
        procheParois=0;
    }
    public Ray(Noeud source,Vector direction){
        this.source=source;
        u=direction;
        numReflection=0;
    }public Ray(Noeud source,double theta,double phi,int numReflection){
        this.source=source;
        u=new Vector(Math.cos(theta)*Math.cos(phi),
                     Math.sin(theta)*Math.cos(phi),
                     Math.sin(phi));
        this.numReflection=numReflection;
        
        procheParois=0;
    }
    public Ray(Noeud source,Vector direction,int numReflection){
        this.source=source;
        u=direction;
        this.numReflection=numReflection;
        
        procheParois=0;
    }
    
    public void rotateZ(double angle){
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        u=new Vector(u.getX()*c-u.getY()*s,u.getX()*s+u.getY()*c,u.getZ());
    }
    public void rotateY(double angle){
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        u=new Vector(u.getX()*c+u.getZ()*s,u.getY(),-u.getX()*s+u.getZ()*c);
    }
    
    public Ray avancer(Scene scene){
        Vector tempCoord = source.getCoord().clone();
        double distance = scene.distance(tempCoord);
        longeurRay = 0;
        while(distance >= Ray.longeurSeuil && longeurRay<Ray.longeurRayMax){
            //System.out.println("LongeurRay: "+longeurRay);
            longeurRay+=distance;
            tempCoord=tempCoord.plus(u.times(distance));
            distance = scene.distance(tempCoord);
            //System.out.println("longeurRay: "+longeurRay+"   distance: "+distance+"  x: "+tempCoord.getX());
        }
        if(longeurRay>=Ray.longeurRayMax){
        //  Si on a atteint la longeur max alors
            tempCoord=u.times(Ray.longeurRayMax);
            longeurRay=Ray.longeurRayMax;
            maxAtteint=true;
        }
        
        objetPlusProche=scene.plusProcheObjet(tempCoord);
        coordImpact=tempCoord;
        return this;
    }
    
    public double getUx(){
        return u.getX();
    }
    public double getUy(){
        return u.getY();
    }
    public double getUz(){
        return u.getZ();
    }
    public Vector getU(){
        return u;
    }
    public Vector getCoordImpact(){
        return coordImpact;
    }

    public double getLongeurRay() {
        return longeurRay;
    }

    public Objet3D getObjetPlusProche() {
        return objetPlusProche;
    }
    
    public int getProcheParois(){
        return procheParois;
    }
    
    public int getNumReflection(){
        return numReflection;
    }
    
    public boolean maxAtteint(){
        return maxAtteint;
    }
}
