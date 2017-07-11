package behaviours;

public enum Cat {
    IT("IT"),
    FACILITIES("Facilities Management"),
    TELECOM("Telecom"),
    INSURANCE("Insurance"),
    HR("HR"),
    PLANT("Plant"),
    MARKETING("Marketing");

    private String categoryType;

    Cat(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryType() {
        return this.categoryType;
    }

}