package cofrinho;

import java.util.Objects;

/**
 * Subclass que representa a moeda Euro. Esta classe herda de MoedaMae, o que
 * caracteriza o uso de Herança
 */
public class Euro extends MoedaMae {

	/**
	 * Construtor que utiliza o 'super' para enviar o valor à classe mãe (MoedaMae)
	 * para armazenamento e validação.
	 */
	public Euro(double valor) {
		super(valor);
	}

	// @Override indica que estamos sobrescrevendo o método da classe mãe
	@Override
	public void info() {
		System.out.println("Euro: " + valor);
	}

	@Override
	public double converter() {
		// Implementação da lógica de conversão específica para o Euro
		return valor * 6.0;
	}

	/**
	 * Método essencial para que a lógica de remover moedas do ArrayList funcione
	 * corretamente ao comparar o objeto criado com o que está na lista.
	 */
	@Override
	public boolean equals(Object obj) {
		// Verifica se é a mesma referência de memória
		if (this == obj)
			return true;
		// Verifica se o objeto recebido é nulo ou de uma classe diferente
		if (obj == null || getClass() != obj.getClass())
			return false;

		// Converte o objeto genérico para o tipo Euro (Cast)
		Euro outraMoeda = (Euro) obj;
		// Compara o valor numérico das moedas
		return Double.compare(outraMoeda.valor, valor) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valor);
	}
}