package Controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class SelectAccessorFormController {

    public AnchorPane secondPageContext;
    public CheckBox cbxAdmin;
    public CheckBox cbxReceptionist;

    public void backToHomePageOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) secondPageContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }

    public void loginOnAction(ActionEvent event) throws IOException {
        if(cbxAdmin.isSelected()){
            Stage stage = (Stage)secondPageContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/adminLoginForm.fxml"))));
            return;
        }
        if(cbxReceptionist.isSelected()){
            Stage stage = (Stage)secondPageContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/receptionistLoginForm.fxml"))));
            return;
        }
    }

    public void adminPressedOnAction(MouseEvent mouseEvent) {
        cbxReceptionist.setSelected(false);
    }

    public void receptionistPressedOnAction(MouseEvent mouseEvent) {
        cbxAdmin.setSelected(false);
    }
}
