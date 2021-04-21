package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Enter Check-In date: (dd/mm/yyyy) ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Enter Check-Out date: (dd/mm/yyyy) ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) { // se o checkout for depois do checkin
			System.out.println("Error in reservation: Check-Out date must be after Check-In date!");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut); // instanciando o objt
			System.out.println("Reservation: " + reservation); // mostrar na tela os dados da reserva

			System.out.println();
			System.out.println("Enter date to update the reservation: "); // atualizar reserva
			System.out.print("Enter Check-In date: (dd/mm/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Enter Check-Out date: (dd/mm/yyyy) ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Reservation update: " + error);
			} else {
				System.out.println("Reservation update " + reservation);
			}
		}

		sc.close();
	}

}
