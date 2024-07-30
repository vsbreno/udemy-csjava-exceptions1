package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner scan = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int roomNumber = scan.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(scan.next(), dtf);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(scan.next(), dtf);

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(scan.next(), dtf);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(scan.next(), dtf);

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

		} 
		catch (DateTimeParseException e) {
			System.out.println("Invalid date format.");
		} 
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		scan.close();
	}

}
