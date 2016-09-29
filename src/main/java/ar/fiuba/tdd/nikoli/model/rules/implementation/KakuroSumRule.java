package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.sets.SumCellSet;

/**
 * Rule for Kakuro set sum validation.
 */
public class KakuroSumRule extends Rule<SumCellSet> {

    public KakuroSumRule() {
        super(new KakuroSetBuilder(), new SumRule());
    }
}
