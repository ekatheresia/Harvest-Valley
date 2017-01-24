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
// File : Time.java
// Deskripsi : Kelas untuk waktu 
// Author : Fanni Ulfani/18214051

import java.util.*;
import java.text.*;

public class Time {
	int hours; //dalam hitungan 24 jam
	int minutes;
	int days;
	int dayIndex; //untuk nama hari
	int months; //dalam 1 bulan ada 30 hari
	int years; // 1 tahun ada 12 bulan
	boolean newDay; //status hari baru jika pemain tidur
	Timer timer; //timer
	
	//Konstruktor
	public Time() {
		this.hours=6;
		this.minutes=0;
		this.days=1;
		this.dayIndex=1;
		this.months=1;
		this.years=1;
		this.newDay=false;
	}
	
	public Time(int hours, int minutes, int days, int dayIndex, int months, int years) {
		this.hours=hours;
		this.minutes=minutes;
		this.days=days;
		this.dayIndex=dayIndex;
		this.months=months;
		this.years=years;
		this.newDay=false;
	}
	
	//Inner class untuk update waktu dalam game
	
	
	//Method untuk mendapatkan nama hari
	public String getNameDays(int dayIndex) {
		if(dayIndex==2) {
			return "Tuesday";
		}
		if(dayIndex==3) {
			return "Wednesday";
		}
		if(dayIndex==4) {
			return "Thursday";
		}
		if(dayIndex==5) {
			return "Friday";
		}
		if(dayIndex==6) {
			return "Saturday";
		}
		if(dayIndex==7) {
			return "Sunday";
		}
		return "Monday";
	}
			
	//Setter
	public void setNewDay(boolean state) {
		this.newDay=state;
	}
	
	//Getter
	public int getHours() {
		return this.hours;
	}
	
	public int getMinutes() {
		return this.minutes;
	}
	
	public int getDays() {
		return this.days;
	}
	
	public int getDayIndex() {
		return this.dayIndex;
	}
	
	public int getMonths() {
		return this.months;
	}
	
	public int getYears() {
		return this.years;
	}
	
	public boolean getNewDay() {
		return this.newDay;
	}
	
	//Setter
	public void setHours(int hours) {
		this.hours=hours;
	}
	
	public void setMinutes(int minutes) {
		this.minutes=minutes;
	}
	
	public void setDays(int days) {
		this.days=days;
	}
	
	public void setDayIndex(int dayindex) {
		this.dayIndex=dayindex;
	}
	
	public void setMonths(int months) {
		this.months=months;
	}
	
	public void setYears(int years) {
		this.years=years;
	}	
	
	
				
}



//For Home - Sleep
// public void save() {
//proses save
// if (t.hours<=23) {
/* setNewDay(true);
 }
 iteratif semua petak tanah {
 crops.countDays(t);
 crops.changePhase();
 crops.changeState(false);
 }
 setNewDay (false);
}
*/

