package itensBuckshotRoulette;

import jogosCassino.BuckshotRoulette;

public class LataDeCerveja extends Item {
    @Override
    public void usar(BuckshotRoulette jogo) {
        jogo.ejetarCartucho();
    }
}
