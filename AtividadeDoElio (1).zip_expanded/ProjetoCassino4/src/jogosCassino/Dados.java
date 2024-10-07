package jogosCassino;

public class Dados extends Jogo {

	private int[] numeros;
	private int soma;
	private String resposta;

	public Dados(int quantiaDados) {
		super();
		this.numeros = new int[quantiaDados];
		this.soma=0;
	}

	@Override
	public boolean start() {
		System.out.println();
		System.out.println("Adivinhe o numero dos a soma dos dados:");
	    resposta = sc.next();
		
		for (int i = 0; i < numeros.length; i++ ) {
			numeros[i] = gerador.nextInt(5) + 1;
			soma += numeros[i];
		}
		
		System.out.println();
		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Dado "+(1+i)+": "+numeros[i]+ ", ");
		}
		
		if (resposta.equals(soma+"")) {
			System.out.print(": Acertou \n\n");
			return true;
		} else {
			System.out.print(": Errou \n\n");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Dados";
	}
}
