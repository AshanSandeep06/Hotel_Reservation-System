package Controller;

import Models.CustomerDetails;
import Models.financialModel;
import db.Database;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

import static Controller.CustomerBookingDetailsFormController.*;

public class CustomerReceiptFormController {

    public static int totalValue = 0;
    public static int totalCost = 0;
    public static String s1, s2, s3;
    public static ArrayList<financialModel> arrayList = new ArrayList<>();
    static String room;
    public Label lblGuestName;
    public Label lblRoomsQuantity;
    public Label lblMealCharges;
    public Label lblDays;
    public Label lblPricePerNight;
    public Label lblCleaningFees;
    public Label lblTotalCost;

    public void initialize() {
        loadReceipts();
    }

    public void loadReceipts() {
        for (CustomerDetails c1 : customerDetails) {
            if (c1.getNicNumber().equals(nicNumber)) {
                lblGuestName.setText(c1.getFullName());
                lblRoomsQuantity.setText(c1.getRoomsQuantity());
                char s = peopleValue.charAt(0);
                int mealCharge = 1000 * (Integer.parseInt(c1.getDays())) * (Integer.parseInt(String.valueOf(s)));
                lblMealCharges.setText(String.valueOf(mealCharge));
                lblDays.setText(c1.getDays());

                int k = 0;

                for (int i = 0; i < Database.roomArrayList.size(); i++) {
                    if (roomType.equals(Database.roomArrayList.get(i).getRoomType())) {
                        k = (int) Database.roomArrayList.get(i).getPrice();
                        s1 = String.valueOf(k);
                    }
                }

                lblPricePerNight.setText(s1);
                s2 = lblMealCharges.getText();

                int clFee = (Integer.parseInt(lblCleaningFees.getText())) * (Integer.parseInt(c1.getRoomsQuantity()));

                // s3 = lblCleaningFees.getText();
                s3 = String.valueOf(clFee);
                //lblCleaningFees.setText(s3);

                totalCost = (Integer.parseInt(c1.getRoomsQuantity())) * (Integer.parseInt(c1.getDays())) * (Integer.parseInt(s1)) + (Integer.parseInt(s2)) + (Integer.parseInt(c1.getDays())) * (Integer.parseInt(s3));
                lblTotalCost.setText(String.valueOf(totalCost));

                arrayList.add(new financialModel(c1.getRoomId(), totalCost));

            }
        }
        totalValue += Integer.parseInt(lblTotalCost.getText());
    }

    public void MailToCustomerOnAction(MouseEvent mouseEvent) {
        System.out.println("Sent to the customer " + lblGuestName.getText());

        /*for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Array List : " + arrayList.get(i).getRoomId());
        }*/
    }
}


