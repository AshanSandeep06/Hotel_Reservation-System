package db;

import Models.Food;
import Models.Room;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Room> roomArrayList=new ArrayList<>();

    static {
        roomArrayList.add(new Room("Room 1","Single","Yes",1000));
        roomArrayList.add(new Room("Room 2","Double","Yes",2500));
        roomArrayList.add(new Room("Room 3","Single","No",1000));
        roomArrayList.add(new Room("Room 4","Triple","Yes",3500));
        roomArrayList.add(new Room("Room 5","Double","No",2500));
        roomArrayList.add(new Room("Room 6","Quadra","Yes",5000));
    }

}
