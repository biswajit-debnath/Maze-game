package mazegame.entity;

public class Player extends Character {

    private Location currentLocation;
    private Item equippedItem;
    private Inventory items;


    public Item getEquippedItem() {
        return equippedItem;
    }

    public String setEquippedItem(Item equippedItem) {
        if (this.equippedItem == null) {
            this.equippedItem = equippedItem;
            return equippedItem.getLabel() + " Equipped";
        } else return this.equippedItem.getLabel() + " Already Equipped";
    }

    public void resetEquippedItem() {
        this.equippedItem = null;
    }

    public Player() {
    }

    public Player(String name) {
        super(name);
        setStrength(25);
        setMaxStrength(25);
        items = new FiniteInventory(25);
    }

    public Inventory getInventory() {
        return items;
    }


    //added getter and setter for currentLocation

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String toString() {
        return "**********\n" + this.getName() + " Strength : " + getStrength() + "\n**********\n"
                + "Collected Items :: " + (getInventory() != null ? getInventory().toString() : "") + "\n**********\n"
                + "Items found :: " + (getEquippedItem() != null ? getEquippedItem().toString() : "") + "\n**********\n"
                + "Current Location :: " + getCurrentLocation().toString() + "\n**********\n";

    }


}
