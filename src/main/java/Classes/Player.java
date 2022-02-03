package Classes;

import java.util.ArrayList;

public class Player extends Character{

    private ArrayList<String> inventory;

    public ArrayList<String> getInventory() {
        return inventory;
    }
    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }
}
