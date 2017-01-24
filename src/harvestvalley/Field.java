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
// File : Field.java
// Deskripsi : Kelas untuk petak tanah 
// Author : Fanni Ulfani/18214051

import java.util.Scanner;

//NOTE : Besar field diubah karena gambarnya tidak cukup
public class Field {
	Crops[] arrayOfCrops; //array untuk menyimpan tanaman
	boolean[] arrayOfPlots; //array untuk menyimpan status tanah (sudah dicangkul/belum)
	int maxField = 100; //jumlah maksimal petak tanah 20x20 ada 36 petak tanah
	Point location;
	double length;
	double width;
	Point[] arrayPoint;
	int nAF; //Berapa banyak array of crops yang terisi
	
	//Konstruktor
	public Field() {
		this.arrayOfCrops = new Crops[maxField];
		this.arrayOfPlots = new boolean[maxField];
		this.width = 10;
		this.length = 10;
		this.location = new Point(1,7);
		this.arrayPoint = new Point[maxField];
                this.arrayPoint[0] = new Point(50,50);
                this.arrayPoint[1] = new Point(100,50);
                this.arrayPoint[2] = new Point(150,50);
                this.arrayPoint[3] = new Point(200,50);
                this.arrayPoint[4] = new Point(250,50);
                this.arrayPoint[5] = new Point(300,50);
                this.arrayPoint[6] = new Point(350,50);
                this.arrayPoint[7] = new Point(400,50);
                this.arrayPoint[8] = new Point(450,50);
                this.arrayPoint[9] = new Point(500,50);
                this.arrayPoint[10] = new Point(50,100);
                this.arrayPoint[11] = new Point(100,100);
                this.arrayPoint[12] = new Point(150,100);
                this.arrayPoint[13] = new Point(200,100);
                this.arrayPoint[14] = new Point(250,100);
                this.arrayPoint[15] = new Point(300,100);
                this.arrayPoint[16] = new Point(350,100);
                this.arrayPoint[17] = new Point(400,100);
                this.arrayPoint[18] = new Point(450,100);
                this.arrayPoint[19] = new Point(500,100);
                this.arrayPoint[20] = new Point(50,150);
                this.arrayPoint[21] = new Point(100,150);
                this.arrayPoint[22] = new Point(150,150);
                this.arrayPoint[23] = new Point(200,150);
                this.arrayPoint[24] = new Point(250,150);
                this.arrayPoint[25] = new Point(300,150);
                this.arrayPoint[26] = new Point(350,150);
                this.arrayPoint[27] = new Point(400,150);
                this.arrayPoint[28] = new Point(450,150);
                this.arrayPoint[29] = new Point(500,150);
                this.arrayPoint[30] = new Point(50,200);
                this.arrayPoint[31] = new Point(100,200);
                this.arrayPoint[32] = new Point(150,200);
                this.arrayPoint[33] = new Point(200,200);
                this.arrayPoint[34] = new Point(250,200);
                this.arrayPoint[35] = new Point(300,200);
                this.arrayPoint[36] = new Point(350,200);
                this.arrayPoint[37] = new Point(400,200);
                this.arrayPoint[38] = new Point(450,200);
                this.arrayPoint[39] = new Point(500,200);
                this.arrayPoint[40] = new Point(50,250);
                this.arrayPoint[41] = new Point(100,250);
                this.arrayPoint[42] = new Point(150,250);
                this.arrayPoint[43] = new Point(200,250);
                this.arrayPoint[44] = new Point(250,250);
                this.arrayPoint[45] = new Point(300,250);
                this.arrayPoint[46] = new Point(350,250);
                this.arrayPoint[47] = new Point(400,250);
                this.arrayPoint[48] = new Point(450,250);
                this.arrayPoint[49] = new Point(500,250);
                this.arrayPoint[50] = new Point(50,300);
                this.arrayPoint[51] = new Point(100,300);
                this.arrayPoint[52] = new Point(150,300);
                this.arrayPoint[53] = new Point(200,300);
                this.arrayPoint[54] = new Point(250,300);
                this.arrayPoint[55] = new Point(300,300);
                this.arrayPoint[56] = new Point(350,300);
                this.arrayPoint[57] = new Point(400,300);
                this.arrayPoint[58] = new Point(450,300);
                this.arrayPoint[59] = new Point(500,300);
                this.arrayPoint[60] = new Point(50,350);
                this.arrayPoint[61] = new Point(100,350);
                this.arrayPoint[62] = new Point(150,350);
                this.arrayPoint[63] = new Point(200,350);
                this.arrayPoint[64] = new Point(250,350);
                this.arrayPoint[65] = new Point(300,350);
                this.arrayPoint[66] = new Point(350,350);
                this.arrayPoint[67] = new Point(400,350);
                this.arrayPoint[68] = new Point(450,350);
                this.arrayPoint[69] = new Point(500,350);
                this.arrayPoint[70] = new Point(50,400);
                this.arrayPoint[71] = new Point(100,400);
                this.arrayPoint[72] = new Point(150,400);
                this.arrayPoint[73] = new Point(200,400);
                this.arrayPoint[74] = new Point(250,400);
                this.arrayPoint[75] = new Point(300,400);
                this.arrayPoint[76] = new Point(350,400);
                this.arrayPoint[77] = new Point(400,400);
                this.arrayPoint[78] = new Point(450,400);
                this.arrayPoint[79] = new Point(500,400);
                this.arrayPoint[80] = new Point(50,450);
                this.arrayPoint[81] = new Point(100,450);
                this.arrayPoint[82] = new Point(150,450);
                this.arrayPoint[83] = new Point(200,450);
                this.arrayPoint[84] = new Point(250,450);
                this.arrayPoint[85] = new Point(300,450);
                this.arrayPoint[86] = new Point(350,450);
                this.arrayPoint[87] = new Point(400,450);
                this.arrayPoint[88] = new Point(450,450);
                this.arrayPoint[89] = new Point(500,450);
                this.arrayPoint[90] = new Point(50,500);
                this.arrayPoint[91] = new Point(100,500);
                this.arrayPoint[92] = new Point(150,500);
                this.arrayPoint[93] = new Point(200,500);
                this.arrayPoint[94] = new Point(250,500);
                this.arrayPoint[95] = new Point(300,500);
                this.arrayPoint[96] = new Point(350,500);
                this.arrayPoint[97] = new Point(400,500);
                this.arrayPoint[98] = new Point(450,500);
                this.arrayPoint[99] = new Point(500,500);
		/*for (int a=0;a<=5;a++) {
			this.arrayPoint[a] = new Point(x,y);
			x = x+3;
		}
		y=y+3;
		for (int a=6;a<=11;a++) {
			this.arrayPoint[a] = new Point(x,y);
			x = x+3;
		}
		y=y+3;
		for (int a=12;a<=17;a++) {
			this.arrayPoint[a] = new Point(x,y);
			x = x+3;
		}
		y=y+3;
		for (int a=18;a<=23;a++) {
			this.arrayPoint[a] = new Point(x,y);
			x = x+3;
		}
		y=y+3;
		for (int a=24;a<=29;a++) {
			this.arrayPoint[a] = new Point(x,y);
			x = x+3;
		}
		y=y+3;
		for (int a=30;a<=35;a++) {
			this.arrayPoint[a] = new Point(x,y);
			x = x+3;
		}*/
		this.nAF=0;
	}
	
	//Setter
        public void setWidth(double width) {
            this.width = width;
        }
        
        public void setLength(double length) {
            this.length = length;
        }
        
	public void setArrayOfCrops(int i, Crops crops) {
		arrayOfCrops[i]= crops;
	}
	
	public void setArrayOfPlots(int i, boolean state) {
		arrayOfPlots[i] = state;
	}
	
	public void setnAF(int i) {
		this.nAF=i;
	}
	
	//Getter
	public Crops getArrayOfCrops(int i) {
		return arrayOfCrops[i];
	}
		
	public boolean getArrayOfPlots(int i) {
		return arrayOfPlots[i];
	}
	
	public Point getPoint(int i) {
		return arrayPoint[i];
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public int getnAF() {
		return this.nAF;
	}
	
	//Method siram tanaman
	public void waterPlant() {
		Scanner input = new Scanner(System.in);
		System.out.println("List of crops");
		int iplotsss;
		for (iplotsss=0; iplotsss<maxField; iplotsss++) {
			if ((getArrayOfCrops(iplotsss)!=null) && (getArrayOfCrops(iplotsss).getState()==false)){
					System.out.println( iplotsss + " | " + getArrayOfCrops(iplotsss).getName() + " | " + getArrayOfCrops(iplotsss).getPhase());					
				}
			}
		System.out.println("Choose crops (insert number) :");
			int chocrops = input.nextInt();
			if ((chocrops <0) || (chocrops>40) || (getArrayOfCrops(chocrops)==null)) {
					System.out.println("Wrong choice!");
			}
			else {
				getArrayOfCrops(chocrops).setState(true);
				System.out.println("Plots " + chocrops + " has been watered");
				}
	}
										
} 

