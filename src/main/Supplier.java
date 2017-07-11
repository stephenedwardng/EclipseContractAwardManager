package main;

import java.sql.ResultSet;
import db.SqlRunner;

/**
 * Created by user on 08/07/2017.
 */

public class Supplier extends Company implements Screenable, Scorable {

    private int id;
    private int financialScore;
    private int valueScore;
    private int deliveryScore;
    private int exclude;
    private int insurance;
    private int courtJudgement;

    public Supplier(String name, String registration, int financialScore, int valueScore, int deliveryScore, int exclude, int insurance, int courtJudgement) {
        super(name, registration);
        this.financialScore = financialScore;
        this.valueScore = valueScore;
        this.deliveryScore = deliveryScore;
        this.exclude = exclude;
        this.insurance = insurance;
        this.courtJudgement = courtJudgement;
    }

    public int getFinancialScore() {
        return financialScore;
    }

    public void setFinancialScore(int financialScore) {
        this.financialScore = financialScore;
    }

    public int getValueScore() {
        return valueScore;
    }

    public void setValueScore(int valueScore) {
        this.valueScore = valueScore;
    }

    public int getDeliveryScore() {
        return deliveryScore;
    }

    public void setDeliveryScore(int deliveryScore) {
        this.deliveryScore = deliveryScore;
    }

    public int isExclude() {
        return exclude;
    }

    public void setExclude(int exclude) {
        this.exclude = exclude;
    }

    public int hasInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int hasCourtJudgement() {
        return courtJudgement;
    }

    public void setCourtJudgement(int courtJudgement) {
        this.courtJudgement = courtJudgement;
    }


    // CRUD begins

    public void save() {
        String sql = String.format("INSERT INTO suppliers (name, registration, financialScore, valueScore, deliveryScore, exclude, insurance, courtJudgement) " +
                "VALUES ('%s', '%s', %d, %d, %d, %d, %d, %d)", this.name, this.registration, this.financialScore, this.valueScore, this.deliveryScore, this.exclude, this.insurance, this.courtJudgement);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all() {
        String sql = "SELECT * FROM suppliers;";
        ResultSet rs = SqlRunner.executeQuery(sql);

        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String registration = rs.getString("registration");
                int financialScore = rs.getInt("financialScore");
                int valueScore = rs.getInt("valueScore");
                int deliveryScore = rs.getInt("deliveryScore");
                int exclude = rs.getInt("exclude");
                int insurance = rs.getInt("insurance");
                int courtJudgement = rs.getInt("courtJudgement");


                System.out.println("Name: " + name);
                System.out.println("Registration: " + registration);
                System.out.println("Financial Score: " + financialScore);
                System.out.println("Value Score: " + valueScore);
                System.out.println("Delivery Score: " + deliveryScore);
                System.out.println("Exclude: " + exclude);
                System.out.println("Insurance: " + insurance);
                System.out.println("Court Judgement: " + courtJudgement);
            }
        }catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }

    }

    public static void deleteAll() {
        String sql = "DELETE FROM suppliers;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete() {
        String sql = String.format("DELETE FROM suppliers WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update() {
        String sql = String.format("UPDATE suppliers SET name = '%s', registration = '%s', financialScore = %d, valueScore = %d, deliveryScore = %d, exclude = %d, insurance = %d, courtJudgement = %d WHERE id = %d;", this.name, this.registration, this.financialScore, this.valueScore, this.deliveryScore, this.exclude, this.insurance, this.courtJudgement);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static Supplier findSupplier(int supplier_id) {
        Supplier supplier = null;
        String sql = String.format("SELECT * FROM suppliers WHERE id = %d;", supplier_id);
        ResultSet rs = SqlRunner.executeQuery(sql);

        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String registration = rs.getString("registration");
                int financialScore = rs.getInt("financialScore");
                int valueScore = rs.getInt("valueScore");
                int deliveryScore = rs.getInt("deliveryScore");
                int exclude = rs.getInt("exclude");
                int insurance = rs.getInt("insurance");
                int courtJudgement = rs.getInt("courtJudgement");


                supplier = new Supplier(name, registration, financialScore, valueScore, deliveryScore, exclude, insurance, courtJudgement);
            }
        }catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return supplier;
    }

    public String prettySupplier(Supplier supplier) {
        return String.format("'%s', '%s', %d, %d, %d, %d, %d, %d", supplier.name, supplier.registration, supplier.financialScore, supplier.valueScore, supplier.deliveryScore, supplier.exclude, supplier.insurance, supplier.courtJudgement);
    }

}