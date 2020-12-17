public class Vector{
    public static final Vector dx = new Vector(1E-10,0,0);
    public static final Vector dy = new Vector(0,1E-10,0);
    public static final Vector dz = new Vector(0,0,1E-10);
    
    private double x;
    private double y;
    private double z;
    public Vector(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Vector clone(){
        return new Vector(x,y,z);
    }
    public Vector(Vector v){
        this.x=v.getX();
        this.y=v.getY();
        this.z=v.getZ();
    }
    public Vector plus(Vector v){
        return new Vector(x+v.getX(),y+v.getY(),z+v.getZ());
    }
    public Vector minus(Vector v){
        return new Vector(x-v.getX(),y-v.getY(),z-v.getZ());
    }
    public Vector opposit(){
        return new Vector(-x,-y,-z);
    }
    public double dot(Vector v){
        return x*v.getX()+y*v.getY()+z*v.getZ();
    }
    public Vector cross(Vector v){
        return new Vector(y*v.getZ()-z*v.getY(),z*v.getX()-x*v.getZ(),x*v.getY()-y*v.getX());
    }
    public double norme2(){
        return this.dot(this);
    }
    public double norme(){
        return Math.sqrt(this.norme2());
    }
    public Vector times(double k){
        return new Vector(x*k,y*k,z*k);
    }
    public void normalize(){
        double nor=this.norme();
        x/=nor;
        y/=nor;
        z/=nor;
    }
    public Vector normalized(){
        double nor=this.norme();
        return this.times(1/nor);
    }
    public Vector reflect(Vector normale){
        return this.minus(normale.times(2*this.dot(normale)));
    }
    
    public String toString(){
        return "x:"+x+"\t y:"+y+"\t z:"+z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    
}
