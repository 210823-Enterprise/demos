package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private final String theatreName; // we will initialize it inside of the constructor
	private List<Seat> seats = new ArrayList<>();
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows - 1);
		
		for (char row = 'A'; row <= lastRow; row++) {
			
			// nested for loop for each row, to make seats for each row 
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				
				seats.add(seat);
			}
			
			
		}
		
		
	}
	
	
	private class Seat {
		
		private final String seatNumber; // A11 - G11
		private boolean reserved = false;
		
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}
		
		
		
	}
	

}
