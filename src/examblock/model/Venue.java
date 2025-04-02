package examblock.model;

import java.util.ArrayList;

public class Venue extends Room {

    private int roomCount; // 1 or 2 or 3
    private RoomList rooms; // at least one room
    private int rows;
    private int columns;
    private int totalDesks; // not necesseraly rows x columns
    private ArrayList<Desk> desklist; //
    private boolean aara;
    private ArrayList<Session> sessions;
    private ArrayList<Integer> sessionIDs;


    public Venue(String id, int roomCount, RoomList rooms, int rows, int columns, int totalDesks, boolean aara) {
        super(id); // constructor of room
        this.roomCount = roomCount;
        this.rooms = rooms;
        this.rows = rows;
        this.columns = columns;
        this.totalDesks = totalDesks;
        this.aara = aara;
        this.sessions = new ArrayList<>();
        this.sessionIDs = new ArrayList<>();
    }

    int getColumns() {
        return this.columns;
    }

    int getRows() {
        return this.rows;
    }

    public ArrayList<Session> getSessions() {
        return this.sessions;
    }

    public ArrayList<Integer> getSessionIDs() {
        return this.sessionIDs;
    }


    // add session : adds a session to where we store the past sessions and IDs
    public void addSession(Session newSession) {
        if (this.sessionIDs.contains(newSession.getSessionNumber())) {
            Boolean temp = true;
            int i = 1;
            while (temp) {
                if (this.sessionIDs.contains(i) ){
                    i++;
                } else {
                    newSession.setSessionNumber(i);

                    this.sessions.add(newSession);
                    this.sessionIDs.add(i);

                    temp = false;
                    break;
                }
            }
        } else {
            sessions.add(newSession);
            sessionIDs.add(newSession.getSessionNumber());
        }
    }

    RoomList getRooms() {
        return this.rooms;
    }


    public boolean checkVenueType(boolean aara) {
        if (this.aara == aara) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getAARA() {
        return this.aara;
    }



    public int deskCount() {
        return this.totalDesks;
    }

    public String venueId() {
        return this.id;
    }

    public boolean willFit(int numberStudents){
        if (this.deskCount() < numberStudents) {
            // we cant fit all those students
            return false;
        } else {
            return true;
        }
    }


    @Override
    public String toString() {
        return "Venue{" +
                "id='" + id + '\'' +
                ", roomCount=" + roomCount +
                ", rooms=" + rooms +
                ", rows=" + rows +
                ", columns=" + columns +
                ", totalDesks=" + totalDesks +
                ", aara=" + aara +
                '}';
    }
}
