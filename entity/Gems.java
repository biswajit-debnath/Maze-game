package mazegame.entity;

public class Gems extends Item implements Collectable {

    public Gems(String label, int value, double weight, String description) {
        super(label, value, weight, description);
    }


    @Override
    public boolean canCollected() {
        return true;
    }
}
