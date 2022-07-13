package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MainFormController {

    public Button btn1;
    public AnchorPane mainPageContext;

    public void btnOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)mainPageContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/selectAccessorForm.fxml"))));
    }
}
