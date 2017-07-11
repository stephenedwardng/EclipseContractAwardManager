package tests;
import main.*;
import org.junit.Test;

import behaviours.Cat;
import behaviours.Status;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 09/07/2017.
 */

public class ScreenerTest {

    Supplier supplier;
    Contract contract;
    Screener screener;

    @Test
    public void canCheckExcluded_true() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 1, 1, 0);
        screener = new Screener(supplier);
        assertEquals(true, screener.checkExcluded());
    }

    @Test
    public void canCheckExcluded_false() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 0);
        screener = new Screener(supplier);
        assertEquals(false, screener.checkExcluded());
    }

    @Test
    public void canCheckHasInsurance_true() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 0);
        screener = new Screener(supplier);
        assertEquals(true, screener.checkInsurance());
    }

    @Test
    public void canCheckHasInsurance_false() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 0, 0);
        screener = new Screener(supplier);
        assertEquals(false, screener.checkInsurance());
    }

    @Test
    public void canCheckHasCourtJudgement_true() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 1);
        screener = new Screener(supplier);
        assertEquals(true, screener.checkCourtJudgement());
    }

    @Test
    public void canCheckHasCourtJudgement_false() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 0);
        screener = new Screener(supplier);
        assertEquals(false, screener.checkCourtJudgement());
    }

    @Test
    public void canScreenForEligibility__supplier_passes() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 0);
        screener = new Screener(supplier);
        assertEquals(true, screener.screenForEligibility());
    }

    @Test
    public void canScreenForEligibility__supplier_fails() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 1);
        screener = new Screener(supplier);
        assertEquals(false, screener.screenForEligibility());
    }

    @Test
    public void canCheckStatusOpenToSuppliers__contract_open() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 0);
        contract = new Contract("200 MacBook Pros", "Edward Ng", 1, Status.PIPELINE, Cat.IT, 3, "2017-07-07", "2018-07-07", 40000, 45000, "Procurement of new laptops for new location in Aberdeen");
        screener = new Screener(supplier, contract);
        assertEquals(true, screener.checkStatusOpenToSuppliers());
    }

    @Test
    public void canCheckStatusOpenToSuppliers__contract_locked() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 0, 1, 0);
        contract = new Contract("200 MacBook Pros", "Edward Ng", 1, Status.LIVE, Cat.IT, 3, "2017-07-07", "2018-07-07", 40000, 45000, "Procurement of new laptops for new location in Aberdeen");
        screener = new Screener(supplier, contract);
        assertEquals(false, screener.checkStatusOpenToSuppliers());
    }
}
