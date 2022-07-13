package Models;

public class Food {
    private String mealType;
    private String foodName;
    private double foodPrice;

    public Food() {

    }

    public Food(String mealType, String foodName, double foodPrice) {
        this.mealType = mealType;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
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

    @Override
    public String toString() {
        return "Food{" +
                "mealType='" + mealType + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                '}';
    }
}
