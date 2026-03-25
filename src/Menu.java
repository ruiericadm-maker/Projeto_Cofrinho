package cofrinho;

import java.util.Scanner;

/**
 * Classe Principal que gerencia a interface com o usuário. Implementa o menu de
 * interações solicitado no roteiro da atividade.
 */
public class Menu {
	public static void main(String[] args) {
		// Instanciando o Scanner para entrada de dados via teclado
		Scanner teclado = new Scanner(System.in);
		// Criação do objeto cofrinho que armazenará as moedas
		Cofrinho cofrinho = new Cofrinho();
		int opcao;

		System.out.println("COFRINHO DO RUI:");

		// Estrutura de repetição para manter o menu ativo até que o usuário escolha
		// sair
		while (true) {
			System.out.println("\n1-Adicionar Moeda");
			System.out.println("2-Remover Moeda");
			System.out.println("3-Listar Moedas");
			System.out.println("4-Calcular total convertido");
			System.out.println("0-Encerrar");
			System.out.print("Escolha uma opção: ");
			opcao = teclado.nextInt();

			// Condição de parada do loop principal
			if (opcao == 0) {
				System.out.println("Encerrando o programa...");
				break;
			}

			int tipoMoeda;
			double valorMoeda;
			// Referência genérica da classe mãe para aplicar polimorfismo
			MoedaMae moeda = null;

			// Switch-case para direcionar o fluxo conforme a opção escolhida pelo usuário
			switch (opcao) {
			case 1: // Opção para Adicionar moedas
				System.out.println("1-Real | 2-Dolar | 3-Euro");
				tipoMoeda = teclado.nextInt();
				System.out.print("Digite o valor: ");
				valorMoeda = teclado.nextDouble();

				// Validação preventiva para garantir que não entrem valores negativos ou zero
				if (valorMoeda <= 0) {
					System.out.println("ERRO: O valor deve ser maior que zero!");
					break;
				}

				// Instanciação da classe específica conforme o tipo escolhido
				if (tipoMoeda == 1)
					moeda = new Real(valorMoeda);
				else if (tipoMoeda == 2)
					moeda = new Dolar(valorMoeda);
				else if (tipoMoeda == 3)
					moeda = new Euro(valorMoeda);

				// Verifica se a moeda foi instanciada antes de adicionar à coleção
				if (moeda != null) {
					cofrinho.adicionar(moeda);
					System.out.println("Moeda adicionada!");
				} else {
					System.out.println("Tipo de moeda inexistente.");
				}
				break;

			case 2: // Opção para Remover moedas específicas
				System.out.println("Escolha a moeda para remover: 1-Real | 2-Dolar | 3-Euro");
				tipoMoeda = teclado.nextInt();
				System.out.print("Digite o valor exato para remover: ");
				valorMoeda = teclado.nextDouble();

				if (valorMoeda <= 0) {
					System.out.println("ERRO: Valor inválido para remoção.");
					break;
				}

				// Criamos um objeto temporário para localizar a moeda correspondente no
				// cofrinho
				if (tipoMoeda == 1)
					moeda = new Real(valorMoeda);
				else if (tipoMoeda == 2)
					moeda = new Dolar(valorMoeda);
				else if (tipoMoeda == 3)
					moeda = new Euro(valorMoeda);

				if (moeda != null) {
					cofrinho.remover(moeda);
				}
				break;

			case 3: // Opção para Listagem das moedas presentes na coleção
				cofrinho.listagemMoedas();
				break;

			case 4: // Opção para exibir o Total convertido para Real
				double total = cofrinho.totalConvertido();
				System.out.printf("Total convertido para Real: R$ %.2f\n", total);
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
		// Fechamento do scanner para liberar o recurso, é uma prática recomendada
		teclado.close();
	}
}