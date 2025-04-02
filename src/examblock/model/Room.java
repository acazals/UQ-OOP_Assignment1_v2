package examblock.model;

public class Room {

    protected final String id;


    public Room (String id){
        this.id = id;
    }

    public String roomId() {
        return  this.id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                '}';
    }
}
