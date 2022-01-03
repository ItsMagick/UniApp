package Models;

public class Semester {
    private final String id;
    private final String displayName;

    public Semester(String id, String displayName) {
        this.id = id.replace("#", "_");
        this.displayName = displayName;
    }

    public String getYear() {
        return id.split("_")[2];
    }

    public String getType() {
        return id.split("_")[1];
    }

    public String getSemesterNumber() {
        return id.split("_")[0];
    }

    public String getName() {
        return displayName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
