package jogosCassino;

import java.util.ArrayList;
import java.util.Collections;

public class Keno extends Jogo {

	private ArrayList<Integer> numerosTabela;
	private int numerosEscolhidos;

	public Keno() {
		this.numerosTabela = new ArrayList<>();
		this.numerosEscolhidos = 10;
	}

	@Override
	
	public String toString() {
		return "Keno";
	}
	
	public boolean start() {
		System.out.println("Bem-vindo ao Keno!!!");

		iniciarTabela();

		ArrayList<Integer> escolhas = new ArrayList<>();
		System.out.println("Escolha " + numerosEscolhidos + " números entre 1 e 80:");

		while (escolhas.size() < numerosEscolhidos) {
			int escolha = sc.nextInt();
			if (escolha >= 1 && escolha <= 80 && !escolhas.contains(escolha)) {
				escolhas.add(escolha);
			} else {
				System.out.println("Número inválido ou já escolhido. Tente novamente.");
			}
		}
		System.out.println("Seus números escolhidos: " + escolhas);
		verificarResultado(escolhas);

		return true;
	}

	private void iniciarTabela() {
		for (int i = 1; i <= 80; i++) {
			numerosTabela.add(i);
		}
		Collections.shuffle(numerosTabela); // Embaralhador
	}

	// Sorteador de numeros automatico, só falta a casa automatrica
	private ArrayList<Integer> sortearNumeros() {
		ArrayList<Integer> numerosSorteados = new ArrayList<>();
		Collections.shuffle(numerosTabela);
		for (int i = 0; i < 20; i++) {
			numerosSorteados.add(numerosTabela.get(i));
		}
		return numerosSorteados;
	}

	private void verificarResultado(ArrayList<Integer> escolhas) {
		// sorteador de numeros automatico, agora só falta a casa automatica
		ArrayList<Integer> numerosSorteados = sortearNumeros();
		System.out.println("Números sorteados: " + numerosSorteados);

		int acertos = 0;

		for (int numero : escolhas) {
			if (numerosSorteados.contains(numero)) {
				acertos++;
			}
		}
		System.out.println("Você acertou " + acertos + " número(s).");
	}
}