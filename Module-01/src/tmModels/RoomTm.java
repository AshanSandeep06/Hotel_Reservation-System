package tmModels;

import javafx.scene.control.Button;

public class RoomTm {
    private String roomId;
    private String roomType;
    private String use;
    private double price;
    private Button btn;

    public RoomTm() {

    }

    public RoomTm(String roomId, String roomType, String use, double price, Button btn) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.use = use;
        this.price = price;
        this.btn=btn;
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
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "RoomTm{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", use='" + use + '\'' +
                ", roomPrice=" + price +
                ", btn=" + btn +
                '}';
    }
}
