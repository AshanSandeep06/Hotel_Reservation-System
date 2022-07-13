package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AdminSignUpFormController {
    static String name, email, password;
    static int attempts = 0;
    public JFXTextField txtFullName;
    public JFXPasswordField txtPassword;
    public AnchorPane adminSignUpContext;
    public JFXTextField txtEmail;

    public void initialize() {
        txtFullName.setText(null);
        txtPassword.setText(null);
        txtEmail.setText(null);

        txtFullName.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
        txtPassword.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
        txtEmail.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
    }

    public void createAnAccountOnAction(ActionEvent event) {
        if (txtFullName.getText() != null && txtPassword.getText() != null && txtEmail.getText() != null) {
            if (attempts != 1) {
                name = txtFullName.getText();
                email = txtEmail.getText();
                password = txtPassword.getText();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Account was successfully created");
                alert.show();
                attempts++;
            }
        }
    }

    public void alreadyHaveAnAccountOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) adminSignUpContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/adminLoginForm.fxml"))));
    }
}
