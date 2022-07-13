package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class FinancialFormController {

    public Label lblIncome;
    public Label lblExpense;
    public Label lblProfit;
    public AnchorPane financialReportsContext;

    public void initialize(){
        lblIncome.setStyle("-fx-text-fill: WHITE; -fx-font-size: 25px;");
        lblExpense.setStyle("-fx-text-fill: WHITE; -fx-font-size: 25px;");
        lblProfit.setStyle("-fx-text-fill: WHITE; -fx-font-size: 25px;");
    }

    public void monthReportsOnAction(ActionEvent event) {
        lblExpense.setText("93000");
        lblIncome.setText(String.valueOf((CustomerReceiptFormController.totalValue) * 30));
        lblProfit.setText(String.valueOf((Integer.parseInt(lblIncome.getText())) - (Integer.parseInt(lblExpense.getText()))));
    }

    public void annualReportsOnAction(ActionEvent event) {
        lblExpense.setText("225000");
        lblIncome.setText(String.valueOf((CustomerReceiptFormController.totalValue) * 365));
        lblProfit.setText(String.valueOf((Integer.parseInt(lblIncome.getText())) - (Integer.parseInt(lblExpense.getText()))));
    }

    public void dayReportsOnAction(ActionEvent event) {
        lblExpense.setText("8000");
        lblIncome.setText(String.valueOf(CustomerReceiptFormController.totalValue));
        lblProfit.setText(String.valueOf((Integer.parseInt(lblIncome.getText())) - (Integer.parseInt(lblExpense.getText()))));
    }

    public void weekReportsOnAction(ActionEvent event) {
        lblExpense.setText("42000");
        lblIncome.setText(String.valueOf((CustomerReceiptFormController.totalValue) * 7));
        lblProfit.setText(String.valueOf((Integer.parseInt(lblIncome.getText())) - (Integer.parseInt(lblExpense.getText()))));
    }

    public void logOutToAdminLoginOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) financialReportsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/adminLoginForm.fxml"))));
    }
}
