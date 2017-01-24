
package harvestvalley;
// File : Barn.java
// Deskripsi : Kelas untuk barn
// Author : Eka Theresia Kartika Suri/18214055
import java.util.Scanner;

public class Barn extends Bangunan {
    int maxsize = 12;
    Point[] arrayFeeder; //array untuk menyimpan kondisi tempat makan berisi atau tidak
    Point[] arrayPoint;
    Livestock[] arrayLivestock;  //array untuk menyimpan sapi atau domba
    int nAL;
    
    //konstruktor
    public Barn () {
        super ("Barn", (new Point(6,1)), 250, 250, (new Point(7,4)), "south");
        //Letak kotak fodder
        this.arrayFeeder = new Point[maxsize];
        this.arrayFeeder[0] = new Point(215,240);
        this.arrayFeeder[1] = new Point(275,240);
        this.arrayFeeder[2] = new Point(340,240);
        this.arrayFeeder[3] = new Point(410,240);
        this.arrayFeeder[4] = new Point(475,240);
        this.arrayFeeder[5] = new Point(540,240);
        this.arrayFeeder[6] = new Point(215,290);
        this.arrayFeeder[7] = new Point(275,290);
        this.arrayFeeder[8] = new Point(340,290);
        this.arrayFeeder[9] = new Point(410,290);
        this.arrayFeeder[10] = new Point(475,290);
        this.arrayFeeder[11] = new Point(540,290);
        //Instansiasi Array Livestock & posisi
        this.arrayLivestock = new Livestock[12];
        this.arrayPoint = new Point[12];
        this.nAL = -1;
        this.arrayPoint[0] = new Point(40,90);
        this.arrayPoint[1] = new Point(170,90);
        this.arrayPoint[2] = new Point(320,90);
        this.arrayPoint[3] = new Point(445,90);
        this.arrayPoint[4] = new Point(560,90);
        this.arrayPoint[5] = new Point(700,90);
        this.arrayPoint[6] = new Point(50,400);
        this.arrayPoint[7] = new Point(200,400);
        this.arrayPoint[8] = new Point(590,400);
        this.arrayPoint[9] = new Point(720,400);
        this.arrayPoint[10] = new Point(40,240);
        this.arrayPoint[11] = new Point(720, 240);
        /*this.arrayLivestock[2] = new Cow("Marie",this.getPoint(2));
        this.arrayLivestock[3] = new Sheep("Shaun", this.getPoint(3));
        this.arrayLivestock[4] = new Cow("Marie",this.getPoint(4));
        this.arrayLivestock[5] = new Sheep("Shaun", this.getPoint(5));
        this.arrayLivestock[6] = new Cow("Marie",this.getPoint(6));
        this.arrayLivestock[7] = new Sheep("Shaun", this.getPoint(7));
        this.arrayLivestock[8] = new Cow("Marie",this.getPoint(8));
        this.arrayLivestock[9] = new Sheep("Shaun", this.getPoint(9));
        this.arrayLivestock[10] = new Cow("Marie",this.getPoint(10));
        this.arrayLivestock[11] = new Sheep("Shaun", this.getPoint(11));
    */
    }
        
    //setter
    public void setnAL(int nAL) {
		this.nAL = nAL;
	}
	
    public void setLocation(Point p) {
        this.location = p;
    }
    
    public void setPintu (Point door) {
        this.pintu = door;
    }
    
    public void setLivestock(int i, Livestock ls) {
		this.arrayLivestock[i] = ls;
		setnAL(getnAL()+1);
	}
	
    //Getter
    public Point getArrayFeeder(int i) {
		return this.arrayFeeder[i];
	}
    
    public Livestock getLivestock(int i) {
		return this.arrayLivestock[i];
	}
	
	public int getnAL() {
		return this.nAL;
	}
	
   public void setArrayLivestock(int i, Livestock ls) {
        arrayLivestock[i] = ls;
    }
   
   public void setArrayFeeder (int i,Point p) {
       arrayFeeder[i] = p;
   }
   
   public Point getPoint(int i) {
       return this.arrayPoint[i];
   }
   
   //Method beri makan Hewan
   /*public void feedCow() {
		Scanner input = new Scanner(System.in);
		System.out.println("List of Cow");
		int i;
		for (i=0; i<=this.nAL;i++) {
			if (getLivestock(i) instanceof Cow && (getLivestock(i)!=null) && (getLivestock(i).getState()==false)){
					System.out.println("Tes");
					System.out.println( i + " | " + getLivestock(i).getName());					
					System.out.println("Apakah berhasil?");
				}
			}
		System.out.println("Choose cow (insert number) :");
			int chocow = input.nextInt();
			if ((chocow <=0) || (chocow>=getnAL()) || (getLivestock(chocow)==null)) {
					System.out.println("Wrong choice!");
			}
			else {public getArrayPoint(int i) {
	   return this.arrayPoint[i];
	}
				getLivestock(chocow).setState(true);
				System.out.println(getLivestock(chocow).getName() + " already ate.");
			}
	}*/
	public void setDead(int i){
		this.arrayLivestock[i]=null;
		setnAL(getnAL()-1);
	}
}


