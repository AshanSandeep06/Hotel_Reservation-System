package db;

import Models.Food;

import java.util.ArrayList;

public class Database1 {
    public static ArrayList<Food> foodArrayList=new ArrayList<>();

        static {
            foodArrayList.add(new Food("Local Meals","Rice & curry",250));
            foodArrayList.add(new Food("Chinese Meals","Spring rolls",150));
            foodArrayList.add(new Food("Local Meals","Chicken kottu",350));
            foodArrayList.add(new Food("French Meals","Boeuf bourguignon",250));
            foodArrayList.add(new Food("Chinese Meals","Quick Noodles",400));
            foodArrayList.add(new Food("Local Meals","Egg Fried Rice",250));
        }
}
