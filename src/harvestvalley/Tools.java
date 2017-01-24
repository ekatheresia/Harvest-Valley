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
// File : Tools.java
// Deskripsi : Kelas untuk tools 
// Terdapat beberapa objek turunan tools misal : sickle, milker, clippers, watering can, hoe
// Author : Tirza Fidela Bernadus/18214055

public class Tools extends Inventory {
	//Konstruktor
	public Tools(String name) {
		super(name);
	}
	
	//Method
	public void print() {
		System.out.println("Name	: " + this.getName());
		if(this.getState() == true) {
			System.out.println("State	: active");
		} else {
			System.out.println("State	: not active");
		}
		System.out.println();
	}
}

