package itensBuckshotRoulette;

import jogosCassino.BuckshotRoulette;

public class Cigarro extends Item {
    @Override
    public void usar(BuckshotRoulette jogo) {
        if (jogo.turnoDealer()) {
            jogo.restaurarVidaDealer(20); 
            System.out.println("Dealer restaurou 20 de vida.");
        } else {
            jogo.restaurarVida(20);
            System.out.println("Jogador restaurou 20 de vida.");
        }
    }
}
