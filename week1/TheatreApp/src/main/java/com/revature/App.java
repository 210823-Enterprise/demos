package com.revature;

public class App {

	public static void main(String[] args) {
		
		Theatre theatre = new Theatre("Ford's Theatre", 8, 12);
		
		theatre.getSeats();
		
		// I want to reserve a seat.
		
		// I'll enter the seatNumber, and it must go through a method in the SEAT class to check if it's reserved or not
		
		
		if (theatre.reserveSeatBinary("G11")) { // O(log n) -- logarithmic time because of Binary Search
			System.out.println("Please pay to reserve this free seat");
			
		} else {
			System.out.println("the seat is reserved, sorry");
		}
		
	}

}
