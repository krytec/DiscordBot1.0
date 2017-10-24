package commands;

import core.Constants;
import member.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Add implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (event.getMessage().getContent().startsWith(Constants.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {

            Member.player.add(new Member(0, event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0)).getUser()));

            event.getTextChannel().sendMessage(event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0)).getUser().getName()+" wurde als Spieler hinzugefügt!").queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return " @user || Fügt einen Spieler zu dem Spiel hinzu";
    }
}
