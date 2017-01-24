
package harvestvalley;
// File : Cow.java
// Deskripsi : Kelas untuk hewan sapi 
// Author : Siti Aisyah

public class Cow extends Livestock
{
		boolean isKandang;//mengecek keaadaan, dikandang atau tidak
		
		//Konstruktor
		public Cow(String name, Point p){
			super(name,p,"Cow");
		}
		
		//Method menghitung jumlah hari sapi tidak diberi makan
		/*public void countDays(Time time) {
		if (this.state=="alive") {
			day++;
			feed++;
			noFeed=0;
			super.changeReady(true);
		}
		else {
			noFeed++;
		}
		}
		
		public void condition(){
			if (this.state=="alive") {
				if (this.noFeed==1) {
					this.setState("starving");
				}
			}
			if (this.state=="starving") {
				if(this.noFeed == 4) {
					this.setState("dead");
				}
			}
		} */
		
		//method mendapatkan product
		//pas menghasilkan produk, dia status readynya jadi false
		public Items getProduct(){
                    if(isReady) {
                        super.changeReady(false);
                        return new Items("Milk",1,500);
                    } else
                        return null;		
		}
}
				
		
