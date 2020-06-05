package mazegame.control;

import mazegame.entity.FiniteInventory;
import mazegame.entity.Item;
import mazegame.entity.Player;

//L 10
public class ListItemCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("No Items Here!");
        if (userInput.getCommand() == null) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        String allItems = thePlayer.getInventory().toString();
        response= new CommandResponse(allItems);

        return response;
    }
}
