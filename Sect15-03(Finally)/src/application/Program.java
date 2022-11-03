package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	
	/**
	 * O bloco "finally", permite que, independente de que o bloco
	 * "try" tenha ou não sido executado, ou se o programa caiu em
	 * uma excessão no bloco "catch", o que está no bloco "finally"
	 * sempre será executado. Isso é importante em situações em que,
	 * quando um arquivo, conexão com banco de dados, ou recurso 
	 * expecifico seja aberto, o mesmo sempre seja fechado ao final 
	 * do processo por exemplo.
	 */

	public static void main(String[] args) {
		
		File file = new File("/home/kayne/temp/output.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(file);
			System.out.println("Now opening file...");
			while (scan.hasNextLine() ) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file: " + e.getMessage());
		} finally {
			System.out.println("Closing file...");
			if (scan != null) {
				scan.close();
			}
			System.out.println("File closed.");
		}
		System.out.println("End of program.");
	}

}
