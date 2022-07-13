package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;

public class AdminLoginFormController {

    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane adminLoginContext;
    public Label backArrow;
    static int attempts=0;

    public void initialize() {
        txtUserName.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
        txtPassword.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
        txtUserName.setText(null);
        txtPassword.setText(null);
    }

    public void letsGetStartedOnAction(ActionEvent event) throws IOException {
        if (txtUserName.getText()!=null && txtPassword.getText()!=null) {
            if (txtUserName.getText().equals(AdminSignUpFormController.name) && txtPassword.getText().equals(AdminSignUpFormController.password)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login successfully");
                Optional<ButtonType> buttonType = alert.showAndWait();

                if(buttonType.get().equals(ButtonType.OK)) {
                    // write code here
                    Stage stage = (Stage) adminLoginContext.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/adminDashBoard.fxml"))));
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
                        Stage stage = (Stage) adminLoginContext.getScene().getWindow();
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/adminSignUpForm.fxml"))));
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
        Stage stage = (Stage) adminLoginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/adminSignUpForm.fxml"))));
    }


    public void backArrow(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage)adminLoginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/selectAccessorForm.fxml"))));
    }
}
