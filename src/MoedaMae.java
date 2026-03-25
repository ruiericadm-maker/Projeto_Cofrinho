package cofrinho;

/**
 * Classe Mãe Abstrata que serve como molde para todas as moedas. Define a
 * estrutura comum (atributo valor) e os comportamentos obrigatórios que as
 * subclasses (Real, Dolar, Euro) devem implementar.
 */
public abstract class MoedaMae {
	// Atributo protegido para que as subclasses possam acessá-lo diretamente,
	// mas mantendo o encapsulamento em relação a classes externas.
	protected double valor;

	/**
	 * Esta correção foi implementada no Construtor da classe mãe que centraliza a
	 * lógica de validação, para garantir parâmetros reais.
	 */
	public MoedaMae(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor da moeda deve ser maior que zero!");
		}
		this.valor = valor;
	}

	// Método abstrato para exibição de informações. Cada moeda terá sua própria
	// mensagem.
	public abstract void info();

	// Método abstrato de conversão. Obriga cada subclasse a definir sua própria
	// cotação[cite: 26].
	public abstract double converter();

	/**
	 * Sobrescrita do método equals da classe Object. Definimos que duas moedas são
	 * "iguais" se forem do mesmo tipo e possuírem o mesmo valor. Isso é fundamental
	 * para que o ArrayList funcione corretamente nas buscas e remoções.
	 */
	@Override
	public boolean equals(Object obj) {
		// Verifica se é a mesma referência de memória
		if (this == obj)
			return true;
		// Verifica nulidade ou se as classes são diferentes (ex: comparar Real com
		// Dolar)
		if (obj == null || getClass() != obj.getClass())
			return false;

		// Conversão do objeto para o tipo MoedaMae (Downcasting)
		MoedaMae outra = (MoedaMae) obj;
		// Comparação segura de valores do tipo double
		return Double.compare(outra.valor, valor) == 0;
	}
}