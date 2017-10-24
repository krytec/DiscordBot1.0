package core;

import commands.Command;

import java.util.HashMap;

public class CommandHandler {

    public final static CommandParser parse = new CommandParser();
    public static HashMap<String, Command> commands = new HashMap<>();


            public static void handleCommand(CommandParser.commandContainer cmd){
                if(commands.containsKey(cmd.invoke)){

                boolean safe = commands.get(cmd.invoke).called(cmd.args,cmd.event);

                if(!safe){
                    commands.get(cmd.invoke).action(cmd.args,cmd.event);

                }
            }


        }


}
