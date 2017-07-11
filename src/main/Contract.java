package main;


import behaviours.Cat;
import behaviours.Performance;
import behaviours.Status;
import java.sql.ResultSet;
import db.SqlRunner;
import static behaviours.Performance.AMBER;
import static behaviours.Performance.GREEN;
import static behaviours.Performance.RED;

/**
 * Created by user on 07/07/2017.
 */

public class Contract implements Reportable {

    private int id;
    private String title;
    private String manager;
    private int supplier_id;
    private Status status;
    private Cat category;
    private int strategicImportanceRating;
    private String startDate;
    private String endDate;
    private int contractedValue;
    private int actualValue;
    private String description;

    public Contract(String title, String manager, int supplier_id, Status status, Cat category, int strategicImportanceRating, String startDate, String endDate, int contractedValue, int actualValue, String description) {
        this.title = title;
        this.manager = manager;
        this.supplier_id = supplier_id;
        this.status = status;
        this.category = category;
        this.strategicImportanceRating = strategicImportanceRating;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractedValue = contractedValue;
        this.actualValue = actualValue;
        this.description = description;
    }

    public Contract(String title, String manager, int supplier_id, int strategicImportanceRating, String startDate, String endDate, int contractedValue, int actualValue, String description) {
        this.title = title;
        this.manager = manager;
        this.supplier_id = supplier_id;
        this.strategicImportanceRating = strategicImportanceRating;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractedValue = contractedValue;
        this.actualValue = actualValue;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cat getCategory() {
        return category;
    }

    public void setCategory(Cat category) {
        this.category = category;
    }

    public int getStrategicImportanceRating() {
        return strategicImportanceRating;
    }

    public void setStrategicImportanceRating(int strategicImportanceRating) {
        this.strategicImportanceRating = strategicImportanceRating;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getContractedValue() {
        return contractedValue;
    }

    public void setContractedValue(int contractedValue) {
        this.contractedValue = contractedValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int calcChangeValue() {
        return contractedValue - actualValue;
    }

    public Performance valuePerformance() {
        double variance = (double)actualValue / (double)contractedValue;

        if (variance < 0.8) {
            return GREEN;
        } else if (variance <= 1.0) {
            return AMBER;
        } else if (variance > 1.0) {
            return RED;
        }
        else return null;
    }

    // CRUD begins

    public void save() {
        String sql = String.format("INSERT INTO contracts (title, manager, supplier_id, status, category, strategicImportanceRating, startDate, endDate, contractedValue, actualValue, description) " +
                "VALUES ('%s', '%s', %d, '%s', '%s', %d, '%s', '%s', %d, %d, '%s')", this.title, this.manager, this.supplier_id, this.status, this.category, this.strategicImportanceRating, this.startDate, this.endDate, this.contractedValue, this.actualValue, this.description);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all() {
        String sql = "SELECT * FROM contracts;";
        ResultSet rs = SqlRunner.executeQuery(sql);

        try {
            while (rs.next()) {
                String title = rs.getString("title");
                String manager = rs.getString("manager");
                int supplier_id = rs.getInt("supplier_id");
                String status = rs.getString("status");
                String category = rs.getString("category");
                int strategicImportanceRating = rs.getInt("strategicImportanceRating");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                int contractedValue = rs.getInt("contractedValue");
                int actualValue = rs.getInt("actualValue");
                String description = rs.getString("description");

                System.out.println("Title: " + title);
                System.out.println("Screener: " + manager);
                System.out.println("Supplier ID: " + supplier_id);
                System.out.println("Status: " + status);
                System.out.println("Category: " + category);
                System.out.println("Strategic Importance Rating: " + strategicImportanceRating);
                System.out.println("Start Date: " + startDate);
                System.out.println("End Date: " + endDate);
                System.out.println("Contracted Value: " + contractedValue);
                System.out.println("Actual Value: " + actualValue);
                System.out.println("Description: " + description);
            }
        }catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll() {
        String sql = "DELETE FROM contracts;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete() {
        String sql = String.format("DELETE FROM contracts WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update() {
        String sql = String.format("UPDATE contracts SET title = '%s', manager = '%s', supplier_id = %d, status = '%s', category = '%s', strategicImportanceRating = %d, startDate = '%s', endDate = '%s', contractedValue = '%s', actualValue = '%s', description = '%s' WHERE id = %d;", this.title, this.manager, this.supplier_id, this.status, this.category, this.strategicImportanceRating, this.startDate, this.endDate, this.contractedValue, this.actualValue, this.description);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static Contract findContract(int contract_id) {
        Contract contract = null;
        String sql = String.format("SELECT * FROM contracts WHERE id = %d;", contract_id);
        ResultSet rs = SqlRunner.executeQuery(sql);

        try {
            while (rs.next()) {
                String title = rs.getString("title");
                String manager = rs.getString("manager");
                int supplier_id = rs.getInt("supplier_id");
                String status = rs.getString("status");
                String category = rs.getString("category");
                int strategicImportanceRating = rs.getInt("strategicImportanceRating");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                int contractedValue = rs.getInt("contractedValue");
                int actualValue = rs.getInt("actualValue");
                String description = rs.getString("description");

                contract = new Contract(title, manager, supplier_id, strategicImportanceRating, startDate, endDate, contractedValue, actualValue, description);
            }
        }catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return contract;
    }

    public String prettyContract(Contract contract) {
        return String.format("'%s', '%s', %d, %d, '%s', '%s', %d, %d, '%s'", contract.title, contract.manager, contract.supplier_id, contract.strategicImportanceRating, contract.startDate, contract.endDate, contract.contractedValue, contract.actualValue, contract.description);
    }

    public static int countContractsByStatus(Status status) {
        int count = 0;
        String sql = String.format("SELECT * FROM contracts WHERE status = '%s';", status);
        ResultSet rs = SqlRunner.executeQuery(sql);

        try {
            while (rs.next()) {
                count++;
            }
        }catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return count;
    }

    public static int countContractsByCategory(Cat category) {
        int count = 0;
        String sql = String.format("SELECT * FROM contracts WHERE category = '%s';", category);
        ResultSet rs = SqlRunner.executeQuery(sql);

        try {
            while (rs.next()) {
                count++;
            }
        }catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return count;
    }

}