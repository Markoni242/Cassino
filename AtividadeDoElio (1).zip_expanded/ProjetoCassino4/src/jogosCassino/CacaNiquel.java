package jogosCassino;

import java.util.ArrayList;

import entidades.Combinacao;

public class CacaNiquel extends Jogo {
	private int colunas;
	private Combinacao[] sorteados;
	private ArrayList<Combinacao> possiveis;
	private Combinacao qualCombinacao;
		
	public CacaNiquel(int colunas) {
		String[] nomeCombinacao = {"cora�ao","bar","gold","trevo","7"};
		int[] valorCombinacao = {100,200,300,400,500};
		this.colunas = colunas;
		
		this.sorteados = new Combinacao[colunas];
		this.possiveis = new  ArrayList<Combinacao>();
		
		for (int i = 1; i <5; i++) {
			this.possiveis.add(new Combinacao(valorCombinacao[i], nomeCombinacao[i]));
		}
	}
	
	@Override
	public boolean start() {
		System.out.println();
		for (int i = 0; i<colunas;i++) {
			sorteados[i] = possiveis.get(gerador.nextInt(possiveis.size()-1) + 1);
		}
		
		System.out.print("Resultado : ");
		for (int i = 0; i<sorteados.length;i++) {
			System.out.print(sorteados[i] +" ");
		}
		
		for (int i = 0; i < sorteados.length; i++) {
			if (sorteados[0]!=sorteados[i]) {
				System.out.println(" Sem combina�oes");
				return false;
			}
		}
		
		System.out.println();
		System.out.println(" Voce ganhou : "+sorteados[0].getValor()+ " fichas.");
		qualCombinacao = sorteados[0];
		return true;
	}
	
	public int premiacao() {
		return qualCombinacao.getValor();
	}
	
}
