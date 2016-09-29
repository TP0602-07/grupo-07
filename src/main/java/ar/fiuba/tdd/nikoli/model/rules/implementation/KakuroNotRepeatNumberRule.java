package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;


/**
 * Created by ishilkov on 9/28/16.
 */
public class KakuroNotRepeatNumberRule extends Rule<CellSet> {

    public KakuroNotRepeatNumberRule() {
        super(new KakuroSetBuilder(), new NotRepeatNumberRule());
    }
}
