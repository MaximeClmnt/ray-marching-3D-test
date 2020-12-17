
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
public class ShaderClassique implements Shader{
    private static Color couleurCiel;
    private static float minBrightness;
    
    public ShaderClassique(){
        couleurCiel = new Color(220,220,255);
        minBrightness = 0.2f;
    }

    @Override
    public Color calculerCouleur(Scene scene, Ray ray) {
        Color c;
        float[] hsb;
        
        
        if(ray.maxAtteint()){
            c=couleurCiel;
        }
        else{
            //On recupère les paramètres de la surface la plus proche
            Vector coordImpact = ray.getCoordImpact();
            Objet3D objetPlusProche = ray.getObjetPlusProche();
            Vector normaleImpact = objetPlusProche.getNormale(coordImpact);
            c=objetPlusProche.getCouleur(coordImpact);
            hsb=Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
            hsb[2]=minBrightness;
            
            
            Vector lumDirection;
            for(Lumiere lum:scene.getLumieres()){
                lumDirection=lum.getCoord().minus(coordImpact).normalized();
                double dVerticale = new Ray(new Noeud(coordImpact.plus(normaleImpact.times(Ray.longeurSeuil))),lumDirection)
                        .avancer(scene).getLongeurRay();
                if(dVerticale>=Ray.longeurRayMax){
                    double project = normaleImpact.dot(lumDirection);
                    hsb[2]+=Math.max(0, project)*0.8f;
                }
                //double k = ray.getU().reflect(normaleImpact).dot(lumDirection);
                //if(k>0.9)hsb[1]=(float)(1-k)*10;
            }
            
            c=new Color(Color.HSBtoRGB(hsb[0],hsb[1],hsb[2]));
            
            
            if(ray.getNumReflection()<2 && objetPlusProche.getCoefReflexion()>0){
                Color cR = this.calculerCouleur(scene, 
                        new Ray(
                            new Noeud(coordImpact.plus(normaleImpact.times(Ray.longeurSeuil))),
                            ray.getU().reflect(normaleImpact),
                            ray.getNumReflection()+1)
                        .avancer(scene));
                //System.out.println(cR.getRed());
                double coef = objetPlusProche.getCoefReflexion();
                double coef2 = 1-coef;
                c = new Color(
                        (int)((coef*cR.getRed()/255+coef2*hsb[2])*objetPlusProche.getCouleur(coordImpact).getRed()),
                        (int)((coef*cR.getGreen()/255+coef2*hsb[2])*objetPlusProche.getCouleur(coordImpact).getGreen()),
                        (int)((coef*cR.getBlue()/255+coef2*hsb[2])*objetPlusProche.getCouleur(coordImpact).getBlue()));
            }
            
        }
        
        return c;
    }
    
}
