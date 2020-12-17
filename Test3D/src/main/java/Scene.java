
import java.awt.Graphics;
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
public class Scene {
    private ArrayList<Objet3D> objets;
    private ArrayList<Lumiere> lumieres;
    public Camera cam;
    public Scene(int width,int height){
        objets = new ArrayList();
        lumieres = new ArrayList();
        cam = new Camera(this,width,height);
    }
    
    public void addObjet(Objet3D obj){
        objets.add(obj);
        //System.out.println("Ajout d'un objet");
    }

    public ArrayList<Objet3D> getObjets() {
        return objets;
    }
    
    public void addLumiere(Lumiere lum){
        lumieres.add(lum);
    }
    
    public ArrayList<Lumiere> getLumieres(){
        return lumieres;
    }

    public void genererImage(Graphics g) {
        cam.prendrePhoto(g);
    }
    

    public double distance(Vector A) {
        double dmin = Ray.longeurRayMax;//distance du plus proche obstacle
        double d;
        for(Objet3D obj:objets){
                d=obj.distance(A);
            if(d<dmin){
                dmin=d;
            }
        }
        return dmin;
    }
    
    public Objet3D plusProcheObjet(Vector A){
        double dmin = Ray.longeurRayMax;//distance du plus proche obstacle
        Objet3D plusProche = objets.get(0);
        double d;
        for(Objet3D obj:objets){
                d=obj.distance(A);
            if(d<dmin){
                dmin=d;
                plusProche = obj;
            }
        }
        return plusProche;
    }
    
}
