package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Player;

public class MovementState extends CommandState {
    public MovementState()
    {
        this.getAvailableCommands().put("go", new MoveCommand());
        this.getAvailableCommands().put("quit", new QuitCommand());
        this.getAvailableCommands().put("move", new MoveCommand());
        this.getAvailableCommands().put("look", new LookCommand());
        this.getAvailableCommands().put("unlock", new UnlockCommand());
        this.getAvailableCommands().put("attack", new AttackCommand());
        this.getAvailableCommands().put("pick", new PickCommand());
        this.getAvailableCommands().put("drop", new DropCommand());
        this.getAvailableCommands().put("listitem", new ListItemCommand());
        this.getAvailableCommands().put("equip", new EquipItemCommand());
        this.getAvailableCommands().put("unequip", new UnEquipItemCommand());
        this.getAvailableCommands().put("getmazestatus", new GetStatusCommand());
        this.getAvailableCommands().put("heal", new HealCommand());
    }

    public CommandState update(Player thePlayer)
    {
        if (thePlayer.getCurrentLocation() instanceof Blacksmith)
            return new CommerceState();
        return this;
    }
}
