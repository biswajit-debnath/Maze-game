package mazegame.control;

import mazegame.entity.Player;

//L 10
public class UnEquipItemCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't pick any Item!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (Object argument : userInput.getArguments()) {
            if (thePlayer.getEquippedItem() != null && thePlayer.getEquippedItem().getLabel().equalsIgnoreCase((String) argument)) {
                String label = thePlayer.getEquippedItem().getLabel();
                thePlayer.resetEquippedItem();
                return new CommandResponse(label + " Unequipped");
            }
        }
        return response;
    }
}
