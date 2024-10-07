package minigamesTrabalhos;

import jogosCassino.Jogo;

public class JogoFaxineiro extends Jogo {
	private String mover;
	private char[][] sala;
	
	private int faxineiroX;
	private int faxineiroY;
	private int movimentosRestantes;
	
	public JogoFaxineiro() {
		super();
	}

	@Override
	public boolean start() {
		
		sala = construirGame();
		
		
		System.out.println();
		System.out.println("Recolha o lixo = (L) em : "+movimentosRestantes+" movimentos");
		
		while (true) {
			imprimeSala();
			
			if (checarLixo() || movimentosRestantes == 0) {
				System.out.println();
				if (checarLixo()) {
					System.out.println("Local limpo");
					return true;
				} else {
					System.out.println("Voce perdeu");
					return false;
				}
			}
			
			mover = sc.next();
			System.out.println();
			if (mover.length() > 1) {
				System.out.println("movimento invalido");
			} else {
				movimento(mover.charAt(0));
			}
		}
    }
	
	public void imprimeSala() {
		
		for (int i = 0; i < sala.length; i++) {
			for (int x = 0; x < sala[i].length; x++) {
				if (faxineiroX == x && faxineiroY == i) {
					System.out.print(" "+'F');
				} else {
					System.out.print(" "+sala[i][x]);
				}
			}
			System.out.println();
		}
	}
	
	public void movimento(char possicao) {
		if (possicao == 'w' && faxineiroY > 0) {
			faxineiroY-=1;
		} else if (possicao == 's' && faxineiroY < 3) {
			faxineiroY+=1;
		} else if (possicao == 'd' && faxineiroX < 3) {
			faxineiroX+=1;
		} else if (possicao == 'a' && faxineiroX > 0) {
			faxineiroX-=1;
		} else {
			System.out.println("movimento invalido");
		}
		if (sala[faxineiroY][faxineiroX] == 'L') {
			sala[faxineiroY][faxineiroX] = '_';
		}  
		movimentosRestantes -= 1;
	}
	
	public boolean checarLixo() {
		for (int i = 0; i < sala.length; i++) {
			for (int x = 0; x < sala[i].length; x++) {
				if (sala[i][x] == 'L') {
					return false;
				}
			}
		}
		return true;
	}
	
	public char[][] construirGame() {
		
		char[][] sala = {
		        {'_', '_', '_', '_'},
		        {'_', '_', '_', '_'},
		        {'_', '_', '_', '_'},
		        {'_', '_', '_', '_'}};
		
		this.faxineiroX = 0;
		this.faxineiroY = 0;
		
		this.movimentosRestantes = 10;
		
		for (int i = 0; i < 3; i++) {
			for (int x = 0; x < 3; x++) {
				if (gerador.nextInt(9) >= 5) {
					sala[i][x] = 'L';
				} 
			}
		}
		if (sala[faxineiroY][faxineiroX] == 'L') {
			sala[faxineiroY][faxineiroX] = '_';
		}
		
		return sala;
	}
    	
}
