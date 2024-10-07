package minigamesTrabalhos;

import entidades.Prato;
import jogosCassino.Jogo;

public class JogoCozinheiro extends Jogo {
	private Prato[] receitas;
    private int erros;
    private Prato prato;
    private String igrediente;

    public JogoCozinheiro() {
		super();

		String[] receitaSalada = {"alface", "tomate", "pepino", "cenoura"};
		String[] receitaAmburguer = {"pao", "Hamburguer", "alface", "tomate", "queijo"};
		String[] receitaOmelete = {"ovos", "sal", "pimenta", "queijo"};
		String[] receitaSopa = {"agua", "sal", "cenoura", "batata"};
		String[] receitaPizza = {"massa", "molho de tomate", "queijo", "pepperoni"};
		String[] receitaMacarrao = {"Macarrao", "Molho de tomate", "Queijo", "Manjeric�o"};
		String[] receitaPanqueca = {"farinha", "ovos", "leite", "mel"};
		String[] receitaTaco = {"tortilla", "carne", "alface", "queijo", "molho picante"};
		
		this.receitas = new Prato[8];
		this.receitas[0] = new Prato("Salada",receitaSalada);
		this.receitas[1] = new Prato("Hamburguer",receitaAmburguer);
		this.receitas[2] = new Prato("Omelete",receitaOmelete);
		this.receitas[3] = new Prato("Sopa",receitaSopa);
		this.receitas[4] = new Prato("Pizza",receitaPizza);
		this.receitas[5] = new Prato("Macarrao",receitaMacarrao);
		this.receitas[6] = new Prato("Panqueca",receitaPanqueca);
		this.receitas[7] = new Prato("Taco",receitaTaco);
		
	}
    
    @Override
    public boolean start() {
    	erros =  0;
    	System.out.println();
    	for (int x = 0; x < 5; x++ ) {
    		System.out.println();
    		prato = receitas[gerador.nextInt(3)];
    		System.out.println("Monte o prato : "+prato);
	    	
			for (int i = 0; i < prato.getListaSize(); i++) {
				igrediente = sc.next();
				if (prato.getIgrediente(i).equals(igrediente)) {
					System.out.println("Acertou...");
				} else {
					System.out.println("errou...");
					System.out.println("Era : "+prato.getIgrediente(i));
					erros += 1;
				}
	    	}
    	}
		System.out.println();
		System.out.println("Fim, voce errou : " + erros);
		if (erros > 3) {
			return false;
		}
		return true;
    }
}
