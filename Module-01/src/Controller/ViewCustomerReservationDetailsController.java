package Controller;

import Models.CustomerDetails;
import Models.Room;
import Models.financialModel;
import db.Database;
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
import tmModels.CustomerDetailsTm;
import tmModels.RoomTm;

import java.io.IOException;
import java.util.Optional;

import static Controller.CustomerReceiptFormController.arrayList;

public class ViewCustomerReservationDetailsController {

    public TableView<CustomerDetailsTm> tblCustomerResDetails;
    public TableColumn tblColumnRoomID;
    public TableColumn tblColoumnCusName;
    public TableColumn tblColumnCusNIC;
    public TableColumn tblColumnAddress;
    public TableColumn tblColumnNoOfRooms;
    public TableColumn tblColumnRoomType;
    public TableColumn tblColoumnDays;
    public TableColumn tblColumnMealPlan;
    public TableColumn tblColoumnOption;
    public AnchorPane customerReservationContext;

    public void initialize() {
        tblColumnRoomID.setCellValueFactory(new PropertyValueFactory("roomId"));
        tblColoumnCusName.setCellValueFactory(new PropertyValueFactory("fullName"));
        tblColumnAddress.setCellValueFactory(new PropertyValueFactory("address"));
        tblColumnNoOfRooms.setCellValueFactory(new PropertyValueFactory("roomsQuantity"));
        tblColumnRoomType.setCellValueFactory(new PropertyValueFactory("roomType"));
        tblColoumnDays.setCellValueFactory(new PropertyValueFactory("days"));
        tblColumnMealPlan.setCellValueFactory(new PropertyValueFactory("mealType"));
        tblColoumnOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllCustomerReservationDetails();

        tblCustomerResDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });
    }

    public void loadAllCustomerReservationDetails() {
        ObservableList<CustomerDetailsTm> observableList = FXCollections.observableArrayList();

        for (CustomerDetails c1 : CustomerBookingDetailsFormController.customerDetails) {
            Button btn = new Button("Delete");
            CustomerDetailsTm tm = new CustomerDetailsTm(c1.getRoomId(), c1.getFullName(), c1.getAddress(), c1.getRoomsQuantity(), c1.getRoomType(), c1.getDays(), c1.getMealType(), btn);
            observableList.add(tm);

            btn.setOnAction((ActionEvent event) -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.OK)) {
                    //System.out.println(arrayList.size());

                    for (int i = 0; i < CustomerReceiptFormController.arrayList.size(); i++) {
                        if (tm.getRoomId().equals(CustomerReceiptFormController.arrayList.get(i).getRoomId())) {
                            CustomerReceiptFormController.totalValue = CustomerReceiptFormController.totalValue - CustomerReceiptFormController.arrayList.get(i).getValue();
                        }
                    }
                    CustomerBookingDetailsFormController.customerDetails.remove(c1);
                    observableList.remove(tm);
                }
            });
        }
        tblCustomerResDetails.setItems(observableList);
    }

    public void backArrowKeyOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) customerReservationContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/customerBookingDetailsForm.fxml"))));
    }

    public void viewFinancialReportsOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) customerReservationContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/adminLoginForm.fxml"))));
        //
    }
}
