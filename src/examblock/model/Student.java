package examblock.model;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Student {

    public static enum HouseType {
        Blue,Green,Red,White,Yellow;
    }

    Long lui; // large integer
    String givenNames;
    String familyName;
    LocalDate Dob;
    String house;
    Boolean aara;  //AARA adjustments
    private SubjectList subjects;
    private ExamList exams;

    private static Set<Long> usedLui = new HashSet<>();
    private static final ArrayList<String> validHouses = new ArrayList<String>(Arrays.asList("Blue", "Green", "Red", "White", "Yellow"));


    public boolean Check(long lui, int year, int month, int day, String house){


        try {
            LocalDate date = LocalDate.of(year, month, day);

        } catch (DateTimeException e) {
            System.out.println ("Invalid Date.");
            return false;
        }
        if (usedLui.contains(lui)) {
            throw new IllegalArgumentException(" LUI must be Unique");


        }
        if (!validHouses.contains(house)){
            throw new IllegalArgumentException( " House must be part the given HouseList");
        } else {
            return true;
        }

    }

    public Student(Long lui, String givenNames, String familyName, int day, int month, int year, String house, Boolean aara) {

        if (this.Check(lui, year, month, day, house)){
            usedLui.add(lui);
            this.lui = lui;
            this.givenNames = givenNames;
            this.familyName = familyName;
            this.Dob = LocalDate.of(year, month, day);
            this.house = house;
            this.aara = aara;

            // initializing the lists
            this.exams = new ExamList();
            this.subjects = new SubjectList();
        }

    }

    public Student(Long lui, String givenNames, String familyName, int day, int month, int year, String house) {

        if (this.Check(lui, year, month, day, house)){
            usedLui.add(lui);
            this.lui = lui;
            this.givenNames = givenNames;
            this.familyName = familyName;
            this.Dob = LocalDate.of(year, month, day);
            this.house = house;
            this.aara = false;

            // initializing the lists
            this.exams = new ExamList();
            this.subjects = new SubjectList();
        }

    }

    public void addSubject(Subject subject) {
        // adds a subject to the student
        this.subjects.addSubject(subject);
        if (!subject.getExams().isEmpty()) {
            // so we have at least one exam wit this subject
            for (int i=0; i<subject.getExams().size(); i++) {
                this.exams.add(subject.getExams().get(i));
                // we had each exam of this subject in the exam list of that student
            }
        }
    }

    public void changeLui(Long lui) {
        if (usedLui.contains(lui)) {
            throw new IllegalArgumentException("Lui already used");
        }
        this.lui = lui;
    }

    public String firstName() {
        String first = this.givenNames.split(" ")[0];
        return first;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String fullName() {
        String total = this.givenNames +" "+ this.familyName;
        return total;
    }

    public String givenNames() {
        return this.givenNames;
    }

    public Boolean isAara() {
        if (!this.aara || this.aara == null) {
            return false;
        } else {
            return true;
        }
            }

//    public void setFamily( String familyName) {
//        this.familyName = familyName;
//    }
//
//    public void setGiven(String givenNames) {
//        this.givenNames = givenNames;
//    }

    public String shortName() {
        String first = this.givenNames.split(" ")[0];
        return first +" "+ this.familyName;
    }

    public LocalDate getDob() {
        return this.Dob;
    }

    public Long getLui() {
        return this.lui;
    }

    public ExamList getExams() {
        return this.exams;
    }

    public void removeSubject( Subject subject) {
        if (this.subjects.all().contains(subject)) {
            this.subjects.all().remove(subject);
            // all gives a reference so removing the subject from the reference removes it
            // from the actual subject list : subjects

            // now we need to delete the exam associated with this subject from the examlist of our student

            if (!subject.getExams().isEmpty()) {
                // there is a least on exam planned for this subject
                for (int i=0; i<subject.getExams().size(); i++) {
                    this.exams.removeExam(subject.getExams().get(i));
                    // removing the different exams of this subject from our student examList
                }
            }
        }
    }

    public SubjectList getSubjects() {
        return this.subjects;
    }
    // having a set of subjetc sinstead of a list would make operations faster
    // eg : for studentlist count subjetcs, AARA

    @Override
    public String toString() {
        return "Student{" +
                "lui=" + lui +
                ", givenNames='" + givenNames + '\'' +
                ", familyName='" + familyName + '\'' +
                ", Dob=" + Dob +
                ", house='" + house + '\'' +
                ", aara=" + aara +
                '}';
    }
}

