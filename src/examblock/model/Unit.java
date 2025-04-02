package examblock.model;

public class Unit {

    private Subject subject;
    private Character unitId;
    private String title;
    private String description;

    // private methods to check the constructor parameters

    private void validateParameters(Subject subject, Character unitId, String title, String description) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null.");
        }
        if (unitId == null || !Character.toString(unitId).matches("[0-9A-Z]")) {
            throw new IllegalArgumentException("Unit ID must be a single character (0-9 or A-Z).");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (!title.matches("([A-Z][a-z]*|[0-9]+|I{1,3}|IV|V?I{0,3})+( [A-Z][a-z]*|[0-9]+|I{1,3}|IV|V?I{0,3})*")) {
            throw new IllegalArgumentException("Title contains invalid characters or formatting.");
        }
        if (description == null || !description.matches("^[A-Z].*\\.$")) {
            throw new IllegalArgumentException("Description must start with a capital letter and end with a full stop.");
        }
    }


    //Formats the title : ensure single spaces + no trailing full stop.

    private String formatTitle(String title) {
        return title.trim().replaceAll("\\s+", " ").replaceAll("\\.$", "");
    }

    public Unit(Subject subject, Character unitId, String title, String description) {
        //validateParameters(subject, unitId, title, description);
        // if one parameter wrong, error thrown
        this.subject = subject;
        this.unitId = unitId;
        this.title = formatTitle(title);
        this.description = description;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public String getTitle() {
        return this.title;
    }

    public Character id() {
        return this.unitId;
    }

    public String getDescription() {
        return this.description;
    }


    public String getFullDetail() {
        return "Unit{" +
                "subject=" + subject +
                ", unitId=" + unitId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public String toString() {
        // unit ID + title
        return "Unit{" +
                ", unitId=" + unitId +
                ", title='" + title + '\'' +
                '}';
    }
}

