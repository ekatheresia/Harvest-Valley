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
// File : Items.java
// Deskripsi : Kelas untuk items 
// Author : Tirza Fidela Bernadus/18214055

public class Items extends Inventory {
	int amount;		//jumlah item
	static int maxamount = 99;	//jumlah item maksimum pada 1 slot inventory
	long price;
	
	//Konstruktor
	public Items(String name, int amount, long price) {
		super(name);
		this.amount = amount;
		this.price = price;
	}
	
	//Setter
	public void setAmount(int i) {
		this.amount = i;
	}
	
	public void setPrice(long pr) {
		this.price = pr;
	}
	
	//Getter
	public int getAmount() {
		return this.amount;
	}
	
	public long getPrice() {
		return this.price = price;
	}
	
	//Method
	public void print() {
		System.out.println("Name	: " + this.getName());
		System.out.println("Amount 	: " + this.getAmount());
		if(this.getState() == true) {
			System.out.println("State	: active");
		} else {
			System.out.println("State	: not active");
		}
		System.out.println("Price	: " + this.getPrice() + " G");
		System.out.println();
	}
}

