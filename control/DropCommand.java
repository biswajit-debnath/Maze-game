package mazegame.control;

import mazegame.entity.FiniteInventory;
import mazegame.entity.Item;
import mazegame.entity.Player;

//L 10
public class DropCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't drop any Item!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }

        Item item = thePlayer.getInventory().findItem(userInput.getArguments().get(0).toString());
        if (item != null) {
            ((FiniteInventory) thePlayer.getInventory()).removeItem(item.getLabel());
            return new CommandResponse(item.getLabel() + " Dropped");
        } else {
            return new CommandResponse("No Item Matched!");
        }

    }
}
