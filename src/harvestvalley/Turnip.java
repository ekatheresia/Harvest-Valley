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
// File : Turnip.java
// Deskripsi : Kelas untuk tanaman lobak 
// Author : Fanni Ulfani/18214051



public class Turnip extends Crops {
	int waterIndex; //index untuk menghitung jumlah hari tanaman disiram
	int nowaterIndex; //index untuk menghitung jumlah hari tidak disiram
	
	//Konstruktor
	public Turnip (Point p) {
		super("Turnip", "OneTime", p);
		this.waterIndex=0;
		this.nowaterIndex=0;
	}
	
	//Method
	//Method untuk menghitung jumlah hari tanaman disiram/tidak disiram
	public void countDays(Time time) {
		if (this.state==true) {
			waterIndex++;
			nowaterIndex=0;
		}
		else {
			nowaterIndex++;
		}
	}
	
	//Method untuk merubah fase tanaman seed->mature->harvest->withered
	public void changePhase() {
		if (this.phase=="seed") {
			if (this.waterIndex==3) {
				this.setPhase("mature");
				this.waterIndex=0;
			}
			if (this.nowaterIndex==3) {
				this.setPhase("withered");
			}
		}
		if (this.phase=="mature") {
			if (this.waterIndex==1) {
				this.setPhase("harvest");
				this.waterIndex=0;
			}
			if (this.nowaterIndex==3) {
				this.setPhase("withered");
			}
		}
		if (this.phase=="harvest") {
			if (this.waterIndex==5) {
				this.setPhase("withered");
			}
			if (this.nowaterIndex==3) {
				this.setPhase("withered");
			}
		}
	}
	
	//Method untuk memanen tanaman
	public Items harvestCrops(){ //Panggil pakai casting
		this.setPhase("withered");
		Items c = new Items("Turnip", 1, 350);
		return c; 
	}
	
}

