🪙 Projeto Cofrinho - POO em Java
Este projeto foi desenvolvido como parte da disciplina de Programação Orientada a Objetos no curso de Análise e Desenvolvimento de Sistemas (ADS). O objetivo é aplicar conceitos fundamentais de POO através de um sistema que gerencia diferentes moedas em um cofrinho virtual.

🚀 Tecnologias Utilizadas
Linguagem: Java 17+

Conceitos: Abstração, Herança, Polimorfismo e Coleções (ArrayList).

IDE: Eclipse / VS Code.

Versionamento: Git & GitHub.

🧠 Aprendizados e Conceitos Aplicados
O foco principal deste trabalho foi a prática dos pilares da Orientação a Objetos:

Classes Abstratas: Utilização da classe Moeda como base para garantir que todas as moedas tenham comportamentos padronizados (como converter() e info()), mas sem poderem ser instanciadas diretamente.

Herança: As classes Real, Dolar e Euro herdam as características da classe mãe, especializando o comportamento de conversão.

Polimorfismo: Implementação de uma lista única (ArrayList<Moeda>) que consegue armazenar e manipular diferentes tipos de moedas de forma genérica.

Coleções: Uso de ArrayList para gerenciar a adição, remoção e listagem dinâmica dos objetos no cofrinho.

🛠️ Como Funciona
O sistema oferece um menu interativo via console para:

Adicionar Moedas: Inserir valores em Real, Dólar ou Euro.

Remover Moedas: Retirar valores específicos já existentes no cofrinho.

Listar Moedas: Exibir todos os itens armazenados.

Calcular Total Convertido: Somar todos os valores e converter para uma moeda base (Real), demonstrando a lógica de conversão individual de cada classe.
