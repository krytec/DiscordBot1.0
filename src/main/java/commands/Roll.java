package commands;

import core.Constants;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Roll implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        int d20 = (int) (Math.random()*20+1);
        if (event.getMessage().getContent().startsWith(Constants.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {

            if (d20 == 1) {
                event.getTextChannel().sendMessage(event.getMessage().getAuthor().getName() + " du hast einen Immersieg gewürfelt! ").queue();
            } else if (d20 == 20) {
                event.getTextChannel().sendMessage(event.getMessage().getAuthor().getName() + " du hast eine " + d20 + " gewürfelt! Kritisches Versagen!").queue();
            } else {
                event.getTextChannel().sendMessage(event.getMessage().getAuthor().getName() + " euer Wurf ist: " + d20).queue();
            }
        }
    }
    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return " || rollt einen D20";
    }
}
