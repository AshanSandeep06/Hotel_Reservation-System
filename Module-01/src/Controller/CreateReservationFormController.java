package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class CreateReservationFormController {

    public AnchorPane createRservationContext;

    public void createReservationOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) createRservationContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/customerBookingDetailsForm.fxml"))));
    }
}
