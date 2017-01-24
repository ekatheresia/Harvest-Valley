package harvestvalley;
// File : Bangunan.java
// Deskripsi : Kelas untuk bangunan
// Author : Eka Theresia Kartika Suri/18214055

public class Coop extends Bangunan {
    int maxsize = 8;
    Point[] arrayFeeder;
    Chicken[] arrayChicken;
    int nAC;
    Point[] arrayPoint;
    
    //konstruktor
    public Coop () {
        super ("Coop", (new Point(21,1)), 10, 3, (new Point(13,4)), "south");
        this.arrayFeeder = new Point[maxsize];
        this.arrayChicken = new Chicken[maxsize];
        this.arrayPoint = new Point[8];
        this.nAC = -1;
        this.arrayFeeder[0] = new Point(105,320);
        this.arrayFeeder[1] = new Point(175,320);
        this.arrayFeeder[2] = new Point(245,320);
        this.arrayFeeder[3] = new Point(315,320);
        this.arrayFeeder[4] = new Point(385,320);
        this.arrayFeeder[5] = new Point(445,320);
        this.arrayFeeder[6] = new Point(515,320);
        this.arrayFeeder[7] = new Point(585,320);
        this.arrayPoint[0] = new Point(45,180);
        this.arrayPoint[1] = new Point(140,180);
        this.arrayPoint[2] = new Point(220,180);
        this.arrayPoint[3] = new Point(295,180);
        this.arrayPoint[4] = new Point(390,180);
        this.arrayPoint[5] = new Point(475,180);
        this.arrayPoint[6] = new Point(555,180);
        this.arrayPoint[7] = new Point(630, 180);
        /*this.arrayChicken[1] = new Chicken("Siwon",this.getPoint(1));
        this.arrayChicken[2] = new Chicken("Siwon",this.getPoint(2));
        this.arrayChicken[3] = new Chicken("Siwon",this.getPoint(3));
        this.arrayChicken[4] = new Chicken("Siwon",this.getPoint(4));
        this.arrayChicken[5] = new Chicken("Siwon",this.getPoint(5));
        this.arrayChicken[6] = new Chicken("Siwon",this.getPoint(6));
        this.arrayChicken[7] = new Chicken("Siwon",this.getPoint(7)); */
    }
    
    //setter
    public void setLocation(Point p) {
        this.location = p;
    }
    
    public void setPintu (Point door) {
        this.pintu = door;
    }
	
	public void setnAC(int nAC) {
		this.nAC=nAC;
	}
   
	//Getter
	public int getnAC() {
	   return this.nAC;
	} 
	
	public void setArrayFeeder (int i, Point p) {
            arrayFeeder[i] = p;
	}
	
	public Chicken getChicken(int i) {
		return arrayChicken[i];
	}
        
        public Point getArrayFeeder(int i) {
            return this.arrayFeeder[i];
        }
   
   public void setChicken(int i, Chicken c) {
	   this.arrayChicken[i] = c;
	   setnAC(getnAC()+1);
	}
	
	public void setDead(int i){
		this.arrayChicken[i]=null;
		setnAC(getnAC()-1);
	}
	
	public void setArrayChicken(int i, Chicken c) {
		arrayChicken[i]=c;
	}
	
	public Point getPoint(int i) {
	   return this.arrayPoint[i];
	}
}
