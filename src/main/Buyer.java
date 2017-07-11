package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import db.SqlRunner;

/**
 * Created by user on 09/07/2017.
 */

public class Buyer extends Company {

    private int budget;
    private String financialYearEnd;

    public Buyer(String name, String registration, int budget, String financialYearEnd) {
        super(name, registration);
        this.budget = budget;
        this.financialYearEnd = financialYearEnd;
    }

    public int getBudget() {
        return budget;
    }

    public String getFinancialYearEnd() {
        return financialYearEnd;
    }

    public int totalActualSpend() {

        int total = 0;
        String sql = "SELECT SUM(actualValue) FROM contracts;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while(rs.next()) {
                total += rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlRunner.closeConnection();
        return total;

    }

}