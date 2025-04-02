package examblock.model;

import java.util.ArrayList;
import java.util.List;

public class StudentList {

    private ArrayList<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public StudentList(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public void add(Student student) {
        this.students.add(student);
    }

    public int size() {
        return this.students.size();
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Student get(int i) {
        if (i > this.students.size()) {
            throw new IllegalArgumentException("");
        } else {
            return this.students.get(i);
        }
    }

    public boolean contains( Student student) {
        if (this.students.contains(student)) {
            return true;
        } else {
            return false;
        }
    }

    public Student byLui( Long lui) {
        if (this.students.isEmpty()) {
            return null;
        } else {
            for (int i=0; i<this.students.size(); i++) {
                if (this.students.get(i).getLui() == lui) {
                    return this.students.get(i);
                }
            }
            // if we arrive here it means we don thave that student in our list
            return null;
        }
    }

    public boolean isEmpty() {
        return this.students.isEmpty();
    }

    public int countStudents( Subject subject, boolean aara) {
        if (this.students.isEmpty()) {
            return 0;
        } else {
            int total=0;
            for (int i=0; i<this.students.size(); i++) {
                if (this.students.get(i).getSubjects().all().contains(subject)) {

                    // so the student nb i is taking that subject lesson
                    // the subject is in his subjectList
                    // still need to check if he has the AARA adjustments

                    if (this.students.get(i).isAara() == aara) {
                        total++;
                    }
                }

            }
            return total;
        }
    }

    public StudentList bySubject(Subject subject, boolean AARA) {
        StudentList sorted = new StudentList();
        for (int i=0; i<this.students.size(); i++) {
            //if (this.students.get(i).getSubjects().contains(subject)) {
            if (this.students.get(i).isTakingSubject(subject)){
                // so this student is taking that course/subject
                if (AARA == this.students.get(i).isAara() ) {
                    sorted.add(this.students.get(i));
                }

            }
        }
        return sorted;
    }

    public String getFullDetail() {
        if (this.students.isEmpty()) {
            return "";
        } else {
            String total = "";
            for (int i =0; i<this.students.size(); i++) {
                total = total + students.get(i).toString() + "\n";
            }
            return total;
        }
    }

    public StudentList sortStudents() {
        // sorting students based on their frst name ( alphabetically)
        if (this.isEmpty()) {
            throw new IllegalStateException( " we can t sort an empty list");
        }
        StudentList sortedList = new StudentList(this.students);
        sortedList.students.sort( (s1, s2) -> s1.familyName.compareTo(s2.familyName));
        return sortedList;
    }

    @Override
    public String toString() {
          StringBuilder sb = new StringBuilder();
          for (Student student : this.students) {
              String str = student.lui + " " + student.givenNames() + " " + student.getFamilyName() + "\n";
              sb.append(str);
              int i=1;
              for (Subject subject : student.getSubjects().all()) {
                  String str2 = i + ". "+subject.getTitle() + "\n";
                  sb.append(str2);
                  i++;
              }
              sb.append("================================================================================ \n");
          }
          return sb.toString();
    }
}
