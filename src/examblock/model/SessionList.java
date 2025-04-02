package examblock.model;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class SessionList {

    private ArrayList<Session> list;

    public SessionList() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Session> getSessions() {
        return this.list;
    }

    public ArrayList<Session> all() {

        return new ArrayList<>(this.list);
    }

    public void scheduleExam( Venue venue, Exam exam, int numberStudents) {
        // alocates an exam to an existing session

        // here wefind the other sessions using the same venue
        // and choose one of them session to schedule our exam

        for (Session session : this.forVenue(venue)) {
            // for each session using that venue
            if (session.getTime().equals(exam.getTime())) {
                // schedule exam to an already existing session
                if (session.getCohort()!= null) {
                    throw new IllegalStateException( " that session has already been allocated ");
                }
                session.scheduleExam(exam, numberStudents);
                System.out.println( exam.getSubject() + " exam added to " + venue.roomId());
                break;
            }

        }
    }


    public Session getSession( Venue venue, Exam exam) {
        // get the sesh with matching venue and exam
        boolean temp = false;
        for (Session session : this.list) {
            // for each session
            if (session.getExams().contains(exam) && session.getVenue().venueId().equals(venue.venueId())) {
                // right session found
                temp = true;
                return session;
            }
        }
        if (!temp) {
            // not found
            throw new IllegalStateException(" session with given venue and exam not found in the ExamList");

        }
        return null;
    }

//    public int getSessionNewTotal ( Venue venue, Exam exam, int numberStudents) {
//        try {
//            if ((this.getSession(venue, exam) != null)) {
//
//                System.out.println( "There are already" + this.getSession(venue, exam).countStudents()+ "students who will be taking an exam in that venue; along with the " + numberStudents + "students for this exam.");
//                // we already have a session where this exam takes palce
//                try {
//                    int total = this.getSession(venue, exam).countStudents() + numberStudents;
//                    if (total <= venue.deskCount()) {
//                        this.getSession(venue, exam).scheduleExam(exam, this.getSession(venue, exam).countStudents());
//                        System.out.println("That's a total of" + total + " students.");
//                        return total;
//                    }
//
//                } catch(IllegalArgumentException ke) {
//                    System.out.println(ke.toString());
//                    return this.getSession(venue, exam).countStudents();
//                }
//
//                // so we did find the session we wanted
//
//            }
//
//        } catch (IllegalStateException e ) {
//            System.out.println("There is currently no exam session in that venue at that time.");
//            System.out.println("Creating a session...");
//            // we have to create this session
//            Session newSesssion = new Session(venue, 1, exam.getDate(), exam.getTime());
//            newSesssion.setStudentCount(numberStudents);
//            // the session constructor will find a unique ID if 1 already used
//            this.list.add(newSesssion);
//            return numberStudents;
//        }
//        return 0;
//    }

    public int getSessionNewTotal(Venue venue, Exam exam, int numberStudents) {
        // searches for a session in agviven venue at a given time
        for (Session session : this.list) {
            if (session.getVenue().roomId().equals(venue.roomId())  && session.getTime().equals(exam.getTime())) {
                // here we found a session in same venue and same time as the exam

                System.out.println( "There are already" + session.countStudents() + "students who will be taking an exam in that venue; along with the " + numberStudents + "students for this exam.");
                int total = session.countStudents() + numberStudents;
                System.out.println(" That's a total of " + total + " students");
                return total;

            }
        }
        // if we arrive here then we didn't find a session same time same venue
        System.out.println("There is currently no exam session in that venue at that time.");
        System.out.println("Creating a session...");
        // we have to create this session
        Session newSesssion = new Session(venue, 1, exam.getDate(), exam.getTime());
        // if ever 1 is a session id already used in that venue our constructor handles it
        // newSesssion.setStudentCount(numberStudents); // potential error : that line would already define the student count to 32
        System.out.println(" That's a total of " + numberStudents + " students");
        // the session constructor will find a unique ID if 1 already used
        this.list.add(newSesssion);
        return numberStudents;

    }
    public List<Session> forVenue( Venue venue) {
        ArrayList<Session> mylist = new ArrayList<>();
        for ( Session session : this.list) {
            if (session.getVenue().venueId().equals(venue.venueId())) {
                mylist.add(session);
            }
        }
        return mylist;
    }



}
