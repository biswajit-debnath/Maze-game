package mazegame.entity;

public class Wolf extends NonPlayerCharacter {


    public Wolf(String name, int agility, int strength, int lifepoints) {
        setName(name);
        setLifePoints(lifepoints);
        setStrength(strength);
        setAgility(agility);
        setHostile(true);
    }

}
