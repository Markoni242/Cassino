package itensBuckshotRoulette;

import jogosCassino.BuckshotRoulette;

public class Lupa extends Item {
    @Override
    public void usar(BuckshotRoulette jogo) {
        jogo.revelarCartucho(); // Revela o estado do cartucho

        // Se for a vez do dealer, ele age automaticamente
        if (jogo.turnoDealer()) {
            // Se o cartucho for cinza, o dealer atira em si mesmo
            if (!jogo.getCartuchoAtual()) { // cartucho atual é cinza
                System.out.println("O dealer atirou em si mesmo.");
                jogo.atirarEmSiMesmo();
            } else { // se o cartucho for vermelho
                System.out.println("O dealer atirou em você.");
                jogo.atirarNoDealer();
            }
        } else {
            // Interação com o jogador
         
            System.out.println("Deseja atirar em si mesmo (1) ou no dealer (2)?");
            String escolha = sc.nextLine();
            
            if (escolha.equals("1")) {
                jogo.atirarEmSiMesmo();
            } else if (escolha.equals("2")) {
                jogo.atirarNoDealer();
            } else {
                System.out.println("Escolha inválida!");
            }
        }
    }
}
