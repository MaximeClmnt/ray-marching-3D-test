/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Noeud{
    private Vector coord; //[x,y,z]
    //ajouter une liste de voxel pour recalculer la normale et tt en cas de besoins
    
    public Noeud(double x, double y, double z){
        coord = new Vector(x,y,z);
    }
    public Noeud(Vector coordonees){
        coord = coordonees;
    }
    
    
    public void moove(Vector deltaCoord){
        this.coord=this.coord.plus(deltaCoord);
    }

    public Vector getCoord() {
        return coord;
    }

    public void setCoord(Vector coord) {
        this.coord = coord;
    }
    
}
