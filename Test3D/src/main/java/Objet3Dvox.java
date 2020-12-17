
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
public class Objet3Dvox extends Objet3D{
    private ArrayList<Voxel> voxels;
    
    public Objet3Dvox(){
        super(Matiere.GRIS);
        voxels = new ArrayList();
    }
    public Objet3Dvox(Matiere mat){
        super(mat);
        voxels = new ArrayList();
    }
    
    public void addVoxel(Voxel vox){
        voxels.add(vox);
    }

    public ArrayList<Voxel> getVoxels() {
        return voxels;
    }

    public void setVoxels(ArrayList<Voxel> voxels) {
        this.voxels = voxels;
    }
    
    public double distance2(Vector A){
        double d2min = Ray.longeurRayMax*Ray.longeurRayMax;//distance du plus proche obstacle
        double d2;
        for(Voxel vox:voxels){
                d2=vox.distance2(A);
            if(d2<d2min){
                d2min=d2;
            }
        }
        //System.out.println(dmin);
        return d2min;
    }
    @Override
    public double distance(Vector A){
        return Math.sqrt(distance2(A));
    }

    @Override
    public Vector coordPlusProche(Vector A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getCouleur(Vector A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
