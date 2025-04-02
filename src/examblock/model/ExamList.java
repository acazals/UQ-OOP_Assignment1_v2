package examblock.model;
import java.util.ArrayList;
import java.util.List;


public class ExamList {

    // constructs an empty list of Exams

    private List<Exam> examList;

    public ExamList() {
        this.examList = new ArrayList<>();
    }

    public List<Exam> getExams() {
        return this.examList;
    }

    public List<Exam> all() {
        return new ArrayList<>(examList);
    }

    public void add(Exam exam) {
        this.examList.add(exam);
    }

    public Exam bySubjectTitle(String title) {
        for (int i =0; i<this.examList.size(); i++) {
            if ( this.examList.get(i).getSubject().getTitle()== title ) {
                return this.examList.get(i);
            }
        }
        return null; // no matching subject title...
    }

//    public void removeExam(Exam exam) {
//        for (int i =0; i<this.examList.size(); i++) {
//            if (this.examList.get(i).equals(exam)) {
//                this.examList.remove(i);
//                // same exam founded
//                break;
//            }
//        }
//    }

    public void removeExam(Exam exam) {
        if (this.examList.contains(exam)) {
            this.examList.remove(exam);
        }
    }

    public boolean isEmpty() {
        if (this.examList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(Exam exam) {
        if (this.examList.contains(exam)) {
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return this.examList.size();
    }

    public Exam get(int i) {
        if (i > this.size()) {
            throw new IndexOutOfBoundsException(" index too big");
        } else {
            return this.examList.get(i);
        }
    }

    public String getFullDetail() {
        StringBuilder sb = new StringBuilder();
        for (Exam exam : this.examList) {
            sb.append(exam.getFullDetail()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 1;

        for (Exam exam : examList) {
            sb.append(index).append(". ").append(exam.getFormattedTitle()).append("\n");
            index++;
        }

        return sb.toString();
    }
}

