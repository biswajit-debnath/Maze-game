package mazegame.entity;

public class Monkey extends NonPlayerCharacter {


    public Monkey(String name, int agility, int strength, int lifepoints) {
        setName(name);
        setLifePoints(lifepoints);
        setStrength(strength);
        setAgility(agility);
        setHostile(false);
    }

}
