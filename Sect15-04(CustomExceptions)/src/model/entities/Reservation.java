package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Short roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// Exceção de domínio propagada no método construtor
	public Reservation(short roomNumber, Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates must be future dates");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date"); 
		} 
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Short getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Short roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckin() {
		return checkIn;
	}
	public Date getCheckout() {
		return checkOut;
	}

	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	// Exceção de domínio propagada no método de atualização
	public void updateDates (Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates must be future dates");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date"); 
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room: " + this.roomNumber
				+ ", check-in: " + sdf.format(checkIn)
				+ ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}
}
