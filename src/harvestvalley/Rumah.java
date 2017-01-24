
package harvestvalley;
// File : Rumah.java
// Deskripsi : Kelas untuk rumah
// Author : Eka Theresia Kartika Suri/18214012
import java.util.Scanner;

public class Rumah extends Bangunan{
    
    //konstruktor
    public Rumah () {
        super("House", (new Point(1,1)), 5, 3, (new Point(2,4)), "south");    
    }
    
    /*//Methods
    public void menuHouse(Player player, BuySell bs, Field field, Barn barn, Coop coop, MainTime mainTime, Time t) {
		Scanner input = new Scanner(System.in);
			player.setLocation(3,3);
			t = mainTime.stopTime();
			System.out.println("1. Sleep");
			System.out.println("2. Buy");
			System.out.println("3. Sell");
			System.out.println("4. Go out");
			int i = input.nextInt();
			switch (i) {
				case 1 : {
							mainTime.newDays=true;
							//saveGame();
							for(int isave=0;isave<=35;isave++) {
								if( field.getArrayOfCrops(isave) != null) {
									field.getArrayOfCrops(isave).countDays(t);
									field.getArrayOfCrops(isave).changePhase();
									field.getArrayOfCrops(isave).changeState(false);
								}
							}
							for(int isa=0;isa<=coop.getnAC();isa++) {
								if(coop.getChicken(isa) != null) {
									coop.getChicken(isa).countDays(t);
									coop.getChicken(isa).condition();
									if(coop.getChicken(isa).getState()=="dead") {
									System.out.println(coop.getChicken(isa).getName() + " is dead");
									coop.setDead(isa);
									}
								}
							}
							for(int isl=0;isl<=barn.getnAL();isl++) { 
								if(barn.getLivestock(isl) != null) {
									barn.getLivestock(isl).countDays(t);
									barn.getLivestock(isl).condition();
									if(barn.getLivestock(isl).getState()=="dead") {
									System.out.println(barn.getLivestock(isl).getName() + " is dead");
									barn.setDead(isl);
									}
								}
							}
							t.setNewDay(false);
							System.out.println("You've been slept. This is a new day! :)");
							}break;
				case 2 : {
							bs.printMenuBuy();
							bs.buy(player,coop, barn);
							break;
						}
				case 3 : {
							bs.sell(player);
							break;
						}
				case 4 : {
							mainTime.setTime(t);
							player.setLocation(2,5);
						}
				}
			
			}*/
}
    
