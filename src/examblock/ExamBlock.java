package examblock;

import examblock.cli.Cli;
import examblock.inputs.Catalogue;
import examblock.model.Exam;
import examblock.model.ExamList;
import examblock.model.Session;
import examblock.model.SessionList;
import examblock.model.StudentList;
import examblock.model.Subject;
import examblock.model.SubjectList;
import examblock.model.UnitList;
import examblock.model.RoomList;
import examblock.model.Venue;
import examblock.model.VenueList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * An object representing the entire exam block.
 * Manages the process for creating and modifying a new Year 12 exam block.
 */
public class ExamBlock {

    private final Cli cli; // The command-line interface for manipulating the block.
    private final Catalogue catalogue; // This catalogue holds all catalogues,cohort,exams,rooms,venues.
    private final SubjectList subjectCatalogue; // All possible subjects in this block.
    private final UnitList unitCatalogue; // All possible subject units in this block.
    private final StudentList cohort; // All the Year 12 students.
    private final ExamList exams; // The current set of Year 12 Exams.
    private final RoomList rooms; // The current list of available rooms for exam venues.
    private final VenueList venues; // The current list of exam venues.
    private final SessionList sessions; // The current set of exam sessions allocated to venues.

    /**
     * Constructs a new Year 12 exam block.
     */
    public ExamBlock() {
        cli = new Cli(); // The interface to manipulate the variations.
        catalogue = new Catalogue(); // All the possible subjects.
        subjectCatalogue = catalogue.subjects(); // All the possible subject units.
        unitCatalogue = catalogue.units(); // All the possible subject units.
        cohort = catalogue.cohort(); // All the Year 12 Students.
        exams = catalogue.exams();
        rooms = catalogue.rooms();
        venues = catalogue.venues();
        sessions = new SessionList();
    }

    /**
     * Runs the entire interactive block management process.
     */
    public void manage() {
        welcomeMessage();
        String title = getTitleFromUser();
        double version = getVersionFromUser();
        System.out.println("\nNow generating a new Exam Block \"" + title + "\" (version " +
                version + ") on " + LocalDate.now() + " at " + LocalTime.now() + ":");
        processSchedule();
        finaliseExamBlock(title, version);
    }

    private void welcomeMessage() {
        System.out.println("Welcome to the exam block generator.\n" +
                "Currently scheduling main exams in V1, V2, and V3 (or combinations) only.\n" +
                "Currently scheduling AARA exams in W1, W2, or W1+W2.\n" +
                "There will be a complete new schedule generated.");
        System.out.println("=".repeat(60));
    }

    private String getTitleFromUser() {
        System.out.println("What is the title for this exam block? (INPUT HERE): ");
        return cli.getStringInput();
    }

    private double getVersionFromUser() {
        double version = -1.0;
        while (version < 0.0) {
            try {
                System.out.println("Give this schedule a version number (INPUT HERE): ");
                String input = cli.getStringInput();
                version = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + e.getMessage());
            }
        }
        return version;
    }

    private void processSchedule() {
        String pickedOption;
        ArrayList<String> options = new ArrayList<>();
        options.add("List Exams");
        options.add("List Venues");
        options.add("Count non-AARA students for an exam");
        options.add("Count AARA students for an exam");
        options.add("Schedule an Exam to a main venue (non-AARA)");
        options.add("Schedule an Exam to an AARA venue");
        options.add("List Subjects");
        options.add("List Units");
        options.add("List Students");
        options.add("FINALISE the exam block");
        do {
            System.out.println("-".repeat(60));
            pickedOption = cli.pickOptionFromCollection(options);
            switch (pickedOption) {
                case "List Exams" -> listExams();
                case "List Venues" -> listVenues();
                case "Count non-AARA students for an exam" -> countStudents();
                case "Count AARA students for an exam" -> countStudents(true);
                case "Schedule an Exam to a main venue (non-AARA)" -> scheduleExam();
                case "Schedule an Exam to an AARA venue" -> scheduleExam(true);
                case "List Subjects" -> listSubjects();
                case "List Units" -> listUnits();
                case "List Students" -> listStudents();
            }
        } while (!pickedOption.equals("FINALISE the exam block"));
    }

    private void listExams() {
        System.out.println("\nHere is the current list of exams:");
        System.out.println(exams);
    }

    private void listVenues() {
        System.out.println("\nHere is the current list of venues:");
        System.out.println(venues);
    }

    private void listSubjects() {
        System.out.println("\nHere is the current list of subjects:");
        System.out.println(subjectCatalogue);
    }

    private void listUnits() {
        System.out.println("\nHere is the current list of subject units:");
        System.out.println(unitCatalogue);
    }

    private void listStudents() {
        System.out.println("\nHere is the current list of students:");
        System.out.println(cohort);
    }

    private void countStudents() {
        this.countStudents(false);
    }

    private void countStudents(boolean aara) {
        System.out.println("What subject do you want to count the" + aaraString(aara) + "students for? ");
        Subject subject = cli.pickOptionFromCollection(subjectCatalogue.all());
        System.out.println("There are " + cohort.countStudents(subject, aara) + aaraString(aara) +
                "students who will be taking the " + subject.getTitle() + " exam.");
    }

    private void scheduleExam() {
        this.scheduleExam(false);
    }

    private void scheduleExam(boolean aara) {
        // Select the exam to schedule.
        System.out.println("What" + aaraString(aara) + "exam do you want to schedule? ");
        Exam exam = cli.pickOptionFromCollection(exams.all());
        int numberStudents = cohort.countStudents(exam.getSubject(), aara);
        System.out.println("There are " + numberStudents + aaraString(aara) +
                "students who will be taking the " + exam.getSubject().getTitle() + " exam.");
        // Next select a venue.
        Venue venue; // Local variable for the selected venue (will be set from a menu).
        int numberSeats; // the number of available student desks in the venue.
        int totalStudents = numberStudents;
        do {
            // Check venue size first.
            do {
                numberSeats = 0;
                System.out.println("What venue do you want to schedule the exam in? ");
                venue = cli.pickOptionFromCollection(venues.all());
                if (venue.checkVenueType(aara) && venue.willFit(numberStudents)) {
                    numberSeats = venue.deskCount();
                }
            } while (sessionOverflow(numberSeats, totalStudents));
            // Find or create this session in the session list and work out how many students in total.
            totalStudents = sessions.getSessionNewTotal(venue, exam, numberStudents);
        } while (sessionOverflow(numberSeats, totalStudents));
        // Confirm scheduling
        System.out.println("CONFIRM scheduling the " + exam.getSubject().getTitle() +
                aaraString(aara) + "exam into " + venue.venueId());
        String pickedOption;
        ArrayList<String> options = new ArrayList<>();
        options.add("CONFIRM scheduling this exam");
        options.add("Cancel scheduling this exam for now");
        pickedOption = cli.pickOptionFromCollection(options);
        if (pickedOption.equals("CONFIRM scheduling this exam")) {
            sessions.scheduleExam(venue, exam, numberStudents);
        }
    }

    private String aaraString(boolean aara) {
        if (aara) {
            return " AARA ";
        } else {
            return " ";
        }
    }

    private boolean sessionOverflow(int numberSeats, int totalStudents) {
        if (numberSeats < totalStudents) {
            System.out.println("That venue only has " + numberSeats + " desks - " +
                    totalStudents + " students won't fin in there!");
            return true;
        }
        return false;
    }

    private void finaliseExamBlock(String title, double version) {
        // Allocate all the students in each venue to desks
        venues.allocateStudents(sessions, exams, cohort);
        // print the results
        printEverything(title, version);
    }

    private void printEverything(String title, double version) {
        System.out.println("\nHere is the Exam Block \"" + title + "\" (version " +
                version + ") on " + LocalDate.now() + " at " + LocalTime.now() + ":\n");
        String heading = """
                /====================================\\
                |----------  ALL SUBJECTS  ----------|
                \\====================================/
                 
                """;
        System.out.println(heading);
        System.out.println(subjectCatalogue.getFullDetail());
        heading = """
                /=================================\\
                |----------  ALL UNITS  ----------|
                \\=================================/
                 
                """;
        System.out.println(heading);
        System.out.println(unitCatalogue.getFullDetail());
        heading = """
                /=================================\\
                |----------  ALL EXAMS  ----------|
                \\=================================/
                 
                """;
        System.out.println(heading);
        System.out.println(exams.getFullDetail());
        heading = """
                /====================================\\
                |----------  ALL STUDENTS  ----------|
                \\====================================/
                 
                """;
        System.out.println(heading);
        System.out.println(cohort);
        System.out.println("=".repeat(60));
        venues.printAllocations(sessions);
    }
}