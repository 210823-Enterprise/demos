package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private final String theatreName; // we will initialize it inside of the constructor
	private List<Seat> seats = new ArrayList<>();  
	
	/**
	 * 
	 * When do you use an ArrayList over a LinkedList and vice versa?
	 * 
	 * ArrayList:
	 * Best for SEARCHING get(): is done in O(1) constant time
	 * Worst for INSERTING add() (and deleting): done in O(n) linear time
	 * 
	 * LinkedList
	 * Best for INSERTING/DELETING add()/remove(): O(1) constant time (because LinkedList consists of nodes that have addresses)
	 * Worst for: SEARCHING sometimes O(n) other times more complex......
	 */
	
	
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
	
	public String getTheatreName() {
		return theatreName;
		
	}
	
	public void getSeats() {
		
		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	// I'd  like to reseve seat G07
	// BRUTE FORCE ALGORITHM - I will check every single seat to check if it's the one that I want to reserve
	public boolean reserveSeat(String seatNumber) { // someone could enter in Z119
		
		Seat requestedSeat = null;
		
		for (Seat seat : seats) {
			
			System.out.println(".");
			
			if (seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat = seat;
				break;
			}
			
		}
		
		if (requestedSeat == null) {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}
		
		return requestedSeat.reserve(); // we will build this particular method on the Seat class! to r
		
	}
	
	// Binary Reserve Seat Algortihm
	public boolean reserveSeatBinary(String seatNumber) { // A02
		
		int low = 0;
		int high = seats.size();
		
		while (low<=high) {
			
			System.out.println(".");
			
			// capture the middle value
			int mid = (low + high)/2;
			
			// Use the middle value to capture the middle seat of the row
			Seat midVal = seats.get(mid); // get() is a method 
			
			// we have to check is the seatNumber passed through greater than or less than the midVal?????
			int cmp = midVal.getSeatNumber().compareTo(seatNumber);
			
			// 0 if equal, -1 if less than, 1 if greater than
			
			// _A00_ _A01_ _A02_ _A03_ _A04_ _A05_ _A06_ _A07_ _A08_ _A09_ _A10_ 
			
			if (cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid -1; 
			} else {
				return seats.get(mid).reserve();
			}
			
			
			
		}
	
		// this is catching no real seats
		System.out.println("there is no seat " + seatNumber);
		return false;

	}
	
	
	/*
	 * Comparable is a special interface that allows us to define the order of a user-defined class
	 * 
	 * 
	 */
	
	// this is a nested class 
	private class Seat implements Comparable<Seat>{ // Comparable is an interface we use to define order within a user-created class
		
		private final String seatNumber; // A11 - G11
		private boolean reserved = false;
		
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}
		
		public boolean reserve() {
			
			if (!this.reserved) {
				
				this.reserved = true;
				
				System.out.println("Reservation of seat " + seatNumber + " reserved.");
				
				return true;
			} else {
				return false;
			}
		}

		// This is how we define if a seat is greater than or less than another
		@Override
		public int compareTo(Seat seat) {
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
		
	}
	
}