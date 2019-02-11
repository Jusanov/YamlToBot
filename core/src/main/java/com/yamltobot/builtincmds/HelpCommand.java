package com.yamltobot.builtincmds;

import com.yamltobot.core.handler.ConfigHandler;
import com.yamltobot.core.handler.VariableHandler;

import java.util.ArrayList;

/**
 * 
 * Predefined help command. Lists all other registered commands that are enabled.
 * 
 * @author Justin Schaaf
 * @since 1.0.0
 *
 */
public class HelpCommand extends BuiltinCommand {
	
	public HelpCommand() {
		super();
	}

	@Override
	public String onCommandExecuted(String commandName, ArrayList<String> args) {

		StringBuilder helpCommand = new StringBuilder();
		ArrayList<String> commands = ConfigHandler.getCommands();
		
		for (int i = 0; i < commands.size(); i++) {

			String command = commands.get(i);
			String name = ConfigHandler.getString("prefix", "") + command;
			String usage = ConfigHandler.getCommandString(command, "usage", null);
			String desc = ConfigHandler.getCommandString(command, "description", "Generic Command");
			boolean enabled = ConfigHandler.getCommandBoolean(command, "enabled", true);
			
			if (enabled == false) continue;

			if (usage != null) name = usage;

			if (!args.isEmpty()) {

				if (command.equalsIgnoreCase(args.get(0))) {

					helpCommand.append(ConfigHandler.getCommandArray(commandName, "message").get(2).replaceAll("%cmd%", name).replaceAll("%desc%", desc));
					break;

				} else {
					continue;
				}

			} else {
				if (i == 0) helpCommand.append(ConfigHandler.getCommandArray(commandName, "message").get(0) + "\n");
				helpCommand.append(ConfigHandler.getCommandArray(commandName, "message").get(1).replaceAll("%cmd%", name).replaceAll("%desc%", desc));
				helpCommand.append("\n");
			}
			
		}

		if (!args.isEmpty()) if (helpCommand.toString().trim().length() == 0) return "Sorry, the command you were looking for could not be found. ( ◡︵◡)";

		return VariableHandler.formatMessage(helpCommand.toString());
		
	}

}