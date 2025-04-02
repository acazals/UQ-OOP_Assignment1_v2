package examblock.model;
import java.util.ArrayList;
import java.util.List;

public class RoomList {
    private List<Room> roomlist;

    public RoomList() {
        this.roomlist = new ArrayList<>();
    }

    public void addRoom (Room room) {
        this.roomlist.add(room);
    }

    public List<Room> all() {
        return new ArrayList<>(roomlist); // ✅ Returns a new list, but with the same Room references
    }


    public String getFullDetail() {
        if (this.roomlist.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.roomlist.size(); i++){
            sb.append(this.roomlist.get(i).toString());
        }
        return sb.toString();
    }

    public void removeRoom(Room room) {
        if (this.roomlist.contains(room)) {
            this.roomlist.remove(room);
        }
    }

    public Room getRoom(String id) {
        if (this.roomlist.isEmpty()) {
            throw new IllegalStateException("");
        } else {
            boolean temp = false;
            for (int i=0; i<this.roomlist.size(); i++) {
                if (this.roomlist.get(i).roomId().equals(id)) {
                    temp = true;
                    return this.roomlist.get(i);
                }
            }
            if (!temp) {
                throw new IllegalStateException("");

            }
        }
        return null;
    }



    @Override
    public String toString() {
        return "RoomList{" +
                "roomlist=" + roomlist +
                '}';
    }
}
