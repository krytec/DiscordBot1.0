package commands;

import core.Constants;
import member.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ShowPlayers implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        boolean checked=false;
        for (Role r: event.getGuild().getMember(event.getAuthor()).getRoles()
                ) { if(r.getName().equals("Spielleiter") || r.getName().equals("Spieler")){
            checked = false;
        }

        }
        if(!checked) {
            if(Member.player.size()==0){
                event.getTextChannel().sendMessage("Keine Spieler gefunden!").queue();
            }
            for (int i = 0; i < Member.player.size(); i++) {
                if (event.getMessage().getContent().startsWith(Constants.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
                    event.getTextChannel().sendMessage(Member.player.get(i).getUser().getName() + " || " + Member.player.get(i).getLevel() + " || " + Member.player.get(i).getXP()).queue();
                }
            }
        }else{
            event.getTextChannel().sendMessage("Nicht authorisiert!").queue();

        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return " || Zeigt die Spieler an";
    }
}
