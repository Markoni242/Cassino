package minigamesTrabalhos;

import jogosCassino.Jogo;

public class JogoSeguranca extends Jogo {
	private String mover;
	private char[][] sala;
	
	private int SegurancaX;
	private int SegurancaY;
	
	public JogoSeguranca() {
		super();
	}

	@Override
	public boolean start() {
		
		for (int i = 0; i < 5; i++) {
			mover = "";
			if (gerador.nextInt() > 6) {
				sala = construirGame();
				System.out.println();
				System.out.println("Va ate o local = (E) e resolva o problema");
				
				while (true) {
					imprimeSala();
					
					if (checarEnimigo()) {
						System.out.println();
						System.out.println("Resolvido");
						break;
					}
					
					mover = sc.next();
					System.out.println();
					if (mover.length() > 1) {
						System.out.println("movimento invalido");
					} else {
						movimento(mover.charAt(0));
					}
				}
		    } else {
		    	int cont = 0;
		    	while (mover.equals("1") == false) {
		    		if (cont == 1) {
		    			System.out.println();
		    			System.out.println("opcao invalida");
		    		}
		    		System.out.println();
		    		System.out.println("Nada esta acontecendo :");
		    		System.out.println("Esperar               : 1");
		    		mover = sc.next();
		    		cont = 1;
		    	}
		    }
		}
		return true;
	}
		
	public void imprimeSala() {
		
		for (int i = 0; i < sala.length; i++) {
			for (int x = 0; x < sala[i].length; x++) {
				if (SegurancaX == x && SegurancaY == i) {
					System.out.print(" "+'F');
				} else {
					System.out.print(" "+sala[i][x]);
				}
			}
			System.out.println();
		}
	}
	
	public void movimento(char possicao) {
		if (possicao == 'w' && SegurancaY > 0) {
			SegurancaY-=1;
		} else if (possicao == 's' && SegurancaY < 3) {
			SegurancaY+=1;
		} else if (possicao == 'd' && SegurancaX < 3) {
			SegurancaX+=1;
		} else if (possicao == 'a' && SegurancaX > 0) {
			SegurancaX-=1;
		} else {
			System.out.println("movimento invalido");
		}
		if (sala[SegurancaY][SegurancaX] == 'E') {
			sala[SegurancaY][SegurancaX] = '_';
		}  
	}
	
	public boolean checarEnimigo() {
		for (int i = 0; i < 3; i++) {
			for (int x = 0; x < 3; x++) {
				if (this.sala[i][x] == 'E') {
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
		
		this.SegurancaX = 0;
		this.SegurancaY = 0;
		
		for (int i = 1; i < 3; i++) {
			for (int x = 0; x < 3; x++) {
				if (gerador.nextInt(9) > 6) {
					sala[i][x] = 'E';
					return sala;
				} 
			}
		} 
		if (checarEnimigo()) {
			sala[3][3] = 'E';
		}
		
		return sala;
	}
}



