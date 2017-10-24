package commands;

import core.CommandHandler;
import core.Constants;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.util.HashMap;
public class help implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (event.getMessage().getContent().startsWith(Constants.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {

            CommandHandler.commands.forEach((k, v) -> event.getTextChannel().sendMessage("|| "+k+" "+v.help()).queue());
        }
    }
    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return " || Zeigt alle Commands an";
    }
}
