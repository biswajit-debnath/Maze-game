package mazegame.control;

import mazegame.entity.Equipable;
import mazegame.entity.Item;
import mazegame.entity.Player;

//L 10
public class EquipItemCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't equip any Item!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (Object argument : userInput.getArguments()) {
            if (thePlayer.getInventory().findItem(argument.toString())!=null) {
                Item item = thePlayer.getInventory().findItem((String) argument);
                if (!(item instanceof Equipable)) {
                    return new CommandResponse("Can not wear this item");
                }
                String equippedItem = thePlayer.setEquippedItem(item);
                return new CommandResponse(equippedItem);
            }else {
                return new CommandResponse("Firstly pick an item to equip");
            }
        }
        return response;
    }
}
