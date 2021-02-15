package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private int rommNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation(int rommNumber, Date checkIn, Date checkOut) {
		this.rommNumber = rommNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRommNumber() {
		return rommNumber;
	}

	public void setRommNumber(int rommNumber) {
		this.rommNumber = rommNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now))
			return "Error in reservation: Reservation dates for update must be future dates.";
		if (!checkOut.after(checkIn))
			return "Error in reservation: Check-out date must be after check-in date";
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			
		return null;

	}

	@Override
	public String toString() {
		return "Room " + rommNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}
}
