package cofrinho;

import java.util.Objects;

/**
 * Classe que representa a moeda Real.
 * Herda os atributos e métodos da classe abstrata MoedaMae.
 */
public class Real extends MoedaMae {

	// Construtor que utiliza o 'super' para enviar o valor à classe mãe (MoedaMae) para armazenamento e validação.
	public Real(double valor) {
		super(valor);
	}

	// Sobrescrita do método para exibir as informações específicas desta moeda.
	@Override
	public void info() {
		System.out.println("Real: " + valor);
	}

	// Método que realiza a conversão. No caso do Real, retorna o próprio valor.
	@Override
	public double converter() {
		return this.valor;
	}

	/**
	 * Sobrescrita do método equals para permitir a comparação entre objetos.
	 * Essencial para que o método remover da classe Cofrinho localize a moeda correta.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Real outraMoeda = (Real) obj;
		return Double.compare(outraMoeda.valor, valor) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valor);
	}
}