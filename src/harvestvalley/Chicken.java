
package harvestvalley;

// File : Chicken.java
// Deskripsi : Kelas untuk hewan ayam 
// Author : Siti Aisyah / 18214042

public class Chicken extends Livestock
{
		boolean isKandang;//mengecek keaadaan, dikandang atau tidak
		int noFeed;//menghitung berapa hari tidak diberi makan
		int feed;//menghitung hari diberi makan
		int day;//hari dia hidup
		
		
		//Konstruktor
		public Chicken(String name, Point p){
			super(name,p,"Chicken");
		}
		//method
		//keberadaan di kandang

		
		//method mendapatkan product
		//pas menghasilkan produk, dia status readynya jadi false
		public Items getProduct(){
                    if(isReady) {
                        super.changeReady(false);
                        return new Items("Egg",1,250);
                    } else
                        return null;
                }
}
