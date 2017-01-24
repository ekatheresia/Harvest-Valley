/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harvestvalley;

/**
 *
 * @author Fanni
 */
// File : Crops.java
// Deskripsi : Kelas untuk tanaman 
// Author : Fanni Ulfani/18214051


public abstract class Crops {
	String name;    // nama tanaman
	String phase;   // fase
	String variety; // sekali panen/panen berkali-kali
	boolean state;  // disiram/tidak
	Point location; // lokasi dari tanaman
	//Asumsi tanaman yang dalam fase panen jika tidak dipanen dalam jumlah hari yg ditentukan akan layu
	
	//Konstruktor
	public Crops (String name, String variety, Point location) {
		this.variety= variety;
		this.name = name;
		this.phase = "seed"; //default seed
		this.state = false; //default tidak disiram
		this.location = location;
	}
	
	//Setter
	public void setName(String name) {
            this.name = name;
        }
        
        public void setPhase (String phase) {
		this.phase = phase;
	}
	
	public void setState (boolean state) {
		this.state = state;
	}
	
	public void setLocation (Point p) {
		this.location = p;
	}
	
        public void setVariety(String var) {
            this.variety = var;
        }
	//Getter
	public String getName() {
		return this.name;
	}
	
	public String getVariety() {
		return this.variety;
	}
	
	public String getPhase() {
		return this.phase;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	public Point getLocation() {
		return this.location;
	} 
	
	//Method
	public void printLocation() {
		if(this.location != null) {
			System.out.println("(" + this.location.getX() + " , " + this.location.getY() + ")");
		} else
			System.out.println("Cannot display location");
    }
	
	//Method untuk mengganti status ketika tanaman disiram, hasil interaksi dengan penyiram tanaman
	public void changeState(boolean state){
		setState(state);
	}
	
	public void printDetails() {
		System.out.println("Name	: " + this.getName());
		System.out.println("Variety	: " + this.getVariety());
		System.out.println("Phase	: " + this.getPhase());
		System.out.println("State	: " + this.getState());
		System.out.print("Location: ");
		printLocation();
	}	
	//Method untuk menghitung jumlah hari tanaman disiram/tidak disiram
	public abstract void countDays(Time time);
	
	//Method untuk merubah fase tanaman seed->mature->harvest->withered
	public abstract void changePhase();
	
	//Method untuk memanen tanaman
	public abstract Items harvestCrops();
	
}
