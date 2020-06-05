package mazegame.control;

import mazegame.entity.Player;

//L 10
public class GetStatusCommand implements Command {
    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("No Items Here!");
        if (userInput.getCommand() == null) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        response = new CommandResponse(thePlayer.toString());

        return response;
    }
}
