package itensBuckshotRoulette;

import jogosCassino.BuckshotRoulette;

public class Algemas extends Item {
    @Override
    public void usar(BuckshotRoulette jogo) {
        // Aplica o efeito das algemas
        jogo.bloquearProximoTurno();
        System.out.println("Algemas usadas!");
    }
}
