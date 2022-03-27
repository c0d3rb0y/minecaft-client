package wug.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wug.command.impl.Info;
import wug.command.impl.Toggle;
import wug.events.listeners.EventChat;

public class CommandManager {

	public List<Command> commands = new ArrayList<Command>();
	public String prefix = "//";
	
	public CommandManager() {
		setup();
	}
	
	public void setup() {
		commands.add(new Toggle());
		commands.add(new Info());
	}
	
	public void handleChat(EventChat event) {
		String message = event.getMessage();
		
		if(!message.startsWith(prefix))
			return;
		
		message = message.substring(prefix.length());
		
		if(message.split(" ").length > 0) {
			String commandName = message.split(" ")[0];
			
			
			for(Command c : commands) {
				if(c.aliases.contains(commandName)) {
					c.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
				}
			}
		}
	}
}
