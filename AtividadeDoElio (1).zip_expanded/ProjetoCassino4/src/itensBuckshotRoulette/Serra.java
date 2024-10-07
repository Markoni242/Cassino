package itensBuckshotRoulette;

import jogosCassino.BuckshotRoulette;

public class Serra extends Item {
    @Override
    public void usar(BuckshotRoulette jogo) {
        jogo.transformarEmSerrada();
    }
}
