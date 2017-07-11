package tests;
import main.*;

import org.junit.Test;

import behaviours.Cat;
import behaviours.Status;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 10/07/2017.
 */

public class ScorerTest {

    Supplier supplier;
    Contract contract;
    Scorer scorer;

    @Test
    public void canScoreSupplier_() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 0);
        contract = new Contract("200 MacBook Pros", "Edward Ng", 1, Status.PIPELINE, Cat.IT, 3, "2017-07-07", "2018-07-07", 40000, 45000, "Procurement of new laptops for new location in Aberdeen");
        scorer = new Scorer(supplier, contract);
        assertEquals(77, scorer.scoreSupplier());
    }

}