package examblock.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Exam {

    // i added an override equals methode AND a check conditions boolean method

    public static enum ExamType {
        INTERNAL,  // Internal assessment, conducted by the school
        EXTERNAL;  // External assessment, conducted by the QCAA

        // Optional: Custom method inside the enum for additional functionality
        public String getDescription() {
            switch (this) {
                case INTERNAL:
                    return "Internal assessment, conducted by the school";
                case EXTERNAL:
                    return "External assessment, conducted by the QCAA";
                default:
                    return "Unknown";
            }
        }
    }


    private Subject subject;
    private Exam.ExamType examtype;

    private LocalDate date;
    private LocalTime time;

    private Character unit;
    private String subtitle;
    private Character paper;

    private Venue venue; // i added this

    public Boolean CheckConditions(int day, int month, int year, int hour, int minute) {
        if (year < 2025) {
            System.out.println("Year must be 2025 or later.");
            return false;
        }
        if (month < 1 || month > 12) {
            System.out.println("Month must be between 1 and 12.");
            return false;
        }
        if (hour < 7 || hour > 17) {
            System.out.println("Hour must be between 7 and 17 (24-hour format).");
            return false;
        }
        if (minute < 0 || minute > 59) {
            System.out.println("Minute must be between 0 and 59.");
            return false;
        }

        // check the date :
        try {
            this.date = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            System.out.println("Invalid day for given month and year.");
            return false;
        }
        return true;
    }

    public Exam(Subject subject, Exam.ExamType examType, int day, int month, int year, int hour, int minute) {

        // check conditions
        if (!this.CheckConditions(day, month, year, hour, minute)) {
            throw new IllegalArgumentException("Something is wrong with the argument, pls check the string printed right before this.");
        } else {
            this.subject = subject;
            subject.addExam(this); // storing the exam in the subject's exam list
            this.examtype = examType;
            this.date = LocalDate.of(year, month, day);
            this.time = LocalTime.of(hour, minute);
        }
    }

    public Exam(Subject subject, Exam.ExamType examType, Character unit, int day, int month, int year, int hour, int minute) {
        if (!this.CheckConditions(day, month, year, hour, minute)) {
            throw new IllegalArgumentException("Something is wrong with the argument, pls check the string printed right before this.");
        } else {
            this.subject = subject;
            this.examtype = examType;
            subject.addExam(this);

            this.date = LocalDate.of(year, month, day);
            this.time = LocalTime.of(hour, minute);

            this.unit = unit;
             }
        // paper number and subtitle but no unit specified
    }



    public Exam(Subject subject, Exam.ExamType examType, Character paper, String subtitle, int day, int month, int year, int hour, int minute) {
        if (!this.CheckConditions(day, month, year, hour, minute)) {
            throw new IllegalArgumentException("Something is wrong with the argument, pls check the string printed right before this.");
        } else {
            this.subject = subject;
            this.examtype = examType;
            subject.addExam(this);

            this.date = LocalDate.of(year, month, day);
            this.time = LocalTime.of(hour, minute);

            this.paper = paper;
            this.subtitle = subtitle; }
        // paper number and subtitle but no unit specified
    }

    public Exam(Subject subject, Exam.ExamType examType, Character paper, String subtitle, Character unit, int day, int month, int year, int hour, int minute) {
        if (!this.CheckConditions(day, month, year, hour, minute)) {
            throw new IllegalArgumentException("Something is wrong with the argument, pls check the string printed right before this.");
        } else {
            this.subject = subject;
            this.examtype = examType;
            subject.addExam(this);

            this.date = LocalDate.of(year, month, day);
            this.time = LocalTime.of(hour, minute);

            this.paper = paper;
            this.subtitle = subtitle;
            this.unit = unit; }
        // paper number and subtitle but no unit specified
    }

    public Subject getSubject() {
        return subject;
    }

    // Getter for date
    public LocalDate getDate() {
        return date;
    }

    // Getter for time
    public LocalTime getTime() {
        return time;
    }

    //  title
    public String getTitle() {
        // returns type subject paper subtitle
        if (this.paper != null) {
            return this.examtype + " - " + subject.getTitle() + " - " + paper.toString() + " - " + subtitle;
        } else {
            return this.examtype + " - " + subject.getTitle() + " - " + subtitle;
        }

    }


    public String getShortTitle() {
        // same as get title ??
        if (this.paper != null) {
            return this.examtype + " - " + subject.getTitle() + " - " + Character.toString(paper) + this.subtitle;
        } else {
            return this.examtype + " - " + subject.getTitle() + " - " + this.subtitle;
        }

    }

    public void setVenue( Venue venue) {
        this.venue = venue;
    }

//    public Venue getVenue() {
//        return this.venue;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        // Check if same instance
//        if (this == obj) {
//            return true;
//        }
//
//        // Check if  type Exam
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//
//        // Cast the object to Exam
//        Exam otherExam = (Exam) obj;
//
//        // Compare all relevant fields (subject, examType, date, time, etc.)
//        return this.examtype == otherExam.examtype &&
//                this.subject.getFullDetail().equals(otherExam.subject.getFullDetail()) &&
//                this.date.equals(otherExam.date) &&
//                this.time.equals(otherExam.time) &&
//                this.unit.equals(otherExam.unit) &&
//                this.subtitle.equals(otherExam.subtitle) &&
//                this.paper.equals(otherExam.paper);
//    } normally not needed if i use the liste.remove object in the ExamList class

    // full details
    public String getFullDetail() {
        if (this.paper!= null) {
            return "Exam: " + this.getTitle() + "\n" +
                    "Paper: " + paper + "\n" +
                    "Subtitle: " + subtitle + "\n" +
                    "Unit: " + unit + "\n" +
                    "Date: " + date + "\n" +
                    "Time: " + time;
        }  else {
            return "Exam: " + this.getTitle() + "\n" +
                    "Subtitle: " + subtitle + "\n" +
                    "Unit: " + unit + "\n" +
                    "Date: " + date + "\n" +
                    "Time: " + time;
        }

    }

    public String getFormattedTitle() {
        String title = "Year 12 "+  this.examtype+  " Assessment " + this.subject;

        if (this.paper != null) {
            title += " " + "Paper " + this.paper;
        }
        return title;
    }

    // toString
    @Override
    public String toString() {
        return getShortTitle() + " on " + date + " at " + time;
    }


}


