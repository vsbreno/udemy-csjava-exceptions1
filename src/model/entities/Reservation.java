package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkIn;
	}

	public LocalDate getCheckout() {
		return checkOut;
	}

	public long duration() {
		Duration duration = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		return duration.toDays();
	}

	public String updateDates(LocalDate checkIn, LocalDate checkOut) {

		LocalDate now = LocalDate.now();

		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.isAfter(checkIn)) {
			return "Check-Out date must be after check-In date.";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;

		return null;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + checkIn.format(dtf) + ", check-out: " + checkOut.format(dtf)
				+ ", " + duration() + " nights";
	}
}
