
package harvestvalley;
// File : Bangunan.java
// Deskripsi : Kelas untuk bangunan
// Author : Eka Theresia Kartika Suri/18214012

public abstract class Bangunan {
    String name;    	//nama bangunan
    double width;   	//lebar bangunan
    double length;  	//panjang bangunan
    Point location;    	//titik ujung kiri atas
    String arah;    	//arah pintu bangunan
    Point pintu;    	//titik koordinat pintu
 
    //konstruktor
    public Bangunan (String name, Point location, double width, double length, Point pintu, String arah) {
        this.name = name;
        this.location = location;
        this.length = length;
        this.width = width;
        this.pintu = pintu;
        this.arah = arah;
    }
    
    //Setter
    public void setName (String name) {
        this.name = name;
    }
    
    public void setLength (double length) {
        this.length = length;
    }
    
    public void setWidth (double width) {
        this.width = width;
    }
    
    public void setArah (String arah) {
        this.arah = arah;
    }
    
    public void setLocation (Point p) {
        this.location = p;
    }
    
    public void setPintu (Point door) {
        this.pintu = door;
    }
    // Getter
    public String getName() {
        return this.name;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public double getLength() {
        return this.length;
    }
    
    public String getArah() {
        return this.arah;
    }
    
    public Point getLocation() {
	return this.location;
    }
	
    public Point getPintu() {
	return this.pintu;
    }
	
     //methods
    public void print() {
		System.out.println ("++++ " +this.name+ " Information ++++");
		System.out.println ("Door location   : (" + this.pintu.getX() + " , " + this.pintu.getY() + ")");
		System.out.println ("Door navigation : " +this.arah);
		System.out.println();
    }
}
