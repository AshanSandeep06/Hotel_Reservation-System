package tmModels;

import javafx.scene.control.Button;

public class FoodTm {
    private String mealType;
    private String foodName;
    private double foodPrice;
    private Button btn;

    public FoodTm() {

    }

    public FoodTm(String mealType, String foodName, double foodPrice, Button btn) {
        this.mealType = mealType;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.btn=btn;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "FoodTm{" +
                "mealType='" + mealType + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", btn=" + btn +
                '}';
    }
}
