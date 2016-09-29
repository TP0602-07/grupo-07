package ar.fiuba.tdd.nikoli.model.rules;

import java.util.List;

/**
 * Created by ishilkov on 9/29/16.
 */
public interface RuleValidator<T> {

    boolean isRuleBroken(SetBuilder<? extends T> setBuilder, GameBoardIterator board);
}
