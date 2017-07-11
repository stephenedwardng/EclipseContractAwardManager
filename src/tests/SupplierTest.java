package tests;
import main.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 08/07/2017.
 */

public class SupplierTest {

    Supplier supplier;

    @Test
    public void canGetName() {
        supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 1, 1, 1);
        assertEquals("Tyrell Corporation", supplier.getName());
    }

    @Test
    public void canFindSupplier() {
        Supplier supplier = new Supplier("Tyrell Corporation", "SC 0754429", 9, 6, 8, 1, 1, 1);
        supplier.save();
        assertEquals("'Tyrell Corporation', 'SC 0754429', 9, 6, 8, 1, 1, 1", supplier.prettySupplier(supplier));
    }
}