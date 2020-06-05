package mazegame.control;

import mazegame.entity.FiniteInventory;
import mazegame.entity.Item;
import mazegame.entity.Player;

//L 10
public class SellCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't sell any Item!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (Object argument : userInput.getArguments()) {
            if (thePlayer.getInventory().getItemList().containsKey(argument.toString())) {
                Item item = thePlayer.getInventory().findItem((String) argument);
                ((FiniteInventory) thePlayer.getInventory()).addMoney(item.getValue());
                ((FiniteInventory) thePlayer.getInventory()).removeItem(item.getLabel());
                return new CommandResponse(item.getLabel() + " Sold");

            }
        }
        return response;
    }
}
