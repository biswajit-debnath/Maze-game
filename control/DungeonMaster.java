package mazegame.control;

import java.io.IOException;
import java.util.ArrayList;

import mazegame.SimpleConsoleClient;
import mazegame.boundary.IMazeClient;
import mazegame.boundary.IMazeData;
import mazegame.entity.Exit;
import mazegame.entity.Player;

public class DungeonMaster {
	private IMazeClient gameClient;
	private IMazeData gameData;
	private Player thePlayer;
    private CommandHandler playerTurnHandler; //L8

	// Added 3 new fields L7
    private boolean continueGame;
    private ArrayList<String> commands;
    private Parser theParser;


    public DungeonMaster(IMazeData gameData, IMazeClient gameClient)
     {
         this.gameData = gameData;
         this.gameClient = gameClient;
         this.playerTurnHandler=new CommandHandler(); //L8


     }

     public void printWelcome()
     {
         gameClient.playerMessage(gameData.getWelcomeMessage());
     }

     public void setupPlayer()
     {
         String playerName = gameClient.getReply("What name do you choose to be known by?");
         thePlayer = new Player(playerName);

         // setting starting location for new player L7
         thePlayer.setCurrentLocation(gameData.getStartingLocation());

         gameClient.playerMessage("Welcome " + playerName + "\n\n");
         gameClient.playerMessage("You find yourself looking at ");
         gameClient.playerMessage(gameData.getStartingLocation().getDescription());

         //commented out old method call

         //gameClient.getReply("<<Hit Enter to exit>>");
     }

     public void runGame()
     {
         printWelcome();
         setupPlayer();

         while (handlePlayerTurn()) {
             // handle npc logic later
         }
         gameClient.getReply("\n\n<<Hit enter to exit>>");
     }
    private boolean handlePlayerTurn() {
        CommandResponse playerResponse = playerTurnHandler.processTurn(gameClient.getCommand(), thePlayer);
        gameClient.playerMessage(playerResponse.getMessage());
        return !playerResponse.isFinishedGame();
    }


    //Added new method L7
  /*  public boolean processPlayerTurn() {
        ParsedInput userInput = theParser.parse(gameClient.getCommand());
        if (commands.contains(userInput.getCommand())) {
            if (userInput.getCommand().equals("quit"))
                return false;
            if (userInput.getCommand().equals("move")) {
                // move process call
                processMove(userInput);

                //old method commented out
               // gameClient.playerMessage("You entered the move command");
                return true;
            }
        }
        gameClient.playerMessage("We don't recognise that command - try again!");
        return true;
    }*/

    // Added new move processor method L7
    private void processMove(ParsedInput userInput) {
        String exitLabel = (String) userInput.getArguments().get(0);
        Exit desiredExit = thePlayer.getCurrentLocation().getExitCollection().getExit(exitLabel);
        if (desiredExit == null) {
            gameClient.playerMessage("There is no exit there . . . try moving somewhere else");
            return;
        }
        thePlayer.setCurrentLocation(desiredExit.getDestination());
        //printed the current exit description
        gameClient.playerMessage(desiredExit.getDescription()+"\n");
        gameClient.playerMessage("You find yourself looking at ");
        //calling toString function for cobined info of current location and shown to the user
        gameClient.playerMessage(thePlayer.getCurrentLocation().toString());
    }

}
