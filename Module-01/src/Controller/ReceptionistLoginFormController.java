package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ReceptionistLoginFormController {

    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane receptionistContext;
    static int attempts=0;

    public void initialize(){
        txtUserName.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
        txtPassword.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
        txtUserName.setText(null);
        txtPassword.setText(null);
    }

    public void letsGetStartedOnAction(ActionEvent event) throws IOException {
        if (txtUserName.getText()!=null && txtPassword.getText()!=null) {
            if (txtUserName.getText().equals(ReceptionistSignUpFormController.name) && txtPassword.getText().equals(ReceptionistSignUpFormController.password)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login successfully");
                Optional<ButtonType> buttonType = alert.showAndWait();

                if(buttonType.get().equals(ButtonType.OK)) {
                    // write code here
                    Stage stage = (Stage) receptionistContext.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/createReservationForm.fxml"))));
                }

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Username or Password");
                alert.show();
                return;
            }
        } else {
            if(attempts!=1) {
                //if (txtUserName.getText() == null || txtPassword.getText() == null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please create an account first");
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get().equals(ButtonType.OK)) {
                        Stage stage = (Stage) receptionistContext.getScene().getWindow();
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/receptionistSignUpForm.fxml"))));
                    }
                    attempts++;
                    return;
                //}
            }
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Username or Password");
            alert.show();
            return;
        }
    }

    public void createNewAccountOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) receptionistContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/receptionistSignUpForm.fxml"))));
    }


    public void backArrow(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage)receptionistContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/selectAccessorForm.fxml"))));
    }
}
