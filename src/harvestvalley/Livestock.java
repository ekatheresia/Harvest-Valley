
package harvestvalley;
// File : Livestock.java
// Deskripsi : Kelas untuk hewan ternak 
// Author : Siti Aisyah/18214042

import java.util.Scanner;

public abstract class Livestock {
	String name; 		//nama hewan
	Point location; 	//lokasi
	String kind; 		//jenis hewan
	String state; 		//status diberi makan/tidak
	boolean isReady;
	Scanner input = new Scanner(System.in);
	int noFeed;//menghitung berapa hari tidak diberi makan
	int feed;//menghitung hari diberi makan
	int day;//hari dia hidup
	
	//Konstruktor
	public Livestock(String name, Point loc, String kind) {
		this.name = name;
		this.location = loc;
		this.kind = kind;
		this.state = "starving";
		this.day=0;
		this.feed=0;
		this.noFeed=0;
                this.isReady = true;
	}
	
	//Getter
	public String getName() {
		return this.name;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	public String getState() {
		return this.state;
	}
	
	public boolean getReady() {
		return this.isReady;
	}
	
	//Setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLocation(Point p) {
		this.location = p;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
        public void setKind(String kind) {
            this.kind = kind;
        }
        
	//Method
	public void changeReady(boolean ready) {
		this.isReady = ready;
	}
	
	//Method untuk menghitung jumlah hari hewan diberi makan/tidak
	public void countDays(Time time) {
			if (this.state=="alive") {
				feed++;
				noFeed=0;
				this.changeReady(true);
			}
			else {
				noFeed++;
			}
	}
	
	//menghitung hari sapi tidak diberi makan
	public void condition(){
		if (this.state=="alive") {
			if (this.noFeed==1) {
				this.setState("starving");
			}
		}
		if (this.state=="starving") {
			if(this.noFeed >= 4) {
				this.setState("dead");
			}
		}
	}
	
	//Method untuk mengambil produk
	public abstract Items getProduct();
	
	public void printLocation() {
		System.out.println("(" + this.location.getX() + " , " + this.location.getY() + ")");
	}
	
	public boolean checkLocation(double x, double y) {
		if ((x >= 1 &&  x <= 14 && y >= 1 && y <=4) || (x >= 1 &&  x <= 21 && y >= 7 && y <=27)) {	//Lokasi building & fields
			return false;
		} else
			return true;
	}
		
	public void moveTo(Point p) {
		if (this.checkLocation(p.getX(),p.getY())==false){
			System.out.println("Cannot move to new location!");
		} else {
			setLocation(p);
			System.out.println(this.getName() + " has been moved to (" + location.getX() + " , " + location.getY() + ")");
		}
	}
	public boolean checkReady() {
		return this.isReady;
	}
		
	public void printDetails() {
		System.out.println("Name	: " + this.getName());
		System.out.println("Kind	: " + this.getKind());
		System.out.println("State	: " + this.getState());
		if(this.getReady() == true) {
			System.out.println("Ready to produce");;
		} else {
			System.out.println("Cannot produce");
		}
		System.out.print("Location: ");
		printLocation();
	}
}
