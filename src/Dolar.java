package cofrinho;

import java.util.Objects;

/**
 * Subclasse que representa a moeda Dólar. Estende a classe abstrata MoedaMae,
 * herdando seus atributos e métodos.
 */
public class Dolar extends MoedaMae {

	/**
	 * Construtor que utiliza o 'super' para enviar o valor à classe mãe (MoedaMae)
	 * para armazenamento e validação.
	 */

	public Dolar(double valor) {
		super(valor);
	}

	// Método sobrescrito para exibir as informações específicas desta moeda
	@Override
	public void info() {
		System.out.println("Dólar: " + valor);
	}

	/**
	 * Implementação do método abstrato de conversão. Multiplica o valor pela
	 * cotação definida para transformar em Real.
	 */
	@Override
	public double converter() {
		return valor * 5.0;
	}

	/**
	 * Sobrescrita do método equals para permitir a comparação de objetos. Essencial
	 * para que o método remover da classe Cofrinho funcione.
	 */
	@Override
	public boolean equals(Object obj) {
		// Verifica se os objetos ocupam o mesmo espaço na memória
		if (this == obj)
			return true;
		// Verifica se o objeto comparado é nulo ou de classe diferente
		if (obj == null || getClass() != obj.getClass())
			return false;

		// Faz o cast para Dolar e compara se os valores numéricos são iguais
		Dolar outraMoeda = (Dolar) obj;
		return Double.compare(outraMoeda.valor, valor) == 0;
	}

	// Método auxiliar para gerar o código hash baseado no valor da moeda
	@Override
	public int hashCode() {
		return Objects.hash(valor);
	}
}