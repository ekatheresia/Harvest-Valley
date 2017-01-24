
package harvestvalley;
// File : Player.java
// Deskripsi : Kelas untuk pemain
// Author : Eka Theresia K.S/18214055 & Tirza Fidela B/18214055

import java.util.Scanner;

public class Player {
    String name; 				//nama pemain 
    long gold; 					//gold yang dimiliki pemain
    Point location; 			//titik koordinat pemain
    String navigation;			//arah hadap pemain
    int maxsize = 12;			//jumlah maksimum tabel inventory
    int nAI;					//jumlah array inventory yang terisi					
    Inventory[] arrayInventory;
    Point[] arrayPoint;
    Scanner input = new Scanner(System.in);
    
    //Konstruktor
    public Player (String name, long gold, String navigation) {
        this.name = name;
        this.gold = gold;
        location = new Point(400,400);
        this.navigation = navigation;     
		//mengisi inventory dengan tools default
		arrayInventory = new Inventory[maxsize];
		arrayInventory[0] = new Tools("Hoe");
		arrayInventory[1] = new Tools("Sickle");
		arrayInventory[2] = new Tools("Watering Can");
		arrayInventory[3] = new Tools("Milker");
		arrayInventory[4] = new Tools("Clipper");
		/*arrayInventory[5] = new Items("Turnip seed", 3, 210);
		arrayInventory[6] = new Items("Fodder", 10, 120);
                arrayInventory[7] = new Items("Milk", 2, 240);
		arrayInventory[8] = new Items("Egg", 3, 210);
		arrayInventory[9] = new Items("Tomato Seed", 3, 120); */
                nAI = 4;
        //Buat GUI
        arrayPoint = new Point[12];
        arrayPoint[0] = new Point(30, 120);
        arrayPoint[1] = new Point(150, 120);
        arrayPoint[2] = new Point(280, 120);
        arrayPoint[3] = new Point(45, 240);
        arrayPoint[4] = new Point(165, 240);
        arrayPoint[5] = new Point(280, 230);
        arrayPoint[6] = new Point(50, 360);
        arrayPoint[7] = new Point(150, 340);
        arrayPoint[8] = new Point(280, 340);
        arrayPoint[9] = new Point(30, 440);
        arrayPoint[10] = new Point(150, 440);
        arrayPoint[11] = new Point(280, 440);
    }
    
    //setter
    public void setName(String name){
        this.name = name;
    }
    
    public void setnAI(int i) {
		this.nAI = i;
	}
    
    public void setGold(long gold){
        this.gold = gold;
    }
    
    public void setLocation(double x, double y){
        this.location.setX(x);
        this.location.setY(y);
    }
    
    public void setNavigation (String navigation) {
        this.navigation = navigation;
    }
    
    public void setInventory(int i, Inventory items) {
		this.arrayInventory[i] = items;
	}
	
    public void setInvent(int i, Items items) {
		this.arrayInventory[i+1]= items;
		setnAI(getnAI()+1);
	}
    
    //getter
    public String getName() {
        return this.name;
    }
    
    public long getGold() {
        return this.gold;
    }
    
    public Point getLocation() {
        return this.location;
    }
    
    public String getNavigation() {
        return this.navigation;
    }
    
    public Point getPoint(int i) {
       return this.arrayPoint[i];
   }
    
    public int getnAI() {
		return this.nAI;
	}
	
	public Inventory getInvent(int i) {
		return this.arrayInventory[i];
	}
/*	
    //Methods
    public boolean checkChickenfeed(Coop c) {
		boolean found = false;
		for (int i=0;i<=this.getnAI();i++) {
			if(getInvent(i) != null && getInvent(i).getName() == "Chicken feed") {
				if(((Items)getInvent(i)).getAmount() >= c.getnAC()) {
					found = true;
				} 
			}
		}
		return found;
	}
	
	public boolean checkFodder(Barn b) {
		boolean found = false;
		for (int i=0;i<=this.getnAI();i++) {
			if(getInvent(i) != null && getInvent(i).getName() == "Fodder") {
				if(((Items)getInvent(i)).getAmount() >= b.getnAL()) {
					found = true;
				} 
			}
		}
		return found;
	}
	*/
	//Method untuk mengurangi jumlah items pada inventory
	public void minusAmount(int i, int am) {
		if (am>((Items) getInvent(i)).getAmount()) {
			System.out.println("You don't have enough items");
		} else {
			((Items) getInvent(i)).setAmount(((Items) getInvent(i)).getAmount()-am);
			if (((Items) getInvent(i)).getAmount() == 0 ) {
				setInventory(i, null);
			}
		}
	}
	
	//Method untuk menambah jumlah items pada inventory
	public void plusAmount(int i, int am) {
		((Items) getInvent(i)).setAmount(((Items) getInvent(i)).getAmount()+am);
		if (((Items) getInvent(i)).getAmount() >= 99 ) {
			System.out.println("This item has reached maximum amount");
		}
	}
	
    public void printLocation() {
		System.out.println("(" + this.location.getX() + " , " + this.location.getY() + ")");
    }
    
    public boolean checkIFOBuilding(int i) {
		if(this.getNavigation() == "north") {
			if (i==1) {
				return (location.getX() == 2 && location.getY() == 5);		//mengecek lokasi player, mengembalikan true jika berada di depan pintu rumah
			} else if (i==2) {
				return (location.getX() == 7 && location.getY() == 5);		//mengecek lokasi player, mengembalikan true jika berada jika di depan pintu barn
			} else if (i==3) {
				return (location.getX() == 13 && location.getY() == 5);		//mengecek lokasi player, mengembalikan true jika beradajika di depan pintu coop
			} else {
				return false;
			}
		} else
			return false;
	}
		
    public void print() {
        System.out.println ("Hello, " + this.name);
        System.out.println ("Below is your self information : ");
        System.out.println ("Gold : " + this.gold + " G");
        System.out.println ("Location : ");
        printLocation();
        System.out.println ("Navigation : " + this.navigation);
        System.out.println();
    }
    
    public void useTools() {
		int i;
		for (i=0;i<=getnAI();i++) {
			if ((arrayInventory[i]) instanceof Tools) {
				System.out.print(i + " ");
				arrayInventory[i].print();
				arrayInventory[i].setState(false);
			}
		}
		System.out.println("Choose tools number : ");
		int pil1 = input.nextInt();
		arrayInventory[pil1].setState(true);
		System.out.println(arrayInventory[pil1].getName() + " activated!"); 
	}
    public void setActive(int i){
        for(int a=0;a<=this.getnAI();a++) {
            getInvent(a).setState(false);
        }
        arrayInventory[i].setState(true);
    }
	
	public void showItems() {
		int v;
		for (v=0;v<=getnAI();v++) {
			if (arrayInventory[v] instanceof Items) {
				System.out.print(v + " ");
				arrayInventory[v].print();
			}
		}
	}
	
	public boolean checkLocation(double x, double y) {
		if ((x >= 1 &&  x <= 16 && y >= 1 && y <=4) || (x >= 1 &&  x <= 21 && y >= 7 && y <=27)) {	//Lokasi building & fields
			return false;
		} else
			return true;
	}
	
	public void moveTo() {
		System.out.println("Insert new location : ");
		System.out.print("x : ");
		double x = input.nextDouble();
		System.out.print("y : ");
		double y = input.nextDouble();
		if (this.checkLocation(x,y)==false){
			System.out.println("You cannot move here!");
		} else {
			setLocation(x,y);
			System.out.println("Player has been moved to (" + location.getX() + " , " + location.getY() + ")");
		}
		System.out.println("Do you want to change navigation?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int c = input.nextInt();
		if(c == 1) {
			System.out.print("Insert new navigation : ");
			String nav = input.next();
			this.setNavigation(nav);
		}
	}
	
	public boolean checkInventState(int i) {
		return arrayInventory[i].getState();
	}
	/*
	public void showObjectDetails(Barn barn, Coop coop, Field field) {
		if((this.checkIFOBuilding(2)==true) || (this.checkIFOBuilding(3)==true)) {
			System.out.println("1. Check animals");
			System.out.println("2. Check feeding box");
			System.out.println("Insert option : ");
			int pil2 = input.nextInt();
			switch (pil2) {
				case 1 : {	
							if (this.checkIFOBuilding(2) == true) {
								for(int ia=0; ia<=barn.getnAL();ia++) {
									if(barn.getLivestock(ia) != null) {
										System.out.println(ia);
										barn.getLivestock(ia).printDetails();
									}
								}
							} else if (this.checkIFOBuilding(3)==true) {
								for(int ib=0; ib<=coop.getnAC();ib++) {
									if(coop.getChicken(ib) != null) {
										System.out.println(ib);
										coop.getChicken(ib).printDetails();
									}
								}
							}
						}break;
				case 2 : {
							if (this.checkIFOBuilding(2) == true) {
								if(this.checkFodder(barn) == true) {
									System.out.println("Feeding box is filled with fodder.");
								} else {
									System.out.println("Feeding box is empty.");
								}
							} else if (this.checkIFOBuilding(3) == true) {
								if(this.checkChickenfeed(coop) == true) {
									System.out.println("Feeding box is filled with chicken feed.");
								} else {
										System.out.println("Feeding box is empty.");
								}		
							} break;
						}
					}
		} else {
					System.out.println("Plants details");
					for(int ipd=0; ipd<=35;ipd++) {
						if(field.getArrayOfCrops(ipd) != null) {
							field.getArrayOfCrops(ipd).printDetails();
						}
					}
			}
	} */
}

