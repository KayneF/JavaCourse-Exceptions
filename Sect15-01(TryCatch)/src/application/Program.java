package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	
	/**
	 * Aqui temos 2 possibilidades de erros, uma é a entrada de um
	 * valor inválido (uma letra ou um número fracionado por exemplo), 
	 * ou a entrada de uma posição inexistente no Array.
	 * Quando um erro ocorre, por padrão, o programa é encerrado sem
	 * nenhum prévio aviso. 
	 * Os blocos "try/catch", servem para isolar um bloco de código,
	 * em que há chances de ocorrer algum tipo de erro. Neste exemplo,
	 * temos um bloco simples, em que o programa solicita a entrada
	 * de uma String e em seguida, solicita um número inteiro que
	 * exibe o conteúdo de uma posição do Array.
	 * O bloco "try" tenta executar o bloco de código, caso ocorra um
	 * erro ou algo impeça o bloco de ser executado, ele cairá no
	 * bloco "catch", e aqui podemos tratar a excessão conforme o 
	 * necessário.
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		try {
			String[] array = scan.nextLine().split(" ");
			int position = scan.nextInt();
			System.out.println(array[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Invalid position!");
		}
		catch (InputMismatchException e) {
			System.err.println("Input error!");
		}
		
		System.out.println("End of program.");
		
		scan.close();
	}
}
