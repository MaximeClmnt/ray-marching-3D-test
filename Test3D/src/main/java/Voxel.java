/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Voxel {
    //crée un triangle a b c orienté dans l'espace
    private Noeud a,b,c;
    private Vector ab,bc,ca;
    private Vector normale;
    public Voxel(Noeud a, Noeud b, Noeud c){
        this.a=a;
        this.b=b;
        this.c=c;
        ab=b.getCoord().minus(a.getCoord());
        bc=c.getCoord().minus(b.getCoord());
        ca=a.getCoord().minus(c.getCoord());
        normale = ab.cross(ca).opposit();
    }
    public Noeud[] getNoeuds() {
        return new Noeud[]{a,b,c};
    }
    
    private double clamp(double value,double min, double max){
        return Math.min(Math.max(value, min),max);
    }
    
    public double distance2(Vector A) {
        double d2;
        Vector aA = A.minus(a.getCoord());
        Vector bA = A.minus(b.getCoord());
        Vector cA = A.minus(c.getCoord());
        
        
        //test interieur/exterieur
        if(Math.signum(normale.dot(ab.cross(aA)))+Math.signum(normale.dot(bc.cross(bA)))+Math.signum(normale.dot(ca.cross(cA)))<2){
            d2=Math.min(Math.min(
                    aA.minus(ab.times(clamp(ab.dot(aA)/ab.norme2(),0,1))).norme2()  , //distance au segment ab
                    aA.minus(bc.times(clamp(bc.dot(bA)/bc.norme2(),0,1))).norme2()  ),//distance au segment bc
                    aA.minus(ca.times(clamp(ca.dot(cA)/ca.norme2(),0,1))).norme2()  );//distance au segment ca
        }
        else{//distance au plan (longeur du projeté sur la normale)
            double proj = normale.dot(aA);
            d2=proj*proj/normale.norme2();
        }
        return d2;
    }
    
}
