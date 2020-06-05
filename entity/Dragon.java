package mazegame.entity;

public class Dragon extends NonPlayerCharacter {


    public Dragon(String name, int agility, int strength, int lifepoints) {
        setName(name);
        setLifePoints(lifepoints);
        setStrength(strength);
        setAgility(agility);
        setHostile(true);
    }

}
