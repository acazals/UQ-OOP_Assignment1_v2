package examblock.model;

import java.util.Locale;

public class Subject {

    private String title;
    private String description;
    private ExamList exams;
    // stroing the different exams for one subjetc in it s instance subject

    // what should i do if the title / descirption is not respecting the rules ?

    private String cleanAndValidateTitle(String title) {
        // Trim leading/trailing spaces + replace multiple spaces with a single space
        title = title.trim().replaceAll("\\s+", " ");

        // if title ends with a full stop
        if (title.endsWith(".")) {
            throw new IllegalArgumentException("Title must not end with a full stop.");
        }

        // Check if title is in the correct format: each word capitalized
        if (!title.matches("([A-Z][a-z]*|[0-9]+|[IVXLCDM]+)( [A-Z][a-z]*|[0-9]+|[IVXLCDM]+)*")) {
            throw new IllegalArgumentException("Invalid title format.");
        }

        return title;
    }

    private String validateDescription(String description) {
        // Check if description starts with a capital letter and ends with a full stop
        if (!description.matches("[A-Z].*\\.")) {
            // .* means followed by any characters
            throw new IllegalArgumentException("Description must start with a capital letter and end with a full stop.");
        }

        return description;
    }
    public Subject(String title, String description) {
        this.title = title;
        this.description = description;
        this.exams = new ExamList();
    }

    // store the exams if there are some for ths subject
    public void addExam( Exam exam) {
        this.exams.add(exam);
    }

    public String getDescription() {
        return  this.description;
    }

    public String getFullDetail() {
        return this.title.toUpperCase() + "\n" + "\"" + this.description + "\"";
    }

    public String getTitle() {
        return this.title;
    }

    public ExamList getExams() {
        return this.exams;
    }


    public boolean equals( Subject subject) {
        if (this.title.equals( subject.title) && this.description.equals(subject.description) && this.exams.equals(subject.getExams())) {
            return  true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.title.toUpperCase(); // subject title as a String in all uppercase and a newline.
    }
}
