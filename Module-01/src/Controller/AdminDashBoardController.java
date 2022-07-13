package Controller;

import Models.Food;
import Models.Room;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.Database;
import db.Database1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import tmModels.FoodTm;
import tmModels.RoomTm;

import java.io.IOException;
import java.util.Optional;

public class AdminDashBoardController {

    public JFXTextField txtRoomId;
    public JFXTextField txtRoomType;
    public JFXTextField txtUse;
    public JFXTextField txtRoomPrice;

    public JFXTextField txtMealType;
    public JFXTextField txtFoodName;
    public JFXTextField txtFoodPrice;

    public TableView<RoomTm> tblRoom;
    public TableView<FoodTm> tblFood;

    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colUse;
    public TableColumn colRoomPrice;
    public TableColumn colRoomOption;
    public TableColumn colFoodType;
    public TableColumn colFoodName;
    public TableColumn colFoodPrice;
    public TableColumn colFoodOption;
    public JFXButton btnAddRoom;
    public JFXButton btnAddFood;
    public Button btnDelete;
    public AnchorPane adminDashBoardContext;

    public void initialize() {

        /*txtRoomId.setStyle("-fx-text-fill: BLACK; -fx-font-size: 15px;");
        txtRoomType.setStyle("-fx-text-fill: BLACK; -fx-font-size: 15px;");
        txtUse.setStyle("-fx-text-fill: BLACK; -fx-font-size: 15px;");
        txtRoomPrice.setStyle("-fx-text-fill: BLACK; -fx-font-size: 15px;");
        txtMealType.setStyle("-fx-text-fill: BLACK; -fx-font-size: 15px;");
        txtFoodName.setStyle("-fx-text-fill: BLACK; -fx-font-size: 15px;");
        txtFoodPrice.setStyle("-fx-text-fill: BLACK; -fx-font-size: 15px;");*/

        colRoomId.setCellValueFactory(new PropertyValueFactory("roomId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("roomType"));
        colUse.setCellValueFactory(new PropertyValueFactory("use"));
        colRoomPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colRoomOption.setCellValueFactory(new PropertyValueFactory("btn"));
        colFoodType.setCellValueFactory(new PropertyValueFactory("mealType"));
        colFoodName.setCellValueFactory(new PropertyValueFactory("foodName"));
        colFoodPrice.setCellValueFactory(new PropertyValueFactory("foodPrice"));
        colFoodOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllRooms();
        loadAllFoods();

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                setRooms(newValue);
            }
        });

        tblFood.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setFoods(newValue);
            }
        });

    }

    public void setRooms(RoomTm tm) {
        btnAddRoom.setText("Update Room");
        txtRoomId.setText(tm.getRoomId());
        txtRoomType.setText(tm.getRoomType());
        txtUse.setText(tm.getUse());
        txtRoomPrice.setText(String.valueOf(tm.getPrice()));
    }

    public void setFoods(FoodTm tm) {
        btnAddFood.setText("Update Food");
        txtMealType.setText(tm.getMealType());
        txtFoodName.setText(tm.getFoodName());
        txtFoodPrice.setText(String.valueOf(tm.getFoodPrice()));
    }

    public void loadAllRooms() {
        ObservableList<RoomTm> roomObservableList = FXCollections.observableArrayList();

        for (Room r1 : Database.roomArrayList) {
            Button btn = new Button("Delete");
            RoomTm roomTm = new RoomTm(r1.getRoomId(), r1.getRoomType(), r1.getUse(), r1.getPrice(), btn);
            roomObservableList.add(roomTm);

            btn.setOnAction(  (event) -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.OK)) {
                    Database.roomArrayList.remove(r1);
                    roomObservableList.remove(roomTm);
                }
            });
        }
        tblRoom.setItems(roomObservableList);
    }

    public void loadAllFoods() {
        ObservableList<FoodTm> foodObservableList = FXCollections.observableArrayList();

        for (Food f1 : Database1.foodArrayList) {
            Button foodBtn = new Button("Delete");
            FoodTm foodTm = new FoodTm(f1.getMealType(), f1.getFoodName(), f1.getFoodPrice(), foodBtn);
            foodObservableList.add(foodTm);

           foodBtn.setOnAction((ActionEvent event) -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.OK)) {
                    Database1.foodArrayList.remove(f1);
                    foodObservableList.remove(foodTm);
                }
            });
        }
        tblFood.setItems(foodObservableList);
    }


    public void addRoomOnAction(ActionEvent event) {
        if (btnAddRoom.getText().equals("+ Add Room")) {
            Room r1 = new Room(txtRoomId.getText(), txtRoomType.getText(), txtUse.getText(), Double.parseDouble(txtRoomPrice.getText()));
            Database.roomArrayList.add(r1);
            loadAllRooms();
        } else {
            for (Room tm : Database.roomArrayList) {
                if (tm.getRoomId().equals(txtRoomId.getText())) {
                    tm.setRoomId(txtRoomId.getText());
                    tm.setPrice(Double.parseDouble(txtRoomPrice.getText()));
                    tm.setRoomType(txtRoomType.getText());
                    tm.setUse(txtUse.getText());
                    loadAllRooms();
                }
            }
        }
    }

    public void addFoodPackageOnAction(ActionEvent event) {
        if (btnAddFood.getText().equals("+ Add Food Package")) {
            Food f1 = new Food(txtMealType.getText(), txtFoodName.getText(), Double.parseDouble(txtFoodPrice.getText()));
            Database1.foodArrayList.add(f1);
            loadAllFoods();
        } else {
            for (Food tm : Database1.foodArrayList) {
                if (tm.getFoodName().equals(txtFoodName.getText())) {
                    tm.setMealType(txtMealType.getText());
                    tm.setFoodPrice(Double.parseDouble(txtFoodPrice.getText()));
                    tm.setFoodName(txtFoodName.getText());
                    loadAllFoods();
                }
            }
        }
    }

    public void addNewRoomAndFoodOnAction(ActionEvent event) {
        btnAddRoom.setText("+ Add Room");
        btnAddFood.setText("+ Add Food Package");
    }

    public void showFinancialReportsOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) adminDashBoardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/financialForm.fxml"))));
    }
}
