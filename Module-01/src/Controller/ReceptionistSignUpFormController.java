package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistSignUpFormController {

    public JFXTextField txtFullNameRe;
    public JFXPasswordField txtPasswordRe;
    public AnchorPane recepSignUpContext;
    public JFXTextField txtEmailRe;

    static String name,email,password;
    static int attempts=0;

    public void initialize(){
        txtFullNameRe.setText(null);
        txtPasswordRe.setText(null);
        txtEmailRe.setText(null);

        txtFullNameRe.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
        txtPasswordRe.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
        txtEmailRe.setStyle("-fx-text-fill: WHITE; -fx-font-size: 20px;");
    }

    public void createAnAccountReOnAction(ActionEvent event) {
       if(txtFullNameRe.getText()!=null && txtPasswordRe.getText()!=null && txtEmailRe.getText()!=null) {
            if (attempts != 1) {
                name = txtFullNameRe.getText();
                email = txtEmailRe.getText();
                password = txtPasswordRe.getText();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Account was successfully created");
                alert.show();
                attempts++;
            }
        }
    }

    public void alreadyHaveAnAccountReOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) recepSignUpContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/receptionistLoginForm.fxml"))));
    }
}
