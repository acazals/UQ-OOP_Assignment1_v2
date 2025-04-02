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
        this.venue = venue;
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
// to do : allocate students, getexams, countstudents, schedule exam, allocate students

    // each exam is Associated with a subject
    // each sudent has it's own list of subjects and list of exams

//    public void allocateStudents( ExamList exams, StudentList cohort) {
//        if (!exams.isEmpty() && !cohort.isEmpty()) {
//            // so there are exams taking place; and there are students
//            // hyp : exams = subset of all the exams
//            // only the exams relevant to this particuliar session
//            this.exams = exams; //
//            // just check if there is enough desks first
//            int total = 0;
//            ArrayList<StudentList> mylist = new ArrayList<>();
//            StudentList myStudentList = new StudentList();
//
//            for (int i=0; i<this.exams.size(); i++) {
//                // for each exam
//                // each exam is associated with asubject
//                // we have a methode from StudentList countstudent
//                // counts nb of student taking a given subject + AARA or not
//
//                total = total + cohort.countStudents(exams.get(i).getSubject(), true) + cohort.countStudents(exams.get(i).getSubject(), false);
//                StudentList StudentTakingExam = cohort.bySubject(exams.get(i).getSubject());
//
//                // student list with ALL students taking an exam here regardless of the subject
//                for (int m =0; m<StudentTakingExam.size(); m++) {
//                    myStudentList.add(StudentTakingExam.get(m));
//                }
//
//                // array list of student list
//                mylist.add(StudentTakingExam);
//                // now we have the total number of student in this session
//                // we have a student list for each exam too
//            }
//            if (this.venue.deskCount() < total) {
//                throw new IllegalArgumentException(" not enough desks");
//            } else {
//                // we can start allocating students
//                int index = 0; // index of the desks
//                for (int j=0; j<mylist.size(); j++){
//                    // for each exam we have a given StudentList
//                    for (int k=0; k<mylist.get(j).size(); k++) {
//                        // for each student taking that given exam we create an instance of a desk with
//                        // unique index plus his name and family name
//                        Desk currentDesk = new Desk(index, mylist.get(j).get(k).familyName, mylist.get(j).get(k).givenNames() );
//                        allocatedDesks.add(currentDesk);
//                        index ++;
//                    }
//                }
//                this.students = myStudentList; // list with all the students taking an exam
//            }
//        }
//    }

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

            // count students taking the exam (AARA + non-AARA combined)
            int studentCount = cohort.countStudents(subject, true) + cohort.countStudents(subject, false);
            totalStudents += studentCount;

            //  list of students taking this subject
            StudentList studentsTakingExam = cohort.bySubject(subject);
            for (Student student : studentsTakingExam.getStudents()) {
                allExamStudents.add(student); // saving all our different students no matter the exam in a StudentList
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
        int index = 0;
        // sorted by first name
        // columns we are going to leave empty : ComputeGap
        int freeColumns = this.ComputeGap();
        for (int i = 0; i<this.getVenue().getColumns(); i++) {
            // iterating through columns
            // strating from the beginning : left
            for (int j=0; j<this.getVenue().getRows(); j++) {
                // iterating through rows, starting from the beginning ( up )
                this.allocatedDesks[j][i] = new Desk(index, sorted.get(index).getFamilyName(), sorted.get(index).firstName() ) ;
                if (index < sorted.size()) {
                    index++;
                } else {
                    // we reached the last student
                    break;
                }
            }

            // here we filled up the whole j column
            if (freeColumns > 0 && i<this.getVenue().getColumns()-1) {
                freeColumns = freeColumns -1;
                // for all the rows of that column we put empty desks
                for (int j=0; j<this.getVenue().getRows(); j++) {
                    // for each row of that column number i : we assign an empty desk
                    this.allocatedDesks[j][i] = new Desk(0, "Empty", "Empty");
                }

            }

            if (index < sorted.size()) {
                continue;
            } else {
                break; // we have already allocated all students
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
        for (int i = 0; i < this.allocatedDesks.length; i++) {
            for (int j = 0; j < this.allocatedDesks[i].length; j++) {
                // desk tostring
                System.out.print(this.allocatedDesks[i][j] + "\t");
            }
            System.out.println();
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

//    public void scheduleExam( Exam exam, int nbStudents) {
//        // allocates an exam to this session : venue + time
//        if (!this.exams.contains(exam)) { // if the exam is not  already in that session
//            if (this.venue.deskCount() < nbStudents + this.countStudents()) { // and if there is enough room in the venue
//                // too many students
//                throw new IllegalArgumentException("too many students in our venue");
//            } else{
//                this.studentCount += nbStudents;
//                this.exams.add(exam); // add given exam to the examList
//            }
//        }
//    }

    public void scheduleExam( Exam exam, int nbStudents) {
        this.studentCount+= nbStudents;
        this.exams.add(exam);
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
