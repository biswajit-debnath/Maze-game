package mazegame.entity;

public class Armor extends Item implements Equipable {
	private int bonus;	

	public Armor (String label, int value, double weight, String description) {
		super (label, value, weight, description);
	}
	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public boolean canBeEquiped() {
		return true;
	}
}
