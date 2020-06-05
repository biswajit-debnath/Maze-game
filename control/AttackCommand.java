package mazegame.control;

import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

//L 10
public class AttackCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't attack anyone!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (Object argument : userInput.getArguments()) {
            if (thePlayer.getCurrentLocation().getNonPlayerCharacterCollection().containsKey(argument.toString())) {
                NonPlayerCharacter item = thePlayer.getCurrentLocation().getNonPlayerCharacterCollection().get((String) argument);
                if (item.getStrength() > item.getDefenseStrength()) {
                    int newStrength = item.getStrength() - thePlayer.getAttackStrength();
                    item.setStrength(newStrength);
                } else item.setStrength(0);
                if (item.getStrength() > 0) {
                    if (thePlayer.getStrength() > item.getDefenseStrength()) {
                        int newStrength = thePlayer.getStrength() - thePlayer.getDefenseStrength();
                        thePlayer.setStrength(newStrength);
                        return new CommandResponse(item.getName() + " Strength : " + item.getStrength() + "\n"
                                + thePlayer.getName() + " Strength : " + thePlayer.getStrength() + "\n"
                        );
                    } else {
                        response = new CommandResponse("You have no more strength to attack");
                        // new QuitCommand().execute(new ParsedInput("quit",null),thePlayer);
                    }
                } else {
                    response = new CommandResponse("Enemy has no strength to attack!");
                }
            }
        }
        return response;
    }
}
