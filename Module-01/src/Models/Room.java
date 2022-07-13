package Models;

public class Room {
    private String roomId;
    private String roomType;
    private String use;
    private double roomPrice;

    public Room() {

    }

    public Room(String roomId, String roomType, String use, double roomPrice) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.use = use;
        this.roomPrice = roomPrice;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public double getPrice() {
        return roomPrice;
    }

    public void setPrice(double price) {
        this.roomPrice = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", use='" + use + '\'' +
                ", price=" + roomPrice +
                '}';
    }
}
