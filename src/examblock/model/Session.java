package examblock.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Session {

    private Venue venue;
    private int sessionNumber;
    private LocalDate day;
    private LocalTime start;
    private ExamList exams;
    private StudentList students;
    private StudentList cohort;
    //private ArrayList<Desk> allocatedDesks;
    private Desk[][] allocatedDesks;
    private int studentCount;

    public Session (Venue venue, int sessionNumber, LocalDate day, LocalTime start) {
        this.venue = venue; // stores if the session will be AARA friendly or not
        // check that the id works : is unique
        if (venue.getSessionIDs().contains(sessionNumber)) {
            // make the id of the session is unique for that venue
            Boolean temp = true;
            int i = 1;
            while (temp) {
                if (venue.getSessionIDs().contains(i) ){
                    i++;
                } else {
                    this.sessionNumber = i;
                    // normally the ID of our session is added in the list with the previous method
                    this.venue.addSession(this);
                    temp = false;
                    break;
                }
            }
        } else {
            this.sessionNumber = sessionNumber;
        }
        this.day = day;
        this.start = start;
        this.exams = new ExamList();
        this.students = new StudentList();
        this.allocatedDesks = new Desk[venue.getRows()][venue.getColumns()];
    }

    public ExamList getExams(){
        return this.exams;
    }

    public Venue getVenue() {
        return venue;
    }

    public LocalTime getTime() {
        return start;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int i) {
        this.sessionNumber = i;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public LocalDate getDay() {
        return this.day;
    }


    public void allocateStudents(ExamList exams, StudentList cohort) {
        if (exams.isEmpty() || cohort.isEmpty()) {
            return; // No exams or no  students = nothing to allocate
        }

        this.cohort = cohort; // saving the cohort with all students infos
        this.exams = exams; // Store exams for this session

        // Step 1: Count total students & check desk availability
        int totalStudents = 0;
        ArrayList<StudentList> studentsByExam = new ArrayList<>();
        StudentList allExamStudents = new StudentList();

        for (Exam exam : exams.getExams()) {
            Subject subject = exam.getSubject();
            //  list of students taking this subject
            StudentList studentsTakingExam = cohort.bySubject(subject, this.getVenue().getAARA());
            for (Student student : studentsTakingExam.getStudents()) {
                if (!allExamStudents.contains(student)) {
                    allExamStudents.add(student); // saving all our different students no matter the exam in a StudentList
                }

            }
            studentsByExam.add(studentsTakingExam);
        }
        if (allExamStudents.isEmpty()) {
            throw new IllegalStateException(" we have no students taking those exams ...");
        }

//        if (this.venue == null || this.venue.deskCount() < totalStudents) {
//            throw new IllegalArgumentException("Not enough desks available.");
//        }

        // 2 :  Allocate desks
        // seated in alphabetical order by surname starting from the desk in the front left corner
        // so firstname ( we have a getter for that)


        StudentList sorted = allExamStudents.sortStudents();
        // iterating through columns ( going up to down )
        // and then through rows ( going right to left)

        int StudentCount = 0;
        int deskCount =0;
        int freeColumns = this.ComputeGap();
        boolean studentsLeft = true;

        for ( int i=0; i<this.getVenue().getColumns(); i++) {
            // we also have to take into account the gaps

            for (int j=0; j<this.getVenue().getRows(); j++) {
                // iterating though the rows
                if (studentsLeft) {
                    this.allocatedDesks[j][i] = new Desk( deskCount, sorted.get(StudentCount).getFamilyName(), sorted.get(StudentCount).firstName());
                    StudentCount++;
                    deskCount++;
                    if (StudentCount >= this.countStudents()) {
                        studentsLeft = false;
                    }
                } else {
                    this.allocatedDesks[j][i] = new Desk(deskCount, "Empty", "");
                    deskCount++;
                }


            }

            if ( freeColumns > 0 && deskCount < this.getVenue().deskCount() && i  <this.getVenue().getColumns()-1 && studentsLeft) {
                freeColumns--;
                // add a free column
                for (int j=0; j<this.getVenue().getRows(); j++) {
                    this.allocatedDesks[j][i+1] = new Desk(deskCount, "Empty", "");
                    deskCount++;
                }
                // so we actually already filled a whole column so we need to increase i by one
                i++; // skipping next column
            }


        }
        this.students = allExamStudents; // Store all students taking exams
        this.studentCount = allExamStudents.size();
    }

    // cohort : all year 12 students
    // total nb of students and total nb of desk and calculates the desk gap ;
    // how to distribute gap ??
    // count number of different exams / count number of subjects (same)
    // sorting students by family name
    // allocate diffent desks to students ; front to back, left to right
    // what if more students in cohort then available desks in the venue : probably dosen t happen here
    // iterate through all exams and identify which student is taking which exam


    public void printDesks() {
        for (Student student : this.students.getStudents()) {
            System.out.println(student);
        }
        for (Exam exam : this.exams.getExams()) {
            System.out.println(exam);
        }

        int rows = this.allocatedDesks.length;
        int cols = this.allocatedDesks[0].length;

        for (int i = 0; i < rows; i++) {  // Iterate over rows
            for (int line = 0; line < 3; line++) { // 3 lines per desk
                for (int j = 0; j < cols; j++) {  // Iterate throu columns
                    Desk desk = this.allocatedDesks[i][j];

                    if (desk == null || desk.deskFamilyName().equals("Empty")) {
                        switch (line) {
                            case 0:
                                System.out.printf("Desk %-10d", (i * cols + j)); //  desk number
                                break;
                            case 1:
                                System.out.printf("%-15s", "Empty"); // empty
                                break;
                            case 2:
                                System.out.printf("%-15s", " "); // no given name
                                break;
                        }
                    } else {
                        switch (line) {
                            case 0: // Desk Number
                                System.out.printf("Desk %-10d", desk.deskNumber());
                                break;
                            case 1: //  Family Name
                                System.out.printf("%-15s", desk.deskFamilyName());
                                break;
                            case 2: // given Name
                                System.out.printf("%-15s", desk.deskGivenAndInit());
                                break;
                        }
                    }
                }
                System.out.println(); //  line after each row
            }
            System.out.println(); // separating matrix rows
        }

    }

    public int ComputeGap() {
        // using total desks + number of students
        return ((this.getVenue().deskCount() - this.countStudents()) / this.getVenue().getRows());
        // get rows = nb of desk per column
        // if we have more then a whole column free we can afford a free column for the gap
        // so we compute how many free columns we can afford : we count number of free seats and count how many free columns that is
    }

    public int countStudents() {
        return this.studentCount;
    }


    public void scheduleExam( Exam exam, int nbStudents) {
        this.studentCount+= nbStudents;
        exam.setVenue(this.getVenue());
        this.exams.add(exam); // so that exam will take place in that venue
        //this.allocateStudents(this.exams, this.cohort);
    }

    public StudentList getCohort() {
        return this.cohort;
    }

    //

    // parameters : exam and nmber of students
    // add an exam to an existing sessions ( our given instance of )
    // check is the VENUE is AARA firendly
    // check the number of student
    @Override
    public String toString() {
        return "Session{" +
                "venue=" + venue +
                ", sessionNumber=" + sessionNumber +
                ", day=" + day +
                ", start=" + start +
                ", studentCount =" + studentCount+
                '}';
    }
}
