package tests;
import main.*;
import org.junit.Before;
import org.junit.Test;

import behaviours.Cat;
import behaviours.Status;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 10/07/2017.
 */

public class ReportTest {

    Report report;
    Buyer buyer;
    Contract contract;

    @Before
    public void before() {

        buyer = new Buyer("CodeClan", "SC009857568", 250000, "2018-04-05");
        report = new Report(buyer);

        Contract.deleteAll();
        Contract contract1 = new Contract("200 MacBook Pros", "Edward Ng", 1, Status.LIVE, Cat.IT, 1, "2017-07-07", "2018-07-07", 40000, 45000, "Procurement of new laptops for new location in Aberdeen");
        contract1.save();
        Contract contract2 = new Contract("1000 CodeClan pens", "Edward Ng", 2, Status.PIPELINE, Cat.MARKETING, 4, "2017-10-10", "2018-10-10", 3000, 3000, "Procurement of promotional pens for events and students");
        contract2.save();
        Contract contract3 = new Contract("2 Soap Dispensers", "Edward Ng", 3, Status.EXPIRED, Cat.FACILITIES, 2, "2016-05-07", "2017-05-07", 1000, 1500, "Wall mounted soap dispensers");
        contract3.save();
        Contract contract4 = new Contract("6 Phones", "Edward Ng", 4, Status.LIVE, Cat.TELECOM, 3, "2017-03-10", "2018-03-10", 25000, 35000, "Phones for central stall and instructors");
        contract4.save();
        Contract contract5 = new Contract("Business Insurance", "Edward Ng", 5, Status.LIVE, Cat.INSURANCE, 5, "2017-08-09", "2018-08-09", 70000, 80000, "Insurance cover for business");
        contract5.save();

    }

    @Test
    public void checkTotalActualSpend() {
        assertEquals(164500, buyer.totalActualSpend());
    }

    @Test
    public void checkPercentageBudgetSpent() {
        assertEquals(66, report.percentageBudgetSpent());
    }

}