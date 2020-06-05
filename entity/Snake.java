package mazegame.entity;

public class Snake extends NonPlayerCharacter {


    public Snake(String name, int agility, int strength, int lifepoints) {
        setName(name);
        setLifePoints(lifepoints);
        setStrength(strength);
        setAgility(agility);
        setHostile(true);
    }

}
