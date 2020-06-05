package mazegame.control;

import mazegame.entity.Collectable;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.utility.DiceRoller;

//L 10
public class HealCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't use any Item!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (Object argument : userInput.getArguments()) {
            if (thePlayer.getInventory().findItem(argument.toString()) != null) {
                Item item = thePlayer.getInventory().findItem((String) argument);
                if (!(item instanceof Collectable)) {
                    return new CommandResponse("Can not consume this item for healing");
                }
                int strengthBoost = DiceRoller.getInstance().generateAbilityScore();
                if (thePlayer.getStrength() + strengthBoost > thePlayer.getMaxStrength())
                    strengthBoost = thePlayer.getMaxStrength();
                thePlayer.setStrength(strengthBoost);
                return new CommandResponse("Strength Boosted , New strength : " + thePlayer.getStrength());
            } else {
                return new CommandResponse("Firstly pick an item to use for healing");
            }
        }
        return response;
    }
}
