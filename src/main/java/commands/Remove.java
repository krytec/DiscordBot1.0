package commands;

import core.Constants;
import member.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Remove implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (event.getMessage().getContent().startsWith(Constants.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {

            for (int i=0;i< Member.player.size();i++
                 ) {
                if(Member.player.get(i).getUser().getName().equals(event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0)).getUser().getName())){
                    Member.player.remove(i);
                }

            }


            event.getTextChannel().sendMessage(event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0)).getUser().getName()+" wurde Entfernt!").queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return " @user || Entfernt einen Spieler aus dem Spiel";
    }
}
