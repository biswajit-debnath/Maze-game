package mazegame.control;

import mazegame.entity.FiniteInventory;
import mazegame.entity.Item;
import mazegame.entity.Player;

//L 10
public class BuyCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't buy any Item!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (Object argument : userInput.getArguments()) {
            if (thePlayer.getCurrentLocation().getItemCollection().containsItem(argument.toString())) {
                Item item = thePlayer.getCurrentLocation().getItemCollection().getItem((String) argument);
                if (((FiniteInventory) thePlayer.getInventory()).getGold().getTotal() > item.getValue()) {
                    ((FiniteInventory) thePlayer.getInventory()).removeMoney(item.getValue());
                    ((FiniteInventory) thePlayer.getInventory()).addItem(item);
                    return new CommandResponse(item.getLabel() + " Purchased");
                }else
                return new CommandResponse("insufficient money to purchase this item");
            }
        }
        return response;
    }
}
