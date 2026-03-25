package cofrinho;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar a coleção de moedas. Foi aplicado aqui
 * conceito de Polimorfismo para tratar diferentes moedas como uma lista única
 * de MoedaMae.
 */
public class Cofrinho {

	// Atributo privado para garantir o encapsulamento dos dados.
	// Usamos ArrayList para armazenar moedas de forma dinâmica.
	private ArrayList<MoedaMae> listaMoedas = new ArrayList<>();

	// Método para inserir uma moeda na lista.
	public void adicionar(MoedaMae moeda) {
		if (moeda != null) {
			this.listaMoedas.add(moeda);
		}
	}

	/**
	 * Método para remover uma moeda específica. Utiliza o método 'remove'
	 * do ArrayList, que depende do 'equals' que sobrescrevemos nas classes de moeda
	 * para funcionar corretamente.
	 */
	public void remover(MoedaMae moeda) {
		// Tenta remover o objeto; retorna true se encontrar e remover
		boolean removido = this.listaMoedas.remove(moeda);

		if (removido) {
			System.out.println("Moeda removida com sucesso!");
		} else {
			// Lógica extra para dar um feedback melhor ao usuário caso a remoção falhe
			double totalNoCofrinho = totalConvertido();
			double valorTentado = moeda.converter();

			System.out.println("---------------------------------------");
			System.out.println("ERRO: Moeda não encontrada!");

			if (valorTentado > totalNoCofrinho) {
				System.out.printf(
						"Saldo Insuficiente! Você tentou retirar R$ %.2f, mas o total no cofrinho é R$ %.2f\n",
						valorTentado, totalNoCofrinho);
			} else {
				System.out.println("O valor existe em saldo total, mas não há uma moeda única com esse valor exato.");
			}

			System.out.println("DICA: Use a opção '3-Listar Moedas' para ver seus lançamentos.");
			System.out.println("---------------------------------------");
		}
	}

	// Percorre a lista e chama o método 'info' de cada objeto
	// Aqui o Polimorfismo decide em tempo de execução se chama o info do Real,
	// Dolar ou Euro.
	public void listagemMoedas() {
		if (this.listaMoedas.isEmpty()) {
			System.out.println("O cofrinho está vazio.");
			return;
		}
		System.out.println("--- Lista de Moedas no Cofrinho ---");
		for (MoedaMae m : listaMoedas) {
			m.info();
		}
	}

	/**
	 * Calcula o somatório de todas as moedas convertidas para Real
	 * 
	 * @return double acumulado com o valor total convertido
	 */
	public double totalConvertido() {
		double acumulador = 0;
		for (MoedaMae m : listaMoedas) {
			// Chama o método converter específico de cada subclasse
			acumulador += m.converter();
		}
		return acumulador;
	}
}