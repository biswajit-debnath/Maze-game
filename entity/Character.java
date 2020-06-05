package mazegame.entity;

public class Character {
    private int agility;
    private int lifePoints;
    private String name = "";
    private int strength;
    private int attackStrength;
    private int defenseStrength;
    private int maxStrength;

//    public Mazegame.Entity.Dice m_Dice;
//    public Mazegame.Entity.Party m_Party;
//    public Mazegame.Entity.Item m_Item;
//    public Mazegame.Entity.Shield m_Shield;
//    public Mazegame.Entity.Weapon m_Weapon;
//    public Mazegame.Entity.Armor m_Armor;

    public Character() {
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public void setMaxStrength(int maxStrength) {
        this.maxStrength = maxStrength;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getDefenseStrength() {
        return defenseStrength;
    }

    public void setDefenseStrength(int defenseStrength) {
        this.defenseStrength = defenseStrength;
    }

    public Character(String name) {
        this.setName(name);
        setAttackStrength(8);
        setDefenseStrength(4);

    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
