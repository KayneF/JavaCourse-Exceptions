package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	
	/**
	 * Basicamente, o "printStackTrace" permite que seja impresso
	 * em console ou janela de aviso, uma forma mais detalhada do
	 * erro, o que facilita na identificação do erro ocorrido.
	 * Nesse exemplo, o log mostra exatamente o erro ocorrido, e
	 * por quem ele foi chamado a princípio.
	 */

	public static void main(String[] args) {
		
		method1();
		System.out.println("End of program.");
		
	}
	
	public static void method1() {
		
		System.out.println("*** METHOD 1 START ***");
		method2();
		System.out.println("*** METHOD 1 END ***");
	}
	
	public static void method2() {
		
		System.out.println("*** METHOD 2 START ***");
		Scanner scan = new Scanner(System.in);
		
		try {
			String[] array = scan.nextLine().split(" ");
			int position = scan.nextInt();
			System.out.println(array[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Invalid position!");
			e.printStackTrace();
			scan.next();
		}
		catch (InputMismatchException e) {
			System.err.println("Input error!");
			e.printStackTrace();
			scan.next();
		}
		
		scan.close();
		System.out.println("*** METHOD 2 END ***");
	}

}
