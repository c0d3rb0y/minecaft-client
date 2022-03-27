package wug.command.impl;

import wug.Client;
import wug.command.Command;
import wug.modules.Module;

public class Info extends Command {

	
	public Info() {
		super("Info", "Gets client name and verison", "info", "ver");
	}

	@Override
	public void onCommand(String[] args, String command) {
		
		Client.addChatMessage(Client.name + " " + Client.v);
		
	}
	
	
}
