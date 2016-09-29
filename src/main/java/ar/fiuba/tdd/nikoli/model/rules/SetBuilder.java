package ar.fiuba.tdd.nikoli.model.rules;

import java.util.List;

/**
 * Created by ishilkov on 9/29/16.
 */
public interface SetBuilder<T> {

    List<?extends T> buildRuleCellSets(GameBoardIterator board);
}
