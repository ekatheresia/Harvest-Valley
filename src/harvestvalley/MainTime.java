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
// File : MainTime.java
// Deskripsi : Kelas untuk update waktu 
// Author : Fanni Ulfani/18214051

import java.util.*;

public class MainTime {
	Timer timer;
	boolean newDays;
	Time t;
	Player p;
	
	public MainTime(Time t, Player p) {
		this.t = t;
		this.newDays= false;
		Timer timer = new Timer();
		timer.schedule( new UpdateTimeTask(), 10000, 10000);
		this.p = p;
	}
	
	//Method set waktu
	public void setTime(Time t) {
		this.t=t;
	}
	 
	public class UpdateTimeTask extends TimerTask {
	public void run() {
		t.setMinutes(t.getMinutes()+10);
			if (t.getMinutes()>=60) {
				t.setHours(t.getHours()+1);
				t.setMinutes(t.getMinutes()-60);
			}
			if (t.getHours()==24) { //set hari baru, kemungkinan ada gap 10 detik
				t.setHours(0);
				t.setMinutes(0);
				t.setDays(t.getDays()+1);
				t.setDayIndex(t.getDayIndex()+1);
				if (t.getDayIndex()>7) {
					t.setDayIndex(1);
				}
			}
			if (t.getHours()==3) { // Kasus jika pemain terjaga hingga pukul 3 pagi
				//Time tn = stopTime();
				p.setLocation(3,3);
				System.out.println("You have been moved to house");
				System.out.println("Go out?");
				System.out.println("1.	Yes");
				System.out.println("2.	No");
				Scanner input = new Scanner(System.in);
				int a = input.nextInt();
				if(a==1) {
                                    t.setHours(6);
                                    t.setMinutes(0);
                                    p.setLocation(2,5);
				}
			}
			
			if (newDays==true) { //set hari baru
				t.setHours(6);
				t.setMinutes(0);
				t.setDays(t.getDays()+1);
				t.setDayIndex(t.getDayIndex()+1);
				if (t.getDayIndex()>7) {
					t.setDayIndex(1);
				}
				newDays=false;
			}
			if (t.getDays()>30) { //set bulan baru
				t.setDays(1);
				t.setMonths(t.getMonths()+1);
			}
			if (t.getMonths()>12) { //set tahun baru
				t.setYears(t.getYears()+1);
				t.setMonths(1);
				t.setDays(1);
			}
		}
	
	}
	
	//Method print Time
	public void printTime() {
		System.out.println(t.getNameDays(t.getDayIndex()));
		System.out.println("Day " + t.getDays());
		System.out.println("Month " + t.getMonths());
		System.out.println("Year " + t.getYears());
		System.out.println(t.getHours() + " : " + t.getMinutes());
	
	}
	
	public Time getTime() {
		return this.t;
	}
	
	//For building - karena tidak bisa melakukan pause jadi delete->create new one
	public Time stopTime() {
	 int h = t.getHours();
	 int m = t.getMinutes();
	 int d = t.getDays();
	 int di = t.getDayIndex();
	 int mt = t.getMonths();
	 int y = t.getYears();
	 Time t = new Time(h, m, d, di, mt, y);
	 return t;
	}
}

