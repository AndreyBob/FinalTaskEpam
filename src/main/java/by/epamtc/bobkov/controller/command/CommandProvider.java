package main.java.by.epamtc.bobkov.controller.command;

import main.java.by.epamtc.bobkov.controller.command.impl.AuthorizationCommand;
import main.java.by.epamtc.bobkov.controller.command.impl.GoToMainPageCommand;
import main.java.by.epamtc.bobkov.controller.command.impl.RegistrationCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private final Map<CommandName, Command> commandMap = new HashMap<>();

    public CommandProvider() {
        commandMap.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPageCommand());
        commandMap.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
        commandMap.put(CommandName.REGISTRATION, new RegistrationCommand());
    }

    public Command getCommand(String commandName) {
        return commandMap.get(CommandName.valueOf(commandName.toUpperCase()));
    }

}
