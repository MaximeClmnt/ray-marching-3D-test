
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Panel extends JPanel{
    private Scene scene;
    
    public Panel(int width,int height){
        scene=new Scene(width,height);
        scene.cam.setCoord(new Vector(-2,0,3));
        scene.cam.rotateY(Math.PI/6);
        scene.cam.rotateZ(-Math.PI/160);
    }
    
    public void init(){
        //Création de la scene
//        Objet3Dvox obj = new Objet3Dvox();
//        obj.addVoxel(new Voxel(new Noeud(25,-30,0),new Noeud(25,20,15),new Noeud(25,-30,15)));
//        scene.addObjet(obj);

        scene.addLumiere(new Lumiere(0,0,10000));
        //scene.addObjet(new Sphere(new Vector(3.3215,-1.554,2.248),1.5,Matiere.BLEU_BRILLANT));
        //scene.addObjet(new Sphere(new Vector(2.756,1.956,1.371),1.133,Matiere.GRIS));
        //scene.addObjet(new Sphere(new Vector(0.8526,0.8,0.861),1.1,Matiere.MIRROIR));
        //scene.addObjet(new Sphere(new Vector(1.4526,3.8,1.261),0.4,Matiere.ROUGE));
        Objet3D o1 = new Sphere(new Vector(2,0.5,1),0.8,Matiere.VERT);
        Objet3D o2 = new Sphere(new Vector(2,-0.5,1),0.5,Matiere.ROUGE);
        scene.addObjet(o2);
        scene.addObjet(o1);
        //scene.addObjet(new TestSmoothMin(Matiere.VERT_BRILLANT,o1,o2));
        scene.addObjet(new Sol());
        
        
        this.repaint();
//        
//        double theta = 0;
//        while(true){
//            try {
//                theta+=0.01;
//                Thread.sleep(100);
//                double x2=1+0.5*Math.sin(theta);
//                double y2=0.5*Math.cos(theta);
//                double[] coord = {x2,y2,0};
//                n2.setCoord(coord);
//                this.repaint();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
    
    public void paintComponent(Graphics g){
        g.setColor(new Color(0,255,0));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        scene.genererImage(g);
    }
    
}
