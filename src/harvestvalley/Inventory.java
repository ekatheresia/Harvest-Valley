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
// File : Inventory.java
// Deskripsi : Kelas untuk inventory 
// Author : Tirza Fidela Bernadus/18214055

public abstract class Inventory {
	String name;				//nama objek
	boolean state;				//status aktif/tidak
	
	//Konstruktor
	public Inventory(String name) {
		this.name = name;
		this.state = false;
	}
	
	//Setter
	public void setState (boolean state) {
		this.state = state;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	//Getter
	public String getName() {
		return this.name;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	//Method
	public abstract void print();
}

