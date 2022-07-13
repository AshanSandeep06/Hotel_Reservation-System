package tmModels;

import javafx.scene.control.Button;

public class CustomerDetailsTm {
    String fullName;
    String id;
    String contactNumber;
    String email;
    String address;
    String reservationTime;
    String days;
    String people;
    String roomId;
    String roomType;
    String roomsQuantity;
    String mealType;
    Button btn;

    public CustomerDetailsTm(String fullName, String id, String contactNumber, String email, String address, String reservationTime, String days, String people, String roomId, String roomType, String roomsQuantity, String mealType, Button btn) {
        this.fullName = fullName;
        this.id = id;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.reservationTime = reservationTime;
        this.days = days;
        this.people = people;
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomsQuantity = roomsQuantity;
        this.mealType = mealType;
        this.btn = btn;
    }

    public CustomerDetailsTm(String roomId, String fullName, String address, String roomsQuantity, String roomType, String days, String mealType, Button btn) {
        this.fullName = fullName;
        this.id = id;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.reservationTime = reservationTime;
        this.days = days;
        this.people = people;
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomsQuantity = roomsQuantity;
        this.mealType = mealType;
        this.btn = btn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNicNumber() {
        return id;
    }

    public void setNicNumber(String nicNumber) {
        this.id = nicNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
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

    public String getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(String roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "CustomerDetailsTm{" +
                "fullName='" + fullName + '\'' +
                ", nicNumber='" + id + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", reservationTime='" + reservationTime + '\'' +
                ", days='" + days + '\'' +
                ", people='" + people + '\'' +
                ", roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomsQuantity='" + roomsQuantity + '\'' +
                ", mealType='" + mealType + '\'' +
                ", btn=" + btn +
                '}';
    }
}
