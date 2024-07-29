package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner scan = new Scanner(System.in);

		System.out.print("Room number: ");
		int roomNumber = scan.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(scan.next(), dtf);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(scan.next(), dtf);

		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: check-Out date must be after check-In date.");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(scan.next(), dtf);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(scan.next(), dtf);

			LocalDate now = LocalDate.now();

			if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for update" + "must be future dates");
			} 
			else if (!checkOut.isAfter(checkIn)){
				System.out.println("Error in reservation: check-Out date must be after check-In date.");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}

		}

		scan.close();
	}

}
