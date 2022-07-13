package Models;

public class financialModel {
    String roomId;
    int value;

    public financialModel(String roomId, int value) {
        this.roomId = roomId;
        this.value = value;
    }

    public financialModel() {

    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "financialModel{" +
                "roomId='" + roomId + '\'' +
                ", value=" + value +
                '}';
    }
}
