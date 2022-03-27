package wug.command.impl;

import wug.Client;
import wug.command.Command;
import wug.modules.Module;

public class Toggle extends Command {

	
	public Toggle() {
		super("Toggle", "Toggles module by name", "toggle <name>", "t");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length > 0) {
			String moduleName = args[0];
			
			boolean foundModule = false;
			
			for(Module module : Client.modules) {
				if(module.name.equalsIgnoreCase(moduleName)) {
					module.toggle();
					foundModule = true;
					break;
				}
			}
			
			if(!foundModule) {
				Client.addChatMessage("Couldn't find module " + moduleName);
			}
		}
		
	}
	
	
}
