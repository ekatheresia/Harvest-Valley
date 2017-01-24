
package harvestvalley;
// File : Sheep.java
// Deskripsi : Kelas untuk hewan sapi 
// Author : Siti Aisyah

public class Sheep extends Livestock
{
		boolean isKandang;//mengecek keaadaan, dikandang atau tidak
		
		//Konstruktor
		public Sheep(String name, Point p){
                    super(name,p,"Sheep");
		}
		//method
		public Items getProduct(){
                    super.changeReady(false);
                    return new Items("Wool",1,400);
		}
}
