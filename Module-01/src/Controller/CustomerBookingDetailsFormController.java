package Controller;

import Models.CustomerDetails;
import Models.financialModel;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import tmModels.CustomerDetailsTm;

import java.io.IOException;
import java.util.ArrayList;

import static Controller.CustomerReceiptFormController.arrayList;
import static Controller.CustomerReceiptFormController.totalCost;

public class CustomerBookingDetailsFormController {

    public static ArrayList<CustomerDetails> customerDetails = new ArrayList<>();
    public static int totalCostValue = 0;
    public static String roomType;
    public static String nicNumber;
    static String peopleValue = " ";
    public JFXTextField txtResTime;
    public JFXComboBox<String> cmbPeople;
    public JFXTextField txtRoomType;
    public JFXTextField txtHowManyRooms;
    public JFXTextField txtSelectMealPlan;
    public JFXTextField txtFullName;
    public JFXTextField txtNixNumber;
    public JFXTextField txtContactNumber;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtRoomId;
    public JFXTextField days;
    public AnchorPane bookingDetailsContext;

    public void initialize() {
        txtResTime.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        days.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        //datePicker.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        cmbPeople.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtRoomType.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtHowManyRooms.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtSelectMealPlan.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtFullName.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtContactNumber.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtEmail.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtAddress.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtRoomId.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");
        txtNixNumber.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16px;");

        cmbPeople.getItems().addAll("1 People","2 people", "3 people", "4 people", "5 people", "6 people", "7 people", "8 people", "9 people", "10 people");
    }

    public void bookingOnAction(ActionEvent event) {
        Button btn = new Button("Delete");
        CustomerDetails c1 = new CustomerDetails(txtFullName.getText(), txtNixNumber.getText(), txtContactNumber.getText(), txtEmail.getText(), txtAddress.getText(), txtResTime.getText(), days.getText(), cmbPeople.getSelectionModel().getSelectedItem(), txtRoomId.getText(), txtRoomType.getText(), txtHowManyRooms.getText(), txtSelectMealPlan.getText(), btn);
        customerDetails.add(c1);
        roomType = txtRoomType.getText();
        nicNumber = txtNixNumber.getText();
        loadAllCustomerDetails();

        //totalCostValue = (Integer.parseInt(c1.getRoomsQuantity())) * (Integer.parseInt(c1.getDays())) * (2000) + (1000 + (Integer.parseInt(c1.getDays())) * (300));
    }

    public void showBookingReceiptOnAction(MouseEvent mouseEvent) throws IOException {
        // insert code here
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/customerReceiptForm.fxml"))));
        stage.show();
        //totalCostValue+=CustomerReceiptFormController.totalValue;
    }

    public void loadAllCustomerDetails() {
        ObservableList<CustomerDetailsTm> observableList = FXCollections.observableArrayList();
        for (CustomerDetails c1 : customerDetails) {
            Button btn = new Button("Delete");
            CustomerDetailsTm tm = new CustomerDetailsTm(c1.getFullName(), c1.getNicNumber(), c1.getContactNumber(), c1.getEmail(), c1.getAddress(), c1.getReservationTime(), c1.getDays(), c1.getPeople(), c1.getRoomId(), c1.getRoomType(), c1.getRoomsQuantity(), c1.getMealType(), btn);
            observableList.add(tm);
            peopleValue = cmbPeople.getSelectionModel().getSelectedItem();
        }
    }

    public void nextArrowKeyOnAction(MouseEvent mouseEvent) throws IOException {
        // insert code here
        Stage stage = (Stage) bookingDetailsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/viewCustomerReservationDetails.fxml"))));
    }
}
