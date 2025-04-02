package examblock.model;

import java.util.ArrayList;
import java.util.List;

public class VenueList {

    private ArrayList<Venue> venues;

    public VenueList() {
        this.venues = new ArrayList<>();
    }

    public void addVenue( Venue venue) {
        this.venues.add(venue);
    }

    public void allocateStudents ( SessionList sessions, ExamList exams, StudentList cohort) {

        for (Venue venue : this.venues) {
            // for each venue : we have a given array of sessiosn
            // the given list : sessions.forVenue(venue);
            for (Session session : sessions.forVenue(venue)) {
                // for each session taking place in that venue

                for (Exam exam : exams.getExams()) {
                    session.allocateStudents(exams, cohort); // examlist always the same
                }


            }
        }
    }


    public List<Venue> all() {
        return new ArrayList<>(this.venues);
    }

    public Venue getVenue( String id) {
        // get first venue with a matching id

        for (Venue venue : this.venues) {
            if (venue.venueId().equals(id)) {
                return venue;
            }
        }
        // same venue not found
        throw new IllegalStateException("");
    }

    public String getFullDetail() {
        StringBuilder bd = new StringBuilder("");
        for (Venue venue : this.venues) {
            bd.append(venue.toString());
        }
        // go on
        return bd.toString();
    }

    public void removeVenue( Venue venue) {
        for (Venue myvenue : this.venues) {
            if (myvenue.venueId().equals(venue.venueId())) {
                this.venues.remove(myvenue);
            }
        }
    }

    public void printAllocations( SessionList sessions) {
        // print students allocations for each session of each venue
        for (Venue venue : this.venues) {
            // for each venue
            for (Session session : sessions.forVenue(venue)) {
                // for each session taking place in that venue
                session.printDesks();

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i=1;
        for (Venue venue : this.venues) {
            String str = i + ". " + venue.roomId() + "\n";
            sb.append(str);
            i++;
        }
        return sb.toString();
    }
}
