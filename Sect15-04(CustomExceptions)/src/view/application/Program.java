package view.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		/**
		 * Nesta solução, reduzimos o nível de acoplamento ao seu mínimo,
		 * delegando todas as funções para a classe encarregada de operar
		 * seus próprios atributos, fazendo com que a classe principal, 
		 * seja apenas destinada a operações de entrada e saída de dados.
		 * 
		 * Também tratamos todos os possíveis erros identificados que 
		 * poderiam ocorrer na aplicação principal utilizando o "try/catch".
		 * 
		 * Na classe "Reservation", foram propagados cláusulas de excessão,
		 * onde erros de entrada e saída de dados poderiam ocorrer. Elas
		 * foram utilizadas no método construtor da classe, e também no
		 * método de atualização de dados "updateDates()".
		 * 
		 * Por ultimo, criamos e utilizamos uma excessão personalizada
		 * para tratar os erros expecificos de domínio, onde uma data de 
		 * check-in anterior a data de check-out, ou uma data passada,
		 * poderia ser inserida na aplicação. Por ser um erro lógico da 
		 * própria aplicação, e não um erro lógico da linguagem, criamos
		 * a excessão personalizada para tratar de possíveis problemas.
		 */

		// OPTIMAL SOLUTION

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Insert reservation data: ");
			System.out.print("Room number: ");
			short number = scan.nextShort();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next());

			Reservation res = new Reservation(number, checkIn, checkOut);
			System.out.println("\nReservation successful: \n" + res);

			System.out.println("\nUpdate date reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());

			res.updateDates(checkIn, checkOut);
			System.out.println("\nReservation update successful! \n" + res);
		} 
		catch (ParseException e) {		// Excessão de conversão
			System.err.println("Invalid date format");
		}
		catch (DomainException e) {		// Excessão de domínio (personalizada)
			System.err.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {	// Excessão de tempo de execução (inesperado)
			System.err.println("An unexpected error has ocurred. Exiting application...");
		}

		scan.close();
	}

}
