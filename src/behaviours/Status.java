package behaviours;

public enum Status {
    PIPELINE("Pipeline"),
    LIVE("Live"),
    EXPIRED("Expired");

    private String statusType;

    Status(String statusType) {
        this.statusType = statusType;
    }

    public String getStatusType() {
        return this.statusType;
    }

}