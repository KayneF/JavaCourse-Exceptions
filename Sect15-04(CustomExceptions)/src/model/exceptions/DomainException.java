package model.exceptions;

// Exceção de domínio personalizada
public class DomainException extends Exception{

	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}
	
	/**
	 * Cláusula "throws": propaga a exceção ao invés de trata-la
	 * Cláusula "throw": lança a exceção/"corta" o método (semelhante ao 'return')
	 * Exception: compilador obriga a tratar ou propagar a exceção
	 * RuntimeException: compilador ignora a exceção
	 * 
	 * Vantagens de utilizar exceções:
	 * 		Lógica delegada
	 * 		Construtores podem ser tratados
	 * 		Possibilidade de auxílio do compilador
	 * 		Código mais limpo, simples e menos aninhado
	 * 		Possível capturar outras exceções de sistema
	 */
}