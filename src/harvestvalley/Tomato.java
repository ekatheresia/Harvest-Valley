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
// File : Tomato.java
// Deskripsi : Kelas untuk tanaman tomat, tomat dapat dipanen 2 kali 
// Author : Fanni Ulfani/18214051



public class Tomato extends Crops {
	int waterIndex; //index untuk menghitung jumlah hari tanaman disiram
	int nowaterIndex; //index untuk menghitung jumlah hari tidak disiram
	int harvestIndex; //index untuk menghitung jumlah panen
	
	//Konstruktor
	public Tomato (Point p) {
		super("Tomato", "Regrow", p);
		this.waterIndex=0;
		this.nowaterIndex=0;
		this.harvestIndex=0;
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
			if (this.waterIndex==4) {
				this.setPhase("mature");
				this.waterIndex=0;
			}
			if (this.nowaterIndex==3) {
				this.setPhase("withered");
			}
		}
		if (this.phase=="mature") {
			if (this.waterIndex==3) {
				this.setPhase("harvest");
				this.waterIndex=0;
			}
			if (this.nowaterIndex==3) {
				this.setPhase("withered");
			}
		}
		if (this.phase=="harvest") {
			if (this.waterIndex==6) {
				this.setPhase("withered");
			}
			if (this.nowaterIndex==3) {
				this.setPhase("withered");
			}
		}
		if (this.harvestIndex>2) {
			this.setPhase("withered");
		}
			
	}
	
	//Method untuk memanen tanaman
	public Items harvestCrops(){ //Panggil pakai casting
		this.changeState(false);
		this.harvestIndex++;
		this.setPhase("mature"); //Kembali ke fase tanaman
		Items c = new Items("Tomato", 4, 160);
		return c; //Sekali panen mendapatkan 4 buah tomat
	}
	
}

