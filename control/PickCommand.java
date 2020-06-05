package mazegame.control;

import mazegame.entity.FiniteInventory;
import mazegame.entity.Item;
import mazegame.entity.Player;

//L 10
public class PickCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't pick any Item!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (Object argument : userInput.getArguments()) {
            if (thePlayer.getCurrentLocation().getItemCollection().containsItem(argument.toString())) {
                Item item = thePlayer.getCurrentLocation().getItemCollection().getItem((String) argument);
                if (!((FiniteInventory) thePlayer.getInventory()).addItem(item)) {
                    return new CommandResponse("Can not pick this item, Maximum Weight limit reached !");
                }
                return new CommandResponse(item.getLabel() + " Picked");
            }
        }
        return response;
    }
}
