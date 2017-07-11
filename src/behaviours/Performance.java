package behaviours;

public enum Performance {
    RED("Red"),
    AMBER("Amber"),
    GREEN("Green");

    private String performanceType;

    Performance(String performanceType) {
        this.performanceType = performanceType;
    }

    public String getPerformanceType() {
        return this.performanceType;
    }

}