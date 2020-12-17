
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Camera extends Noeud{
    private Ray[][] rays;
    private Vector direction;//theta(horizontal par rapport a la direction x),phi(vertical par rapport a l'horizontale >0 haut, <0 bas)
    private Scene scene;
    private int width;
    private int height;
    private Shader shader;
    
    public Camera(Scene scene,int width,int height){
        super(new Vector(0,0,0));
        this.scene=scene;
        this.height=height;
        this.width=width;
        
        shader = new ShaderClassique();
        
        double FOV = 60;
        double pas = 2*Math.tan(FOV/180*Math.PI/2)/height;
        //dangle=0.001;
        direction = new Vector(1,0,0);
        rays=new Ray[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                //System.out.println("y:"+(i-width/2)*pas+"   z:"+(j-height/2)*pas);
                rays[i][j]=new Ray(this,new Vector(1,(i-width/2)*pas,(j-height/2)*pas).normalized());
                //rays[i][j]=new Ray(this,(i-width/2)*dangle,(j-height/2)*dangle);
                //System.out.println(rays[i][j].getUx()+"  "+rays[i][j].getUy()+"   "+rays[i][j].getUz());
            }
            //System.out.println("");
        }
    }
    
    public void rotateZ(double angle){
        
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                rays[i][j].rotateZ(angle);
            }
        }
    }
    
    public void rotateY(double angle){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                rays[i][j].rotateY(angle);
            }
        }
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    void prendrePhoto(Graphics g){
        long time = System.currentTimeMillis();
        for(int i=0 ; i<width ; i++){
            for(int j=0 ; j<height ; j++){
                rays[i][j].avancer(scene);
                g.setColor(shader.calculerCouleur(scene,rays[i][j]));
                g.drawLine(i, height-j-1, i, height-j-1);
            }
        }
        System.out.println("Temps de calcul:"+(double)(System.currentTimeMillis()-time)/1000+"s");
    }
    
    
    
}
