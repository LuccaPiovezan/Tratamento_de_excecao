package model.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
		
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // data saida menos data entrada em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //conversão de milisegundos para dias
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error! Reservation dates for update must be future date now.";
		} 
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-Out date must be after Check-In date!";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber 
				+ ", Check-In date: " + sdf.format(checkIn)
				+ ", Check-Out date: " +  sdf.format(checkOut)
				+ ", " + duration()
				+ " Days!";
		
	}
	
	

	
}
